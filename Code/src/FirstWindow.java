import javax.swing.*;

public class FirstWindow extends JFrame{

	
	private JButton loginButton;
	private JButton registerButton;
	private JPanel panel;
	
	public FirstWindow(){
		setBounds(400, 200,1500, 1250);
		panel = new JPanel();
		add(panel);
		setVisible(true);
		
		loginButton = new JButton("login");
		loginButton.setBounds(	0, 0, 80, 25);
		panel.add(loginButton);
		
		registerButton = new JButton("register");
		registerButton.setBounds(10, 20, 80,25);
		panel.add(registerButton);
	}
	
	
	private void login(){
		
	}
	
	private void register(){
		
	}
}
