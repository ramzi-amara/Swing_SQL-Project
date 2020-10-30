package Gestion;

import java.util.ArrayList;

public class Librairie {
	private int id_librairie;
	private String nom_librairie;
	private String adresse_librairie;
	
	public Librairie(int Idlibrairie, String Nomlibrairie, String Adresselibrairie) {
		this.id_librairie = Idlibrairie;
		this.nom_librairie = Nomlibrairie;
		this.adresse_librairie = Adresselibrairie;
	}

	public int getId_librairie() {
		return id_librairie;
	}

	public void setId_librairie(int id_librairie) {
		this.id_librairie = id_librairie;
	}

	public String getNom_librairie() {
		return nom_librairie;
	}

	public void setNom_librairie(String nom_librairie) {
		this.nom_librairie = nom_librairie;
	}

	public String getAdresse_librairie() {
		return adresse_librairie;
	}

	public void setAdresse_librairie(String adresse_librairie) {
		this.adresse_librairie = adresse_librairie;
	}
	
	public String toString() {
		return " ID: " + this.id_librairie + " Nom: " + this.nom_librairie + " Adresse: " + this.adresse_librairie;
	}
}
