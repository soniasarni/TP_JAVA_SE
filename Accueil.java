package tp_JRame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Accueil extends JFrame{
	 
	public static void main(String[]args){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Accueil frame = new Accueil();
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
	public Accueil() {
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 1248, 1500, -749);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(55, 0, 255, 191);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\tokyo.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 0, 102));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(311, 99, 255, 191);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\img.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(102, 0, 102));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(210, 447, 336, 191);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\img1.jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(102, 0, 102));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(559, 0, 273, 209);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\doubs.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(102, 0, 102));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(44, 229, 261, 191);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\LL.jpg"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(102, 0, 102));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(552, 312, 261, 191);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\GGGG.jpg"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(102, 0, 102));
		getContentPane().add(lblNewLabel_5);
		
		JButton btnD1 = new JButton("Distination1");
		btnD1.setBounds(87, 190, 214, 32);
		btnD1.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		btnD1.setBackground(new Color(204, 204, 204));
		getContentPane().add(btnD1);
		
		JButton btnD2 = new JButton("Distination2");
		btnD2.setBounds(569, 215, 214, 23);
		btnD2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnD2.setFont(new Font("Script MT Bold", Font.ITALIC, 18));
		getContentPane().add(btnD2);
		
		JButton btnD3 = new JButton("Distination3");
		btnD3.setBounds(71, 422, 234, 31);
		btnD3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnD3.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		getContentPane().add(btnD3);
		
		JButton btnD4 = new JButton("Distination4");
		btnD4.setBounds(321, 295, 221, 32);
		btnD4.setFont(new Font("Script MT Bold", Font.ITALIC, 20));
		getContentPane().add(btnD4);
		
		JButton btnD5 = new JButton("Distination5");
		btnD5.setBounds(607, 514, 138, 23);
		btnD5.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		getContentPane().add(btnD5);
		
		JButton btnD6 = new JButton("Distination6");
		btnD6.setBounds(267, 628, 244, 42);
		btnD6.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		getContentPane().add(btnD6);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 103, 341, 456);
		scrollPane.add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 816, 813, -116);
		getContentPane().add(list);
		
		JButton btnV_Liste = new JButton("Voir liste");
		btnV_Liste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Liste plus = new Liste();
				plus.setVisible(true);
			}
		});
		btnV_Liste.setBackground(new Color(102, 0, 102));
		btnV_Liste.setForeground(new Color(255, 204, 255));
		btnV_Liste.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 30));
		btnV_Liste.setBounds(607, 572, 187, 42);
		getContentPane().add(btnV_Liste)
		;
		
	
	}
}
