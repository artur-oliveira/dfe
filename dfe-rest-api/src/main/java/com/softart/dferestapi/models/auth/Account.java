package com.softart.dferestapi.models.auth;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.BinaryOperator;

@Entity
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(name = "unique_username", columnNames = {"username"}),
        @UniqueConstraint(name = "unique_email", columnNames = {"email"})
})
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "fetch.fullAccount",
                includeAllAttributes = true
        )
})
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String username;
    @Email
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String email;
    @JsonIgnore
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, columnDefinition = "BIT DEFAULT 1")
    @Builder.Default
    private Boolean enabled = Boolean.TRUE;
    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    @Builder.Default
    private Boolean locked = Boolean.FALSE;
    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    @Builder.Default
    private Boolean expired = Boolean.FALSE;
    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    @Builder.Default
    private Boolean credentialsExpired = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Transient
    public boolean hasRole(RoleType role) {
        return getRoles().stream().anyMatch(it -> Objects.equals(it.getName(), role));
    }

    @Transient
    @JsonIgnore
    public boolean isAdmin() {
        return hasRole(RoleType.ADMIN);
    }
}
