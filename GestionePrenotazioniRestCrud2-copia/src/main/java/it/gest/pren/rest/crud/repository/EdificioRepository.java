package it.gest.pren.rest.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.gest.pren.rest.crud.model.Edificio;
import it.gest.pren.rest.crud.model.Prenotazione;


public interface EdificioRepository extends JpaRepository<Edificio, Long>{

	
	@Query("SELECT e FROM Edificio e WHERE e.citta.nome= :citta")
	public List <Optional<Edificio>> getEdificioByCitta(String citta);

	public List<Edificio> findByOrderByNomeAsc();

}
//<>