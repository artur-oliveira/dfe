package com.softart.dferestapi.services.auth;

import com.softart.dferestapi.exceptions.auth.AccountExistsException;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.auth.UserAccount;
import com.softart.dferestapi.models.auth.request.RegisterRequest;
import com.softart.dferestapi.repository.AccountRepository;
import com.softart.dferestapi.repository.RoleRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Getter
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Account createAccount(RegisterRequest request) {
        getAccountRepository().findAccountByEmail(request.getEmail()).ifPresent(account -> {
            throw new AccountExistsException();
        });
        getAccountRepository().findAccountByUsername(request.getUsername()).ifPresent(account -> {
            throw new AccountExistsException();
        });

        return getAccountRepository().save(Account
                .builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(getPasswordEncoder().encode(request.getPassword()))
                .roles(getRoleRepository().findAllByNameIn(request.getRoles()))
                .build());
    }

    @Override
    public Account getLoggedAccount() {
        return ((UserAccount) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAccount();
    }
}
