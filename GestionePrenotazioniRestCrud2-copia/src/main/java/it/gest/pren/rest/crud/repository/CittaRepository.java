package it.gest.pren.rest.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.gest.pren.rest.crud.model.Citta;
import it.gest.pren.rest.crud.model.Prenotazione;


public interface CittaRepository extends JpaRepository<Citta, Long> {

	@Query ("SELECT c FROM Citta c WHERE c.nome = :nome")
	public List <Optional<Citta>> findCittaByNome(String nome);
	
	public List<Citta> findByOrderByNomeAsc();

}
//<>