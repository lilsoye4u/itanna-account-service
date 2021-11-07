package com.itanna.service;

import com.itanna.model.Status;
import com.itanna.model.impl.UserAccount;
import com.itanna.model.UserAccountDTO;
import com.itanna.model.UserLoginDTO;

import java.util.List;
import java.util.Optional;

public interface IUserAccountService {
    List<UserAccount> getAllUsers();
    Optional<UserAccount> getUserByID(Long id);
    Optional<UserAccount> getUserByEmail(String email);
    Status createUserAccount(UserAccountDTO account);
    Status authenticate(UserLoginDTO userAccount);
}
