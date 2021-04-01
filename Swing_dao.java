package tp_JRame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Swing_dao extends JFrame{
	private JTextField email;
	private JPasswordField pwd;
	private String pwd_saisi;
	private String email_saisi;
	private String nom_saisi;
	private String prenom_saisi;
	private JTextField prenom;
	private JTextField nom;
	Connection connect = ConnectionBase.getConnection();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing_dao frame = new Swing_dao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Swing_dao() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 740, 652);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblEmail.setOpaque(true);
		lblEmail.setBackground(new Color(0, 0, 205));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(8, 325, 218, 56);
		panel.add(lblEmail);
		
		JLabel lblPwd = new JLabel("mot de passe");
		lblPwd.setForeground(new Color(255, 255, 255));
		lblPwd.setOpaque(true);
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPwd.setBackground(new Color(0, 0, 205));
		lblPwd.setBounds(10, 403, 216, 53);
		panel.add(lblPwd);
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBackground(new Color(240, 248, 255));
		email.setFont(new Font("SansSerif", Font.BOLD, 18));
		email.setBounds(236, 325, 454, 56);
		panel.add(email);
		email.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBackground(new Color(240, 248, 255));
		pwd.setBounds(236, 400, 454, 56);
		panel.add(pwd);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setOpaque(true);
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPrenom.setBackground(new Color(0, 0, 205));
		lblPrenom.setBounds(10, 258, 218, 56);
		panel.add(lblPrenom);
		
		prenom = new JTextField();
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setFont(new Font("SansSerif", Font.BOLD, 18));
		prenom.setColumns(10);
		prenom.setBackground(new Color(240, 248, 255));
		prenom.setBounds(236, 258, 454, 56);
		panel.add(prenom);
		
		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setOpaque(true);
		lblNom_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom_1.setForeground(Color.WHITE);
		lblNom_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNom_1.setBackground(new Color(0, 0, 205));
		lblNom_1.setBounds(8, 191, 218, 56);
		panel.add(lblNom_1);
		
		nom = new JTextField();
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setFont(new Font("SansSerif", Font.BOLD, 18));
		nom.setColumns(10);
		nom.setBackground(new Color(240, 248, 255));
		nom.setBounds(236, 191, 454, 56);
		panel.add(nom);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pwd_saisi= pwd.getText();
			email_saisi=email.getText();
			nom_saisi=nom.getText();
			prenom_saisi=prenom.getText();
//			Utilisateur per= new Utilisateur( nom_saisi, prenom_saisi, email_saisi, pwd_saisi);
//			Utilisateur_dao perdao=new Utilisateur_dao();
			try {
				PreparedStatement req= connect.prepareStatement("INSERT INTO Utilisateur"
						+"(nom,prenom,email,pwd)VALUES(?,?,?,?)");
				req.setString(1,nom_saisi);
				req.setString(2,prenom_saisi);
				req.setString(3,email_saisi);
				req.setString(4,pwd_saisi);
				
				req.executeUpdate();
				System.out.println("insert success");
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnAjouter.setBackground(new Color(0, 0, 205));
		btnAjouter.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAjouter.setBounds(296, 493, 173, 53);
		panel.add(btnAjouter);
		
		JLabel formulaire = new JLabel("formulaire d'inscription");
		formulaire.setForeground(new Color(0, 0, 205));
		formulaire.setHorizontalAlignment(SwingConstants.CENTER);
		formulaire.setFont(new Font("SansSerif", Font.BOLD, 35));
		formulaire.setBackground(new Color(0, 0, 205));
		formulaire.setBounds(174, 51, 467, 42);
		panel.add(formulaire);
		

	}
	}


