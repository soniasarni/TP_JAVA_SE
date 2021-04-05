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

public class Liste extends JFrame {
	private JTextField date_saisi;
	private JTextField destination_saisi;
	private JTextField prix_saisi;
	private JTextField textField;
	
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
		date_saisi.setBackground(new Color(255, 240, 245));
		date_saisi.setForeground(new Color(0, 0, 0));
		date_saisi.setFont(new Font("SansSerif", Font.BOLD, 18));
		date_saisi.setBounds(160, 64, 469, 45);
		panel_2.add(date_saisi);
		date_saisi.setColumns(10);
		
		destination_saisi = new JTextField();
		destination_saisi.setBackground(new Color(255, 240, 245));
		destination_saisi.setForeground(new Color(0, 0, 0));
		destination_saisi.setFont(new Font("SansSerif", Font.BOLD, 18));
		destination_saisi.setColumns(10);
		destination_saisi.setBounds(160, 10, 469, 45);
		panel_2.add(destination_saisi);
		
		prix_saisi = new JTextField();
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
		btn_Add.setBounds(10, 11, 149, 45);
		panel_1.add(btn_Add);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnDelete.setBackground(new Color(255, 204, 255));
		btnDelete.setBounds(169, 11, 149, 45);
		panel_1.add(btnDelete);
		
		JButton btnUpDate = new JButton("UpDate");
		btnUpDate.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnUpDate.setBackground(new Color(255, 204, 255));
		btnUpDate.setForeground(new Color(102, 0, 102));
		btnUpDate.setBounds(328, 11, 149, 45);
		panel_1.add(btnUpDate);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBackground(new Color(255, 204, 255));
		btnSelect.setForeground(new Color(102, 0, 102));
		btnSelect.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnSelect.setBounds(487, 11, 142, 45);
		panel_1.add(btnSelect);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(50, 292, 639, 109);
		panel_3.setBackground(new Color(102, 0, 102));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblrecherche = new JLabel("Search");
		lblrecherche.setOpaque(true);
		lblrecherche.setForeground(new Color(102, 0, 102));
		lblrecherche.setBackground(new Color(255, 204, 255));
		lblrecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblrecherche.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		lblrecherche.setBounds(10, 23, 171, 63);
		panel_3.add(lblrecherche);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.BOLD, 19));
		textField.setBackground(new Color(255, 240, 245));
		textField.setBounds(191, 22, 438, 63);
		panel_3.add(textField);
		textField.setColumns(10);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(50, 417, 639, 203);
		scrollPane_1.setBackground(new Color(102, 0, 102));
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setPreferredSize(new Dimension(0, 23));
		table_1.setColumnSelectionAllowed(true);
		table_1.setFont(new Font("SansSerif", Font.BOLD, 18));
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
		table_1.setBackground(new Color(255, 240, 245));
//		
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterDis();
			}

			boolean ajout=true; 
			private void ajouterDis() {
				modele=(DefaultTableModel)table_1.getModel();
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
					modele.addRow(new Object[]{destination1.getId(),
							destination1.getDestination(),destination1.getDate(),
							destination1.getPrix()});
					//vider les champs de saisie
					destination_saisi.setText("");
					date_saisi.setText("");
					prix_saisi.setText("");
					//remettre le curseur a sa place
					destination_saisi.requestFocus();
					
				}
			}
		});
		
		 }
	}
