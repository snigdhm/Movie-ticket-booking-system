package Movie;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class run extends JFrame {
/*	public int[] flag=new int[40];*/
	
	private JPanel contentPane;
	JLabel pic;
	int x=0;
	Timer tm;
	String[] list=
		{
				"/home/teja/a.jpg",
				"/home/teja/t.jpg",
				"/home/teja/b.jpg",
				//"/home/teja/h.jpg",
				"/home/teja/p.jpg",
				"/home/teja/f.jpg"
			
			
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String []args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					run frame = new run();
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
	public run(final String name)
	{
		super("MOVIE SLIDE SHOW");
		
		pic=new JLabel();
		pic.setBounds(380, 105, 736, 325);
		pic.setVisible(true);
		SetImageSize(4);
		 tm = new Timer(2000,new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                SetImageSize(x);
	                x += 1;
	                if(x >= list.length )
	                    x = 0; 
	            }
	        });
		 //add(pic);
	        tm.start();
	        getContentPane().setLayout(null);
	        setSize(1272, 712);
	        contentPane = new JPanel();
	        contentPane.setForeground(Color.WHITE);
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
	        contentPane.add(pic);
	       // getContentPane().setBackground(Color.decode("#bdb67b"));
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
			
		
		
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 34, 1272, 712);
		
		
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag;
				if(!name.equals("null"))
				{
					flag=0;
					offers of=new offers(flag,name);
					of.setVisible(true);
				}
				else
				{
					flag=1;
					offers of=new offers(flag,name);
					of.setVisible(true);
				}
			}
		});
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
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				run r=new run(name);
				r.setVisible(true);
				r.setResizable(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 134, 34);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("LOGOUT");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null ,"LOGGED OUT");
				run r=new run();
				dispose();
						
			}
		});
		btnNewButton_2.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(870, 0, 134, 34);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("WALLET");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wallet w=new wallet(name);
				w.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(1004, 0, 134, 34);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("LOCATION");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				location s=new location(0,"null");
				s.setVisible(true);
			}
		});
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
		 Image img1_4 = new ImageIcon(this.getClass().getResource("/post11.jpg")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("");
		 Image img1_5 = new ImageIcon(this.getClass().getResource("/post21.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img1_5));
		lblNewLabel_1.setBounds(69, 501, 150, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		 Image img1_6 = new ImageIcon(this.getClass().getResource("/post31.jpg")).getImage();
		 lblNewLabel_2.setIcon(new ImageIcon(img1_6));
		lblNewLabel_2.setBounds(534, 501, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		 Image img1_7 = new ImageIcon(this.getClass().getResource("/post41.jpg")).getImage();
		 lblNewLabel_3.setIcon(new ImageIcon(img1_7));
		lblNewLabel_3.setBounds(290, 501, 150, 150);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
		 Image img1_8 = new ImageIcon(this.getClass().getResource("/post51.jpg")).getImage();
		 lblNewLabel_4.setIcon(new ImageIcon(img1_8));
		lblNewLabel_4.setBounds(769, 501, 150, 150);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel();
		 Image img1_9 = new ImageIcon(this.getClass().getResource("/post61.jpg")).getImage();
		 lblNewLabel_5.setIcon(new ImageIcon(img1_9));
		lblNewLabel_5.setBounds(1041, 501, 150, 150);
		contentPane.add(lblNewLabel_5);
		
		JLabel comments = new JLabel();
		  Image img1= new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
		  comments.setIcon(new ImageIcon(img1));
		comments.setBounds(41, 167, 250, 200);
		contentPane.add(comments);
		
		JButton btnNewButton_5 = new JButton("Display");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			
			
			}
		});
		btnNewButton_5.setBounds(94, 389, 100, 30);
		contentPane.add(btnNewButton_5);
		
	}
	
	
	public run() {
		super("MOVIE SLIDE SHOW");
		pic=new JLabel();
		pic.setBounds(380, 105, 736, 325);
		pic.setVisible(true);
		SetImageSize(4);
		 tm = new Timer(2000,new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                SetImageSize(x);
	                x += 1;
	                if(x >= list.length )
	                    x = 0; 
	            }
	        });
		 //add(pic);
	        tm.start();
	        getContentPane().setLayout(null);
	        setSize(1272, 712);
	        contentPane = new JPanel();
	        contentPane.setForeground(Color.WHITE);
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
	        contentPane.add(pic);
	       // getContentPane().setBackground(Color.decode("#bdb67b"));
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
			
		
		
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 34, 1272, 712);
		
		
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				offers of=new offers(0,"null");
				of.setVisible(true);
			}
		});
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
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				run r=new run();
				r.setVisible(true);
				r.setResizable(false);
				
			}
		});
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
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signup l=new signup();
				l.sign();
			}
		});
		btnNewButton_3.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(1004, 0, 134, 34);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("LOCATION");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				location s=new location(0,"null");
				s.setVisible(true);
			}
		});
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
		 Image img1_4 = new ImageIcon(this.getClass().getResource("/post11.jpg")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("");
		 Image img1_5 = new ImageIcon(this.getClass().getResource("/post21.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img1_5));
		lblNewLabel_1.setBounds(69, 501, 150, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		 Image img1_6 = new ImageIcon(this.getClass().getResource("/post31.jpg")).getImage();
		 lblNewLabel_2.setIcon(new ImageIcon(img1_6));
		lblNewLabel_2.setBounds(534, 501, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		 Image img1_7 = new ImageIcon(this.getClass().getResource("/post41.jpg")).getImage();
		 lblNewLabel_3.setIcon(new ImageIcon(img1_7));
		lblNewLabel_3.setBounds(290, 501, 150, 150);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
		 Image img1_8 = new ImageIcon(this.getClass().getResource("/post51.jpg")).getImage();
		 lblNewLabel_4.setIcon(new ImageIcon(img1_8));
		lblNewLabel_4.setBounds(769, 501, 150, 150);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel();
		 Image img1_9 = new ImageIcon(this.getClass().getResource("/post61.jpg")).getImage();
		 lblNewLabel_5.setIcon(new ImageIcon(img1_9));
		lblNewLabel_5.setBounds(1041, 501, 150, 150);
		contentPane.add(lblNewLabel_5);
		
		JLabel comments = new JLabel();
		  Image img1= new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
		  comments.setIcon(new ImageIcon(img1));
		comments.setBounds(41, 167, 250, 200);
		contentPane.add(comments);
		
		JButton btnNewButton_5 = new JButton("Display");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				display disp=new display();
				disp.setVisible(true);
			
			}
		});
		btnNewButton_5.setBounds(94, 389, 100, 30);
		contentPane.add(btnNewButton_5);
		
	}
	public void SetImageSize(int i)
	{
		ImageIcon icon=new ImageIcon(list[i]);
		Image img=icon.getImage();
		Image newImg=img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc=new ImageIcon(newImg);
		pic.setIcon(newImc);
		
	}
	
	
}
