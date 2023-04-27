package com.softart.dferestapi.models.certificate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.company.Company;
import com.softart.dferestapi.services.encrypt.EncryptService;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "certificate", uniqueConstraints = {@UniqueConstraint(name = "unique_md5", columnNames = {"md5"})})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "fetch.fullCertificate",
                includeAllAttributes = true
        )
})
public final class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "alias", nullable = false)
    private String alias;

    @NotBlank
    @Column(name = "subject", nullable = false)
    private String subject;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificate")
    @Builder.Default
    private Set<Company> companies = new HashSet<>();

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    @JsonIgnore
    private String decryptedPassword;

    @NotBlank
    @Column(name = "salt", nullable = false)
    private String salt;

    @NotBlank
    @Column(name = "md5", nullable = false)
    private String md5;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expires_at", nullable = false)
    private Date expiresAt;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    public Certificate decrypt(EncryptService service) {
        setDecryptedPassword(service.decrypt(getPassword(), getSalt()));
        return this;
    }

    @SuppressWarnings("unused")
    public String getDecryptedPassword(EncryptService service) {
        return decrypt(service).decryptedPassword;
    }
}
