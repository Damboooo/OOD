
import java.awt.*;
import javax.swing.*;

public class LoginWindow  extends JFrame{

	
	private JButton loginButton;
	private JButton cancelButton;
	private JButton retrieveButton;
	private JPanel panel;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	public LoginWindow(){
		//setLayout(null);
		setTitle("ورود");
		setSize(400,200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);
		
		usernameTextField = new JTextField("نام کاربری");
		usernameTextField.setSize(120, 25);
		usernameTextField.setLocation(150,40);
		panel.add(usernameTextField);
		
		passwordTextField = new JTextField("کلمه عبور");
		passwordTextField.setSize(120, 25);
		passwordTextField.setLocation(150,70);
		panel.add(passwordTextField);
		
		loginButton = new JButton("ورود");
		loginButton.setSize(80, 25);
		loginButton.setLocation(150,100);
		panel.add(loginButton);
		
		cancelButton = new JButton("انصراف");
		cancelButton.setSize(80, 25);
		cancelButton.setLocation(250,100);
		panel.add(cancelButton);
		
		retrieveButton = new JButton("بازیابی نام کاربری و کلمه عبور");
		retrieveButton.setSize(180, 25);
		retrieveButton.setLocation(150,130);
		panel.add(retrieveButton);
		
		
		
	
	}
	
	
	private void login(){
		
	}
	
	private void cancel(){
		
	}
	
    private void forgetPassword(){
		
	}
}
