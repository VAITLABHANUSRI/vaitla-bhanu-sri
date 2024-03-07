import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentDetails {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;
	private JTextField tb3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails window = new StudentDetails();
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
	public StudentDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(111, 10, 254, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(122, 54, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Roll Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(85, 87, 72, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(124, 179, 7, -7);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(111, 125, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		tb1 = new JTextField();
		tb1.setBounds(209, 52, 166, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(209, 85, 166, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("Female");
		lblNewLabel_6.setLabelFor(r1);
		r1.setBounds(209, 121, 72, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setBounds(279, 122, 59, 23);
		frame.getContentPane().add(r2);
		
		JRadioButton r3 = new JRadioButton("Other");
		r3.setBounds(336, 122, 59, 23);
		frame.getContentPane().add(r3);
		
		JLabel lblNewLabel_5 = new JLabel("Department");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(85, 154, 72, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Mobile No");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(96, 195, 61, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"+91 ", "+040", "+12"}));
		cb2.setBounds(206, 192, 66, 22);
		frame.getContentPane().add(cb2);
		
		
		tb3 = new JTextField();  
		tb3.setBounds(283, 193, 92, 20);
		frame.getContentPane().add(tb3);
		tb3.setColumns(10);
		
		

		JCheckBox cbox1 = new JCheckBox("C");
		cbox1.setBounds(195, 262, 46, 23);
		frame.getContentPane().add(cbox1);
		
		JCheckBox cbox2 = new JCheckBox("Python");
		cbox2.setBounds(243, 262, 72, 23);
		frame.getContentPane().add(cbox2);
		
		JCheckBox cbox3 = new JCheckBox("Java");
		cbox3.setBounds(313, 262, 97, 23);
		frame.getContentPane().add(cbox3);
		

		JSpinner year_val = new JSpinner();
		year_val.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		year_val.setBounds(209, 225, 30, 20);
		frame.getContentPane().add(year_val);
		ButtonGroup brg =  new ButtonGroup();
		brg.add(r1);
		brg.add(r2);
		brg.add(r3);
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "CSE-AIML", "CSE-DS", "IT", "ECE", "MECH"}));
		cb1.setBounds(209, 151, 166, 22);
		frame.getContentPane().add(cb1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = tb1.getText();
				String rollno = tb2.getText();
				String branch = (String) cb1.getSelectedItem();
				String Mobno = (String) cb2.getSelectedItem() + (String) tb3.getText();
				
				String gender = " ";
				String languages = " ";
				int value = (Integer) year_val.getValue();
			
				if(r1.isSelected()) {
					gender = "Female";
				}else if (r2.isSelected()) {
					gender = "Male";
				}else {
					gender = "Other";
				}
				if(cbox1.isSelected()) {
					languages += " C";
				}
				if(cbox2.isSelected()) {
					languages += " Python";
				}
				if(cbox3.isSelected()) {
					languages += " Java";
				}
				
				JOptionPane.showMessageDialog(btnNewButton, "Welcome ! " +name+ " Your details are as follows \n Roll No : "+rollno+"\n Gender : "
						+ ""+gender+
						"\n Branch : "+branch+ "\n Mobile Number :" +Mobno+ "\n Year :"+value+"\n Programming Langugaes :"+languages);
			}
		});
		btnNewButton.setBounds(167, 297, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Year");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(122, 231, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Programming Languages");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(26, 266, 142, 20);
		frame.getContentPane().add(lblNewLabel_8);
		
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\online lab\\Pictures\\Saved Pictures\\BG4.jpg"));
		lblNewLabel_9.setBounds(0, 0, 434, 339);
		frame.getContentPane().add(lblNewLabel_9);
	}
}
