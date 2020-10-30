package Gestion;

public class Edition {
	int id_edition;
	int no_edition;
	int nombre_exemplaire;
	String date_edition;
	private Livre liv;
	public Livre getLiv() {
		return liv;
	}
	public void setLiv(Livre liv) {
		this.liv = liv;
	}
	public Edition() {
		super();
	}
	public Edition(int NoEdition, int nombreExemplaire) {
		this.no_edition = NoEdition;
		this.nombre_exemplaire = nombreExemplaire;

	}
	public Edition(int IdEdition, int NoEdition, int nombreExemplaire, String date) {
		this.id_edition = IdEdition;
		this.no_edition = NoEdition;
		this.nombre_exemplaire = nombreExemplaire;
		this.date_edition = date;
	}
	public int getId_edition() {
		return id_edition;
	}
	public void setId_edition(int id_edition) {
		this.id_edition = id_edition;
	}
	public int getNo_edition() {
		return no_edition;
	}
	public void setNo_edition(int no_edition) {
		this.no_edition = no_edition;
	}
	public int getNombre_exemplaire() {
		return nombre_exemplaire;
	}
	public void setNombre_exemplaire(int nombre_exemplaire) {
		this.nombre_exemplaire = nombre_exemplaire;
	}
	public String getDate_edition() {
		return date_edition;
	}
	public void setDate_edition(String date_edition) {
		this.date_edition = date_edition;
	}
	
	public String toString() {
		return "ID : " + this.id_edition + " Édition: " + this.no_edition + " Nombre: " + this.nombre_exemplaire + " Date: " + this.date_edition;
	}
}
