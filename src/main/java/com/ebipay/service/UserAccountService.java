package com.ebipay.service;

import com.ebipay.dao.UserAccountDao;
import com.ebipay.model.*;
import com.ebipay.model.impl.UserAccount;
import com.ebipay.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService implements IUserAccountService {

    @Autowired
    UserAccountDao accountRepository;

    //@Value("${password.pepper}")
    //String passwordPepper;

    @Value("${password.strength}")
    int strength;

    @Override
    public List<UserAccount> getAllUsers() {
        return null;
    }

    @Override
    public Optional<UserAccount> getUserByID(Long id) {
        return Optional.ofNullable(accountRepository.getUserById(id));
    }

    @Override
    public Optional<UserAccount> getUserByEmail(String email) {
        return Optional.ofNullable(accountRepository.getUserByEmailAddress(email));
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(strength);
    }

    @Override
    public Status createUserAccount(UserAccountDTO userAccountDTO) {
        UserAccount user = null;
        try {
            user = accountRepository.save(createPersistedUserAccount(userAccountDTO));
        }
        catch (Exception e){
            e.printStackTrace();
            return Status.FAILURE;
        }

        return user != null ? Status.SUCCESS : Status.FAILURE;
    }

    @Override
    public Status authenticate(UserLoginDTO userAccount) {
        UserAccount account = accountRepository.getUserByEmailAddress(userAccount.getEmailAddress());
        if (account != null)
        {
            boolean authenticated = verifyAccount(account, userAccount);
            return authenticated ? Status.SUCCESS : Status.FAILURE;
        }
        return Status.UNKNOWN_USER;
    }

    private boolean verifyAccount(UserAccount account, UserLoginDTO userAccount) {
        return passwordEncoder().matches(userAccount.getPassword(), account.getPassword());
    }

    private UserAccount createPersistedUserAccount(UserAccountDTO userAccountDTO) {

        //Extract Password from userInfo object and add salt and pepper
        String emailAddress = userAccountDTO.getEmailAddress();
        String firstName = userAccountDTO.getFirstName();
        String lastName = userAccountDTO.getLastName();
        String encodedPassword = passwordEncoder().encode(userAccountDTO.getPassword());

        //Create UserAccount object with email, first, last from UserInfo object and encrypted password, salt and pepper
        UserAccount userAccount = new UserAccount(emailAddress, firstName, lastName, encodedPassword);

        return userAccount;
    }
}
