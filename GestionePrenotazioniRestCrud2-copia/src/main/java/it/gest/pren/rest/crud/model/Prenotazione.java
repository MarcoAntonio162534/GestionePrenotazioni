package it.gest.pren.rest.crud.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@ManyToOne
	@NonNull
	protected User user;

	@ManyToOne
	@NonNull
	protected Postazione postazione;

	@NonNull
	protected LocalDate dataPrenotata;

	protected LocalDate dataPrenotazione;

	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotata) {
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = LocalDate.now();
	}

}
