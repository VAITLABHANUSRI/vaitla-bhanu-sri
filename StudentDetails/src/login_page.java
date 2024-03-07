import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login_page {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page window = new login_page();
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
	public login_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(126, 97, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tb1 = new JTextField();
		tb1.setBounds(224, 94, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASS WORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(98, 143, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("LOGIN PAGE");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewJgoodiesTitle.setBounds(162, 11, 148, 14);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb1.getText();
				String password=p1.getText();
				try {
					java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mrec");
					PreparedStatement stn=con.prepareStatement("select name , password from users where name=? and password=?");
					stn.setString(1,name);
					stn.setString(2,password);
					ResultSet rs=stn.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "valid user");
						
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "invalid user");
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(172, 203, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		p1 = new JPasswordField();
		p1.setBounds(224, 141, 86, 20);
		frame.getContentPane().add(p1);
	}
}
