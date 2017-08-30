package Movie;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class exp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection connect=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exp frame = new exp("PIKU");
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
	public exp(String str) {
		final String p=str;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 472, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel back = new JLabel("background");	
		back.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/stars_back.jpg")).getImage();
		back.setBounds(-10, -200, 940, 740);
	    back.setIcon(new ImageIcon(img1_3));
		contentPane.add(back);
		
		JButton btnComment = new JButton("comment");
		btnComment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						text t=new text(p);
						t.setVisible(true);
						dispose();
						
						
			}
		});
		btnComment.setBounds(80, 430, 117, 25);
		back.add(btnComment);
		
		JButton btnDisplay = new JButton("display");
		btnDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
				connect=sqliteConnection.dataConnector();
				
				String query="select comments from posts where movie='"+p+"'";
				PreparedStatement pst=connect.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				String a=rs.getString(1);
				 pst=connect.prepareStatement(query);
				textField.setText(a);
				pst.execute();
				pst.close();
				}
				catch(Exception g)
				{
					g.printStackTrace();
				}
			}
		});
		btnDisplay.setBounds(270, 430, 117, 25);
		back.add(btnDisplay);
		
		textField = new JTextField();
		textField.setBounds(12, 35, 436, 183);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
