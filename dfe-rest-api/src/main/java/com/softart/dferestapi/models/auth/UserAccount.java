package com.softart.dferestapi.models.auth;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;


@Getter
public final class UserAccount extends User {
    private final Account account;

    public UserAccount(Account account) {
        super(account.getUsername(), account.getPassword(), account.getEnabled(), !account.getExpired(), !account.getCredentialsExpired(), !account.getLocked(), account.getRoles().stream().map(it -> "ROLE_" + it.getName().name()).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        this.account = account;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
