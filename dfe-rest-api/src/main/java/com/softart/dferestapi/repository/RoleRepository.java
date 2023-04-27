package com.softart.dferestapi.repository;

import com.softart.dferestapi.models.auth.Role;
import com.softart.dferestapi.models.auth.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findRoleByName(RoleType name);

    Set<Role> findAllByNameIn(Set<RoleType> names);

}
