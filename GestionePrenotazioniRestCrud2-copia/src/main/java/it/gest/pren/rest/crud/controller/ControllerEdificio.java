package it.gest.pren.rest.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.repository.CittaRepository;
import it.gest.pren.rest.crud.service.EdificioService;
import it.gest.pren.rest.crud.service.ServiceCitta;

@RestController
@RequestMapping("/controlleredificio")
public class ControllerEdificio {

	@Autowired
	EdificioService edificioService;

	@GetMapping("/findalledifici")
	public List<Edificio> findAllEdifici() {
		return edificioService.findAllEdifici();
	}

	@GetMapping("/findedificibyid")
	public Optional<Edificio> findEdificiById(@RequestParam Long id) {
		return edificioService.findEdificiById(id);
	}

	@Autowired
	ServiceCitta serviceCitta;

	@GetMapping("/saveedificio")
	public void saveEdificio(@RequestParam String nome, String indirizzo, Long idCitta, String pin) {
		edificioService.saveEdificio2(nome, indirizzo, serviceCitta.findCittabyId2(idCitta), pin);
	}

	@PostMapping("/saveedificio2")
	public String saveEdificio2(@RequestBody Edificio edificio) {
		try {
			edificioService.saveEdificio(edificio);
			return "Edificio salvato correttamente";
		} catch (Exception e) {
			return "Errore! Edificio non salvato ";
		}
	}

	@GetMapping("/findeficiobycitta")
	public List<Optional<Edificio>> findEdificioByCitta(@RequestParam String citta) {
		return edificioService.getEdificioByCitta(citta);
	}

	@GetMapping("/findedificiobynameasc")
	public List<Edificio> findEdificioByNameAsc() {
		return edificioService.findEdificioByNameAsc();
	}

	@GetMapping("/findalledificibynomesortedpage")
	public ResponseEntity<List<Edificio>> findAllPostazioniByCodiceUnivoco(@RequestParam Integer page, Integer size,
			@RequestParam(defaultValue = "nome") String sort) {
		List<Edificio> listaEdifici = edificioService.findEdificioByNameSortedPage(page, size, sort);
		return new ResponseEntity<List<Edificio>>(listaEdifici, new HttpHeaders(), HttpStatus.OK);
	}

}
