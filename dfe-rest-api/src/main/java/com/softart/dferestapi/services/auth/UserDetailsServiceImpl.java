package com.softart.dferestapi.services.auth;

import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.auth.UserAccount;
import com.softart.dferestapi.repository.AccountRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Getter
public final class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final UserCache userCache;

    @Autowired
    public UserDetailsServiceImpl(
            AccountRepository accountRepository,
            UserCache userCache
    ) {
        this.accountRepository = accountRepository;
        this.userCache = userCache;
    }

    private UsernameNotFoundException notFoundException(String username) {
        return new UsernameNotFoundException(username + " not found");
    }

    private UserAccount loadUserByUserNameInDatabase(String username) {
        Optional<Account> optionalAccount = Optional.empty();
        if (Objects.nonNull(username) && username.contains("@")) {
            optionalAccount = getAccountRepository().findAccountByEmail(username);
        } else if (Objects.nonNull(username)) {
            optionalAccount = getAccountRepository().findAccountByUsername(username);
        }

        UserAccount userAccount = new UserAccount(optionalAccount.orElseThrow(() -> notFoundException(username)));
        getUserCache().putUserInCache(userAccount);

        return userAccount;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable((UserAccount) getUserCache().getUserFromCache(username)).orElseGet(() -> loadUserByUserNameInDatabase(username));
    }
}
