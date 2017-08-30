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

public class bangalore extends JFrame {

	private JPanel contentPane;
	Connection connect=null;
	String b2,b3;
	/**
	 * Launch the application.
	 */
	public static void bangalore1() {								//
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bangalore(int f,String s,final int dis) {
		final int flag=f;
		final String name=s;
		connect =sqliteConnection.dataConnector();
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!name.equals("null"))
				{
					
					offers of=new offers(flag,name);
					of.setVisible(true);
				}
				else
				{
					
					offers of=new offers(flag,name);
					of.setVisible(true);
				}
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
		if(flag==0)
			{JButton btnNewButton_2 = new JButton("LOGIN");
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
		contentPane.add(btnNewButton_2);}
		else
		{
			JButton btnNewButton_2 = new JButton("LOGOUT");
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null ,"LOGGED OUT");
					run r=new run();
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
			btnNewButton_2.setBackground(Color.DARK_GRAY);
			btnNewButton_2.setForeground(Color.WHITE);
			btnNewButton_2.setBounds(870, 0, 134, 34);
			contentPane.add(btnNewButton_2);
		}
		
		if(flag==0)
		{
			JButton btnNewButton_3 = new JButton("SIGNUP");
			btnNewButton_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					signup l=new signup();
					l.sign();
				}
			});
			btnNewButton_3.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
			btnNewButton_3.setBackground(Color.DARK_GRAY);
			btnNewButton_3.setForeground(Color.WHITE);
			btnNewButton_3.setBounds(1004, 0, 134, 34);
			contentPane.add(btnNewButton_3);
			
		}
		else
			{
			JButton btnNewButton_3 = new JButton("WALLET");
			btnNewButton_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					wallet w=new wallet(name);
					w.setVisible(true);
				}
			});

			btnNewButton_3.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
			btnNewButton_3.setBackground(Color.DARK_GRAY);
			btnNewButton_3.setForeground(Color.WHITE);
			btnNewButton_3.setBounds(1004, 0, 134, 34);
			contentPane.add(btnNewButton_3);
			
			}
		
		JButton btnNewButton_4 = new JButton("LOCATION");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				location s=new location(0,"null");
				s.setVisible(true);
			}
		});
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
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exp s=new exp("ZOOTOPIA");
				s.setVisible(true);
			}
		});
		 Image img1_4 = new ImageIcon(this.getClass().getResource("/bangalore11.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(img1_4));
		lblNewLabel.setBounds(186, 461, 150, 150);
		contentPane.add(lblNewLabel);
		 Image img1_5 = new ImageIcon(this.getClass().getResource("/bangalore21.jpg")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exp s=new exp("COURT");
				s.setVisible(true);
			}
		});
		 Image img1_6 = new ImageIcon(this.getClass().getResource("/bangalore31.jpg")).getImage();
		 lblNewLabel_2.setIcon(new ImageIcon(img1_6));
		lblNewLabel_2.setBounds(735, 206, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exp s=new exp("INTO DARKNESS");
				s.setVisible(true);
			}
		});
		 Image img1_7 = new ImageIcon(this.getClass().getResource("/bangalore21.jpg")).getImage();
		 lblNewLabel_3.setIcon(new ImageIcon(img1_7));
		lblNewLabel_3.setBounds(186, 206, 150, 150);
		contentPane.add(lblNewLabel_3);
		 Image img1_8 = new ImageIcon(this.getClass().getResource("/bangalore51.jpg")).getImage();
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exp s=new exp("JURASSIC WORLD");
				s.setVisible(true);
			}
		});
		 Image img1_9 = new ImageIcon(this.getClass().getResource("/bangalore61.jpg")).getImage();
		 lblNewLabel_5.setIcon(new ImageIcon(img1_9));
		lblNewLabel_5.setBounds(756, 448, 150, 150);
		contentPane.add(lblNewLabel_5);
		
		final String mov1,mov2,mov3,mov4;
		mov1="INTO DARKNESS\n\nRex Theater\nNo. 12, Brigade Road\nBangalore - 560007\nRating: 5/5";
		mov2="ZOOTOPIA\n\nSri Thirumala Theaters\n162, 24th Main, Sector 1, Near BDA Complex\nHSR Layout, Bangalore - 560089\nRating: 4/5";
		mov3="JURASSIC WORLD\n\nDNI Theater\nKR Complex, Opp. Bangalore Central\nBellandur Junction, Maratahalli\nSarjapur\nBangalore - 563002\nRating: 3.5/5";
		mov4="COURT\n\nPVR Cinemas\nOrion Mall, MG Road, Opp.KC Hospital\nBangalore - 560034\nRating: 4.5/5";
		JTextArea txtrSdsf = new JTextArea(mov1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 206, 267, 150);
		contentPane.add(scrollPane);
		txtrSdsf.setEditable(false);
		scrollPane.setViewportView(txtrSdsf);
	
		JTextArea textArea_3 = new JTextArea(mov2);
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(401, 461, 267, 150);
		contentPane.add(scrollPane_3);
		textArea_3.setEditable(false);
		scrollPane_3.setViewportView(textArea_3);
		
		JTextArea textArea_1 = new JTextArea(mov3);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(970, 461, 267, 150);
		contentPane.add(scrollPane_1);
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
	
		JTextArea textArea_2 = new JTextArea(mov4);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(971, 206, 267, 150);
		contentPane.add(scrollPane_2);
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==0)
				{
					login_back l=new login_back();
					l.login();
				}
				else{
				book b=new book("INTO DARKNESS",name,dis,mov1);
				b.setVisible(true);}
			}
		});
		btnBook.setBounds(206, 368, 117, 25);
		contentPane.add(btnBook);
		
		JButton btnBook_1 = new JButton("BOOK");
		btnBook_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==0)
				{
					login_back l=new login_back();
					l.login();
				}
				else{
				book b=new book("COURT",name,dis,mov4);
				b.setVisible(true);}
			}
		});
		btnBook_1.setBounds(219, 622, 117, 25);
		contentPane.add(btnBook_1);
		
		JButton btnBook_2 = new JButton("BOOK");
		btnBook_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==0)
				{
					login_back l=new login_back();
					l.login();
				}
				else{
				book b=new book("JURASSIC WORLD",name,dis,mov3);
				b.setVisible(true);}
			}
		});
		btnBook_2.setBounds(756, 368, 117, 25);
		contentPane.add(btnBook_2);
		
		JButton btnBook_3 = new JButton("BOOK");
		btnBook_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==0)
				{
					login_back l=new login_back();
					l.login();
				}
				else{
				book b=new book("ZOOTOPIA",name,dis,mov2);
				b.setVisible(true);}
			}
		});
		btnBook_3.setBounds(768, 610, 117, 25);
		contentPane.add(btnBook_3);
	
		
		
	}
}