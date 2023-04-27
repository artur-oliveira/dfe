package com.softart.dferestapi.configuration;

import com.softart.dferestapi.models.auth.Role;
import com.softart.dferestapi.models.auth.RoleType;
import com.softart.dferestapi.repository.RoleRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Configuration
@Getter
public class RoleConfiguration {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleConfiguration(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    @Transactional
    public void createAllRoles() {
        for (RoleType type : RoleType.values()) {
            Optional<Role> role = getRoleRepository().findRoleByName(type);
            if (!role.isPresent()) getRoleRepository().save(Role.builder().name(type).build());
        }
    }

}
