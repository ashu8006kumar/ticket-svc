package io.arha.ticketsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.arha.ticketsvc.entity.Role;
import io.arha.ticketsvc.enums.RoleType;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(RoleType name);
}
