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
import javax.swing.JTextArea;

public class ticketslip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//
					ticketslip frame = new ticketslip("srg", "ihgr", "shri", 3, 5, 6);
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
	public ticketslip(String mov,String mov_name,String user,int dis,int cost,int num) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 80, 1050, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel back = new JLabel("background");	
		back.setBorder(null);
        Image img1_3 = new ImageIcon(this.getClass().getResource("/ticket_back.jpg")).getImage();
		back.setBounds(-10, -30, 1100, 600);
	    back.setIcon(new ImageIcon(img1_3));
		contentPane.add(back);
		
		JLabel lblSuccessfullyBooked = new JLabel("Thank You For Booking!");
		lblSuccessfullyBooked.setBounds(590, 90, 210, 15);
		back.add(lblSuccessfullyBooked);
		
		JLabel lblNewLabel_3 = new JLabel("Movie name");
		lblNewLabel_3.setBounds(470, 150, 89, 15);
		back.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(470, 180, 70, 15);
		back.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Show Details");
		lblNewLabel_1.setBounds(470, 210, 119, 15);
		back.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total cost");
		lblNewLabel_2.setBounds(470, 240, 89, 15);
		back.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Tickets");
		lblNewLabel_5.setBounds(470, 370, 70, 15);
		back.add(lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("Discount availed");
		lblNewLabel_4.setBounds(470, 410, 119, 15);
		back.add(lblNewLabel_4);
		
		
		
		textField = new JTextField(mov_name);
		textField.setBounds(610, 150, 114, 19);
		back.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField(user);
		textField_1.setBounds(610, 180, 114, 19);
		back.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_3 = new JTextField(Integer.toString(cost));
		textField_3.setBounds(610, 210, 114, 19);
		back.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		JTextArea textArea = new JTextArea(mov);
		textArea.setBounds(610, 240, 230, 120);
		back.add(textArea);
		textArea.setEditable(false);
		
		textField_2 = new JTextField(Integer.toString(num));
		textField_2.setBounds(610, 370, 114, 19);
		back.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		textField_4 = new JTextField(Integer.toString(dis)+"%");
		textField_4.setBounds(610, 410, 114, 19);
		back.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
	}
}
