package it.gest.pren.rest.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected String codiceUnivoco;
	protected String descrizione;
	protected EnumPostazione tipoPostazione;
	protected int numeroMaxPartecipanti;
	
	@ManyToOne
	protected Edificio edificio;
	
	public Postazione(String codiceUnivoco, String descrizione, EnumPostazione tipoPostazione,
			int numeroMaxPartecipanti, Edificio edificio) {
		this.codiceUnivoco = codiceUnivoco;
		this.descrizione = descrizione;
		this.tipoPostazione = tipoPostazione;
		this.numeroMaxPartecipanti = numeroMaxPartecipanti;
		this.edificio = edificio;
	}



}
