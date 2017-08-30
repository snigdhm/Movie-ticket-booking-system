package Movie;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class screen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	Connection connect=null;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					screen frame = new screen();
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
	public screen() {
		

		connect =sqliteConnection.dataConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 939, 742);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							}
		});
		//contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBackground(Color.red);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		/*JLabel logo3 = new JLabel("");
		logo3.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/log_back.jpg")).getImage();
		contentPane.setLayout(null);
		logo3.setBounds(0, 0, 939, 742);
	    logo3.setIcon(new ImageIcon(img1_3));
		contentPane.add(logo3);
		Image gohome_2 = new ImageIcon(this.getClass().getResource("/loc.jpg")).getImage();*/
	    
	   
		
		textField = new JTextField();
		textField.setForeground(Color.YELLOW);
		textField.setBackground(Color.red);
		textField.setBounds(394, 243, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblUserName.setBounds(258, 244, 118, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblPassword.setBounds(268, 276, 105, 14);
		contentPane.add(lblPassword);
		
		JLabel login_fac = new JLabel("");
		login_fac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					String query="select name,pwd from login where name=? and pwd=?";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count++;
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "DONE");
						dispose();
						//Faculty_page ad = new Faculty_page();
						//ad.setLocationRelativeTo(null);
						//ad.setVisible(true);
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
		Image log_fac = new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		login_fac.setBounds(374, 307, 225, 143);
		login_fac.setIcon(new ImageIcon(log_fac));
		contentPane.add(login_fac);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(394, 275, 151, 20);
		contentPane.add(passwordField);
		
		JLabel register = new JLabel("");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				signup st = new signup();
				st.sign();
			}
		});
		Image reg = new ImageIcon(this.getClass().getResource("/signup.jpg")).getImage();
		register.setBounds(616, 531, 286, 171);
		register.setIcon(new ImageIcon(reg));
		contentPane.add(register);
		
		textField_1 = new JTextField();
		textField_1.setBounds(322, 578, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	    
		this.setLocationRelativeTo(null);
	}
}
