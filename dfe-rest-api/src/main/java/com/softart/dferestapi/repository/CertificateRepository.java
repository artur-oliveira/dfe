package com.softart.dferestapi.repository;

import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.certificate.Certificate;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    @EntityGraph("fetch.fullCertificate")
    List<Certificate> findAllByAccount(Account account);

    @EntityGraph("fetch.fullCertificate")
    Optional<Certificate> findByAccountAndMd5(Account account, String md5);

}
