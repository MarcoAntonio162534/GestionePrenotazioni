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

import it.gest.pren.rest.crud.model.Citta;
import it.gest.pren.rest.crud.model.Edificio;
import it.gest.pren.rest.crud.repository.CittaRepository;

@Service
public class ServiceCitta  {

	@Autowired
	CittaRepository cittaRepository;

	public void saveCitta(Citta citta) {
		cittaRepository.save(citta);
		
	}
	public Optional<Citta> findCittaById(Long id) {
		return cittaRepository.findById(id);
	}

	public List<Citta> findAllCitta() {
		return cittaRepository.findAll();
	}

	public Citta findCittabyId2(Long id) {
		return cittaRepository.getById(id);
	}

	public List<Optional<Citta>> findCittaByNome(String nome) {
		return cittaRepository.findCittaByNome(nome);
	}

	public List<Citta> findCittaByNameAsc(){
		return cittaRepository.findByOrderByNomeAsc();
	}

	public List<Citta> findCittaByNameSortedPage(Integer page, Integer size, String sort){
		 Pageable paging = PageRequest.of(page, size, Sort.by(sort));
	        Page<Citta> pagedResult = cittaRepository.findAll(paging);
	        if (pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Citta>();
	        }
	    }
	}

