package UI.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import ProjectManagement.Module;
import ProjectManagement.ModuleCatalogue;
import ProjectManagement.Task;
import ProjectManagement.TaskCatalogue;
import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;

public class TasksListWindow extends UserWindow {

	private ArrayList<Task> tasks = new ArrayList<>();
	private ArrayList<JLabel> taskLabels = new ArrayList<>();
	private ArrayList<JLabel> descriptionLabels = new ArrayList<>();
	private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	private JButton saveButton;
	private JLabel label;

	public TasksListWindow(final User user) {
		super(user);
		setTitle("پنل کارمند");

		ArrayList<Task> allTasks = TaskCatalogue.getInstance().getTaskList();
		System.out.println(allTasks.size());
		for (int i = 0; i < allTasks.size(); i++) {
			ArrayList<User> taskUsers = allTasks.get(i).getUsers();
			for (int j = 0; j < taskUsers.size(); j++) {
				System.out.println(user.getId());
				if (taskUsers.get(j).getId() == user.getId()) {
					tasks.add(allTasks.get(i));
					break;
				}
			}
		}

		label = new JLabel("فهرست وطیفه ها");
		label.setSize(80, 25);
		label.setLocation(600, 90);
		super.panel.add(label);
		System.out.println(tasks.size());
		for (int i = 0; i < tasks.size(); i++) {
			JLabel taskLabel = new JLabel();
			taskLabel = createLabel(tasks.get(i).getName(), 500, 200 + 60 * i);
			taskLabels.add(taskLabel);
			JLabel descriptionLabel = new JLabel();
			descriptionLabel = createLabel(tasks.get(i).getDescription(), 340,
					225 + 60 * i);
			descriptionLabels.add(descriptionLabel);
			JCheckBox checkBox = createCheckBox("انجام شد", 200, 225 + 60 * i);
			if (tasks.get(i).getIsFinished())
				checkBox.setSelected(true);
			checkBoxes.add(checkBox);
		}

		saveButton = new JButton("تایید");
		saveButton.setSize(70, 25);
		saveButton.setLocation(100, 520);
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				confirmChanges();
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

		for (int i = 0; i < tasks.size(); i++) {
			g2.drawRect(180, 230 + 60 * i, 420, 50);
		}
		// g2.drawRect(180, 230, 420, 50);
		// g2.drawRect(180, 230 + 60, 420, 50);
		// g2.drawRect(180, 230 + 60 * 2, 420, 50);
		// g2.drawRect(180, 230 + 60 * 3, 420, 50);

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

	}

	public boolean doneTask() {
		return false;
	}

	public boolean confirmChanges() {
		// display/center the jdialog when the button is pressed
		for (int i = 0; i < tasks.size(); i++) {
			tasks.get(i).setIsFinished(checkBoxes.get(i).isSelected());
		}
		EmployeeMainWindow em = new EmployeeMainWindow(user);
		dispose();
		return false;
	}
}
