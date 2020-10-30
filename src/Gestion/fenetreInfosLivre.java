package Gestion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class fenetreInfosLivre extends JFrame {

	JLabel lbltitre,lblNbEdition;
	JTable table;
	JScrollPane jsp;
	JPanel contentPane,pano,tit;
	
	String col[] = {"No d'édition", "Nb d'exemplaire"};
	DefaultTableModel model = new DefaultTableModel(col, 0);
	public fenetreInfosLivre() {
		
		this.setLocationRelativeTo(null);
				setLayout(new BorderLayout());
				setTitle("TP2");
				setResizable(false);
				lbltitre=new JLabel("Informations du livre");
				tit=new JPanel();
				add(tit,BorderLayout.NORTH);
				Font font = new Font("Arial",Font.BOLD,18);
				lbltitre.setFont(font);
				tit.add(lbltitre);
				setBounds(100, 100, 600, 300);
				this.setLocationRelativeTo(null);
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
				model.addRow(col);
				table = new JTable(model);
				table.setBounds(60,60,300,500);
				jsp.setViewportView(table);
				jsp.add(table);
				contentPane.add(Box.createVerticalStrut(150));
				contentPane.add(table);
				getContentPane().add(contentPane);
				pano=new JPanel();
				add(pano, BorderLayout.SOUTH);
				//this.add(table);
				try {
					AjoutLigne(connexion.Question2(Integer.parseInt(FenetreMain.txtLivre.getText())), model);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				lblNbEdition=new JLabel();
				try {
					String contenu=connexion.Question2_nbEdition(Integer.parseInt(FenetreMain.txtLivre.getText()));
					lblNbEdition.setText(contenu);
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
				pano.add(lblNbEdition);
	}
	//remplir la jtable
	public static void AjoutLigne(ArrayList<Edition> lstEdit, DefaultTableModel model) {
		Object row[] = new Object[2];
		for (int i = 0; i < lstEdit.size(); i++) {
			row[0]=lstEdit.get(i).no_edition;
			row[1]=lstEdit.get(i).nombre_exemplaire;

			model.addRow(row);
		}
	}
	
}
