package it.gest.pren.rest.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.gest.pren.rest.crud.model.Citta;
import it.gest.pren.rest.crud.model.Edificio;
import it.gest.pren.rest.crud.service.ServiceCitta;

@RestController
@RequestMapping("/controllercitta")
public class ControllerCitta {

	@Autowired
	ServiceCitta serviceCitta;
	
	@GetMapping("/findallcitta")
	public List<Citta> findAllCitta() {
		return serviceCitta.findAllCitta();
	}

	@GetMapping("/findcittabyid")
	public Optional<Citta> findCittaById(@RequestParam Long id) {
		return serviceCitta.findCittaById(id);
	}
	
	@PostMapping("/savecitta")
	public void saveCitta(@RequestParam String nome) {
		Citta citta = new Citta(nome);
		serviceCitta.saveCitta(citta);
	}

	@GetMapping("/findcittabynome")
	public List<Optional<Citta>> findCittaByNome(@RequestParam String nome) {
		return serviceCitta.findCittaByNome(nome);
	}

	@GetMapping("/findcittabynameasc")
	public List <Citta> findCittaByNameAsc(){
		return serviceCitta.findCittaByNameAsc();
	}
	
	@GetMapping("/findcittabynamesortedpage")
	public ResponseEntity<List<Citta>> findAllPostazioniByCodiceUnivoco(@RequestParam Integer page, Integer size,
			@RequestParam(defaultValue = "nome") String sort) {
		List<Citta> listaCitta = serviceCitta.findCittaByNameSortedPage(page, size, sort);
		return new ResponseEntity<List<Citta>>(listaCitta, new HttpHeaders(), HttpStatus.OK);
	}
}
