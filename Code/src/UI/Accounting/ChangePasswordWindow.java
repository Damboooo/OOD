package UI.Accounting;

import MainPackage.Main;
import ResourceManagement.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ChangePasswordWindow extends JFrame {

	private JButton acceptButton;
	private JButton cancelButton;
	private JPanel panel;
	private JPasswordField currentPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPasswordField newPasswordRepeatTextField;
	private JLabel currentPasswordLabel;
	private JLabel newPasswordLabel;
	private JLabel newPasswordRepeatLabel;
	private JLabel errorLabel;

	public ChangePasswordWindow(final User user) {
		// setLayout(null);
		setTitle("تغییر کلمه عبور");
		setSize(400, 200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);

		currentPasswordLabel = createLabel("کلمه عبور قبلی:", 230, 10);
		currentPasswordTextField = createPasswordField(100, 10);

		newPasswordLabel = createLabel("کلمه عبور جدید:", 230, 40);
		newPasswordTextField = createPasswordField(100, 40);

		newPasswordRepeatLabel = createLabel("تکرار کلمه عبور: ", 230, 70);
		newPasswordRepeatTextField = createPasswordField(100, 70);

		errorLabel = createLabel("", 130, 90);
		errorLabel.setSize(180, 25);
		
		acceptButton = new JButton("تایید");
		acceptButton.setSize(80, 25);
		acceptButton.setLocation(200, 115);
		acceptButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				confirm(user);
			}
		});
		panel.add(acceptButton);

		cancelButton = new JButton("انصراف");
		cancelButton.setSize(80, 25);
		cancelButton.setLocation(100, 115);
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cancel(user);
			}
		});
		panel.add(cancelButton);

	}

	private JLabel createLabel(String s, int x, int y) {
		JLabel label = new JLabel(s);
		label.setSize(80, 25);
		label.setLocation(x, y);
		panel.add(label);
		return label;
	}

	private JPasswordField createPasswordField(int x, int y) {
		JPasswordField t = new JPasswordField();
		t.setSize(120, 25);
		t.setLocation(x, y);
		panel.add(t);
		return t;
	}

	public boolean confirm(User user) {
		// display/center the jdialog when the button is pressed
		if (user.getPassword().equals(
				currentPasswordTextField.getPassword().toString())) {
			if (!newPasswordTextField.getPassword().equals(
					newPasswordRepeatTextField.getPassword())) {
				System.out.println("تکرار کلمه عبور جدید را مجددا وارد کنید!");
				errorLabel.setText("تکرار کلمه عبور جدید را مجددا وارد کنید!");
				return false;
			}
			user.setPassword(newPasswordTextField.getPassword().toString());
			Main.dbManager.updateUser(user.getId(),user);
			ProfileWindow cp = new ProfileWindow(user);
			dispose();
			return true;
		}
		System.out.println("کلمه عبور قبلی نادرست است!");
		errorLabel.setText("کلمه عبور قبلی نادرست است!");
		return false;
	}

	public void cancel(User user) {
		// display/center the jdialog when the button is pressed
		ProfileWindow cp = new ProfileWindow(user);
		dispose();

	}
}
