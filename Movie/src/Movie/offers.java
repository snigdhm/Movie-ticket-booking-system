package Movie;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class offers extends JFrame {

	private JPanel contentPane;
	Connection connect=null;
	/**
	 * Launch the application.
	 */
	//public static void offers1() {
	public static void main(String []args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//
					offers frame = new offers(1, "shri");
					frame.setVisible(true);
					//
									
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public offers(final int flag,final String name) {
		connect =sqliteConnection.dataConnector();
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 34, 1272, 712);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExp = new JButton("EXPERIENCE");
		btnExp.setFont(new Font("Liberation Serif", Font.ITALIC, 15));
		btnExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExp.setForeground(Color.WHITE);
		btnExp.setBackground(Color.DARK_GRAY);
		btnExp.setBounds(134, 0, 134, 34);
		setLocationRelativeTo(null);
		contentPane.add(btnExp);
		
		JButton btnNewButton = new JButton("OFFERS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(268, 0, 134, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==0)
				{
					run r=new run();
					r.setVisible(true);
					r.setResizable(false);
				}
				else
				{
					run r=new run(name);
					r.setVisible(true);
					r.setResizable(false);
				}
			}
		});
		btnNewButton_1.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 134, 34);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_back l=new login_back();
				l.login();
			}
		});
		btnNewButton_2.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(870, 0, 134, 34);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("SIGNUP");
		btnNewButton_3.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(1004, 0, 134, 34);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("LOCATION");
		btnNewButton_4.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_4 .setBackground(Color.DARK_GRAY);
		btnNewButton_4 .setForeground(Color.WHITE);
		btnNewButton_4 .setBounds(1138, 0, 134, 34);
		contentPane.add(btnNewButton_4 );
		
		JButton button = new JButton("");
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(402, 0, 473, 34);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		 Image img1_3 = new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		 label.setIcon(new ImageIcon(img1_3));
			contentPane.add(label);
		label.setBounds(29, 46, 200, 91);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		 Image img1_4 = new ImageIcon(this.getClass().getResource("/offers11.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(img1_4));
		lblNewLabel.setBounds(130, 448, 150, 150);
		contentPane.add(lblNewLabel);
		// Image img1_5 = new ImageIcon(this.getClass().getResource("/offers21.jpg")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("");
		 Image img1_6 = new ImageIcon(this.getClass().getResource("/offers31.jpg")).getImage();
		 lblNewLabel_2.setIcon(new ImageIcon(img1_6));
		lblNewLabel_2.setBounds(700, 206, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		 Image img1_7 = new ImageIcon(this.getClass().getResource("/offers21.jpg")).getImage();
		 lblNewLabel_3.setIcon(new ImageIcon(img1_7));
		lblNewLabel_3.setBounds(130, 206, 150, 150);
		contentPane.add(lblNewLabel_3);
		 //Image img1_8 = new ImageIcon(this.getClass().getResource("/offers51.jpg")).getImage();
		
		JLabel lblNewLabel_5 = new JLabel();
		 Image img1_9 = new ImageIcon(this.getClass().getResource("/offers41.jpg")).getImage();
		 lblNewLabel_5.setIcon(new ImageIcon(img1_9));
		lblNewLabel_5.setBounds(700, 448, 150, 150);
		contentPane.add(lblNewLabel_5);
		
		
		JTextArea textArea = new JTextArea("ENOJY 25% CASHBACK!\n\nSubmit the code XR6TG8 at your ticket counter,\nand recieve 25% cashback on your purchase!\n\n\nOffer only valid on a purchase of, or less \nthan 4 tickets");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 206, 267, 150);
		contentPane.add(scrollPane);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	
		
		
		JTextArea textArea_3 = new JTextArea("POPCORN OFFER!\n\nSubmit the coupon code TYS6S at the popcorn\ncounter, and recieve a free large popcorn with\nyour large coke!");
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(320, 448, 267, 150);
		contentPane.add(scrollPane_3);
		textArea_3.setEditable(false);
		scrollPane_3.setViewportView(textArea_3);
	
	
		
		JTextArea textArea_1 = new JTextArea("MOVIE MEAL DEAL!\n\nGet an amazing meal at the movies!\nFor free!\nMeal includes a burger, large soda and french \nfries\n\nOffer valid only once per booking");
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(890, 448, 267, 150);
		contentPane.add(scrollPane_1);
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
	
		
		JTextArea textArea_2 = new JTextArea("CARAMEL POPCORN!\n\nEnjoy the exotic taste of fresh caramel \npopcorn! Now at the discount price of 100Rs. \nfor a large tub!");
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(890, 206, 267, 150);
		contentPane.add(scrollPane_2);
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
	
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_back l=new login_back();
				l.login();
			}
		});
		btnBook.setBounds(130, 368, 117, 25);
		contentPane.add(btnBook);
		
		JButton btnBook_1 = new JButton("BOOK");
		btnBook_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_back l=new login_back();
				l.login();
			}
		});
		btnBook_1.setBounds(130, 622, 117, 25);
		contentPane.add(btnBook_1);
		
		JButton btnBook_2 = new JButton("BOOK");
		btnBook_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_back l=new login_back();
				l.login();
			}
		});
		btnBook_2.setBounds(700, 368, 117, 25);
		contentPane.add(btnBook_2);
		
		JButton btnBook_3 = new JButton("BOOK");
		btnBook_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_back l=new login_back(0,null,15);
				l.setVisible(true);
				
			}
		});
		btnBook_3.setBounds(700, 610, 117, 25);
		contentPane.add(btnBook_3);
	
		
		
	}
}