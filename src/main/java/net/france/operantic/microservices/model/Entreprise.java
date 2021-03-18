package net.france.operantic.microservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operantic_entreprise")
public class Entreprise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nom", length = 65)
	private String nom;
	
	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", nom=" + nom + "]";
	}

	public Entreprise(String nom) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
	}
	
	
}
