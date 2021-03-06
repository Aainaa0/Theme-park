import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.validator.ViewSchedule;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;

	public Homepage(JFrame frame,String customerID ,String name) {
		super("Theme Park Scheduler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnView = new JButton("View Schedule");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewSchedule v = new ViewSchedule(frame, customerID, name);
				v.setLocationRelativeTo(null);
				v.setVisible(true);
			}
		});
		btnView.setBounds(72, 111, 222, 31);
		contentPane.add(btnView);
		
		JButton btnCreate = new JButton("Create Schedule");
		getRootPane().setDefaultButton(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateSchedule c = new CreateSchedule(frame, customerID, name);
				c.setLocationRelativeTo(null);
				c.setVisible(true);
			}
		});
		btnCreate.setBounds(72, 48, 222, 31);
		contentPane.add(btnCreate);
	}

}
