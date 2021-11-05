package it.gest.pren.rest.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.gest.pren.rest.crud.model.EnumRoleType;
import it.gest.pren.rest.crud.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByRoleType(EnumRoleType roletype);

}
