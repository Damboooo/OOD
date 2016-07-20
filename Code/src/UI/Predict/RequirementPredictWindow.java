package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ResourceManagement.Resource;
import ResourceManagement.User;

public class RequirementPredictWindow extends UserWindow {

	private JLabel[] modulesNameLabel = new JLabel[100];
	private Resource[] resources;
	private JTextField resourceTextField;
	private JButton addResourceButton;
	private JButton predicButtonButton;
	private JLabel label;

	// private JPanel panel;

	public RequirementPredictWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");

		label = new JLabel("جستجو در پروژه های مشابه برای پیش بینی");
		label.setSize(280, 25);
		label.setLocation(340, 152);
		super.panel.add(label);

		resourceTextField = new JTextField();
		resourceTextField.setSize(150, 25);
		resourceTextField.setLocation(350, 70 + 40 * 3);
		panel.add(resourceTextField);

		 modulesNameLabel[0] = createLabel("منبع یک" , 420,70+40*4);
		 modulesNameLabel[1] = createLabel("منبع دو" , 420,70+40*5);
		 modulesNameLabel[2] = createLabel("منبع سه" , 420,70+40*6);

		
		addResourceButton = new JButton("ثبت منبع");
		addResourceButton.setSize(90, 25);
		addResourceButton.setLocation(270, 70 + 40 * 3);
		panel.add(addResourceButton);

		predicButtonButton = new JButton("پیش بینی");
		predicButtonButton.setSize(80, 25);
		predicButtonButton.setLocation(270, 340);
		panel.add(predicButtonButton);

	}

	private boolean addResources() {
		return false;
	}

	private void predict() {

	}

	private JLabel createLabel(String s , int x , int y){
		JLabel label = new JLabel(s);
		label.setSize(90,25);
		label.setLocation(x,y);
		panel.add(label);
		return label;
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(270, 210, 250, 190);

		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

	}

}
