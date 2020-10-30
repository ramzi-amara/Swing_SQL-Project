package Gestion;

public class Commande {

	private int id_commande;
	private int id_librairie;
	public Commande(int id_commande, int id_librairie) {
		super();
		this.id_commande = id_commande;
		this.id_librairie = id_librairie;
	}
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public int getId_librairie() {
		return id_librairie;
	}
	public void setId_librairie(int id_librairie) {
		this.id_librairie = id_librairie;
	}
	
	
}
