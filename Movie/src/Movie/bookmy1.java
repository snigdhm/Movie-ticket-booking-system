package Movie;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.lang.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.sql.*;

public class bookmy1 extends JFrame {
	Connection connect;
	Connection connect1;
	Connection connect2;
	Connection connect3;
	Connection connect4;
	public int total=0,i=1;
	public int[] count=new int[40];
	public int[] donemy1=new int[40];
	
		
	
	private JPanel contentPane;
	/*private JLabel label6;
	private JLabel label8;
	private JLabel label7;*/

	/**
	 * Launch the application.
	 */
	public static void bookee() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookmy1 frame = new bookmy1();
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
	public bookmy1() {
		for(int i=0;i<40;i++)
		{
			count[i]=0;
			donemy1[i]=0;
		}
		connect =sqliteConnection.dataConnector();
		/*String query="select * from flag  ";*/
		String query=" SELECT booked FROM bookmy1 WHERE (id<11"
				+ ")";
		try{
			PreparedStatement pst=connect.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			
				donemy1[i-1]=rs.getInt(1);
				
				//JOptionPane.showMessageDialog(null,i);
				i++;
			}
			rs.close();
			pst.close();
		}catch(Exception e)
			{	JOptionPane.showMessageDialog(null, e);}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1178, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel label1 = new JLabel("");
		
		 final Image img1 = new ImageIcon(this.getClass().getResource("/not.png")).getImage();
		 final Image img11 = new ImageIcon(this.getClass().getResource("/fill.jpg")).getImage();
		 
