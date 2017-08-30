package Movie;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.*;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class text extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection connect=null;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					text frame = new text("PIKU");
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
	public text(String str) {
		final String p;
		p=str;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 25, 336, 163);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(306, 200, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPost = new JButton("post");
		btnPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
				connect=sqliteConnection.dataConnector();
				
				String query="select comments from posts where movie='"+p+"'";
				PreparedStatement pst=connect.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				String a=rs.getString(1);
				a=a+"\n"
						+ textField.getText();
						query="update  posts set comments='"+a+"' where movie='"+p+"'";
				 pst=connect.prepareStatement(query);
				
				
				pst.execute();
				pst.close();
				}
				catch(Exception g)
				{
	
					g.printStackTrace();
				}
			}
		});
		btnPost.setBounds(164, 237, 117, 25);
		contentPane.add(btnPost);
		
	}

}
