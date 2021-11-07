package com.itanna.model;

import java.time.Instant;

public interface IUserAccount {
    Long getID();
    String getEmailAddress();
    String getFirstName();
    String getLastName();
    String getPassword();
    Instant getCreatedDate();
}
