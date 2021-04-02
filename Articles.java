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

public class Articles extends JFrame{
	 
		public static void main(String[]args){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Articles frame = new Articles();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
	public Articles() {
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 685, 886, -686);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\tokyo.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 0, 102));
		lblNewLabel.setBounds(55, 0, 255, 191);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\img.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(102, 0, 102));
		lblNewLabel_1.setBounds(311, 99, 255, 191);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\img1.jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(102, 0, 102));
		lblNewLabel_2.setBounds(210, 447, 336, 191);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\doubs.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(102, 0, 102));
		lblNewLabel_3.setBounds(559, 0, 273, 209);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\LL.jpg"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(102, 0, 102));
		lblNewLabel_4.setBounds(44, 229, 261, 191);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\sonia\\OneDrive\\Images\\TPPPP\\GGGG.jpg"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(102, 0, 102));
		lblNewLabel_5.setBounds(540, 312, 261, 191);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnD1 = new JButton("Distination1");
		btnD1.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		btnD1.setBackground(new Color(102, 0, 102));
		btnD1.setBounds(87, 190, 214, 32);
		getContentPane().add(btnD1);
		
		JButton btnD2 = new JButton("Distination2");
		btnD2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnD2.setFont(new Font("Script MT Bold", Font.ITALIC, 18));
		btnD2.setBounds(569, 215, 214, 23);
		getContentPane().add(btnD2);
		
		JButton btnD3 = new JButton("Distination3");
		btnD3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnD3.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		btnD3.setBounds(71, 422, 234, 31);
		getContentPane().add(btnD3);
		
		JButton btnD4 = new JButton("Distination4");
		btnD4.setFont(new Font("Script MT Bold", Font.ITALIC, 20));
		btnD4.setBounds(321, 295, 221, 32);
		getContentPane().add(btnD4);
		
		JButton btnD5 = new JButton("Distination5");
		btnD5.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		btnD5.setBounds(607, 514, 138, 23);
		getContentPane().add(btnD5);
		
		JButton btnD6 = new JButton("Distination6");
		btnD6.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		btnD6.setBounds(267, 628, 244, 42);
		getContentPane().add(btnD6);
	}
}
