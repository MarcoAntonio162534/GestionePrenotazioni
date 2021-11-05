package it.gest.pren.rest.crud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.epicode.StringAttributeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String username;
	protected String nomeCompleto;
	@Convert(converter = StringAttributeConverter.class)
	protected String email;
	protected String password;
	protected boolean active;
	
	@ManyToMany
	@JoinTable
	protected Set<Role> roles = new HashSet<>();

	public User(String username, String nomeCompleto, String email, String password) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.password = password;
		this.active = true;
	}

}

//<>