package Movie;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.lang.*;
/*import java.lang.*/

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class wallet extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoggedIn;
	Connection connect;
	int m;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//
					wallet frame = new wallet("shri");
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
	public wallet(String s) {
		final String p;
		p=s;
		
		connect=sqliteConnection.dataConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel back = new JLabel("back");	
		back.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/payment_back.png")).getImage();
		contentPane.setLayout(null);
		back.setBounds(0, -80, 800, 700);
	    back.setIcon(new ImageIcon(img1_3));
		contentPane.add(back);
		
		try
		{
			String query="select * from login where name='"+p+"'";
			PreparedStatement pst=connect.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{				
				 m=rs.getInt(4);
				JOptionPane.showMessageDialog(null,m);
			}
			rs.close();
			pst.close();	
		}
		catch(Exception f)
		{
			JOptionPane.showMessageDialog(null, f);	
		}

		String num;
		num=Integer.toString(m);
		txtLoggedIn= new JTextField();
		txtLoggedIn.setEditable(false);
		txtLoggedIn.setBounds(160, 70, 114, 19);
		contentPane.add(txtLoggedIn);
		txtLoggedIn.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(350, 70, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "Enter Amount");
				
				String x=textField.getText();
				int u=Integer.parseInt(x);
				m=m+u;
				try
				{
					String query="update login set money='"+m+"' where name='"+p+"'";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.execute();
					pst.close();
				}
				catch(Exception d)
				{
					JOptionPane.showMessageDialog(null, "Updating money");
				}
				String r=Integer.toString(m);
				txtLoggedIn.setText(r);
			}
		});
		btnAdd.setBounds(240, 230, 117, 25);
		back.add(btnAdd);
		
		
		
	}
}
