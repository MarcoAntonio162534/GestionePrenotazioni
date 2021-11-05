package it.gest.pren.rest.crud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.gest.pren.rest.crud.model.User;

public interface PageRepository extends PagingAndSortingRepository<User, Long> {

	public Page<User> findAll(Pageable pageable);
}
