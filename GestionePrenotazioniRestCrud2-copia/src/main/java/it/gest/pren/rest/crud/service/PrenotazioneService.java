package it.gest.pren.rest.crud.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.model.Prenotazione;
import it.gest.pren.rest.crud.model.User;
import it.gest.pren.rest.crud.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	public boolean checkMaxNumber(Postazione postazione, LocalDate dataPrenotata) {
		List<Optional<Prenotazione>> prenotazioni = prenotazioneRepository.findPrenotazione(dataPrenotata, postazione);
		if (prenotazioni.size() < postazione.getNumeroMaxPartecipanti()) {
			return true;
		} else {
			return false;
		}
	}

	public void savePrenotazione3(User user, Postazione postazione, LocalDate dataPrenotata) {

		if (checkMaxNumber(postazione, dataPrenotata)) {
			if (checkDay(dataPrenotata)) {
				if (checkUser(user, dataPrenotata)) {
					prenotazioneRepository.save(new Prenotazione(user, postazione, dataPrenotata));
					System.out.println("Postazione prenotata");
				} else {
					System.out.println("L'utente ha già una prenotazione attiva per la data selezionata");
				}
			} else {
				System.out.println("Prenotazioni disponibili solo oltre i due giorni");
			}
		} else {
			System.out.println("Postazione non disponibile");
		}
	}

	public boolean checkDay(LocalDate dataPrenotata) {
		LocalDate today = LocalDate.now();
		if (dataPrenotata.minusDays(2).isAfter(today)) {
			return true;
		}
		return false;
	}

//	public boolean checkDay(LocalDate dataPrenotata, LocalDate dataPrenotazione) {
////		LocalDate today = LocalDate.now();
//		if (dataPrenotazione != dataPrenotata.minusDays(2)) {
//			return true;
//		}
//		return false;
//	}
	public boolean checkUser(User user, LocalDate data) {
		List<Optional<Prenotazione>> lista = prenotazioneRepository.findPrenotazionePerUtente(user, data);
		if (lista.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public List<Prenotazione> findallPrenotazioni() {
		return prenotazioneRepository.findAll();
	}

	public void savePrenotazione2(Prenotazione prenotazione) {
		prenotazioneRepository.save(prenotazione);
	}

	public Optional<Prenotazione> findPrenotazioniById(Long id) {
		return prenotazioneRepository.findById(id);
		
	}

	public List<Prenotazione> findBydataPrenotataAsc() {
		return prenotazioneRepository.findByOrderByDataPrenotataAsc();
	}

	public List<Prenotazione> myFindAllPrenotazioniPageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<Prenotazione> pagedResult = prenotazioneRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Prenotazione>();
        }
    }
}
