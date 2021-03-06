package controller.validator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.calculation.PriceCalculator;

import javax.swing.JLabel;

public class ViewSchedule extends JDialog {

	private double totalPrice;
	public ViewSchedule(JFrame frame, String customerID, String name) {
		super(frame, "Theme Park Trip Scheduler", true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		totalPrice = PriceCalculator.calculateTotalPrice(customerID);

		JLabel lblLabel = new JLabel("Hi "+name+", The total price is RM "+totalPrice+".");
		lblLabel.setBounds(10, 11, 402, 22);
		getContentPane().add(lblLabel);

	}

}
