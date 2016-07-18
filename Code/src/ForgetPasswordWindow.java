
import java.awt.*;
import javax.swing.*;

public class ForgetPasswordWindow  extends JFrame{

	
	private JButton sendEmailButton;
	private JButton returnButton;
	private JPanel panel;
	private JTextField mailTextField;
	private JLabel currentPasswordLabel;
	
	
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
		panel.add(sendEmailButton);
		
		returnButton = new JButton("بازگشت");
		returnButton.setSize(80, 25);
		returnButton.setLocation(100,85);
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
