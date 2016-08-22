package UI.HeadManager;

import MainPackage.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.*;
import ResourceManagement.User;
import ResourceManagement.UserCatalogue;
import UI.Accounting.EditProfileWindow;

public class AccountsListWindow extends UI.Employee.UserWindow {

	private ArrayList<User> users;
	private int counter;
	private JButton searchButton;
	private JTextField searchTextField;
	private JLabel label;

	public AccountsListWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");
		// Rectangle r = new Rectangle(0, 0, 100, 100);
		// super.panel.add(r);

		createLabel("فهرست حساب های کاربری", 560, 90 - 50);

		searchTextField = new JTextField();
		searchTextField.setSize(300, 25);
		searchTextField.setLocation(250, 150);
		super.panel.add(searchTextField);

		searchButton = new JButton("جستجو");
		searchButton.setSize(65, 25);
		searchButton.setLocation(200, 150);
		super.panel.add(searchButton);

		users = UserCatalogue.getInstance().getUserAccountList();

		for (counter = 0; counter < users.size(); counter++) {
			createLabel(users.get(counter).getUsername(), 510,
					150 + 30 * (counter + 1));
			JButton show = createbutton("مشاهده و ویرایش", 290,
					150 + 30 * (counter + 1), 110);
			show.addActionListener(new ActionListener() {
				User u = users.get(counter);

				public void actionPerformed(ActionEvent e) {
					editUserProfile(u);
				}
			});
			JButton remove = createbutton("حذف", 180 + 20, 150 + 30 * (counter + 1), 70);
			remove.addActionListener(new ActionListener() {
				User u = users.get(counter);

				public void actionPerformed(ActionEvent e) {
					deleteAccount(u);
				}
			});
		}

		// createbutton("مشاهده و ویرایش", 290, 150 + 30, 110);
		// createbutton("مشاهده و ویرایش", 290, 150 + 60, 110);
		// createbutton("مشاهده و ویرایش", 290, 150 + 90, 110);
		// createbutton("مشاهده و ویرایش", 290, 150 + 120, 110);
		// createbutton("حذف", 180 + 20, 150 + 30, 70);
		// createbutton("حذف", 180 + 20, 150 + 60, 70);
		// createbutton("حذف", 180 + 20, 150 + 90, 70);
		// createbutton("حذف", 180 + 20, 150 + 120, 70);

	}

	private void createLabel(String s, int x, int y) {
		JLabel t = new JLabel(s);
		t.setSize(200, 25);
		t.setLocation(x, y + 50);
		panel.add(t);
		// return t;
	}

	private JButton createbutton(String s, int x, int y, int size) {
		JButton t = new JButton(s);
		t.setSize(size, 20);
		t.setLocation(x, y + 50);
		panel.add(t);
		return t;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

	}

	public void editUserProfile(User user) {
		new EditProfileWindow(user, 1);
	}

	public void deleteAccount(User user) {
		UserCatalogue.getInstance().deleteUser(user);
	}

	public void search() {

	}

}
