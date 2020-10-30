package Gestion;

public class Auteur {
	private int id_auteur;
	private String nom_auteur;
	private int niveau_auteur;
	private Livre liv;
	
	public Livre getLiv() {
		return liv;
	}

	public void setLiv(Livre liv) {
		this.liv = liv;
	}

	public Auteur() {
		
	}
	
	public Auteur(int idAuteur, String nom, int niveau) {
		this.id_auteur = idAuteur;
		this.nom_auteur = nom;
		this.niveau_auteur = niveau;
	}

	public int getId_auteur() {
		return id_auteur;
	}

	public void setId_auteur(int id_auteur) {
		this.id_auteur = id_auteur;
	}

	public String getNom_auteur() {
		return nom_auteur;
	}

	public void setNom_auteur(String nom_auteur) {
		this.nom_auteur = nom_auteur;
	}

	public int getNiveau_auteur() {
		return niveau_auteur;
	}

	public void setNiveau_auteur(int niveau_auteur) {
		this.niveau_auteur = niveau_auteur;
	}
	
	public String toString() {
		return "ID: " + getId_auteur() + " Nom: " + getNom_auteur() + " niveau: " + getNiveau_auteur();
	}
	
}
