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
import it.gest.pren.rest.crud.model.EnumPostazione;
import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.model.Prenotazione;
import it.gest.pren.rest.crud.model.User;
import it.gest.pren.rest.crud.repository.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepository;

	public List<Postazione> allPostazione() {
		return postazioneRepository.findAll();
	}

	public Optional<Postazione> postazioneById(Long id) {
		return postazioneRepository.findById(id);
	}

	public void savePostazione(String codice, String descrizione, Integer numeroMassimoOccupati,
			EnumPostazione tipoPostazione, Edificio edificio) {
		postazioneRepository.save(new Postazione(codice, descrizione, tipoPostazione, numeroMassimoOccupati, edificio));
	}

	public void savePostazione2(Postazione postazione) {
		postazioneRepository.save(postazione);
	}

	public List<Postazione> findByPostazione(EnumPostazione tipo, String city) {
		return postazioneRepository.findByPostazione(tipo, city);
		
	}

	public Postazione getById(Long id) {
		return postazioneRepository.getById(id);
	}
	public Page <Postazione> myFindAllPostazionePageable(Pageable pageable) {
		return postazioneRepository.findAll(pageable);
	}
	public List<Postazione> findAllPostazioniSorted() {
		return postazioneRepository.findByOrderByCodiceUnivocoAsc();
	}

	public List<Postazione> findAllpostazioniSortedByCodiceUnivoco(Integer page, Integer size, String sort){
		  Pageable paging = PageRequest.of(page, size, Sort.by(sort));
	        Page<Postazione> pagedResult = postazioneRepository.findAll(paging);
	        if (pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Postazione>();
	        }
	    }
	}

