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

public class display extends JFrame {

	private JPanel contentPane;
	Connection connect=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display frame = new display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public display() {
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
		 Image img1_4 = new ImageIcon(this.getClass().getResource("/post11.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(img1_4));
		lblNewLabel.setBounds(150, 461, 150, 150);
		contentPane.add(lblNewLabel);
		 Image img1_5 = new ImageIcon(this.getClass().getResource("/post21.jpg")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("");
		 Image img1_6 = new ImageIcon(this.getClass().getResource("/post31.jpg")).getImage();
		 lblNewLabel_2.setIcon(new ImageIcon(img1_6));
		lblNewLabel_2.setBounds(700, 206, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		 Image img1_7 = new ImageIcon(this.getClass().getResource("/post41.jpg")).getImage();
		 lblNewLabel_3.setIcon(new ImageIcon(img1_7));
		lblNewLabel_3.setBounds(150, 206, 150, 150);
		contentPane.add(lblNewLabel_3);
		 Image img1_8 = new ImageIcon(this.getClass().getResource("/post51.jpg")).getImage();
		
		JLabel lblNewLabel_5 = new JLabel();
		 Image img1_9 = new ImageIcon(this.getClass().getResource("/post61.jpg")).getImage();
		 lblNewLabel_5.setIcon(new ImageIcon(img1_9));
		lblNewLabel_5.setBounds(700, 461, 150, 150);
		contentPane.add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea("Rating: 8.3/10\n\nA stunningly original concept that will not \nonly delight and entertain the companys \nmassive worldwide audience, but also \npromises to forever change the way people \nthink about the way people think.");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 206, 267, 150);
		contentPane.add(scrollPane);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	
		try{
			String query="select * from insideout ";
		PreparedStatement pst=connect.prepareStatement(query);
		/*pst.setString(1, textField.getText());
		pst.setString(2, passwordField.getText());
		*/	
		ResultSet rs=pst.executeQuery();
		textArea.setText(rs.getString(1));
		//textArea.setText(rs.getString(2));
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JTextArea textArea_3 = new JTextArea("Rating: 7.1/10\n\nEven when you think you know the outcome, \nthis film still has you on the edge of your \nseat. It's another underdog story, only \nthis underdog is a has-been robot piloted by a \nhas-been fighter and his cast-off son.");
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(340, 461, 267, 150);
		contentPane.add(scrollPane_3);
		textArea_3.setEditable(false);
		scrollPane_3.setViewportView(textArea_3);
	
		try{
			String query="select * from insideout ";
		PreparedStatement pst=connect.prepareStatement(query);
		/*pst.setString(1, textField.getText());
		pst.setString(2, passwordField.getText());
		*/	
		ResultSet rs=pst.executeQuery();
		textArea_3.setText(rs.getString(1));
		//textArea.setText(rs.getString(2));
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JTextArea textArea_1 = new JTextArea("Rating: 8.6/10\n\nBrainy, barmy and beautiful to behold, this \nis Stephen Hawking’s Star Trek: a mind-\nbending opera of space and time with a soul \nwrapped up in all the science.");
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(920, 461, 267, 150);
		contentPane.add(scrollPane_1);
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
	
		try{
			String query="select * from insideout ";
		PreparedStatement pst=connect.prepareStatement(query);
		/*pst.setString(1, textField.getText());
		pst.setString(2, passwordField.getText());
		*/	
		ResultSet rs=pst.executeQuery();
		textArea_1.setText(rs.getString(1));
		//textArea.setText(rs.getString(2));
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		JTextArea textArea_2 = new JTextArea("Rating: 6.5/10\n\nMinions hilariously imagines centuries in \nwhich the little guys have sought to serve the \ngreatest villain they could find, but quickly settles\ninto more conventional cartoon territory.");
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(920, 206, 267, 150);
		contentPane.add(scrollPane_2);
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
	
		try{
			String query="select * from insideout ";
		PreparedStatement pst=connect.prepareStatement(query);
		/*pst.setString(1, textField.getText());
		pst.setString(2, passwordField.getText());
		*/	
		ResultSet rs=pst.executeQuery();
		textArea_2.setText(rs.getString(1));
		//textArea.setText(rs.getString(2));
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}