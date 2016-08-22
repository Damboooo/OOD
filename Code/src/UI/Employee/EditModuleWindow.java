package UI.Employee;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import MainPackage.Main;
import ProjectManagement.Change;
import ProjectManagement.Module;
import ProjectManagement.ModuleCatalogue;
import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;

public class EditModuleWindow extends UserWindow {

	private Module module;
	private JLabel[] resourceNameLabel = new JLabel[100];
	private JButton saveButton;
	private JButton addresourceButton;
	private JLabel moduleNameLabel;
	private int last = 0;
	private JLabel[] modulesNameLabel = new JLabel[100];
	private JTextField changeNameTextField;
	private JComboBox<String> resourceComboBox = new JComboBox<String>();
	private List<Resource> resources;
	private ArrayList<Resource> changeResources = new ArrayList<Resource>();
	// private JPanel panel;

	public EditModuleWindow(Module module, final User user) {
		super(user);

		this.module = module;
		setTitle("پنل کارمند");

		createLabel("ثبت تغییرات ماژول", 580, 90);

		createLabel("نام ماژول:", 580, 160);
		createLabel("نوع تغییر:", 580, 160 + 40);
		createLabel("میزان زمان تغییر:", 580, 160 + 40 * 2);
		createLabel("منابع مورد استفاده:", 580, 160 + 40 * 3);
		moduleNameLabel = createLabel(module.getName(), 450, 160);

		createLabel("از تاریخ:", 500, 160 + 40 * 2);
		createLabel("تا تاریخ:", 320, 160 + 40 * 2);

		changeNameTextField = new JTextField();
		changeNameTextField.setSize(350, 25);
		changeNameTextField.setLocation(200, 160 + 40);
		panel.add(changeNameTextField);

		resources = Main.dbManager.getResources();
		for (int i = 0; i < resources.size(); i++) {
			resourceComboBox.addItem(resources.get(i).getName());
		}
		panel.add(resourceComboBox);
		resourceComboBox.setBounds(400, 160 + 40 * 3, 150, 25);
		((JLabel) resourceComboBox.getRenderer())
				.setHorizontalAlignment(JLabel.RIGHT);

		addresourceButton = new JButton("ثبت منبع");
		addresourceButton.setSize(90, 25);
		addresourceButton.setLocation(320, 160 + 40 * 3);
		addresourceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addResources();
			}
		});
		panel.add(addresourceButton);

		saveButton = new JButton("ثبت تغییرات");
		saveButton.setSize(80, 25);
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
		label.setSize(90, 25);
		label.setLocation(x, y);
		panel.add(label);
		return label;
	}

	public boolean addResources() {
		changeResources.add(resources.get(resourceComboBox.getSelectedIndex()));
		boolean repeated = false;
		for (int i = 0; i < last; i++) {
			if (resourceNameLabel[i].getText().contains(
					resourceComboBox.getItemAt(resourceComboBox
							.getSelectedIndex()))) {
				repeated = true;
				break;
			}
		}
		if (!repeated) {
			resourceNameLabel[last] = createLabel(
					" + "
							+ resourceComboBox.getItemAt(resourceComboBox
									.getSelectedIndex()), 490,
					230 + 25 * (4 + last));
			last++;
			return true;
		} else
			return false;
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

	public boolean confirmChanges() {
		// display/center the jdialog when the button is pressed
		List<Module> moduleList = ModuleCatalogue.getInstance().getModuleList();
		for (int i = 0; i < moduleList.size(); i++) {
			Module prevModule = moduleList.get(i);
			if(prevModule.getModuleId() == module.getModuleId())
			{
				Change change = new Change();
				change.setDiscribtion(changeNameTextField.getText());
				change.setResources(changeResources);
				prevModule.addChange(change);
				break;
			}
		}
		EmployeeMainWindow em = new EmployeeMainWindow(user);
		dispose();
		return false;
	}
}