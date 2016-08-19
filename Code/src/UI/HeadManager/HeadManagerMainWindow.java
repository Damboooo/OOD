
package UI.HeadManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ResourceManagement.User;
import UI.Accounting.FirstWindow;
import UI.Predict.PredictMainWindow;
import UI.Report.ReportMainWindow;

public class HeadManagerMainWindow extends UI.Employee.UserWindow {

	private JButton projectDetailsButton;
	private JButton projectModulesButton;
	private JButton projectResourcesButton;
	private JButton projectTasksButton;
	private JButton projectRequirementsButton;
	//private JPanel panel;
	
	public HeadManagerMainWindow(final User user) {
		super(user);
		setTitle("پنل مدیریت ");
		
		
		projectDetailsButton = createbutton("مدیریت حساب های کاربری" , 300,180);
		projectDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				AccountsListWindow rw = new AccountsListWindow(user);
				dispose();
			}
		});
		projectModulesButton = createbutton("مدیریت پروژه ها" , 300,230);
		projectModulesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				ManageProjectsWindow rw = new ManageProjectsWindow(user);
				dispose();
			}
		});
		projectResourcesButton = createbutton("مدیریت منابع" , 300,230+50);
		projectResourcesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				ManageResourcesWindow rw = new ManageResourcesWindow(user);
				dispose();
			}
		});
		projectTasksButton = createbutton("ابزار گزارش گیری" , 300,330);
		projectTasksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				ReportMainWindow rm = new ReportMainWindow(user);
				dispose();
			}
		});
		projectRequirementsButton = createbutton("ابزار پیش بینی" , 300,330+50);
		projectRequirementsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				PredictMainWindow rm = new PredictMainWindow(user);
				dispose();
			}
		});

		

		
	}
	   private JButton createbutton(String s , int x , int y ){
			JButton t = new JButton(s);
			t.setSize(180,25);
			t.setLocation(x,y);
			panel.add(t);
			return t;
		}



    public void manageAccounts() {

    }

    public void manageProjects() {

    }

    public void manageResources() {

    }

    public void report() {

    }

    public void predict() {

    }

}
