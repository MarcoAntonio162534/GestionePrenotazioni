package it.gest.pren.rest.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import it.gest.pren.rest.crud.model.User;
import it.gest.pren.rest.crud.repository.PageRepository;
import it.gest.pren.rest.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PageRepository pageRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public Optional<User> findById (Long Id) {
        return userRepository.findById(Id);
    }
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	public User getById (Long Id) {
        return userRepository.getById(Id);
    }

	public Page <User> myFindAllUsersPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	public Page<User> myFindAllUsersPageSize(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<User> pagedResult = userRepository.findAll(paging);
        if(pagedResult.hasContent()) {
      return pagedResult;
      } else {
          return null;
      }
    }
	// Paginazione e Ordinamento
    public List<User> myFindAllUsersPageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<User> pagedResult = userRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }

 // Ordinamento
    public List<User> myFindAllUsersSorted() {
        return userRepository.findByOrderByUsernameDesc();
    }
}


//<>