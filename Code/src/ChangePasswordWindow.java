

import java.awt.*;
import javax.swing.*;

public class ChangePasswordWindow  extends JFrame{

	
	private JButton acceptButton;
	private JButton cancelButton;
	private JPanel panel;
	private JPasswordField currentPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPasswordField newPasswordRepeatTextField;
	private JLabel currentPasswordLabel;
	private JLabel newPasswordLabel;
	private JLabel newPasswordRepeatLabel;
	
	public ChangePasswordWindow(){
		//setLayout(null);
		setTitle("تغییر کلمه عبور");
		setSize(400,200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);

	
		currentPasswordLabel = createLabel("کلمه عبور قبلی:", 230, 10);
		currentPasswordTextField = createPasswordField(100, 10);
		
		newPasswordLabel = createLabel("کلمه عبور جدید:", 230, 40);
		newPasswordTextField = createPasswordField(100,40);
		
		newPasswordRepeatLabel = createLabel("تکرار کلمه عبور: ", 230, 70);
		newPasswordRepeatTextField = createPasswordField(100,70);

		
		acceptButton = new JButton("ورود");
		acceptButton.setSize(80, 25);
		acceptButton.setLocation(200,115);
		panel.add(acceptButton);
		
		cancelButton = new JButton("انصراف");
		cancelButton.setSize(80, 25);
		cancelButton.setLocation(100,115);
		panel.add(cancelButton);
	
	
	}
	
	private JLabel createLabel(String s , int x , int y){
		JLabel label = new JLabel(s);
		label.setSize(80,25);
		label.setLocation(x,y);
		panel.add(label);
		return label;
	}
   private JPasswordField createPasswordField(int x , int y){
		JPasswordField t = new JPasswordField();
		t.setSize(120,25);
		t.setLocation(x,y);
		panel.add(t);
		return t;
	}
	

}
