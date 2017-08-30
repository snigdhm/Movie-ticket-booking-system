package Movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;

public class yourbookings extends JFrame {

	private JPanel contentPane;
	int num=2,i=0,count=0;
	private JTextField number;
	Connection connect;
	String cinema,book;
	int money,dis;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yourbookings frame = new yourbookings("shri");
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
	public yourbookings(final String name) {
		connect =sqliteConnection.dataConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel back = new JLabel("background");	
		back.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/stars_back.jpg")).getImage();
		back.setBounds(-10, -200, 940, 740);
	    back.setIcon(new ImageIcon(img1_3));
		contentPane.add(back);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Purisa", Font.BOLD | Font.ITALIC, 16));
		textArea.setBounds(105, 220, 251, 85);
		back.add(textArea);
		
		number = new JTextField("");
		number.setBounds(250, 340, 75, 25);
		number.setColumns(10);
	    setLocationRelativeTo(null);
	    back.add(number);
	    
	    JLabel lblNoOfTickets = new JLabel("NO OF TICKETS");
		lblNoOfTickets.setBounds(110, 340, 105, 15);
		lblNoOfTickets.setForeground(Color.WHITE);
		back.add(lblNoOfTickets);
	    
		try{
			String query="select cinema,money ,dis from login where name='"+name+"'";
			PreparedStatement pst=connect.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			cinema=rs.getString(1);
			money=rs.getInt(2);
			dis=rs.getInt(3);
			pst.close();
			rs.close();
			query="select * from posts where movie='"+cinema+"'";
			pst=connect.prepareStatement(query);
			rs=pst.executeQuery();
			i=0;
			JOptionPane.showMessageDialog(null, cinema);
			while(i<23)
			{
				book=rs.getString(i+4);
				if(book.equals(name))
				{
					count++;
				}
				i++;
			}
			JOptionPane.showMessageDialog(null, count);
			rs.close();
			pst.close();
	}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
		textArea.setText(cinema+" "+count);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					 num=Integer.parseInt(number.getText());
				if(num<=count)
				{
					int m=money+(num*100)-(dis+10)*num;
					String query="select * from posts where movie='"+cinema+"'";
					 PreparedStatement pst=connect.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();
					 i=0;
					 count=0;
					while(i<23 && count<num)
					{
						i++;
						
						book=rs.getString(i+3);
						String temp="book"+i;
						if(book.equals(name))
						{
							count++;
							String query1="update posts set "+temp+"='false' where movie='"+cinema+"'";
							JOptionPane.showMessageDialog(null, "working"); 
							PreparedStatement pst1=connect.prepareStatement(query1);
							pst1.execute();
							pst1.close();
							
						}
						
						
					}
					pst.close();
					rs.close();
					query="update login set money='"+m+"' where name='"+name+"'";
					 pst=connect.prepareStatement(query);
					pst.execute();
					pst.close();
			
				}
				else
					JOptionPane.showMessageDialog(null, "Stupo");
				
			}
			catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
			}
		
		});
		
		btnCancel.setBounds(160, 390, 117, 25);
		back.add(btnCancel);
		
		
		
		textArea.setText(cinema+" \n"+count+" tickets are booked.");
		textArea.setEditable(false);
		
	}
}
