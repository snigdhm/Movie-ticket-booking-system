package Movie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login_back extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	Connection connect=null;
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_back frame = new login_back();
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
	public login_back() {
		connect =sqliteConnection.dataConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 939, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel logo3 = new JLabel("User Name");
		
		logo3.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/log_back.jpg")).getImage();
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		logo3.setBounds(-12, -28, 939, 742);
	    logo3.setIcon(new ImageIcon(img1_3));
		contentPane.add(logo3);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblUserName.setBounds(71, 331, 120, 50);
		logo3.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		logo3.add(lblPassword);
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblPassword.setBounds(71, 368, 120, 50);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					String query="select name,pwd from login where name=? and pwd=?";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					String n=textField.getText();
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count++;
					}
					if(count==1)
					{
						dispose();
						after_login a=new after_login(n);
						a.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Stupid");
					rs.close();
					pst.close();
					
					
					
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f);
					
				}

			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		logo3.add(btnLogin);
		btnLogin.setBounds(138, 436, 117, 25);
		
		JButton btnSignup = new JButton("SignUp");
		logo3.add(btnSignup);
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				signup st = new signup();
				st.sign();
			}
		});
		btnSignup.setBounds(400, 436, 117, 25);
		
		textField = new JTextField();
		logo3.add(textField);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(190, 346, 125, 19);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		logo3.add(passwordField);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(190, 384, 125, 19);
		
		JLabel lblNewUser = new JLabel("NEW USER....");
		logo3.add(lblNewUser);
		lblNewUser.setBounds(403, 383, 120, 50);
		setLocationRelativeTo(null);
		
		
	}
	public login_back(int f,String s,int d) {
		final int x=d;
		connect =sqliteConnection.dataConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 939, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel logo3 = new JLabel("User Name");
		
		logo3.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/log_back.jpg")).getImage();
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		logo3.setBounds(-12, -28, 939, 742);
	    logo3.setIcon(new ImageIcon(img1_3));
		contentPane.add(logo3);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblUserName.setBounds(71, 331, 120, 50);
		logo3.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		logo3.add(lblPassword);
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblPassword.setBounds(71, 368, 120, 50);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					String query="select name,pwd from login where name=? and pwd=?";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					String n=textField.getText();
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count++;
					}
					if(count==1)
					{
						dispose();
						after_login a=new after_login(1,n,x);
						a.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Stupid");
					rs.close();
					pst.close();
					
					
					
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f);
					
				}

			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		logo3.add(btnLogin);
		btnLogin.setBounds(138, 436, 117, 25);
		
		JButton btnSignup = new JButton("SignUp");
		logo3.add(btnSignup);
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				signup st = new signup();
				st.sign();
			}
		});
		btnSignup.setBounds(400, 436, 117, 25);
		
		textField = new JTextField();
		logo3.add(textField);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(190, 346, 125, 19);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		logo3.add(passwordField);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(190, 384, 125, 19);
		
		JLabel lblNewUser = new JLabel("NEW USER....");
		logo3.add(lblNewUser);
		lblNewUser.setBounds(403, 383, 120, 50);
		setLocationRelativeTo(null);
		
		
	}
}