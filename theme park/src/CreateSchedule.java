import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CreateSchedule extends JDialog {

	public CreateSchedule(JFrame frame, String customerID, String name) {
		super(frame, "Theme Park Trip Scheduler", true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 316);
		getContentPane().setLayout(null);

		ArrayList<String> array = new<String> ArrayList<String>();
		try {

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theme park","root","");
			st = (Statement) con.createStatement();
			String s = "select AttributeID, Description from attribute";
			rs = (ResultSet) st.executeQuery(s);

			while(rs.next())
			{
				array.add(rs.getString(1)+" - "+rs.getString(2));
			}

		} catch (Exception e) {

		}

		JList<String> list = new JList(array.toArray());
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setBounds(20, 53, 404, 177);
		getContentPane().add(list);

		JButton btnSubmit = new JButton("Submit");
		getRootPane().setDefaultButton(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> s = list.getSelectedValuesList();
				System.out.println("Value Selected: " + s);
				System.out.println(s.size());
				if(s.size()==0)
				{
					JOptionPane.showMessageDialog(frame, "Please select minimum 1 attribute.","Validation error",JOptionPane.WARNING_MESSAGE);
				}
				else if(s.size()>0)
				{
					dispose();
					SelectAttraction sa = new SelectAttraction(frame, customerID, name, s);
					sa.setLocationRelativeTo(null);
					sa.setVisible(true);        	
				}
			}
		});
		btnSubmit.setBounds(104, 248, 89, 23);
		getContentPane().add(btnSubmit);

		JButton btnReturn = new JButton("Back to Main Page");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnReturn.setBounds(217, 248, 149, 23);
		getContentPane().add(btnReturn);

		JLabel lblLabel = new JLabel("Hi "+name+", please select your preferred attributes:");
		lblLabel.setBounds(20, 11, 381, 14);
		getContentPane().add(lblLabel);

		JLabel lblLabel2 = new JLabel("*To select multiple attribute (ctrl + right click)");
		lblLabel2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLabel2.setBounds(20, 28, 371, 14);
		getContentPane().add(lblLabel2);

	}
}
