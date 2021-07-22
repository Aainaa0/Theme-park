import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import controller.validator.InvalidNumberException;
import controller.validator.MaximumDateException;
import controller.validator.MinimumNumberException;
import controller.validator.PasswordMatchException;
import controller.validator.RequiredFieldException;
import controller.validator.UsernameUniqueException;
import controller.validator.Validator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;

public class Register extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textWeight;
	private JTextField textHeight;
	private JTextField textName;
	private String custGender;
	private int day;
	private int month;
	private int year;
	private String date;
	private Date mydate;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField textUsername;

	public Register(JFrame frame) {
		super(frame, "Theme Park Trip Scheduler", true);
		setResizable(false);
		setBounds(100, 100, 677, 337);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setBounds(61, 21, 149, 14);
		getContentPane().add(lblUsername);

		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(61, 49, 149, 14);
		getContentPane().add(lblName);

		JLabel lblDob = new JLabel("Date of Birth:");
		lblDob.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDob.setBounds(30, 80, 180, 14);
		getContentPane().add(lblDob);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setBounds(61, 111, 149, 14);
		getContentPane().add(lblGender);

		JLabel lblHeight = new JLabel("Height (cm):");
		lblHeight.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeight.setBounds(61, 142, 149, 14);
		getContentPane().add(lblHeight);

		JLabel lblWeight = new JLabel("Weigth (kg):");
		lblWeight.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWeight.setBounds(61, 173, 149, 14);
		getContentPane().add(lblWeight);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmPassword.setBounds(61, 236, 149, 14);
		getContentPane().add(lblConfirmPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(61, 204, 149, 14);
		getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(220, 18, 280, 20);
		getContentPane().add(textUsername);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(220, 46, 280, 20);
		getContentPane().add(textName);

		JComboBox<String> boxGender = new JComboBox<String>();
		boxGender.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				custGender = (String) boxGender.getSelectedItem();
				custGender = custGender.substring(0);
				System.out.println(custGender);				
			}
		});
		boxGender.setBounds(220, 108, 280, 20);
		getContentPane().add(boxGender);
		boxGender.addItem("Male");
		boxGender.addItem("Female");

		textHeight = new JTextField();
		textHeight.setColumns(10);
		textHeight.setBounds(220, 139, 280, 20);
		getContentPane().add(textHeight);

		textWeight = new JTextField();
		textWeight.setColumns(10);
		textWeight.setBounds(220, 170, 280, 20);
		getContentPane().add(textWeight);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(220, 80, 39, 14);
		getContentPane().add(lblDay);

		JComboBox<Integer> boxDay = new JComboBox<Integer>();
		boxDay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				day = (int) boxDay.getSelectedItem();
				System.out.println("Day: "+day);	
			}
		});
		boxDay.setBounds(251, 77, 41, 20);
		getContentPane().add(boxDay);

		for(int i=1; i<32; i++)
		{
			boxDay.addItem(i);
		}

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(302, 80, 39, 14);
		getContentPane().add(lblMonth);

		JComboBox<Integer> boxMonth = new JComboBox<Integer>();
		boxMonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				month = (int) boxMonth.getSelectedItem();
				System.out.println("Month: "+month);	
			}
		});
		boxMonth.setBounds(351, 77, 41, 20);
		getContentPane().add(boxMonth);
		for(int i=1; i<13; i++)
		{
			boxMonth.addItem(i);
		}

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(402, 80, 39, 14);
		getContentPane().add(lblYear);

		JComboBox<Integer> boxYear = new JComboBox<Integer>();
		boxYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				year = (int) boxYear.getSelectedItem();
				System.out.println("Year: "+year);	
			}
		});
		boxYear.setBounds(435, 77, 65, 20);
		getContentPane().add(boxYear);
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int i=1910; i<=currYear; i++)
		{
			boxYear.addItem(i);
		}

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Vector <Exception> exceptions = new Vector<Exception>();

				try {

					Validator.validateUsername("Username",textUsername.getText(),true, true);

				} catch (RequiredFieldException | UsernameUniqueException e) {
					exceptions.add(e);
				}
				
				try {

					Validator.validate("Name",textName.getText(),true);

				} catch (RequiredFieldException e) {
					exceptions.add(e);
				}
				
				date = year+"-"+month+"-"+day;
				System.out.println(date);

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				Date startDate;
				String newDateString = null;			

				try {
					startDate = (Date) df.parse(date);
					newDateString = df.format(startDate);
					try {
						Validator.validateDate("Date of birth", startDate, true);
					} catch (MaximumDateException e) {
						exceptions.add(e);		
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				try 
				{
					Validator.validate("Height", textHeight.getText(), true, true, 1);
				} catch (RequiredFieldException | InvalidNumberException | MinimumNumberException e) 
				{
					exceptions.add(e);
				}

				try 
				{
					Validator.validate("Weight", textWeight.getText(), true, true, 1);
				} catch (RequiredFieldException | InvalidNumberException | MinimumNumberException e) 
				{
					exceptions.add(e);
				}
				
				try 
				{
					Validator.validate("Password", passwordField.getText(), true);
				} catch (RequiredFieldException e) 
				{
					exceptions.add(e);
				}
				
				try 
				{
					Validator.validatePassword("Confirm password", passwordField.getText(), confirmPasswordField.getText(), true, true);
				} catch (RequiredFieldException | PasswordMatchException  e) 
				{
					exceptions.add(e);
				}

				int size = exceptions.size();
				if(size == 0) {

					try {
						theQuery("insert into customer (CustomerName,Username, Password, DateOfBirth , Gender, Weight, Height) values('" + textName.getText()
						+ "','"+textUsername.getText()+"','"+passwordField.getText()+"','"+newDateString+"','"+custGender+"','"+textWeight.getText()+"','"+textHeight.getText()+"')");
						
						dispose();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Something wrong with the query","Validation error",JOptionPane.WARNING_MESSAGE);
					}

				}
				else 
				{
					String message = null;

					if(size ==1)
					{
						message = exceptions.firstElement().getMessage();
						JOptionPane.showMessageDialog(frame, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}

					else {
						message = "Please fix the following errors:";
						for (int i = 0; i < size; i++) {
							message += "\n"+ (i+1) + "." +exceptions.get(i).getMessage();
						}
						JOptionPane.showMessageDialog(frame, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}
				}


			}
		});

		btnRegister.setBounds(206, 264, 89, 23);
		getContentPane().add(btnRegister);

		JButton btnReturn = new JButton("Back to Main Page");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnReturn.setBounds(319, 264, 149, 23);
		getContentPane().add(btnReturn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 201, 280, 20);
		getContentPane().add(passwordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(220, 233, 280, 20);
		getContentPane().add(confirmPasswordField);

	}

	public void theQuery(String query) {
		Connection con = null;
		Statement st = null;
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theme park", "root", "");
			st = (Statement) con.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Registration completed successfully");
		} catch (Exception ex) {
			//			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
