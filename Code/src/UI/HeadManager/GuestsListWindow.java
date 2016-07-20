package UI.HeadManager;

import java.awt.*;
import javax.swing.*;
import ResourceManagement.User;

public class GuestsListWindow extends UI.Employee.UserWindow {

	private JButton searchButton;
	private JTextField searchTextField;
	private JLabel label;

	public GuestsListWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");
		// Rectangle r = new Rectangle(0, 0, 100, 100);
		// super.panel.add(r);

		createLabel("فهرست حساب های کاربری تایید نشده", 500, 90 - 50);

		searchTextField = new JTextField();
		searchTextField.setSize(300, 25);
		searchTextField.setLocation(250, 150);
		super.panel.add(searchTextField);

		searchButton = new JButton("جستجو");
		searchButton.setSize(65, 25);
		searchButton.setLocation(200, 150);
		super.panel.add(searchButton);

		createLabel("حساب کاربری یک", 510, 150 + 30);
		createLabel("حساب کاربری دو", 510, 150 + 60);
		createLabel("حساب کاربری سه", 510, 150 + 90);
		createLabel("حساب کاربری چهار", 510, 150 + 120);
		createbutton("مشاهده و ویرایش", 290, 150 + 30, 110);
		createbutton("مشاهده و ویرایش", 290, 150 + 60, 110);
		createbutton("مشاهده و ویرایش", 290, 150 + 90, 110);
		createbutton("مشاهده و ویرایش", 290, 150 + 120, 110);
		createbutton("حذف", 110 + 40, 150 + 30, 60);
		createbutton("حذف", 110 + 40, 150 + 60, 60);
		createbutton("حذف", 110 + 40, 150 + 90, 60);
		createbutton("حذف", 110 + 40, 150 + 120, 60);
		createbutton("تایید", 180 + 40, 150 + 30, 60);
		createbutton("تایید", 180 + 40, 150 + 60, 60);
		createbutton("تایید", 180 + 40, 150 + 90, 60);
		createbutton("تایید", 180 + 40, 150 + 120, 60);
	}

	public void editUserProfile(User user) {
	}

	public void acceptAccount(User user) {

	}

	public void deleteAccount(User user) {

	}

	public void search() {
	}

	private void createLabel(String s, int x, int y) {
		JLabel t = new JLabel(s);
		t.setSize(250, 25);
		t.setLocation(x, y + 50);
		panel.add(t);
		// return t;
	}

	private JButton createbutton(String s, int x, int y, int size) {
		JButton t = new JButton(s);
		t.setSize(size, 20);
		t.setLocation(x + 30, y + 50);
		panel.add(t);
		return t;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

	}

}