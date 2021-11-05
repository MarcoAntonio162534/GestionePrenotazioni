package it.gest.pren.rest.crud.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.gest.pren.rest.crud.model.EnumPostazione;
import it.gest.pren.rest.crud.model.Postazione;


public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	@Query("SELECT p FROM Postazione p, Edificio e WHERE p.tipoPostazione = :tipo AND e.citta.nome =:city ")
	public List<Postazione> findByPostazione(EnumPostazione tipo, String city);
	
	public Page<Postazione> findAll(Pageable pageable);

	public List<Postazione> findByOrderByCodiceUnivocoAsc();
}

//<>