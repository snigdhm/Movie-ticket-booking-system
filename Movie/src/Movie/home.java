package Movie;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void home_1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 34, 1272, 712);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnNewButton_3.setFont(new Font("DejaVu Serif", Font.ITALIC, 14));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(1004, 0, 134, 34);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("LOCATION");
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
		
		JLabel lblNewLabel = new JLabel("");
		 Image img1_4 = new ImageIcon(this.getClass().getResource("/post11.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(img1_4));
		lblNewLabel.setBounds(520, 501, 150, 150);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		 Image img1_5 = new ImageIcon(this.getClass().getResource("/post21.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img1_5));
		lblNewLabel_1.setBounds(769, 304, 150, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		 Image img1_6 = new ImageIcon(this.getClass().getResource("/post31.jpg")).getImage();
		 lblNewLabel_2.setIcon(new ImageIcon(img1_6));
		lblNewLabel_2.setBounds(1041, 304, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		 Image img1_7 = new ImageIcon(this.getClass().getResource("/post41.jpg")).getImage();
		 lblNewLabel_3.setIcon(new ImageIcon(img1_7));
		lblNewLabel_3.setBounds(520, 304, 150, 150);
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
		
	}
}
