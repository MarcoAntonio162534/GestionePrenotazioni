package it.gest.pren.rest.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.gest.pren.rest.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
//	@Query("SELECT u FROM user u WHERE u.age =:age")
//    List<Optional<MyUser>> myFindByUserAge(int age);

	public Page<User> findAll(Pageable pageable);
	
	/* Sort */
    // Formula: findBy + OrderBy + NomeColonna + Ordinamento(Asc/Desc)
    public List<User> findByOrderByUsernameDesc();

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
