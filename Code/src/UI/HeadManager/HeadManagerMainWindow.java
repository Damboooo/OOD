
package UI.HeadManager;

import javax.swing.JButton;

import ResourceManagement.User;

public class HeadManagerMainWindow extends UI.Employee.UserWindow {

	private JButton projectDetailsButton;
	private JButton projectModulesButton;
	private JButton projectResourcesButton;
	private JButton projectTasksButton;
	private JButton projectRequirementsButton;
	//private JPanel panel;
	
	public HeadManagerMainWindow(User user) {
		super(user);
		setTitle("پنل مدیریت ");
		
		
		projectDetailsButton = createbutton("مدیریت حساب های کاربری" , 300,180);
		projectModulesButton = createbutton("مدیریت پروژه ها" , 300,230);
		projectResourcesButton = createbutton("مدیریت منابع" , 300,230+50);
		projectTasksButton = createbutton("ابزار گزارش گیری" , 300,330);
		projectRequirementsButton = createbutton("ابزار پیش بینی" , 300,330+50);

		

		
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
