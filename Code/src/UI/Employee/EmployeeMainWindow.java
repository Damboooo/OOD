package UI.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;


public class EmployeeMainWindow extends UserWindow {

	private JButton changeModuleInformationButton;
	private JButton tasksListButton;
	//private JPanel panel;
	
	public EmployeeMainWindow(final User user) {
		super(user);
		setTitle("پنل کارمند");
		
		changeModuleInformationButton = new JButton("ثبت اطلاعات تغییر ماژول ها");
		changeModuleInformationButton.setSize(180, 25);
		changeModuleInformationButton.setLocation(300,230);
		changeModuleInformationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				ModuleListWindow rw = new ModuleListWindow(user);
				dispose();
			}
		});
		super.panel.add(changeModuleInformationButton);
		
		tasksListButton = new JButton("مشاهده فهرست وظیفه ها");
		tasksListButton.setSize(180,25);
		tasksListButton.setLocation(300,280);
		tasksListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				TasksListWindow rw = new TasksListWindow(user);
				dispose();
			}
		});
		super.panel.add(tasksListButton);
		
	}



}
