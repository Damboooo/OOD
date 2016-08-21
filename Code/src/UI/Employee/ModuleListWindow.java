package UI.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import ProjectManagement.Module;
import ProjectManagement.ModuleCatalogue;
import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;

public class ModuleListWindow extends UserWindow {

	private int counter;
	private ArrayList<Module> modules = new ArrayList<>();
	// private JLabel[] labels = new JLabel[6];
	private ArrayList<JButton> editButtons = new ArrayList<JButton>();
	private JButton searchButton;
	private JLabel label;
	private JTextField searchTextField;

	public ModuleListWindow(final User user) {
		super(user);
		setTitle("ثبت اطلاعات تغییر ماژول ها");
		// Rectangle r = new Rectangle(0, 0, 100, 100);
		// super.panel.add(r);

		ArrayList<Module> allModules = ModuleCatalogue.getInstance().getModuleList();
		System.out.println(allModules.size());
		for (int i = 0; i < allModules.size(); i++) {
			ArrayList<Resource> moduleResources = allModules.get(i)
					.getResourceList();
			System.out.println(moduleResources.size());
			for (int j = 0; j < moduleResources.size(); j++) {
				if (moduleResources.get(j) instanceof User
						&& moduleResources.get(j).getId() == user.getId()) {
					modules.add(allModules.get(i));
					break;
				}
			}
		}
		label = new JLabel("لیست ماژول ها");
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

		for (counter = 0; counter < modules.size(); counter++) {
			JButton editButton = new JButton();
			editButton = new JButton(modules.get(counter).getName() + (counter + 1));
			editButton.setSize(180, 25);
			editButton.setLocation(300, 200 + 30 * counter);
			editButton.addActionListener(new ActionListener() {
				int moduleNum = counter;
				public void actionPerformed(ActionEvent e) {
					// display/center the jdialog when the button is pressed
					EditModuleWindow em = new EditModuleWindow(modules.get(moduleNum),
							user);
					dispose();
				}
			});
			editButtons.add(editButton);
			super.panel.add(editButton);
		}
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

	public boolean editModule(Module module) {
		return false;
	}

	public void search() {

	}

}
