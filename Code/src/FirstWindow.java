import java.awt.*;
import javax.swing.*;

public class FirstWindow extends JFrame{

	
	private JButton loginButton;
	private JButton registerButton;
	private JPanel panel;
	
	public FirstWindow(){
		//setLayout(null);
		setTitle("خوش آمدید");
		setSize(400,200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);
		
		loginButton = new JButton("ورود");
		loginButton.setSize(80, 25);
		loginButton.setLocation(150,50);
		panel.add(loginButton);
		
		registerButton = new JButton("ثبت نام");
		registerButton.setSize(80,25);
		registerButton.setLocation(150,85);
		panel.add(registerButton);
		
	
	}
	
	
	private void login(){
		
	}
	
	private void register(){
		
	}
}
