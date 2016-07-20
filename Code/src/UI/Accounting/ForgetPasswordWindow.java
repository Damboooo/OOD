package UI.Accounting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.control.Alert;

import javax.swing.*;

public class ForgetPasswordWindow  extends JFrame{

	
	private JButton sendEmailButton;
	private JButton returnButton;
	private JPanel panel;
	private JTextField mailTextField;
	private JLabel currentPasswordLabel;
	private JLabel alertLabel;
	
	
	public ForgetPasswordWindow(){
		//setLayout(null);
		setTitle("بازیابی نام کاربری و کلمه عبور");
		setSize(400,200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);

	

		
		sendEmailButton = new JButton("ارسال ایمیل");
		sendEmailButton.setSize(80, 25);
		sendEmailButton.setLocation(200,85);
		sendEmailButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				alertLabel = new JLabel("نام کاربری و کلمه عبور به ایمیل شما ارسال شد!");
				alertLabel.setSize(280,25);
				alertLabel.setLocation(100,55);
				panel.add(alertLabel);
			}
		});
		panel.add(sendEmailButton);
		
		returnButton = new JButton("بازگشت");
		returnButton.setSize(80, 25);
		returnButton.setLocation(100,85);
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				LoginWindow lw = new LoginWindow();
				dispose();
			}
		});
		panel.add(returnButton);
	
		mailTextField = new JTextField();
		mailTextField.setSize(120,25);
		mailTextField.setLocation(100,25);
		panel.add(mailTextField);
	
 	currentPasswordLabel = new JLabel("ایمیل:");
 	currentPasswordLabel.setSize(80,25);
 	currentPasswordLabel.setLocation(250,25);
		panel.add(currentPasswordLabel);
	
	}
	

	
	

}
