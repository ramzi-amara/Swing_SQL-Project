package Gestion;

public class CommandeLivre {

	private String titre;
	private int no_edition;
	private int quantite;
	private int id_librarie;
	
	public CommandeLivre(String titre, int no_edition, int quantite, int id_librarie) {
		this.titre = titre;
		this.no_edition = no_edition;
		this.quantite = quantite;
		this.id_librarie = id_librarie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNo_edition() {
		return no_edition;
	}
	public void setNo_edition(int no_edition) {
		this.no_edition = no_edition;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getId_librarie() {
		return id_librarie;
	}
	public void setId_librarie(int id_librarie) {
		this.id_librarie = id_librarie;
	}
	
	
}
