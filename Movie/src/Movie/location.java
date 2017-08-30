package Movie;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class location extends JFrame {

	private JPanel contentPane;
	private JTextField txtBangaloreMangaloreHubli;

	/**
	 * Launch the application.
	 */
	public static void loc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*location frame = new location();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public location(int f,String s ) {
		final int flag=f;
		final String name=s;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		Image img1_3 = new ImageIcon(this.getClass().getResource("/k.jpg")).getImage();
		label.setIcon(new ImageIcon(img1_3));
		contentPane.add(label);
		label.setBounds(0, 0, 564, 400);
		contentPane.add(label);
		
		
		
		JButton btnCoorg = new JButton("COORG");
		btnCoorg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coorg c=new coorg(flag,name,0);
				c.setVisible(true);
				dispose();
				
			}
		});
		label.add(btnCoorg);
		btnCoorg.setBounds(399, 135, 120, 30);
		
		JButton btnmysore = new JButton("MYSORE");
		btnmysore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mysore my=new mysore(flag,name,0);
				my.setVisible(true);
			}
		});
		label.add(btnmysore);
		btnmysore.setBounds(399, 165, 120, 30);
		
		JButton btnmanipal = new JButton("MANIPAL");
		btnmanipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mani m=new mani(flag,name,0);
				m.setVisible(true);
			}
		});
		label.add(btnmanipal);
		btnmanipal.setBounds(399, 195, 120, 30);
		
		JButton btnmangalore = new JButton("MANGALORE");
		btnmangalore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mangalore m=new mangalore(flag,name,0);
				m.setVisible(true);
				
			}
		});
		label.add(btnmangalore);
		btnmangalore.setBounds(399, 225, 120, 30);
		
		JButton btnbangalore = new JButton("BANGALORE");
		btnbangalore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bangalore b=new bangalore(flag,name,0);
						b.setVisible(true);
			}
		});
		btnbangalore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		label.add(btnbangalore);
		btnbangalore.setBounds(399, 255, 120, 30);
		
		JButton btnHubli = new JButton("HUBLI");
		label.add(btnHubli);
		btnHubli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hubli hc=new hubli(flag,name,0);
				hc.setVisible(true);
				dispose();
			}
		});
		btnHubli.setBounds(399, 105, 120, 30);
		
		
		
		
	}
	public location(int f,String s,final int dis ) {
		final int flag=f;
		final String name=s;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		Image img1_3 = new ImageIcon(this.getClass().getResource("/k.jpg")).getImage();
		label.setIcon(new ImageIcon(img1_3));
		contentPane.add(label);
		label.setBounds(0, 0, 564, 400);
		contentPane.add(label);
		
		
		
		JButton btnCoorg = new JButton("COORG");
		btnCoorg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coorg c=new coorg(flag,name,dis);
				c.setVisible(true);
				dispose();
				
			}
		});
		label.add(btnCoorg);
		btnCoorg.setBounds(399, 135, 120, 30);
		
		JButton btnmysore = new JButton("MYSORE");
		btnmysore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mysore my=new mysore(flag,name,dis);
				my.setVisible(true);
			}
		});
		label.add(btnmysore);
		btnmysore.setBounds(399, 165, 120, 30);
		
		JButton btnmanipal = new JButton("MANIPAL");
		btnmanipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mani m=new mani(flag,name,dis);
				m.setVisible(true);
			}
		});
		label.add(btnmanipal);
		btnmanipal.setBounds(399, 195, 120, 30);
		
		JButton btnmangalore = new JButton("MANGALORE");
		btnmangalore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mangalore m=new mangalore(flag,name,dis);
				m.setVisible(true);
				
			}
		});
		label.add(btnmangalore);
		btnmangalore.setBounds(399, 225, 120, 30);
		
		JButton btnbangalore = new JButton("BANGALORE");
		btnbangalore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bangalore b=new bangalore(flag,name,dis);
						b.setVisible(true);
			}
		});
		btnbangalore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		label.add(btnbangalore);
		btnbangalore.setBounds(399, 255, 120, 30);
		
		JButton btnHubli = new JButton("HUBLI");
		label.add(btnHubli);
		btnHubli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hubli hc=new hubli(flag,name,dis);
				hc.setVisible(true);
				dispose();
			}
		});
		btnHubli.setBounds(399, 105, 120, 30);
		
		
		
		
	}
}
