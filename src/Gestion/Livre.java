package Gestion;



public class Livre {
	private String ISBN;
	private int no_livre;
	private int id_livre;
	private String titre;
	private double prix;
	private int nb_Edition;
	Edition edition;
	private Auteur auteur;
	
	public Livre(int nb) {
		setNb_Edition(nb);
		edition=new Edition();
		auteur=new Auteur();
		
		
	}
	public Livre(int idLivre, int noLivre, String isbn, String titre, int noEdition, double prix) {
		super();
		this.id_livre = idLivre;
		this.no_livre = noLivre;
		this.ISBN = isbn;
		this.titre = titre;
		this.prix = prix;
		auteur=new Auteur();
		

	}

	public int getNb_Edition() {
		return nb_Edition;
	}
	public void setNb_Edition(int nb_Edition) {
		this.nb_Edition = nb_Edition;
	}
	public Livre(String titre) {
		this.titre = titre;
	}
	public Livre(String titre,int num) {
		edition=new Edition();
		this.titre = titre;
		edition.setNombre_exemplaire(num);
	}

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getNo_livre() {
		return no_livre;
	}
	public void setNo_livre(int num) {
		this.no_livre = num;
	}
	public int getId_livre() {
		return id_livre;
	}
	public void setId_livre(int id) {
		this.id_livre = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String nom) {
		this.titre = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String toString() {
		return " ID: " + this.id_livre + " Numéro: " + this.no_livre + " ISBN: " + this.ISBN + " Titre: " + this.titre + " Edition: "  + " Prix: " + this.prix;
	}


}
