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
import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	EdificioRepository edificioRepository;
	
	public void saveEdificio(Edificio edificio) {
		edificioRepository.save(edificio);
	}

	public void saveEdificio2(String nome, String indirizzo, Citta citta, String pin) {
		 edificioRepository.save(new Edificio(nome,indirizzo,citta, pin));
	}
	public Optional<Edificio> findEdificiById(Long id) {
		return edificioRepository.findById(id);
	}
	
	public List<Edificio> findAllEdifici() {
		return edificioRepository.findAll();
	}
	
	public Edificio getEdificioById(Long id) {
		return edificioRepository.getById(id);
	}

	public List<Optional<Edificio>> getEdificioByCitta(String citta) {
		return edificioRepository.getEdificioByCitta(citta);
	}

	public List<Edificio> findEdificioByNameAsc(){
		return edificioRepository.findByOrderByNomeAsc();
	}

	public List<Edificio> findEdificioByNameSortedPage(Integer page, Integer size, String sort){
		 Pageable paging = PageRequest.of(page, size, Sort.by(sort));
	        Page<Edificio> pagedResult = edificioRepository.findAll(paging);
	        if (pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Edificio>();
	        }
	    }
	}

//<>
