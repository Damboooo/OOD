package UI.ProjectManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ResourceManagement.User;

public class UserWindow extends JFrame {
	protected User user;
	private JButton userProfileButton;
	private JButton logoutButton;
	private JButton returnButton;
	protected JPanel panel;

	public UserWindow(User user) {
		setBounds(300, 100, 800, 600);
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		setVisible(true);

		userProfileButton = new JButton("مدیریت صفحه شخصی");
		logoutButton = new JButton("خروچ");
		returnButton = new JButton("بازگشت");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				dispose();
			}
		});
		userProfileButton.setBounds(100, 10, 180, 25);
		panel.add(userProfileButton);
		logoutButton.setBounds(10, 10, 80, 25);
		panel.add(logoutButton);
		returnButton.setBounds(10, 520, 80, 25);
		panel.add(returnButton);

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		g2.drawLine(0, 70, 800, 70);
		g2.drawLine(0, 72, 800, 72);
	}

	private void userProfileView(User user) {

	}

	private void logout(User user) {

	}

	// return in Class Diagram
	private void returnBack() {

	}
}
