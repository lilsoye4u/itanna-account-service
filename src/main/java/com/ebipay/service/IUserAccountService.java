package com.ebipay.service;

import com.ebipay.model.Status;
import com.ebipay.model.impl.UserAccount;
import com.ebipay.model.UserAccountDTO;
import com.ebipay.model.UserLoginDTO;

import java.util.List;
import java.util.Optional;

public interface IUserAccountService {
    List<UserAccount> getAllUsers();
    Optional<UserAccount> getUserByID(Long id);
    Optional<UserAccount> getUserByEmail(String email);
    Status createUserAccount(UserAccountDTO account);
    Status authenticate(UserLoginDTO userAccount);
}
