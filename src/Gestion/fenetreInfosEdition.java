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

public class fenetreInfosEdition extends JFrame {
	JLabel lbltitre;
	JTable table;
	JScrollPane jsp;
	JPanel contentPane,tit;

	String col[] = {"Nom livre", "Nb d'exemplaires"};
	DefaultTableModel model = new DefaultTableModel(col, 0);
	 public fenetreInfosEdition() {
		//setLayout(null);
				this.setLocationRelativeTo(null);
				setLayout(new BorderLayout());
				setTitle("TP2");
				setResizable(false);
				setBounds(100, 100, 300, 300);
				this.setLocationRelativeTo(null);
				lbltitre=new JLabel("Informations de l'édition");
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
				model.addRow(col);
				table = new JTable(model);
				table.setBounds(60,60,300,500);
				jsp.setViewportView(table);
				jsp.add(table);
				contentPane.add(Box.createVerticalStrut(150));
				contentPane.add(table);
				getContentPane().add(contentPane);
				//this.add(table);
				try {
					AjoutLigne(connexion.Question3(Integer.parseInt(FenetreMain.txtEdition.getText())), model);
				}catch(SQLException e) {
					e.printStackTrace();
				}
	}
	public static void AjoutLigne(ArrayList<Livre> lstEdit, DefaultTableModel model) {
		Object row[] = new Object[2];
		for (int i = 0; i < lstEdit.size(); i++) {
			row[0]=lstEdit.get(i).getTitre();
			row[1]=lstEdit.get(i).edition.getNombre_exemplaire();

			model.addRow(row);
		}
	}
	

}
