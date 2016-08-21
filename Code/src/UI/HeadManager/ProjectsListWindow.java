package UI.HeadManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.ProjectCatalogue;
import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.ProjectManager.ProjectDetailsWindow;

public class ProjectsListWindow  extends UI.Employee.UserWindow {

	private JLabel[] labels = new JLabel[6];
	private ArrayList<JButton> editButtons = new ArrayList<>();
	private int counter;
	
	private JLabel label;
	private JButton searchButton;
	private JTextField searchTextField;
	private ArrayList<Project> projects;
	
	public ProjectsListWindow (User user) {
		super(user);
		setTitle("پنل مدیریت پروژه");
		// Rectangle r = new Rectangle(0, 0, 100, 100);
		// super.panel.add(r);

		projects = ProjectCatalogue.getInstance().getProjectList();
		
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


		// ==================================> خوندن از دیتابیس

		for (counter = 0; counter < projects.size(); counter++) {
			JButton editButton = new JButton(projects.get(counter).getName());
			editButton.setSize(180, 25);
			editButton.setLocation(300, 200 + 30 * counter);
			editButton.addActionListener(new ActionListener() {
				Project p = projects.get(counter);
				public void actionPerformed(ActionEvent e) {
					editProject(p);
				}
			});
			editButtons.add(editButton);
			super.panel.add(editButton);
		}

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
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

	}

    public void editProject(Project project) {
    	new ProjectDetailsWindow(user, project);
    }

    public void search() {

    }

}
