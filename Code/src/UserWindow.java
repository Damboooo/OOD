import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserWindow extends JFrame {
	User user;
	private JButton userProfileButton;
	private JButton logoutButton;
	private JButton returnButton;
	private JPanel panel;

	public UserWindow(User user) {
		setBounds(300, 100, 800, 600);
		panel = new JPanel();
		add(panel);
		setVisible(true);
		userProfileButton = new JButton("مدیریت صفحه شخصی");
		logoutButton = new JButton("خروج");
		returnButton = new JButton("بازگشت");
		userProfileButton.setBounds(100, 10, 180, 25);
	    panel.add(userProfileButton);
	    logoutButton.setBounds(10, 10, 80, 25);
	    panel.add(logoutButton);
	    returnButton.setBounds(10,520, 80, 25);
	    panel.add(returnButton);
		
	}
	private void userProfileView(User user) {

	}
	private void logout(User user) {

	}
	// return in Class Diagram
	private void returnBack() {

	}
}
