package UI.Predict;

import java.awt.BasicStroke;
import MainPackage.Main;
import Predict.Predict;
import ProjectManagement.Project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import DB.DBManager;
import ResourceManagement.Resource;
import ResourceManagement.User;

public class RequirementPredictWindow extends UserWindow {

	private JLabel[] resourceNameLabel = new JLabel[100];
	private Resource[] resources;
	// private JTextField resourceTextField;
	private JButton addResourceButton;
	private JButton predicButtonButton;
	private JLabel label;
	private int last = 0;
	private JComboBox<String> resourceComboBox = new JComboBox<String>();
	private Predict pr = new Predict();
	private List<Project> result;
	// private JPanel panel;

	public RequirementPredictWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");

		label = new JLabel("جستجو در پروژه های مشابه برای پیش بینی");
		label.setSize(280, 25);
		label.setLocation(480, 90);
		super.panel.add(label);

		// resourceTextField = new JTextField();
		// resourceTextField.setSize(160, 25);
		// resourceTextField.setLocation(360, 70 + 40 * 3);
		// resourceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		// panel.add(resourceTextField);

		List<Resource> resources = Main.dbManager.getResources();
		for (int i = 0; i < resources.size(); i++) {
			resourceComboBox.addItem(resources.get(i).getName());
		}
		panel.add(resourceComboBox);
		resourceComboBox.setBounds(360, 70 + 40 * 3, 180, 25);
		((JLabel) resourceComboBox.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);

		addResourceButton = new JButton("ثبت منبع");
		addResourceButton.setSize(90, 25);
		addResourceButton.setLocation(270, 70 + 40 * 3);
		panel.add(addResourceButton);
		addResourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addResources();
			}
		});

		predicButtonButton = new JButton("پیش بینی");
		predicButtonButton.setSize(80, 25);
		predicButtonButton.setLocation(140, 440);
		panel.add(predicButtonButton);
		predicButtonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				predict();
			}
		});
	}

	public boolean addResources() {
		boolean repeated = false;
		for (int i = 0; i < last; i++) {
			if(resourceNameLabel[i]
					.getText().
					contains(resourceComboBox.getItemAt(resourceComboBox.getSelectedIndex()))){
				repeated = true;
				break;
			}
		}
		if(!repeated){
		resourceNameLabel[last] = createLabel(" + " + resourceComboBox.getItemAt(resourceComboBox.getSelectedIndex()),
				460, 140 + 20 * (4 + last));
		last++;
		return true;
		}
		else 
			return false;
	}

	public void predict() {
		ArrayList<String> r = new ArrayList<>();
		for (int i = 0; i < last; i++) {
			r.add(resourceNameLabel[i].getText().substring(3));
		}
		result = pr.requirementPredict(r);
		new ResultPredictWindow(user, result);
		dispose();
	}

	private JLabel createLabel(String s, int x, int y) {
		JLabel label = new JLabel(s);
		label.setSize(90, 25);
		label.setLocation(x, y);
		panel.add(label);
		return label;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		// g2.drawRect(270, 210, 250, 190);
		g2.drawRect(115, 150, 560, 370);

		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

	}

}
