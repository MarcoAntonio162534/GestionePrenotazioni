package it.gest.pren.rest.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.gest.pren.rest.crud.model.Citta;
import it.gest.pren.rest.crud.model.Edificio;
import it.gest.pren.rest.crud.model.EnumPostazione;
import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.model.Prenotazione;
import it.gest.pren.rest.crud.service.EdificioService;
import it.gest.pren.rest.crud.service.PostazioneService;

@RestController
@RequestMapping("/controllerpostazioni")
public class ControllerPostazioni {

	@Autowired
	PostazioneService postazioneService;

	@GetMapping("/findallpostazioni")
	public List<Postazione> findAllPostazioni() {
		return postazioneService.allPostazione();
	}

	@GetMapping("/findpostazionebyid")
	public Optional<Postazione> findPostazioneById(@RequestParam Long id) {
		return postazioneService.postazioneById(id);
	}

	@Autowired
	EdificioService edificioService2;

	@GetMapping("/savepostazione")
	public void savePostazione(@RequestParam String codice, String descrizione, Integer numeroMassimo,
			EnumPostazione tipo, Long idEdificio) {
		postazioneService.savePostazione(codice, descrizione, numeroMassimo, tipo,
				edificioService2.getEdificioById(idEdificio));
	}

	@GetMapping("/findpostazionebytipo")
	public List<Postazione> findByTipo(@RequestParam EnumPostazione tipo, String citta) {
		return postazioneService.findByPostazione(tipo, citta);
	}

	@GetMapping("/findallpostazionipageable")
	public Page<Postazione> findAll(Pageable pageable) {
		return postazioneService.myFindAllPostazionePageable(pageable);
	}

	@GetMapping("/findpostazionebycodiceunivoco")
	public List<Postazione> findAllPostazioniSortedAsc() {
		return postazioneService.findAllPostazioniSorted();
	}

	@GetMapping("/findallpostazionibycodiceunivoco")
	public ResponseEntity<List<Postazione>> findAllPostazioniByCodiceUnivoco(@RequestParam Integer page, Integer size,
			@RequestParam(defaultValue = "codiceUnivoco") String sort) {
		List<Postazione> listaPostazioniCodiceUnivoco = postazioneService.findAllpostazioniSortedByCodiceUnivoco(page,
				size, sort);
		return new ResponseEntity<List<Postazione>>(listaPostazioniCodiceUnivoco, new HttpHeaders(), HttpStatus.OK);
	}
}
