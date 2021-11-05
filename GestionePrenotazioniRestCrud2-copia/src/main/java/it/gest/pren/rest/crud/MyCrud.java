package it.gest.pren.rest.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import it.gest.pren.rest.crud.model.Citta;
import it.gest.pren.rest.crud.model.Edificio;
import it.gest.pren.rest.crud.model.EnumPostazione;
import it.gest.pren.rest.crud.model.Postazione;
import it.gest.pren.rest.crud.model.Prenotazione;
import it.gest.pren.rest.crud.model.Role;
import it.gest.pren.rest.crud.model.User;
import it.gest.pren.rest.crud.model.EnumRoleType;
import it.gest.pren.rest.crud.service.EdificioService;
import it.gest.pren.rest.crud.service.PostazioneService;
import it.gest.pren.rest.crud.service.PrenotazioneService;
import it.gest.pren.rest.crud.service.RoleService;
import it.gest.pren.rest.crud.service.ServiceCitta;
import it.gest.pren.rest.crud.service.UserService;

@Component
public class MyCrud implements CommandLineRunner{

	@Autowired
	PostazioneService postazioneService;
	@Autowired
	PrenotazioneService prenotazioneService;
	@Autowired
	RoleService roleService;
	@Autowired
	ServiceCitta serviceCitta;
	@Autowired
	EdificioService serviceEdificio;
	@Autowired
	UserService userService;
	
	
	@Override
	public void run(String... args) throws Exception {
//		User user=new User("playTicci","Marco Antonio","sciaobelo@dskgs","123");
//		User user2=new User("Gennaro","gennarino","sciaobela@gdjhds","1234");
//		userService.saveUser(user);
//		userService.saveUser(user2);
//		
//        Citta citta=new Citta("Roma");
//        serviceCitta.saveCitta(citta);
//
//        Edificio edificio=new Edificio("Duomo", "via dei mille 1", citta, "12345678");
//        serviceEdificio.saveEdificio(edificio);
//        
//        roleService.saveRole(new Role(EnumRoleType.ROLE_ADMIN));
//        
//        Postazione postazione=new Postazione("P245I", "Poltronissima", EnumPostazione.PRIVATO, 2, edificio);
//        postazioneService.savePostazione2(postazione);
//        
//        prenotazioneService.savePrenotazione3(userService.getById(3L), postazione , LocalDate.of(2021, 10, 29));		
////        prenotazioneService.savePrenotazione(user2, postazione, LocalDate.of(21, 10, 30));		
//       
////        prenotazioneService.allPrenotazioni();
	}

}
