package Movie;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class signup  {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void sign() {				//change here
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect=null;
	Statement stmt = null;

	/**
	 * Create the application.
	 */
	public signup() {
		
		initialize();
		connect=sqliteConnection.dataConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		contentPane = new JPanel();
		JLabel back = new JLabel("background");	
		back.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/signup_back2.jpg")).getImage();
		contentPane.setLayout(null);
		back.setBounds(-12, -28, 939, 742);
	    back.setIcon(new ImageIcon(img1_3));
		contentPane.add(back);
		
		frame = new JFrame();
		frame.setBounds(0, 0, 939, 742);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		frame.setContentPane(contentPane);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblName.setBounds(270, 255, 141, 14);
		lblName.setForeground(Color.white);
		back.add(lblName);
		//frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblPassword.setBounds(270, 350, 121, 14);
		lblPassword.setForeground(Color.white);
		back.add(lblPassword);
		//frame.getContentPane().add(lblPassword);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblId.setBounds(270, 300, 87, 14);
		lblId.setForeground(Color.white);
		back.add(lblId);
		//frame.getContentPane().add(lblId);
		
		JLabel lblConfirm = new JLabel("Confirm Password");
		lblConfirm.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		lblConfirm.setBounds(270, 391, 181, 14);
		lblConfirm.setForeground(Color.white);
		back.add(lblConfirm);
		
		textField = new JTextField();
		textField.setBounds(490, 254, 114, 19);
		//frame.getContentPane().add(textField);
		back.add(textField);
		textField_1 = new JTextField();
		textField_1.setBounds(490, 299, 114, 19);
		back.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(490, 349, 114, 19);
		back.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(490, 390, 114, 19);
		back.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSignUp = new JButton("sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String query="insert into login (name,pwd,id) values (?,?,?)";
					PreparedStatement pst=connect.prepareStatement(query);
					String confirm=textField_3.getText() ;
					String pass=textField_2.getText() ;
					if(confirm.equals(pass)){
						
					
					pst.setString(1,textField.getText() );
					pst.setString(2,textField_2.getText() );
					pst.setString(3,textField_1.getText() );
					
					pst.execute();
					/*login_back l=new login_back();
					l.login();*/
					JOptionPane.showMessageDialog(null, "DAta SAVed");
					frame.dispose();
					/*login_back l=new login_back();
					l.login();*/
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Enter the same password");
					}
					pst.close();
					/*login_back l=new login_back();
					l.login();*/
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnSignUp.setBounds(380, 451, 114, 22);
		back.add(btnSignUp);		
		frame.setLocationRelativeTo(null);
		
		
	}
}
