package Gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class connexion {
	private static final String sql = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String chaineConnexion = "jdbc:sqlserver://localhost;database=GestionLivre;user=librairie;password=livre";
	
	public static void Charge() throws ClassNotFoundException {
		Class.forName(sql);
	}
	//méthode pour récupérer tous les livres dans une liste
	public static void ListeLivre (ListGen<Livre> list) {
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			Statement st = connexion.createStatement();
			ResultSet result = st.executeQuery("select * from Livre");
			while(result.next()) {
				Livre livre = new Livre(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5), result.getDouble(6));
				list.Ajout(livre);
			}
			connexion.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//méthode pour récupérer tous les auteurs dans une liste
	public static void ListeAuteur (ListGen<Auteur> listeAuteur) {
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			Statement st = connexion.createStatement();
			ResultSet result = st.executeQuery("select * from Auteur");
			while(result.next()) {
				Auteur auteur = new Auteur(result.getInt(1), result.getString(2), result.getInt(3));
				listeAuteur.Ajout(auteur);
			}
			connexion.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//méthode pour récupérer toutes les éditions dans une liste
	public static void ListeEdition (ListGen<Edition> listeEdition) {
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			Statement st = connexion.createStatement();
			ResultSet result = st.executeQuery("select * from Edition");
			while(result.next()) {
				Edition edition = new Edition(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4));
				listeEdition.Ajout(edition);
			}
			connexion.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//méthode pour récupérer toutes les librairies dans une liste
	public static void ListeLibrairie (ListGen<Librairie> listeLibrarie) {
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			Statement st = connexion.createStatement();
			ResultSet result = st.executeQuery("select * from Librairie");
			while(result.next()) {	
				Librairie librairie = new Librairie(result.getInt(1), result.getString(2), result.getString(3));
				listeLibrarie.Ajout(librairie);
			}
			connexion.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//Cette méthode permet de retourner pour un numéro d'auteur la liste de ses livres
	public static ArrayList<Livre> Question1(int numero) throws SQLException {
		ArrayList<Livre> list = new ArrayList<>();
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			PreparedStatement inssql = connexion.prepareStatement("select t1.titre, t1.prix"
					                                           + " from Livre t1 inner join AuteurLivre t2 on t1.id_livre = t2.id_livre"
					                                                         + " inner join Auteur t3 on t3.id_auteur = t2.id_auteur"
					                                                         + " where t2.id_auteur = ?");
			inssql.setInt(1, numero);
			ResultSet result = inssql.executeQuery();
			while(result.next()) {
				Livre livre = new Livre(result.getString(1));
				livre.setPrix(result.getDouble(2));
				list.add(livre);
			}
			inssql.close();
		}catch(ClassNotFoundException e){
			System.out.println("Échec du chargement du driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Cette méthode permet de retourner le numéro d'édition et le nombre d'exemplaires d'un livre
	public static ArrayList<Edition> Question2(int numero) throws SQLException {
		ArrayList<Edition> list = new ArrayList<>();
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			PreparedStatement inssql = connexion.prepareStatement("select t3.no_edition,t3.nombre_exemplaire " + 
					"from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre" + 
					" inner join Edition t3 on t3.id_edition = t2.id_edition" + 
					" where t1.no_livre = ?");
			inssql.setInt(1, numero);
			ResultSet result = inssql.executeQuery();

			while(result.next()) {
				Edition edit=new Edition(result.getInt(1), result.getInt(2));
				list.add(edit);
			}

			inssql.close();
		}catch(ClassNotFoundException e){
			System.out.println("Échec du chargement du driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Cette méthode permet de retourner le nombre d'éditions et le nombre total d'exemplaires pour un livre (meme que question2 en haut)
	public static String Question2_nbEdition(int numero) throws SQLException {
		int nb=0;
		int totalEx=0;
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			PreparedStatement inssql = connexion.prepareStatement("select count(t3.no_edition),sum (t3.nombre_exemplaire)" + 
					" from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre" + 
					" inner join Edition t3 on t3.id_edition = t2.id_edition" + 
					" where t1.no_livre = ?");
			inssql.setInt(1,numero);
			ResultSet result = inssql.executeQuery();
			while (result.next()) {
			nb=result.getInt(1);
			totalEx=result.getInt(2);
		
			}
			inssql.close();
		}catch(ClassNotFoundException e){
			System.out.println("Échec du chargement du driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "Ce livre est tiré sous "+nb+" éditions pour un total de "+totalEx+" exemplaires";

	}
	//Cette méthode permet de retourner le nom du livre et le nombre d'exemplaires selon le numéro d'édition
	public static ArrayList<Livre> Question3(int numero) throws SQLException {
		ArrayList<Livre> list = new ArrayList<>();
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			PreparedStatement inssql = connexion.prepareStatement("select t1.titre, t3.nombre_exemplaire"
                    + " from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre"
                                  + " inner join Edition t3 on t3.id_edition = t2.id_edition"
                                  + " where t2.id_edition = ?");
			
			inssql.setInt(1, numero);
			ResultSet result = inssql.executeQuery();
			while(result.next()) {
				Livre livre=new Livre(result.getString(1),result.getInt(2));
				list.add(livre);
			}
			inssql.close();
		}catch(ClassNotFoundException e){
			System.out.println("Échec du chargement du driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Cette méthode permet de retourner la liste de livres commandés
	public static ArrayList<CommandeLivre> Question4(int numero) throws SQLException {
		ArrayList<CommandeLivre> list = new ArrayList<>();
		try {
			Charge();
			Connection connexion = DriverManager.getConnection(chaineConnexion);
			PreparedStatement inssql = connexion.prepareStatement("select t1.titre, t1.no_edition, t2.quantite, t3.id_librairie"
					+" from Livre t1 inner join CommandeLivre t2 on t1.id_livre = t2.id_livre"
							 +" inner join Commande t3 on t3.id_commande = t2.id_commande"
							 +" where t3.id_librairie = ?");
			inssql.setInt(1, numero);
			ResultSet result = inssql.executeQuery();			
			while(result.next()) {
				CommandeLivre livre=new CommandeLivre(result.getString(1), result.getInt(2), result.getInt(3),result.getInt(4));
				list.add(livre);
			}
			inssql.close();
		}catch(ClassNotFoundException e){
			System.out.println("Échec du chargement du driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
