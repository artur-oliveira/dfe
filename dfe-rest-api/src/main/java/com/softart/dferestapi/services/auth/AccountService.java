package com.softart.dferestapi.services.auth;

import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.auth.request.RegisterRequest;

public interface AccountService {

    Account createAccount(RegisterRequest request);

    Account getLoggedAccount();

}
