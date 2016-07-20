package UI.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import ProjectManagement.Module;
import ProjectManagement.Task;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;

public class TasksListWindow extends UserWindow {

	private Task[] modules = new Task[100];
	private JLabel[] taskLabel = new JLabel[100];
	JCheckBox[] checkBoxes = new JCheckBox[100];
	private JButton saveButton;
	private JLabel label;

	public TasksListWindow(final User user) {
		super(user);
		setTitle("پنل کارمند");

		label = new JLabel("فهرست وطیفه ها");
		label.setSize(80, 25);
		label.setLocation(600, 90);
		super.panel.add(label);
		taskLabel[0] = createLabel("وظیف یک", 500, 200 + 60 * 0);
		taskLabel[1] = createLabel("وظیفه  دو", 500, 200 + 60 * 1);
		taskLabel[2] = createLabel("وظیفه  سه", 500, 200 + 60 * 2);
		taskLabel[3] = createLabel("وظیفه چهار", 500, 200 + 60 * 3);
		taskLabel[4] = createLabel(
				"شرح وظیفه:    این وظیفه به معنی انجام وظیفه یک است.", 340,
				225 + 60 * 0);
		taskLabel[5] = createLabel(
				"شرح وظیفه:    این وظیفه به معنی انجام وظیفه دو است.", 340,
				225 + 60 * 1);
		taskLabel[6] = createLabel(
				"شرح وظیفه:    این وظیفه به معنی انجام وظیفه سه است.", 340,
				225 + 60 * 2);
		taskLabel[7] = createLabel(
				"شرح وظیفه:    این وظیفه به معنی انجام وظیفه چهار است.", 340,
				225 + 60 * 3);

		checkBoxes[0] = createCheckBox("انجام شد", 200, 225 + 60 * 0);
		checkBoxes[1] = createCheckBox("انجام شد", 200, 225 + 60 * 1);
		checkBoxes[2] = createCheckBox("انجام شد", 200, 225 + 60 * 2);
		checkBoxes[3] = createCheckBox("انجام شد", 200, 225 + 60 * 3);
		checkBoxes[0].setSelected(true);

		saveButton = new JButton("تایید");
		saveButton.setSize(70, 25);
		saveButton.setLocation(100, 520);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				EmployeeMainWindow em = new EmployeeMainWindow(user);
				dispose();
			}
		});
		panel.add(saveButton);

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

		g2.drawRect(180, 230, 420, 50);
		g2.drawRect(180, 230 + 60, 420, 50);
		g2.drawRect(180, 230 + 60 * 2, 420, 50);
		g2.drawRect(180, 230 + 60 * 3, 420, 50);

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

	}

}