		 if(donemy1[0]==1)
				label1.setIcon(new ImageIcon(img11));
		 else
				label1.setIcon(new ImageIcon(img1));
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[0]++;
				if(count[0]%2==0 && donemy1[0]==0)
					 {
						label1.setIcon(new ImageIcon(img1));
						total--;
						connect=sqliteConnection.dataConnector();
						 String query=" UPDATE bookmy1 SET booked =0 WHERE ID = 1"; 
						try{
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
					}
				else if(count[0]%2==1 && donemy1[0]==0)
					 {
						label1.setIcon(new ImageIcon(img11));
						total++;
						connect=sqliteConnection.dataConnector();
						 String query=" UPDATE bookmy1 SET booked =1 WHERE ID = 1"; 
						try{
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						
						}
				
					
			}
		});
		
		label1.setBounds(80, 240, 25, 25);
		contentPane.add(label1);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cost=total *100;
				String str="Confirm "+total+" tickets worth "+cost;
				int result=JOptionPane.showConfirmDialog(null,str);
				if(result==JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(null, "Successfully Booked");
					home h=new home();
					h.home_1();
				}
				
				
			}
		});
		btnBook.setBounds(328, 575, 117, 25);
		contentPane.add(btnBook);
		
		final JLabel label2 = new JLabel("");
		if(donemy1[1]==1)
			label2.setIcon(new ImageIcon(img11));
		else
			label2.setIcon(new ImageIcon(img1));
	label2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[1]++;
			if(count[1]%2==0 && donemy1[1]==0)
				 {
					label2.setIcon(new ImageIcon(img1));
					total--;
					try{
						connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 2"; 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					}
			else if(count[1]%2==1 && donemy1[1]==0)
				 {
					label2.setIcon(new ImageIcon(img11));
					total++;
					try{
						connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 2"; 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label2.setBounds(120, 240, 25, 25);
		contentPane.add(label2);
		
		
		final JLabel label3 = new JLabel("");
		if(donemy1[2]==1)
			label3.setIcon(new ImageIcon(img11));
		else
			label3.setIcon(new ImageIcon(img1));
	label3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[2]++;
			if(count[2]%2==0 && donemy1[2]==0)
				 {
					label3.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked =0 WHERE ID = 3"; 
					try{
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					}
			else if(count[2]%2==1 && donemy1[2]==0)
				 {
					label3.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked =1 WHERE ID = 3"; 
					try{
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label3.setBounds(160, 240, 25, 25);
		contentPane.add(label3);
		
		
		
		final JLabel label4 = new JLabel("");
		if(donemy1[3]==1)
			label4.setIcon(new ImageIcon(img11));
		else
			label4.setIcon(new ImageIcon(img1));
	label4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[3]++;
			if(count[3]%2==0 && donemy1[3]==0)
				 {
					label4.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 4"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					}
			else if(count[3]%2==1 && donemy1[3]==0)
				 {
					label4.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 4"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label4.setBounds(200, 240, 25, 25);
		contentPane.add(label4);
		
		
		final JLabel label5 = new JLabel("");
		if(donemy1[4]==1)
			label5.setIcon(new ImageIcon(img11));
		else
			label5.setIcon(new ImageIcon(img1));
	label5.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[4]++;
			if(count[4]%2==0 && donemy1[4]==0)
				 {
					label5.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0"
					 		+ " WHERE id = 5"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					}
			else if(count[4]%2==1 && donemy1[4]==0)
				 {
					label5.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 5"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label5.setBounds(240, 240, 25, 25);
		contentPane.add(label5);
		
		final JLabel label6 = new JLabel("");
		if(donemy1[5]==1)
			label6.setIcon(new ImageIcon(img11));
		else
			label6.setIcon(new ImageIcon(img1));
	label6.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[5]++;
			if(count[5]%2==0 && donemy1[5]==0)
				 {
					label6.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 6"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					}
			else if(count[5]%2==1 && donemy1[5]==0)
				 {
					label6.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 6"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label6.setBounds(280, 240, 25, 25);
		contentPane.add(label6);
		
		final JLabel label7;
		label7 = new JLabel("");
		if(donemy1[6]==1)
			label7.setIcon(new ImageIcon(img11));
		else
			label7.setIcon(new ImageIcon(img1));
	label7.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[6]++;
			if(count[6]%2==0 && donemy1[6]==0)
				 {
					label7.setIcon(new ImageIcon(img1));
					total--;	
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 7"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			else if(count[6]%2==1 && donemy1[6]==0)
				 {
					label7.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 7"; 
					try{
						
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label7.setBounds(320, 240, 25, 25);
		contentPane.add(label7);
		
		final JLabel label8;
		label8 = new JLabel("");
		if(donemy1[7]==1)
			label8.setIcon(new ImageIcon(img11));
		else
			label8.setIcon(new ImageIcon(img1));
	label8.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[7]++;
			if(count[7]%2==0 && donemy1[7]==0)
				 {
					label8.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 8";
					try{
						 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
										
					}
			else if(count[7]%2==1 && donemy1[7]==0)
				 {
					label8.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 8";
					try{
						 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label8.setBounds(360, 240, 25, 25);
		contentPane.add(label8);
		
		final JLabel label9;
		label9 = new JLabel("");
		if(donemy1[8]==1)
			label9.setIcon(new ImageIcon(img11));
		else
			label9.setIcon(new ImageIcon(img1));
	label9.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[8]++;
			if(count[8]%2==0 && donemy1[8]==0)
				 {
					label9.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 9";
					try{
						 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
										
					}
			else if(count[8]%2==1 && donemy1[8]==0)
				 {
					label9.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 9";
					try{
						 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label9.setBounds(400, 240, 25, 25);
		contentPane.add(label9);
		
		
		final JLabel label10;
		label10 = new JLabel("");
		if(donemy1[9]==1)
			label10.setIcon(new ImageIcon(img11));
		else
			label10.setIcon(new ImageIcon(img1));
	label10.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			count[9]++;
			if(count[9]%2==0 && donemy1[9]==0)
				 {
					label10.setIcon(new ImageIcon(img1));
					total--;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=0 WHERE id = 10";
					try{
						 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
										
					}
			else if(count[9]%2==1 && donemy1[9]==0)
				 {
					label10.setIcon(new ImageIcon(img11));
					total++;
					connect =sqliteConnection.dataConnector();
					 String query=" UPDATE bookmy1 SET booked=1 WHERE id = 10";
					try{
						 
						PreparedStatement pst=connect.prepareStatement(query);
						pst.execute();
						pst.close();
					}
					catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
					
					}
			
				
		}
	});
		label10.setBounds(440, 240, 25, 25);
		contentPane.add(label10);
	}
}
