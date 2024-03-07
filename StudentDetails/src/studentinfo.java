import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class studentinfo {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentinfo window = new studentinfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentinfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 192));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(115, 72, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tb1 = new JTextField();
		tb1.setForeground(new Color(255, 255, 255));
		tb1.setBounds(218, 71, 120, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(105, 113, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tb2 = new JTextField();
		tb2.setBounds(218, 112, 120, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DEPARTMENT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(71, 157, 104, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "DATA SCIENCE", "CYBER SECURITY", "IOT"}));
		cb1.setBounds(218, 155, 120, 22);
		frame.getContentPane().add(cb1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll = tb1.getText();
				int id = Integer.parseInt(roll);
				String name = tb2.getText();
				String department = (String) cb1.getSelectedItem();
				try {
						Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mrec");
						String q="insert into students values('"+id+"', '"+name+"', '"+department+"')";
						Statement stn=con.createStatement();
						stn.executeUpdate(q);
						JOptionPane.showMessageDialog(btnNewButton, "record inserted");
					    con.close();
					}catch (SQLException e1) {
					PrintStream q = null;
					e1.printStackTrace(q);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(64, 0, 64));
		btnNewButton.setBounds(162, 212, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("STUDENT REGISTRATION FORM");
		lblNewJgoodiesTitle.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle.setBounds(102, 21, 295, 14);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\online lab\\Pictures\\Saved Pictures\\istockphoto-1207969619-612x612.jpg"));
		lblNewLabel_3.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
