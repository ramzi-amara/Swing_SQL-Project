package Gestion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FenetreMain extends JFrame implements ActionListener {

	JPanel pano,pnTitre;
	JLabel lbltitre;
	JButton btnAuteur, btnLivre, btnEdition, btnLibrairie;
	static JTextField  txtAuteur,txtLivre,txtEdition,txtLibrairie;

	
	private static ListGen<Livre> listeLivre = new ListGen<>();
	private static ListGen<Auteur> listeAuteur = new ListGen<>();
	private static ListGen<Edition> listeEdition = new ListGen<>();
	private static ListGen<Librairie> listeLibrairie = new ListGen<>();
	
	public FenetreMain() {
		setTitle("TP2");	
		setResizable(false);
		setSize( 500, 300);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbltitre=new JLabel("Bienvenue");
		Font font=new Font("Arial",Font.BOLD,18);
		lbltitre.setFont(font);
		lbltitre.setBounds(200, 0, 200, 30);
		pnTitre=new JPanel();
		pnTitre.setLayout(new BoxLayout(pnTitre, BoxLayout.LINE_AXIS));
		pnTitre.add(lbltitre);
		propriete_btnAuteur();
		propriete_btnLivre();
		propriete_btnEdition();
		propriete_btnLibrairie();
		propriete_txtAuteur();
		propriete_txtLivre();
		propriete_txtEdition();
		propriete_TxtLibrairie();
		propriete_pano();
		getContentPane().add(pano); 
		connexion.ListeAuteur(listeAuteur);
		connexion.ListeLivre(listeLivre);
		connexion.ListeEdition(listeEdition);
		connexion.ListeLibrairie(listeLibrairie);
	}
	
	private void propriete_pano() {
		pano=new JPanel();
		pano.setLayout(null);
		pano.add(btnAuteur);
		pano.add(btnLivre);
		pano.add(btnEdition);
		pano.add(btnLibrairie);
		pano.add(lbltitre);
		pano.add(txtAuteur);
		pano.add(txtLivre);
		pano.add(txtEdition);
		pano.add(txtLibrairie);
	}
	
	private void propriete_pnTitre() {
		pnTitre=new JPanel();
		pnTitre.setLayout(new BoxLayout(pnTitre, BoxLayout.LINE_AXIS));
		pnTitre.add(lbltitre);
	}
	
	private void propriete_lbltitre(Font font) {
		lbltitre=new JLabel("Bienvenue");
		lbltitre.setFont(font);
		lbltitre.setBounds(200, 0, 200, 30);
		pnTitre.add(lbltitre);
	}
	
	private void propriete_btnAuteur() {
		btnAuteur=new JButton("Livres de l'auteur");
		btnAuteur.setBounds(50, 40, 200, 30);
		this.btnAuteur.addActionListener(this);
	}
	
	private void propriete_btnLivre() {
		btnLivre=new JButton("Informations du livre");
		btnLivre.setBounds(50, 75, 200, 30);
		this.btnLivre.addActionListener(this);

	}
	
	private void propriete_btnEdition() {
		btnEdition=new JButton("Informations de l'édition");
		btnEdition.setBounds(50, 110, 200, 30);
		this.btnEdition.addActionListener(this);

	}
	
	private void propriete_btnLibrairie() {
		btnLibrairie=new JButton("Commande de la librairie");
		btnLibrairie.setBounds(50, 145, 200, 30);
		this.btnLibrairie.addActionListener(this);
	}
	
	private void propriete_txtAuteur() {
		txtAuteur=new JTextField();
		txtAuteur.setBounds(300, 40, 100, 30);
	}
	
	private void propriete_txtLivre() {
		txtLivre=new JTextField();
		txtLivre.setBounds(300,75, 100, 30);
	}

	private void propriete_txtEdition() {
		txtEdition=new JTextField();
		txtEdition.setBounds(300,110, 100, 30);
	}

	private void propriete_TxtLibrairie() {
		txtLibrairie=new JTextField();
		txtLibrairie.setBounds(300,145, 100, 30);
	}
	public void actionPerformed(ActionEvent e) {
		fenetreListeLivre f1;
		fenetreInfosLivre f2 ;
		fenetreInfosEdition f3;
		FenetreCommande f4;
		
		if(e.getSource() == btnAuteur) {
			try {
				f1=new fenetreListeLivre();

			if(this.txtAuteur.getText() != null)
			{	
				f1.setVisible(true);
				
			 }
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Veuillez rentrer un numéro d'auteur valide", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtAuteur.setText("");

			}
			
			
		}
		if(e.getSource() == btnLivre) {
			try {
			f2=new fenetreInfosLivre();

			if(this.txtLivre.getText() != null)
			{	
				f2.setVisible(true);
				this.txtLivre.setText("");

				
			}
			}
			catch(Exception ex2) {
				JOptionPane.showMessageDialog(null, "Veuillez rentrer un numéro de livre valide", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtLivre.setText("");

			}
		
	}
		if(e.getSource() == btnEdition) {
			try {
			f3=new fenetreInfosEdition();
			if(this.txtEdition.getText() != null)
			{	
				f3.setVisible(true);
				this.txtEdition.setText("");

			}
			}
			catch(Exception ex3) {
				JOptionPane.showMessageDialog(null, "Veuillez rentrer un numéro d'édition valide", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtEdition.setText("");
			}
}
		if(e.getSource() == btnLibrairie) {
			try {
			f4=new FenetreCommande();
			if(this.txtLibrairie.getText() != null)
			{	
				f4.setVisible(true);
				
			}
			}
			catch(Exception ex4) {
				JOptionPane.showMessageDialog(null, "Veuillez rentrer un numéro de librairie valide", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtLibrairie.setText("");

			}
}
	}
	}
