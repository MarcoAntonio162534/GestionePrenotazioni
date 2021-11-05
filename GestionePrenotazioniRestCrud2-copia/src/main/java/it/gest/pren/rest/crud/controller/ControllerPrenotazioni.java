package it.gest.pren.rest.crud.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.model.Prenotazione;
import it.gest.pren.rest.crud.model.User;
import it.gest.pren.rest.crud.service.PostazioneService;
import it.gest.pren.rest.crud.service.PrenotazioneService;
import it.gest.pren.rest.crud.service.UserService;

@RestController
@RequestMapping("/controllerprenotazioni")
public class ControllerPrenotazioni {

	@Autowired
	PrenotazioneService prenotazioneService;
	
	@GetMapping("/findallprenotazioni")
	public List<Prenotazione> findAllPrenotazioni() {
		return prenotazioneService.findallPrenotazioni();
	}
	
	@GetMapping("/findprenotazionibyid")
	public Optional<Prenotazione> findPrenotazioniById(@RequestParam Long id) {
		return prenotazioneService.findPrenotazioniById(id);
	}

	@PostMapping("/saveprenotazione")
	public void savePrenotazione(@RequestParam User user, Postazione postazione, LocalDate dataPrenotata) {
		prenotazioneService.savePrenotazione3(user, postazione, dataPrenotata);
	}

	@Autowired
    UserService uServ;
    @Autowired
    PostazioneService pServ;
    
    @GetMapping("/savebookingget2")
    public void save(@RequestParam Long userId, Long postId, int y, int m, int d) {
        prenotazioneService.savePrenotazione3(uServ.getById(userId), pServ.getById(postId), LocalDate.of(y, m, d));
    }

    @GetMapping("/findbydataprenotataasc")
    public List<Prenotazione> findByDataPrenotataAsc() {
    	return prenotazioneService.findBydataPrenotataAsc();
    }

    @GetMapping("/findallprenotazionipagesorted")

    public ResponseEntity<List<Prenotazione>> findAllPrenotazioniPAgeSort(@RequestParam Integer page, Integer size,@RequestParam(defaultValue= "dataPrenotata") String sort){
    	List<Prenotazione> listaPrenotazioni = prenotazioneService.myFindAllPrenotazioniPageSizeSort(page, size, sort);
    	return new ResponseEntity<List<Prenotazione>>(listaPrenotazioni, new HttpHeaders(),HttpStatus.OK);
    }
}
//<>