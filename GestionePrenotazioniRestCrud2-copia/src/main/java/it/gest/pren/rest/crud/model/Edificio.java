package it.gest.pren.rest.crud.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import it.gest.pren.rest.crud.security.StringAttributeConverter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
@Entity
@Table(name = "edifici")
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String nome;
	protected String indirizzo;
	
	@ManyToOne
	protected Citta citta;
	
	@Convert(converter= StringAttributeConverter.class)
	@Size (min=8,max=8,message="password non corretta")
	protected String pin;

	public Edificio(String nome, String indirizzo, Citta citta, String pin) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.pin = pin;
	}
	
	public Edificio() {
		
	}

}
