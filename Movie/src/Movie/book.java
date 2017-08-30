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

public class book extends JFrame {
	Connection connect;
	Connection connect1;
	Connection connect2;
	Connection connect3;
	Connection connect4;
	public int total=0,i=1;
	public int[] count=new int[40];
	public String[] done=new String[40];
	String p;
	int m;	
	int check[]=new int [23];
	private JPanel contentPane;
	
	final Image img1 = new ImageIcon(this.getClass().getResource("/empty.jpg")).getImage();
	final Image img11 = new ImageIcon(this.getClass().getResource("/fill.jpg")).getImage();
	
	//static int x=80, y=240;

	/**
	 * Launch the application.
	 */
	public static void bookee(/*final String str*/) {
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
	public book(String movie_name,String s,final int dis,final String mov) {
		p=movie_name;
		final String name=s;
		for(int i=0;i<23;i++)
		{
			count[i]=0;
			done[i]="false";
			check[i]=0;
		}
		connect =sqliteConnection.dataConnector();
		String query;
		
		
			query=" SELECT * FROM posts WHERE movie='"+movie_name+"'";
			try{
				PreparedStatement pst=connect.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
					for(i=1;i<23;i++)
					{
						done[i-1]=rs.getString(i+3);
					}
				rs.close();
				pst.close();
			}catch(Exception e)
				{	JOptionPane.showMessageDialog(null, e);}
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 34, 939, 742);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(1, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel back = new JLabel("background");	
			back.setBorder(null);
	        Image img1_3 = new ImageIcon(this.getClass().getResource("/booking_back.png")).getImage();
			back.setBounds(-10, -50, 940, 740);
		    back.setIcon(new ImageIcon(img1_3));
			contentPane.add(back);
			
			int x=300, y=460;		//xy
			
			final JLabel label1 = new JLabel("");
			
			 if(!done[0].equals("false"))
					label1.setIcon(new ImageIcon(img11));
			 else
					label1.setIcon(new ImageIcon(img1));
			label1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					count[0]++;
					if(count[0]%2==0 && done[0].equals("false"))
						 {
							label1.setIcon(new ImageIcon(img1));
							total--;
							connect=sqliteConnection.dataConnector();
							 String query=" UPDATE posts SET book1='false' WHERE movie='"+p+"'"; 
							 check[0]=0;
							try{
								PreparedStatement pst=connect.prepareStatement(query);
								pst.execute();
								pst.close();
							}
							catch (Exception e1){
							JOptionPane.showMessageDialog(null, e1);
						}
						}
					else if(count[0]%2==1 && done[0].equals("false"))
						 {
							label1.setIcon(new ImageIcon(img11));
							total++;
							connect=sqliteConnection.dataConnector();
							check[0]=1;
							 String query=" UPDATE posts SET book1='"+name+"' WHERE movie='"+p+"'"; 
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
			
			label1.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label1);
			
			
			
			final JLabel label2 = new JLabel("");
			if(!done[1].equals("false"))
				label2.setIcon(new ImageIcon(img11));
			else
				label2.setIcon(new ImageIcon(img1));
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[1]++;
				if(count[1]%2==0 && done[1].equals("false"))
					 {
						label2.setIcon(new ImageIcon(img1));
						total--;
						check[1]=0;
						try{
							connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book2='false' WHERE movie='"+p+"'"; 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						}
				else if(count[1]%2==1 && done[1].equals("false"))
					 {
						label2.setIcon(new ImageIcon(img11));
						total++;
						check[1]=1;
						try{
							connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book2='"+name+"' WHERE movie='"+p+"'"; 
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
			label2.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label2);
			
		
			final JLabel label3 = new JLabel("");
			if(!done[2].equals("false"))
				label3.setIcon(new ImageIcon(img11));
			else
				label3.setIcon(new ImageIcon(img1));
		label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[2]++;
				if(count[2]%2==0 && done[2].equals("false"))
					 {
						label3.setIcon(new ImageIcon(img1));
						total--;
						check[2]=0;
						try{
							connect =sqliteConnection.dataConnector();
							 String query=" UPDATE posts SET book3='false' WHERE movie='"+p+"'"; 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						}
				else if(count[2]%2==1 && done[2].equals("false"))
					 {
						label3.setIcon(new ImageIcon(img11));
						total++;
						check[2]=1;
						try{
							connect =sqliteConnection.dataConnector();
							 String query=" UPDATE posts SET book3='"+name+"' WHERE movie='"+p+"'"; 
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
			label3.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label3);
			
			
			
			final JLabel label4 = new JLabel("");
			if(!done[3].equals("false"))
				label4.setIcon(new ImageIcon(img11));
			else
				label4.setIcon(new ImageIcon(img1));
		label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[3]++;
				if(count[3]%2==0 && done[3].equals("false"))
					 {
						label4.setIcon(new ImageIcon(img1));
						total--;
						check[3]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book4='false' WHERE movie='"+p+"'"; 
						try{
							
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						}
				else if(count[3]%2==1 && done[3].equals("false"))
					 {
						label4.setIcon(new ImageIcon(img11));
						total++;
						check[3]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book4='"+name+"' WHERE movie='"+p+"'"; 
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
			label4.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label4);
			
			
			final JLabel label5 = new JLabel("");
			if(!done[4].equals("false"))
				label5.setIcon(new ImageIcon(img11));
			else
				label5.setIcon(new ImageIcon(img1));
		label5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[4]++;
				if(count[4]%2==0 && done[4].equals("false"))
					 {
						label5.setIcon(new ImageIcon(img1));
						total--;
						check[4]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book5='false' WHERE movie='"+p+"'"; 
						try{
							
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						}
				else if(count[4]%2==1 && done[4].equals("false"))
					 {
						label5.setIcon(new ImageIcon(img11));
						total++;
						check[4]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book5='"+name+"' WHERE movie='"+p+"'"; 
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
			label5.setBounds(x, y, 50, 60);
			//x+=70;
			back.add(label5);
			
			
			final JLabel label6 = new JLabel("");
			if(!done[5].equals("false"))
				label6.setIcon(new ImageIcon(img11));
			else
				label6.setIcon(new ImageIcon(img1));
		label6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[5]++;
				if(count[5]%2==0 && done[5].equals("false"))
					 {
						label6.setIcon(new ImageIcon(img1));
						total--;
						check[5]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book6='false' WHERE movie='"+p+"'"; 
						try{
							
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						}
				else if(count[5]%2==1 && done[5].equals("false"))
					 {
						label6.setIcon(new ImageIcon(img11));
						total++;
						check[5]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book6='"+name+"' WHERE movie='"+p+"'"; 
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
		
			x=260; y=390;			//xy
			
			label6.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label6);
			
			final JLabel label7;
			label7 = new JLabel("");
			if(!done[6].equals("false"))
				label7.setIcon(new ImageIcon(img11));
			else
				label7.setIcon(new ImageIcon(img1));
		label7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[6]++;
				if(count[6]%2==0 && done[6].equals("false"))
					 {
						label7.setIcon(new ImageIcon(img1));
						total--;	
						check[6]=0;
						try{
							connect =sqliteConnection.dataConnector();
							 String query=" UPDATE posts SET book7='false' WHERE movie='"+p+"'"; 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
						
						}
				else if(count[6]%2==1 && done[6].equals("fale"))
					 {
						label7.setIcon(new ImageIcon(img11));
						total++;
						check[6]=1;
						try{
							connect =sqliteConnection.dataConnector();
							 String query=" UPDATE posts SET book7='"+name+"' WHERE movie='"+p+"'"; 
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
			label7.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label7);
			
			final JLabel label8;
			label8 = new JLabel("");
			if(!done[7].equals("false"))
				label8.setIcon(new ImageIcon(img11));
			else
				label8.setIcon(new ImageIcon(img1));
		label8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[7]++;
				if(count[7]%2==0 && done[7].equals("false"))
					 {
						label8.setIcon(new ImageIcon(img1));
						total--;
						check[7]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book8='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[7]%2==1 && done[7].equals("false"))
					 {
						label8.setIcon(new ImageIcon(img11));
						total++;
						check[7]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book8='"+name+"' WHERE movie='"+p+"'";
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
			label8.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label8);
			
			final JLabel label9;
			label9 = new JLabel("");
			if(!done[8].equals("false"))
				label9.setIcon(new ImageIcon(img11));
			else
				label9.setIcon(new ImageIcon(img1));
		label9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[8]++;
				if(count[8]%2==0 && done[8].equals("false"))
					 {
						label9.setIcon(new ImageIcon(img1));
						total--;
						check[8]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book9='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[8]%2==1 && done[8].equals("false"))
					 {
						label9.setIcon(new ImageIcon(img11));
						total++;
						check[8]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book9='"+name+"' WHERE movie='"+p+"'";
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
			label9.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label9);
			
			
			final JLabel label10;
			label10 = new JLabel("");
			if(!done[9].equals("false"))
				label10.setIcon(new ImageIcon(img11));
			else
				label10.setIcon(new ImageIcon(img1));
		label10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[9]++;
				if(count[9]%2==0 && done[9].equals("false"))
					 {
						label10.setIcon(new ImageIcon(img1));
						total--;
						check[9]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book10='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[9]%2==1 && done[9].equals("false"))
					 {
						label10.setIcon(new ImageIcon(img11));
						total++;
						check[9]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book10='"+name+"' WHERE movie='"+p+"'";
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
			label10.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label10);
			
			final JLabel label11;
			label11 = new JLabel("");
			if(!done[10].equals("false"))
				label11.setIcon(new ImageIcon(img11));
			else
				label11.setIcon(new ImageIcon(img1));
		label11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[10]++;
				if(count[10]%2==0 && done[10].equals("false"))
					 {
						label11.setIcon(new ImageIcon(img1));
						total--;
						check[10]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book11='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[10]%2==1 && done[10].equals("false"))
					 {
						label11.setIcon(new ImageIcon(img11));
						total++;
						check[10]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book11='"+name+"' WHERE movie='"+p+"'";
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
			label11.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label11);
			
			
			final JLabel label12;
			label12 = new JLabel("");
			if(!done[11].equals("false"))
				label12.setIcon(new ImageIcon(img11));
			else
				label12.setIcon(new ImageIcon(img1));
		label12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[11]++;
				if(count[11]%2==0 && done[11].equals("false"))
					 {
						label12.setIcon(new ImageIcon(img1));
						total--;
						check[11]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book12='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[11]%2==1 && done[11].equals("false"))
					 {
						label12.setIcon(new ImageIcon(img11));
						total++;
						check[11]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book12='"+name+"' WHERE movie='"+p+"'";
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
		
			x=260; y=320;		//xy
		
			label12.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label12);
			
			final JLabel label13;
			label13 = new JLabel("");
			if(!done[12].equals("false"))
				label13.setIcon(new ImageIcon(img11));
			else
				label13.setIcon(new ImageIcon(img1));
		label13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[12]++;
				if(count[12]%2==0 && done[12].equals("false"))
					 {
						label13.setIcon(new ImageIcon(img1));
						total--;
						check[12]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book13='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[12]%2==1 && done[12].equals("false"))
					 {
						label13.setIcon(new ImageIcon(img11));
						total++;
						check[12]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book13='"+name+"' WHERE movie='"+p+"'";
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
			label13.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label13);
			
			final JLabel label14;
			label14 = new JLabel("");
			if(!done[13].equals("false"))
				label14.setIcon(new ImageIcon(img11));
			else
				label14.setIcon(new ImageIcon(img1));
		label14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[13]++;
				if(count[13]%2==0 && done[13].equals("false"))
					 {
						label14.setIcon(new ImageIcon(img1));
						total--;
						check[13]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book14='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[13]%2==1 && done[13].equals("false"))
					 {
						label14.setIcon(new ImageIcon(img11));
						total++;
						check[13]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book14='"+name+"' WHERE movie='"+p+"'";
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
			label14.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label14);
			
			final JLabel label15;
			label15 = new JLabel("");
			if(!done[14].equals("false"))
				label15.setIcon(new ImageIcon(img11));
			else
				label15.setIcon(new ImageIcon(img1));
		label15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[14]++;
				if(count[14]%2==0 && done[14].equals("false"))
					 {
						label15.setIcon(new ImageIcon(img1));
						total--;
						check[14]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book15='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[14]%2==1 && done[14].equals("false"))
					 {
						label15.setIcon(new ImageIcon(img11));
						total++;
						check[14]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book15='"+name+"' WHERE movie='"+p+"'";
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
			label15.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label15);
			
			final JLabel label16;
			label16 = new JLabel("");
			if(!done[15].equals("false"))
				label16.setIcon(new ImageIcon(img11));
			else
				label16.setIcon(new ImageIcon(img1));
		label16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[15]++;
				if(count[15]%2==0 && done[15].equals("false"))
					 {
						label16.setIcon(new ImageIcon(img1));
						total--;
						check[15]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book16='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[15]%2==1 && done[15].equals("false"))
					 {
						label16.setIcon(new ImageIcon(img11));
						total++;
						check[15]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book16='"+name+"' WHERE movie='"+p+"'";
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
			label16.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label16);
			
			final JLabel label17;
			label17 = new JLabel("");
			if(!done[16].equals("false"))
				label17.setIcon(new ImageIcon(img11));
			else
				label17.setIcon(new ImageIcon(img1));
		label17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[16]++;
				if(count[16]%2==0 && done[16].equals("false"))
					 {
						label17.setIcon(new ImageIcon(img1));
						total--;
						check[16]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book17='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[16]%2==1 && done[16].equals("false"))
					 {
						label17.setIcon(new ImageIcon(img11));
						total++;
						check[16]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book17='"+name+"' WHERE movie='"+p+"'";
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
			label17.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label17);
			
			final JLabel label18;
			label18 = new JLabel("");
			if(!done[17].equals("false"))
				label18.setIcon(new ImageIcon(img11));
			else
				label18.setIcon(new ImageIcon(img1));
		label18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[17]++;
				if(count[17]%2==0 && done[17].equals("false"))
					 {
						label18.setIcon(new ImageIcon(img1));
						total--;
						check[17]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book18='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[17]%2==1 && done[17].equals("false"))
					 {
						label18.setIcon(new ImageIcon(img11));
						total++;
						check[17]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book18='"+name+"' WHERE movie='"+p+"'";
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
		
			x=260; y=250;		//xy
		
			label18.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label18);
			
			final JLabel label19;
			label19 = new JLabel("");
			if(!done[18].equals("false"))
				label19.setIcon(new ImageIcon(img11));
			else
				label19.setIcon(new ImageIcon(img1));
		label19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[18]++;
				if(count[18]%2==0 && done[18].equals("false"))
					 {
						label19.setIcon(new ImageIcon(img1));
						total--;
						check[18]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book19='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[18]%2==1 && done[18].equals("false"))
					 {
						label19.setIcon(new ImageIcon(img11));
						total++;
						check[18]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book19='"+name+"' WHERE movie='"+p+"'";
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
			label19.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label19);
			
			final JLabel label20;
			label20 = new JLabel("");
			if(!done[19].equals("false"))
				label20.setIcon(new ImageIcon(img11));
			else
				label20.setIcon(new ImageIcon(img1));
		label20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[19]++;
				if(count[19]%2==0 && done[19].equals("false"))
					 {
						label20.setIcon(new ImageIcon(img1));
						total--;
						check[19]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book20='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[19]%2==1 && done[19].equals("false"))
					 {
						label20.setIcon(new ImageIcon(img11));
						total++;
						check[19]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book20='"+name+"' WHERE movie='"+p+"'";
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
			label20.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label20);
			
			final JLabel label21;
			label21 = new JLabel("");
			if(!done[20].equals("false"))
				label21.setIcon(new ImageIcon(img11));
			else
				label21.setIcon(new ImageIcon(img1));
		label21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[20]++;
				if(count[20]%2==0 && done[20].equals("false"))
					 {
						label21.setIcon(new ImageIcon(img1));
						total--;
						check[20]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book21='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[20]%2==1 && done[20].equals("false"))
					 {
						label21.setIcon(new ImageIcon(img11));
						total++;
						check[20]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book21='"+name+"' WHERE movie='"+p+"'";
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
			label21.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label21);
			
			final JLabel label22;
			label22 = new JLabel("");
			if(!done[21].equals("false"))
				label22.setIcon(new ImageIcon(img11));
			else
				label22.setIcon(new ImageIcon(img1));
		label22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[21]++;
				if(count[21]%2==0 && done[21].equals("false"))
					 {
						label22.setIcon(new ImageIcon(img1));
						total--;
						check[21]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book22='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[21]%2==1 && done[21].equals("false"))
					 {
						label22.setIcon(new ImageIcon(img11));
						total++;
						check[21]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book22='"+name+"' WHERE movie='"+p+"'";
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
			label22.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label22);
			
			final JLabel label23;
			label23 = new JLabel("");
			if(!done[22].equals("false"))
				label23.setIcon(new ImageIcon(img11));
			else
				label23.setIcon(new ImageIcon(img1));
		label23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				count[22]++;
				if(count[22]%2==0 && done[22].equals("false"))
					 {
						label23.setIcon(new ImageIcon(img1));
						total--;
						check[22]=0;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book23='false' WHERE movie='"+p+"'";
						try{
							 
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch (Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
											
						}
				else if(count[22]%2==1 && done[22].equals("false"))
					 {
						label23.setIcon(new ImageIcon(img11));
						total++;
						check[22]=1;
						connect =sqliteConnection.dataConnector();
						 String query=" UPDATE posts SET book23='"+name+"' WHERE movie='"+p+"'";
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
			label23.setBounds(x, y, 50, 60);
			x+=70;
			back.add(label23);
			
			
			JButton btnBook = new JButton("BOOK");
			btnBook.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int cost=total *100;
					String str="Confirm "+total+" tickets worth "+cost;
					int result=JOptionPane.showConfirmDialog(null,str);
					try
					{
						String query="select * from login where name='"+name+"'";
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
					if(result==JOptionPane.YES_OPTION && m>=cost)
					{
						JOptionPane.showMessageDialog(null, "Successfully book");
						
						int d,c=0;
						for(d=0;d<23;d++)
						{
							if(check[d]==1)
							{
								c++;
							}
						}
						if(c>=3)
						{
							d=dis*cost/100;
						}
						else
							JOptionPane.showMessageDialog(null, "entereddddd");
						cost=cost-d;
						m=m-cost;
						try
						{
							String query="update login set money='"+m+"' where name='"+name+"'";
							PreparedStatement pst=connect.prepareStatement(query);
							pst.execute();
							pst.close();
						}
						catch(Exception f)
						{
							JOptionPane.showMessageDialog(null, "Updating money");
						}

					}
					else
					{
						JOptionPane.showMessageDialog(null, "Cant book");
						String query;
						for(int i=0;i<23;i++)
						{
							if(check[i]==1)
							{
								switch(i+1)
								
								{
								case 1:   label1.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								  query=" UPDATE posts SET book1='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 2:   label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book2='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 3:   label3.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book3='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 4:   label4.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book4='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 5:   label5.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book5='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 6:   label6.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book6='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 7:   label7.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book7='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 8:   label8.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book8='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								case 9:   label9.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book9='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
								}
								catch (Exception e1){
								JOptionPane.showMessageDialog(null, e1);
							}
								break;
								
								case 10:   label10.setIcon(new ImageIcon(img1));
								label2.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book10='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 11:   label11.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book11='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 12:   label12.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book12='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 13:   label13.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book13='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 14:   label14.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book14='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 15:   label15.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book15='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 16:   label16.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book16='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 17:   label17.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book17='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 18:   label18.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book18='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 19:   label19.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book19='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 20:   label20.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book20='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 21:   label21.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book21='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 22:   label22.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book22='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								case 23:   label23.setIcon(new ImageIcon(img1));
								connect =sqliteConnection.dataConnector();
								 query=" UPDATE posts SET book23='false' WHERE movie='"+p+"'";
								try{
									 
									PreparedStatement pst=connect.prepareStatement(query);
									pst.execute();
									pst.close();
									}
								catch (Exception e1){
									JOptionPane.showMessageDialog(null, e1);
									}
								break;
								
								}
							}
						}
					}
					
					
					
				}
			});
			btnBook.setBounds(330, 610, 117, 25);
			contentPane.add(btnBook);

		 }
	
		
		
	}

