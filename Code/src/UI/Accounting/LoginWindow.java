package UI.Accounting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ResourceManagement.User;
import UI.Employee.EmployeeMainWindow;
import UI.HeadManager.HeadManagerMainWindow;
import UI.HeadManager.ProjectsListWindow;
import DB.DBManager;
import MainPackage.Main;

public class LoginWindow extends JFrame {

	private JButton loginButton;
	private JButton cancelButton;
	private JButton retrieveButton;
	private JPanel panel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JLabel errorLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;

	public LoginWindow() {
		// setLayout(null);
		setTitle("ورود");
		setSize(400, 200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setVisible(true);
		// setResizable(false);
		errorLabel = new JLabel();
		errorLabel.setSize(60, 15);
		errorLabel.setLocation(230, 10);
		panel.add(errorLabel);

		usernameTextField = new JTextField();
		usernameTextField.setSize(120, 25);
		usernameTextField.setLocation(100, 10);
		panel.add(usernameTextField);

		usernameLabel = new JLabel("نام کاربری:");
		usernameLabel.setSize(60, 25);
		usernameLabel.setLocation(230, 10);
		panel.add(usernameLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setSize(120, 25);
		passwordTextField.setLocation(100, 40);
		panel.add(passwordTextField);

		passwordLabel = new JLabel("کلمه عبور:");
		passwordLabel.setSize(60, 25);
		passwordLabel.setLocation(230, 40);
		panel.add(passwordLabel);

		loginButton = new JButton("ورود");
		loginButton.setSize(80, 25);
		loginButton.setLocation(100, 70);
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		panel.add(loginButton);

		cancelButton = new JButton("انصراف");
		cancelButton.setSize(80, 25);
		cancelButton.setLocation(200, 70);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		panel.add(cancelButton);

		retrieveButton = new JButton("بازیابی نام کاربری و کلمه عبور");
		retrieveButton.setSize(180, 25);
		retrieveButton.setLocation(100, 115);
		retrieveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgetPassword();
			}
		});
		panel.add(retrieveButton);

	}

	private void login() {

		ProjectsListWindow pl;
		HeadManagerMainWindow hm;
		EmployeeMainWindow em;
		User user = Main.dbManager.getUserByUsername(usernameTextField
				.getText());
		if (user == null) {
			errorLabel.setText("این نام در سیستم موجود نمی باشد");
		} else {
			System.out.println(passwordTextField.getText()+"-");
			System.out.println(user.getPassword()+"-");
			if (user.getPassword().equals(
					passwordTextField.getText())) {
				switch (user.getRole()) {
				case "مدیر":
					pl = new ProjectsListWindow(user);
					break;
				case "مدیرکل":
					hm = new HeadManagerMainWindow(user);
					break;
				case "کارمند":
					em = new EmployeeMainWindow(user);
					break;
				}
			} else {
				System.out.println("Wrong password!");
			}
		}
		// User user = new User();
		// user.setUsername(usernameTextField.getText());
		// // display/center the jdialog when the button is pressed
		// if (usernameTextField.getText().toCharArray().length == 0)
		// return;
		// if (usernameTextField.getText().toCharArray()[0] == 'm')
		// pl = new ProjectListWindow(user);
		// else if (usernameTextField.getText().toCharArray()[0] == 'h')
		// hm = new HeadManagerMainWindow(user);
		// else
		// em = new EmployeeMainWindow(user);
		dispose();
	}

	private void cancel() {
		// display/center the jdialog when the button is pressed
		FirstWindow rw = new FirstWindow();
		dispose();
	}

	private void forgetPassword() {
		// display/center the jdialog when the button is pressed
		ForgetPasswordWindow fp = new ForgetPasswordWindow();
		dispose();
	}
}
