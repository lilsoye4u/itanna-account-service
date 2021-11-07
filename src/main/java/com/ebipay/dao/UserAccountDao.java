package com.ebipay.dao;

import com.ebipay.model.IUserAccount;
import com.ebipay.model.Status;
import com.ebipay.model.impl.UserAccount;
import com.ebipay.model.UserAccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountDao extends JpaRepository<UserAccount, Long> {
    //Status createUserAccount(IUserAccount userAccount);
    //List<UserAccount> getAllUserAccount();
    @Query(value = "SELECT * FROM user_account u WHERE u.email_address = :email", nativeQuery = true)
    UserAccount getUserByEmailAddress(@Param("email") String email);
    UserAccount getUserById(Long id);
}
