package UI.Accounting;

import java.awt.*;
import javax.swing.*;

public class LoginWindow  extends JFrame{

	
	private JButton loginButton;
	private JButton cancelButton;
	private JButton retrieveButton;
	private JPanel panel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	public LoginWindow(){
		//setLayout(null);
		setTitle("ورود");
		setSize(400,200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);
	//	setResizable(false);
		
		usernameTextField = new JTextField();
		usernameTextField.setSize(120, 25);
		usernameTextField.setLocation(100,10);
		panel.add(usernameTextField);
		
		usernameLabel = new JLabel("نام کاربری:");
		usernameLabel.setSize(60, 25);
		usernameLabel.setLocation(230,10);
		panel.add(usernameLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setSize(120, 25);
		passwordTextField.setLocation(100,40);
		panel.add(passwordTextField); 
		
		passwordLabel = new JLabel("کلمه عبور:");
		passwordLabel.setSize(60, 25);
		passwordLabel.setLocation(230,40);
		panel.add(passwordLabel);
		
		loginButton = new JButton("ورود");
		loginButton.setSize(80, 25);
		loginButton.setLocation(100,70);
		panel.add(loginButton);
		
		cancelButton = new JButton("انصراف");
		cancelButton.setSize(80, 25);
		cancelButton.setLocation(200,70);
		panel.add(cancelButton);
		
		retrieveButton = new JButton("بازیابی نام کاربری و کلمه عبور");
		retrieveButton.setSize(180, 25);
		retrieveButton.setLocation(100,115);
		panel.add(retrieveButton);
	
	
	}
	
	
	private void login(){
		
	}
	
	private void cancel(){
		
	}
	
    private void forgetPassword(){
		
	}
}