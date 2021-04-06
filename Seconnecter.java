package tp_JRame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Seconnecter extends JFrame implements IDAO<Seconnecter> {
	private JTextField email1;
	private JPasswordField pwd1;
	private String email_saisi1;
	private String pwd_saisi1;
	
	Connection connect = ConnectionBase.getConnection();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seconnecter frame = new Seconnecter();
					frame.setVisible(true);
					frame.setTitle("Se connecter");
					//frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Seconnecter() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(702, 625, -706, -621);
		getContentPane().add(scrollPane);
		
		JLabel lblconnect = new JLabel("connection");
		lblconnect.setOpaque(true);
		lblconnect.setBackground(new Color(102, 51, 102));
		lblconnect.setHorizontalAlignment(SwingConstants.CENTER);
		lblconnect.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblconnect.setBounds(196, 65, 364, 52);
		getContentPane().add(lblconnect);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblemail.setOpaque(true);
		lblemail.setBackground(new Color(102, 51, 102));
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setBounds(20, 181, 205, 45);
		getContentPane().add(lblemail);
		
		JLabel lblPwd = new JLabel("Mot de passe");
		lblPwd.setOpaque(true);
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPwd.setBackground(new Color(102, 51, 102));
		lblPwd.setBounds(20, 258, 205, 45);
		getContentPane().add(lblPwd);
		
		email1 = new JTextField();
		email1.setBackground(new Color(255, 204, 255));
		email1.setFont(new Font("SansSerif", Font.BOLD, 18));
		email1.setBounds(235, 181, 399, 45);
		getContentPane().add(email1);
		email1.setColumns(10);
		
		pwd1 = new JPasswordField();
		pwd1.setBackground(new Color(255, 204, 255));
		pwd1.setFont(new Font("SansSerif", Font.BOLD, 18));
		pwd1.setBounds(235, 258, 399, 45);
		getContentPane().add(pwd1);
		
		JButton btnConnecter = new JButton("Se connecter");
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		          email_saisi1=email1.getText();
				  pwd_saisi1=pwd1.getText();
				  if (email_saisi1.equals("")||pwd_saisi1.equals("")) {
					  JOptionPane.showMessageDialog(null,"veuillez remplir les champs",	
								"Authentification", JOptionPane.WARNING_MESSAGE);
					  
				  }else
				  try {
				  PreparedStatement req = connect.prepareStatement("SELECT * FROM Utilisateur WHERE email=? "
										+ " AND pwd=?");
								
				  req.setString(1,email_saisi1);
				  req.setString(2,pwd_saisi1);
				 
				  ResultSet rs = req.executeQuery();
								 
				  if(rs.next()) {
				  JOptionPane.showMessageDialog( null,"Bienvenue  " +email_saisi1,"Authentification",JOptionPane.PLAIN_MESSAGE);
			  dispose();
			  Accueil art1=new Accueil();
			  art1.setVisible(true);
			  
//									 
				 }else {
					 JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrects","Authentification",JOptionPane.ERROR_MESSAGE);
					 
				 }
				  }catch(Exception e1) {
				 e1.printStackTrace();
				 System.out.println(" KO - KO - KO");
							}
				  };
				  });
		btnConnecter.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnConnecter.setBackground(new Color(102, 51, 102));
		btnConnecter.setBounds(305, 387, 243, 52);
		getContentPane().add(btnConnecter);
		}
  @Override
	public void create(Seconnecter object) {
	}
  @Override
	public void read(Seconnecter objet) {
		// TODO Auto-generated method stub
	}
	}

