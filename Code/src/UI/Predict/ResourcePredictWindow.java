package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.*;

import ProjectManagement.Module;
import ResourceManagement.User;

public class ResourcePredictWindow extends UserWindow {

	private JLabel alertLabel;
	private JLabel sizeLabel;
	private JLabel techLabel;
	private JButton predictButton;
	private JButton addTechnologyButton;
	private JLabel moduleNameLabel;
	private JLabel[] modulesNameLabel = new JLabel[100];
	private JTextField humanResourceRangeFromTextField;
	private JTextField humanResourceRangeToTextField;
	private JTextField usersRangeFromTextField;
	private JTextField usersRangeToTextField;
	private JTextField modulesRangeFromTextField;
	private JTextField modulesRangeToTextField;
	private JTextField technologyTextField;

	// private JPanel panel;

	public ResourcePredictWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");

		createLabel("پیش بینی منبع", 580, 90);

		// changeNameTextField = new JTextField();
		// changeNameTextField.setSize(350,25);
		// changeNameTextField.setLocation(200,160+40);
		// panel.add(changeNameTextField);

		alertLabel = new JLabel(
				"در صورت نیاز فیلدها را خالی بگذارید تا شامل همه مقادیر شود!");
		alertLabel.setSize(280, 25);
		alertLabel.setLocation(250, 130);
		super.panel.add(alertLabel);

		sizeLabel = new JLabel("سایز پروژه");
		sizeLabel.setSize(120, 25);
		sizeLabel.setLocation(580, 170);
		super.panel.add(sizeLabel);

		createLabel("تعداد سازندگان", 500, 10 + 40 * 4);
		createLabel("تعداد کاربران", 500, 10 + 40 * 5);
		createLabel("تعداد ماژول ها", 500, 10 + 40 * 6);

		createLabel("از", 460, 10 + 40 * 4);
		createLabel("از", 460, 10 + 40 * 5);
		createLabel("از", 460, 10 + 40 * 6);

		createTextField(400, 10 + 40 * 4);
		createTextField(400, 10 + 40 * 5);
		createTextField(400, 10 + 40 * 6);
		
		createLabel("تا", 380, 10 + 40 * 4);
		createLabel("تا", 380, 10 + 40 * 5);
		createLabel("تا", 380, 10 + 40 * 6);

		createTextField(320, 10 + 40 * 4);
		createTextField(320, 10 + 40 * 5);
		createTextField(320, 10 + 40 * 6);

		createLabel("نفر", 300, 10 + 40 * 4);
		createLabel("نفر", 300, 10 + 40 * 5);
		createLabel("ماژول", 290, 10 + 40 * 6);

		techLabel = new JLabel("تکنولوژی های پروژه");
		techLabel.setSize(120, 25);
		techLabel.setLocation(560, 280);
		super.panel.add(techLabel);

		modulesNameLabel[0] = createLabel("تکنولوژِی یک", 500, 160 + 40 * 4);
		modulesNameLabel[1] = createLabel("تکنولوژِی دو", 500, 160 + 40 * 5);
		modulesNameLabel[2] = createLabel("تکنولوژِی سه", 500, 160 + 40 * 6);

		technologyTextField = new JTextField();
		technologyTextField.setSize(150, 25);
		technologyTextField.setLocation(400, 160 + 40 * 3);
		panel.add(technologyTextField);

		addTechnologyButton = new JButton("ثبت تکنولوژِی");
		addTechnologyButton.setSize(90, 25);
		addTechnologyButton.setLocation(320, 160 + 40 * 3);
		panel.add(addTechnologyButton);

		predictButton = new JButton("پیش بینی");
		predictButton.setSize(80, 25);
		predictButton.setLocation(480, 430);
		panel.add(predictButton);

	}

	private JLabel createLabel(String s, int x, int y) {
		JLabel label = new JLabel(s);
		label.setSize(90, 25);
		label.setLocation(x, y);
		panel.add(label);
		return label;
	}

	private JTextField createTextField(int x, int y) {
		JTextField jTextField = new JTextField();
		jTextField .setSize(50, 25);
		jTextField .setLocation(x, y);
		panel.add(jTextField );
		return jTextField;
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

}