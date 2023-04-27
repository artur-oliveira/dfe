package com.softart.dferestapi.repository;

import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.company.Company;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Override
    @EntityGraph("fetch.fullCompany")
    List<Company> findAll();

    @EntityGraph("fetch.fullCompany")
    List<Company> findAllByAccount(Account account);

    @EntityGraph("fetch.fullCompany")
    Optional<Company> findFirstByAccountAndInfoCnpj(Account account, String cnpj);

    @EntityGraph("fetch.fullCompany")
    Optional<Company> findFirstByAccountAndInfoCpf(Account account, String cpf);
}
