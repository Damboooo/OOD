package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Savepoint;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ProjectManagement.Project;
import ResourceManagement.User;
import ResourceManagement.UserCatalogue;

public class NewProjectWindow extends UI.Employee.UserWindow {

	private ArrayList<User> users;
	private JTextField humanResourcesTextField;
	private JTextField userCountTextField;
	private JTextField moduleCountTextField;
	private JTextField technologiesTextField;
	private JTextField developementsCostsTextField;
	private JTextField maintainanceCostsTextField;
	private JTextField projectNameTextField;
	private JTextField physicalResourcesTextField;
	private JButton saveButton;
	private JComboBox<String> typeComboBox = new JComboBox<String>();

	// private JPanel panel;

	public NewProjectWindow(final User user) {
		super(user);
		setTitle("پنل مدیریت پروژه");

		users = UserCatalogue.getInstance().getUserAccountList();

		createLabel("مدیریت پروژه جدید", 560, 90);
		createLabel("اطلاعات تجمیعی پروژه جدید", 230, 90);
		createLabel("تعداد نیروی انسانی ایجاد کننده:", 220, 180 + 35 * 0);
		createLabel("تعداد کاربران:", 220, 180 + 35 * 1);
		createLabel("تعداد ماژول ها:", 220, 180 + 35 * 2);
		createLabel("تکنولوژی مورد استفاده:", 220, 180 + 35 * 3);

		createLabel("هزینه ایجاد:", 220, 180 + 35 * 4);
		createLabel("هزینه نگهداری:", 220, 180 + 35 * 5);
		createLabel("منابع فیزیکی:", 220, 180 + 35 * 6);

		createLabel("نام پروژه:", 570, 180 + 35 * 0);
		createLabel("مدیر پروژه:", 570, 180 + 35 * 1);

		for (int i = 0; i < users.size(); i++) {
			typeComboBox.addItem(users.get(i).getFirstName() + " "
					+ users.get(i).getLastName());
		}
		panel.add(typeComboBox);
		typeComboBox.setSelectedIndex(0);
		typeComboBox.setBounds(430, 180 + 35, 110, 20);

		projectNameTextField = createTextField("", 430, 180);

		saveButton = new JButton("تخصیص منبع");
		saveButton.setSize(100, 25);
		saveButton.setLocation(440, 180 + 80);
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new AddProjectResourcesWindow(user);
			}
		});
		panel.add(saveButton);

		humanResourcesTextField = createTextField("28", 100, 180 + 35 * 0);
		userCountTextField = createTextField("100-250", 100, 180 + 35 * 1);
		moduleCountTextField = createTextField("16", 100, 180 + 35 * 2);
		technologiesTextField = createTextField("Django-MySQL-Html/CSS", 100,
				180 + 35 * 3);
		developementsCostsTextField = createTextField("یک میلیارد تومان", 100,
				180 + 35 * 4);
		maintainanceCostsTextField = createTextField("-", 100, 180 + 35 * 5);
		physicalResourcesTextField = createTextField("سرور - دیتابیس", 100,
				180 + 35 * 6);

		saveButton = new JButton("ثبت پروژه");
		saveButton.setSize(80, 25);
		saveButton.setLocation(100, 520);
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				saveProject();
			}
		});
		panel.add(saveButton);

	}

	private void createLabel(String s, int x, int y) {
		JLabel t = new JLabel(s);
		t.setSize(120, 25);
		t.setLocation(x, y);
		panel.add(t);
		// return t;
	}

	private JTextField createTextField(String s, int x, int y) {
		JTextField t = new JTextField(s);
		t.setSize(110, 25);
		t.setLocation(x, y);
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
		g2.drawRect(85, 150, 285, 370);
		g2.drawRect(380, 150, 285, 370);

	}

	public boolean saveProject() {
		Project project = new Project();
		project.setName(projectNameTextField.getText());
		project.setNumberOfUsers(Integer.parseInt(userCountTextField.getText()));
		project.setProjectManager(users.get(typeComboBox.getSelectedIndex()));
		return false;
	}
}
