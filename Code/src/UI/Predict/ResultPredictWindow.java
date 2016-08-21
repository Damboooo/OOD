package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.Main;
import ProjectManagement.Module;
import ProjectManagement.Project;
import ResourceManagement.Resource;
import ResourceManagement.User;

public class ResultPredictWindow extends UserWindow {
	
	private Module[] projects = new Module[6];
	private JLabel[] labels = new JLabel[6];
	private JButton[] editButton = new JButton[6];
	private JButton searchButton;
	private JLabel label;

	private JTextField searchTextField;

	public ResultPredictWindow(User user , List<Project> result) {
		super(user);
		setTitle("پنل مدیریت");
		// Rectangle r = new Rectangle(0, 0, 100, 100);
		// super.panel.add(r);

		label = new JLabel("لیست پروژه ها");
		label.setSize(60, 25);
		label.setLocation(600, 90);
		super.panel.add(label);

		searchTextField = new JTextField();
		searchTextField.setSize(300, 25);
		searchTextField.setLocation(250, 150);
		super.panel.add(searchTextField);

		searchButton = new JButton("جستجو");
		searchButton.setSize(65, 25);
		searchButton.setLocation(200, 150);
		super.panel.add(searchButton);
		  searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
				}
			});

		for (int i = 0; i < result.size(); i++) {
			editButton[i] = new JButton(result.get(i).getName());
			editButton[i].setSize(180, 25);
			editButton[i].setLocation(300, 200 + 30 * i);
			super.panel.add(editButton[i]);
		}

	}

	private void search() {

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
