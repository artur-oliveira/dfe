package com.softart.dferestapi.models.auth.request;

import com.softart.dferestapi.models.auth.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public final class RegisterRequest {
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String username;
    @Email
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String password;
    @NotEmpty
    private Set<RoleType> roles = new HashSet<>();
}
