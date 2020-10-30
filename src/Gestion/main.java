package Gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class main {
		
	public static void con() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Classe trouvé");
		}catch(ClassNotFoundException e) {
			System.out.println("Classe non trouvé");
		}
		String ChaineDeConnexion = "jdbc:sqlserver://localhost;database=GestionLivre;user=librairie;password=livre";
		try {
			Connection connexion = DriverManager.getConnection(ChaineDeConnexion);
			System.out.println("Connexion réussie");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//PAR HAMZA BELLAHSEN ET RAMZI AMARA MADI
	public static void main(String[] args) {
		FenetreMain mainWindow = new FenetreMain();
		mainWindow.setVisible(true);
		
		
		//ArrayList listeLivre =  new ArrayList();
		//ArrayList listeAuteur =  new ArrayList();
		//ArrayList listeEdition =  new ArrayList();
		//ArrayList listeLibrairie =  new ArrayList();
		
		/*
		connexion.ListeAuteur(listeAuteur);
		connexion.ListeLivre(listeLivre);
		connexion.ListeEdition(listeEdition);
		connexion.ListeLibrairie(listeLibrairie);
		//listeAuteur.afficher();
		listeAuteur.afficher();
		System.out.println("");
		listeLivre.afficher();
		System.out.println("");
		listeEdition.afficher();
		System.out.println("");
		listeLibrairie.afficher();
		*/
		
		
	}

}
