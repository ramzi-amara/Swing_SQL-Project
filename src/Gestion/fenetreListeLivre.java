package Gestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class fenetreListeLivre extends JFrame {

	JLabel lbltitre;
	JTable table;
	JScrollPane jsp;
	JPanel contentPane,tit;

	String col[] = {"Titre", "Prix"};
	DefaultTableModel model = new DefaultTableModel(col, 0);

	public fenetreListeLivre() {
		
		
		//setLayout(null);
		this.setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setTitle("TP2");
		setResizable(false);
		setBounds(100, 100, 300, 300);
		this.setLocationRelativeTo(null);
		lbltitre=new JLabel("Liste des livres de l'auteur");
		tit=new JPanel();
		add(tit,BorderLayout.NORTH);
		Font font = new Font("Arial",Font.BOLD,18);
		lbltitre.setFont(font);
		tit.add(lbltitre);
		//JScrollPane pnlTab = new JScrollPane();
		//pnlTab.setMaximumSize(new Dimension(500, 500));
		//Utilite.addRows(listeEtudiant, model);
		//table = new JTable(model);
		//pnlTab.setViewportView(table);
		//add(pnlTab, BorderLayout.CENTER);
		contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);

		JScrollPane jsp = new JScrollPane();
		jsp.setMaximumSize(new Dimension(500, 500));
		table = new JTable(model);
		model.addRow(col);
		table.setBounds(60,60,300,500);
		jsp.setViewportView(table);
		jsp.add(table);
		contentPane.add(Box.createVerticalStrut(150));
		contentPane.add(table);
		getContentPane().add(contentPane);
		//this.add(table);
		try {
			AjoutLigne(connexion.Question1(Integer.parseInt(FenetreMain.txtAuteur.getText())), model);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//remplir la jtable
	public static void AjoutLigne(ArrayList<Livre> lstLivre, DefaultTableModel model) {
		Object row[] = new Object[2];
		for (int i = 0; i < lstLivre.size(); i++) {
			row[0]=lstLivre.get(i).getTitre();
			row[1]=lstLivre.get(i).getPrix();

			model.addRow(row);
		}
	}

}
