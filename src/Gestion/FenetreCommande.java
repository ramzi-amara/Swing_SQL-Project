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

public class FenetreCommande extends JFrame {
	JLabel lbltitre;
	JTable table;
	JScrollPane jsp;
	JPanel contentPane,tit;
	String col[] = {"Titre", "No edition", "Quantité", "Librairie"};
	DefaultTableModel model = new DefaultTableModel(col, 0);
	 public FenetreCommande() {
		//setLayout(null);
				this.setLocationRelativeTo(null);
				setLayout(new BorderLayout());
				setTitle("TP2");
				setResizable(false);
				setBounds(100, 100, 600, 300);
				this.setLocationRelativeTo(null);
				lbltitre=new JLabel("Informations de la librairie");
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
				jsp.setViewportView(table);
				jsp.add(table);
				contentPane.add(Box.createVerticalStrut(150));
				contentPane.add(table);
				getContentPane().add(contentPane);
				//this.add(table);
				try {
					AjoutLigne(connexion.Question4(Integer.parseInt(FenetreMain.txtLibrairie.getText().trim())), model);
				}catch(SQLException e) {
					e.printStackTrace();
				}
	}
	 //remplir la jtable
	public static void AjoutLigne(ArrayList<CommandeLivre> lst, DefaultTableModel model) {
		Object row[] = new Object[4];
		for (int i = 0; i < lst.size(); i++) {
			row[0]=lst.get(i).getTitre();
			row[1]=lst.get(i).getNo_edition();
			row[2]=lst.get(i).getQuantite();
			row[3]=lst.get(i).getId_librarie();
			
			model.addRow(row);
		}
	}
	
}
