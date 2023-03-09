package com.softart.dferestapi.repository;

import com.softart.dferestapi.models.auth.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @EntityGraph("fetch.fullAccount")
    Optional<Account> findAccountByUsername(String username);

    @EntityGraph("fetch.fullAccount")
    Optional<Account> findAccountByEmail(String email);

}
