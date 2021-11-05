package it.gest.pren.rest.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gest.pren.rest.crud.model.Role;
import it.gest.pren.rest.crud.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
	
	public  Optional<Role> findRoleById(Long id) {
		return roleRepository.findById(id);
	}

	public List<Role> findAllRole() {
		return roleRepository.findAll();
	}

}
