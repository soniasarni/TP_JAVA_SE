package tp_JRame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Liste extends JFrame {
	private JTextField date_saisi;
	private JTextField destination_saisi;
	private JTextField prix_saisi;
	private JTextField search;
	Connection connect = ConnectionBase.getConnection();
	ArrayList<Ma_liste >destinations=new ArrayList<>();
	DefaultTableModel modele;
	
	
	private JTable table_1;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					Liste frame = new Liste();
					frame.setVisible(true);
					frame.setTitle("gestion des distinations");
					//frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		}
	
	public Liste() {
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 835, 689);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 27, 639, 178);
		panel_2.setBackground(new Color(102, 0, 102));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_D = new JLabel("Destination");
		lbl_D.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_D.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 18));
		lbl_D.setOpaque(true);
		lbl_D.setBackground(new Color(255, 204, 255));
		lbl_D.setBounds(10, 10, 140, 44);
		panel_2.add(lbl_D);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		lblDate.setOpaque(true);
		lblDate.setBackground(new Color(255, 204, 255));
		lblDate.setBounds(10, 65, 140, 43);
		panel_2.add(lblDate);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 18));
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setOpaque(true);
		lblPrix.setBackground(new Color(255, 204, 255));
		lblPrix.setBounds(10, 120, 140, 45);
		panel_2.add(lblPrix);
		
		date_saisi = new JTextField();
		//deplacement du cirseur automatiquement
		date_saisi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char touche= e.getKeyChar();
				if(touche==KeyEvent.VK_ENTER && !date_saisi.getText().equals(""))
					prix_saisi.requestFocus();
			
				
				
			}
		});
		date_saisi.setBackground(new Color(255, 240, 245));
		date_saisi.setForeground(new Color(0, 0, 0));
		date_saisi.setFont(new Font("SansSerif", Font.BOLD, 18));
		date_saisi.setBounds(160, 64, 469, 45);
		panel_2.add(date_saisi);
		date_saisi.setColumns(10);
		
		destination_saisi = new JTextField();
		
		//deplacement automatique du curseur dans les champs de saisie
		destination_saisi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char touche= e.getKeyChar();
				if (touche==KeyEvent.VK_ENTER && !destination_saisi.getText().equals(""))
					date_saisi.requestFocus();
				
				// RENTRE QUE DES LETTRE DANS CETTE ZONE
				if(Character.isDigit(touche))
					e.consume();
			}
		});
		destination_saisi.setBackground(new Color(255, 240, 245));
		destination_saisi.setForeground(new Color(0, 0, 0));
		destination_saisi.setFont(new Font("SansSerif", Font.BOLD, 18));
		destination_saisi.setColumns(10);
		destination_saisi.setBounds(160, 10, 469, 45);
		panel_2.add(destination_saisi);
		
		prix_saisi = new JTextField();
		prix_saisi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char touche= e.getKeyChar();
			if(Character.isLetter(touche))
				e.consume();
			}
		});
		prix_saisi.setBackground(new Color(255, 240, 245));
		prix_saisi.setForeground(new Color(0, 0, 0));
		prix_saisi.setFont(new Font("SansSerif", Font.BOLD, 18));
		prix_saisi.setColumns(10);
		prix_saisi.setBounds(160, 120, 469, 45);
		panel_2.add(prix_saisi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 216, 639, 65);
		panel_1.setBackground(new Color(102, 0, 102));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_Add = new JButton("Ajouter");
		
		btn_Add.setBackground(new Color(255, 204, 255));
		btn_Add.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btn_Add.setBounds(48, 11, 149, 45);
		panel_1.add(btn_Add);
		
		// SUPPRIMER DES ELEMENTS DANS MON TABLEAU INTER GRAPH  
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initialiser le modele DANS LE TABLEAU
				modele=(DefaultTableModel)table_1.getModel();
				int ligne=table_1.getSelectedRow();
				if(ligne!=-1) {
					//supprimer dans mon arraylist
					destinations.remove(ligne);
					
					//enlever dans mon tableau dans l'interface graphique
					modele.removeRow(ligne);
					
					//vider mes champs de saisie
					destination_saisi.setText("");
					date_saisi.setText("");
					prix_saisi.setText("");
					
					//remettre le curseur a sa place
					destination_saisi.requestFocus();
				}
			}
		});
		btnDelete.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnDelete.setBackground(new Color(255, 204, 255));
		btnDelete.setBounds(243, 11, 149, 45);
		panel_1.add(btnDelete);
		
		JButton btnUpDate = new JButton("UpDate");
		//modifier mon tableau
		
		btnUpDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modele=(DefaultTableModel)table_1.getModel();
				int ligne=table_1.getSelectedRow();
				if(ligne!=-1) {
					//modifier dans mon arraylist
					destinations.get(ligne).setDestination(destination_saisi.getText());
					destinations.get(ligne).setDate(date_saisi.getText());
					destinations.get(ligne).setPrix(Float.valueOf(prix_saisi.getText()));
					
					
				//modifier dans mon tableau dans l'interface graphique
				//modele.SetValueAt(nouvellevateur,lalignedeLaCase,COLONECASE)
					modele.setValueAt(destination_saisi.getText(),ligne,1);
					modele.setValueAt(date_saisi.getText(),ligne,2);
					modele.setValueAt(prix_saisi.getText(),ligne,3);
					
					
					//vider mes champs de saisie
					destination_saisi.setText("");
					date_saisi.setText("");
					prix_saisi.setText("");
					
					//remettre le curseur a sa place
					destination_saisi.requestFocus();
				}
			}
		});
		btnUpDate.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnUpDate.setBackground(new Color(255, 204, 255));
		btnUpDate.setForeground(new Color(102, 0, 102));
		btnUpDate.setBounds(438, 11, 149, 45);
		panel_1.add(btnUpDate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(50, 292, 639, 109);
		panel_3.setBackground(new Color(102, 0, 102));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		search = new JTextField();
		search.setFont(new Font("SansSerif", Font.BOLD, 19));
		search.setBackground(new Color(255, 240, 245));
		search.setBounds(191, 22, 438, 63);
		panel_3.add(search);
		search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		
		
		//chercher une distination dans arraylist si elle existe
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modele=(DefaultTableModel)table_1.getModel();
				boolean trouve= false;
				int indice=0;
				if(search.getText().equals("")){
				JOptionPane.showMessageDialog(null,"veuillez entrer la destination svp","destination recherché",
						JOptionPane.ERROR_MESSAGE);	
					trouve=false;
				}else {
					
				String destinationRecherche=search.getText();
				for(int i=0;i<destinations.size();i++) {
					Ma_liste dest= destinations.get(i);
					if(destinationRecherche.equals(dest.getDestination())){
					trouve=true;
					indice=i;
					break;
					}
				}
			}
				if(trouve) {
					destination_saisi.setText(destinations.get(indice).getDestination());
					date_saisi.setText(destinations.get(indice).getDate());
					prix_saisi.setText(String.valueOf(destinations.get(indice).getPrix()));
					table_1.setRowSelectionInterval(0, destinations.size());
				}
				else {
					JOptionPane.showMessageDialog(null,"cette destination n'est plus disponible","authentification",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSearch.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnSearch.setBounds(10, 22, 171, 63);
		panel_3.add(btnSearch);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(50, 417, 639, 203);
		scrollPane_1.setBackground(new Color(102, 0, 102));
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(255, 240, 245));
		table_1.addMouseListener(new MouseAdapter() {
			
			
			//creer un evenement dans le tableau quand je clic 
			//remplir les champs avec les composant de la ligne selectionner
			@Override
			public void mouseClicked(MouseEvent e) {
				modele=(DefaultTableModel)table_1.getModel();
				int ligne=table_1.getSelectedRow();
				if(ligne!=-1) {
					//je recupere les information dans arraylist
					destination_saisi.setText(destinations.get(ligne).getDestination());
					date_saisi.setText(destinations.get(ligne).getDate());
					prix_saisi.setText(String.valueOf(destinations.get(ligne).getPrix()));
				}
			}
		});
		table_1.setAutoCreateRowSorter(true);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setPreferredSize(new Dimension(0, 23));
		table_1.setColumnSelectionAllowed(true);
		table_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		scrollPane_1.add(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"prix", "dates", "destinations", "id"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.setBounds(50, 412, 635, 209);
		table_1.setBackground(new Color(102, 0, 102));
		
//		//AJOUTER DES DISTINATION 
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterDis();
			}

			private void ajouterDis() {
				modele=(DefaultTableModel)table_1.getModel();
				boolean ajout=true; 
				if(destination_saisi.getText().equals("")|| date_saisi.getText().equals("")|| prix_saisi.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"remplissez tous les champs","message", JOptionPane.ERROR_MESSAGE);
				ajout=false;
				}
				//pour eviter de dupliquer les meme informations on fait une 
				//boucle 
				for(Ma_liste dest:destinations) {
					if(dest.getDestination().equals(destination_saisi.getText())
							&&dest.getDate().equals(date_saisi.getText())) {
						JOptionPane.showMessageDialog(null,"cette destination existe deja","message", JOptionPane.ERROR_MESSAGE);
						ajout=false;
					}
					
				}
				if (ajout=true) {
					
					Ma_liste destination1= new Ma_liste(destination_saisi.getText(),
							date_saisi.getText(), Integer.valueOf(prix_saisi.getText()));
					
					//ajouter dans mon arraylist
					destinations.add(destination1);
					
					//ajouter dans mon tableau
					modele.addRow(new Object[]{
							destination1.getId(),
							destination1.getDestination(),
							destination1.getDate(),
							destination1.getPrix()});
			try {
					PreparedStatement req= connect.prepareStatement("INSERT INTO Liste"
							+"(distination,periode,prix)VALUES(?,?,?)");
					req.setString(1,destination_saisi.getText());
					req.setString(2,date_saisi.getText());
					req.setString(3,prix_saisi.getText());
					//req.setString(4,pwd_saisi);
					
						
					req.executeUpdate();
					System.out.println("insert success");
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
					
					//vider les champs de saisie
					viderChamps();
				}
			}
			
			//CReer une methode qui va vider les champs de saisies
			private void viderChamps() {
				destination_saisi.setText("");
				date_saisi.setText("");
				prix_saisi.setText("");
				
				//remettre le curseur a sa place
				destination_saisi.requestFocus();
				
			}
		});
		 }
	}
