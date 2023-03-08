package com.softart.dferestapi.services.auth;

import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.repository.AccountRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Getter
public final class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private UsernameNotFoundException notFoundException(String username) {
        return new UsernameNotFoundException(username + " not found");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = Optional.empty();
        if (Objects.nonNull(username) && username.contains("@")) {
            optionalAccount = getAccountRepository().findAccountByEmail(username);
        } else if (Objects.nonNull(username)) {
            optionalAccount = getAccountRepository().findAccountByUsername(username);
        }

        Account account = optionalAccount.orElseThrow(() -> notFoundException(username));

        return User
                .builder()
                .username(account.getUsername())
                .accountExpired(account.getExpired())
                .accountLocked(account.getLocked())
                .credentialsExpired(account.getCredentialsExpired())
                .authorities(account.getRoles().stream().map(it -> it.getName().name()).collect(Collectors.toList()).toArray(new String[] {}))
                .password(account.getPassword())
                .build();
    }
}
