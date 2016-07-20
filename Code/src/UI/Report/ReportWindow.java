package UI.Report;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import ProjectManagement.Module;
import ProjectManagement.Task;
import ResourceManagement.Resource;
import ResourceManagement.User;


public class ReportWindow extends UserWindow {

	JCheckBox[] checkBoxes = new JCheckBox[100];
	JCheckBox checkBoxAll = new JCheckBox();
	JCheckBox checkBoxNone = new JCheckBox();
	private JButton reportButton;
	private JTable reportTable;
	public ReportWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");

		checkBoxes[0] = createCheckBox("منبع 1", 110, 225 + 10 * 0);
		checkBoxes[1] = createCheckBox("منبع 2", 110, 225 + 20 * 1);
		checkBoxes[2] = createCheckBox("منبع 3", 110, 225 + 20 * 2);
		checkBoxes[3] = createCheckBox("منبع 4", 110, 225 + 20 * 3);
		checkBoxes[0].setSelected(true);

		checkBoxNone = createCheckBox("هیچکدام", 180, 175);
		checkBoxAll = createCheckBox("همه موارد", 110, 175);

		reportButton = new JButton("گزارش گیری");
		reportButton.setSize(100, 25);
		reportButton.setLocation(120, 450);
		panel.add(reportButton);


	}

	private void report(Resource[] resourceList) {
	}

	private JLabel createLabel(String s, int x, int y) {
		JLabel label = new JLabel(s);
		label.setSize(400, 25);
		label.setLocation(x, y);
		panel.add(label);
		return label;
	}

	private JCheckBox createCheckBox(String s, int x, int y) {

		JCheckBox checkBoxes = new JCheckBox(s);
		checkBoxes.setSize(100, 20);
		checkBoxes.setLocation(x, y);
		panel.add(checkBoxes);
		return checkBoxes;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

	}

}
