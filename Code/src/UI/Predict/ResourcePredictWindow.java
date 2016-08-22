package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import MainPackage.Main;
import Predict.Predict;
import ProjectManagement.Module;
import ProjectManagement.Project;
import ResourceManagement.Resource;
import ResourceManagement.User;

public class ResourcePredictWindow extends UserWindow {

	private JLabel alertLabel;
	private JLabel sizeLabel;
	private JLabel techLabel;
	private JButton predictButton;
	private JButton addTechnologyButton;
	private JLabel moduleNameLabel;
	private JLabel[] techsNameLabel = new JLabel[100];
	private JTextField humanResourceRangeFromTextField;
	private JTextField humanResourceRangeToTextField;
	private JTextField usersRangeFromTextField;
	private JTextField usersRangeToTextField;
	private JTextField modulesRangeFromTextField;
	private JTextField modulesRangeToTextField;
	private JTextField technologyTextField;
	private int last = 0;
	private JComboBox<String> techComboBox = new JComboBox<String>();
	private Predict pr = new Predict();
	private List<Project> result;
	private JTextField[] informationTextfields = new JTextField[6];
	private Domain humanResource;
	private Domain users;
	private Domain modules;

	// private JPanel panel;

	public ResourcePredictWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");

		createLabel("پیش بینی منبع", 580, 90);

		// changeNameTextField = new JTextField();
		// changeNameTextField.setSize(350,25);
		// changeNameTextField.setLocation(200,160+40);
		// panel.add(changeNameTextField);

		alertLabel = new JLabel("در صورت نیاز فیلدها را خالی بگذارید تا شامل همه مقادیر شود!");
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

		informationTextfields[0] = createTextField(400, 10 + 40 * 4);
		informationTextfields[1] = createTextField(320, 10 + 40 * 4);

		informationTextfields[2] = createTextField(400, 10 + 40 * 5);
		informationTextfields[3] = createTextField(320, 10 + 40 * 5);

		informationTextfields[4] = createTextField(400, 10 + 40 * 6);
		informationTextfields[5] = createTextField(320, 10 + 40 * 6);

		createLabel("تا", 380, 10 + 40 * 4);
		createLabel("تا", 380, 10 + 40 * 5);
		createLabel("تا", 380, 10 + 40 * 6);

		createLabel("نفر", 300, 10 + 40 * 4);
		createLabel("نفر", 300, 10 + 40 * 5);
		createLabel("ماژول", 290, 10 + 40 * 6);

		techLabel = new JLabel("تکنولوژی های پروژه");
		techLabel.setSize(120, 25);
		techLabel.setLocation(560, 280);
		super.panel.add(techLabel);

		// techsNameLabel[0] = createLabel("تکنولوژِی یک", );
		// techsNameLabel[1] = createLabel("تکنولوژِی دو", 500, 160 + 40 * 5);
		// techsNameLabel[2] = createLabel("تکنولوژِی سه", 500, 160 + 40 * 6);

		// technologyTextField = new JTextField();
		// technologyTextField.setSize(150, 25);
		// technologyTextField.setLocation(400, 160 + 40 * 3);
		// panel.add(technologyTextField);
//
//		List<Resource> technologies = Main.dbManager.getTechnologies();
//		for (int i = 0; i < technologies.size(); i++) {
//			techComboBox.addItem(technologies.get(i).getName());
//		}
		panel.add(techComboBox);
		techComboBox.setBounds(400, 160 + 40 * 3, 150, 25);
		((JLabel) techComboBox.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);

		addTechnologyButton = new JButton("ثبت تکنولوژِی");
		addTechnologyButton.setSize(90, 25);
		addTechnologyButton.setLocation(320, 160 + 40 * 3);
		panel.add(addTechnologyButton);
		addTechnologyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTechnology();
			}
		});

		predictButton = new JButton("پیش بینی");
		predictButton.setSize(80, 25);
		predictButton.setLocation(140, 440);
		panel.add(predictButton);
		predictButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				predict();
			}
		});
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
		jTextField.setSize(50, 25);
		jTextField.setLocation(x, y);
		panel.add(jTextField);
		return jTextField;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

	}

	public void predict() {
		humanResource = new Domain(informationTextfields[0].getText(), informationTextfields[1].getText());
		users = new Domain(informationTextfields[2].getText(), informationTextfields[3].getText());
		modules = new Domain(informationTextfields[4].getText(), informationTextfields[5].getText());

		ArrayList<String> techs = new ArrayList<>();
		for (int i = 0; i < last; i++) {
			techs.add(techsNameLabel[i].getText().substring(3));
		}
//		System.out.println(humanResource.getStart()+" "+ humanResource.getEnd());
//		System.out.println(users.getStart()+" "+ humanResource.getEnd());
//		System.out.println(modules.getStart()+" "+ humanResource.getEnd());
		result = pr.resourcePredict(techs, humanResource, users, modules);
		new ResultPredictWindow(user, result);
		dispose();
	}

	public boolean addTechnology() {
		boolean repeated = false;
		for (int i = 0; i < last; i++) {
			if(techsNameLabel[i]
					.getText().
					contains(techComboBox.getItemAt(techComboBox.getSelectedIndex()))){
				repeated = true;
				break;
			}
		}
		if(!repeated){
		techsNameLabel[last] = createLabel(" + " + techComboBox.getItemAt(techComboBox.getSelectedIndex()), 470,
		225 + 20 * (4 + last));
		last++;
		return true;
		}
		else
			return false;
	}

}