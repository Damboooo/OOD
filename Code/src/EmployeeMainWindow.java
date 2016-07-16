import javax.swing.JButton;
import javax.swing.JPanel;


public class EmployeeMainWindow extends UserWindow {

	private JButton changeModuleInformationButton;
	private JButton tasksListButton;
	private JPanel panel;
	
	public EmployeeMainWindow(User user) {
		super(user);
		setTitle("پنل کارمند");
		
		changeModuleInformationButton = new JButton("ثبت اطلاعات تغییر ماژول ها");
		changeModuleInformationButton.setSize(180, 25);
		changeModuleInformationButton.setLocation(300,230);
		super.panel.add(changeModuleInformationButton);
		
		tasksListButton = new JButton("مشاهده فهرست وظیفه ها");
		tasksListButton.setSize(180,25);
		tasksListButton.setLocation(300,280);
		super.panel.add(tasksListButton);
		
	
	
	}
	
	private void login(){
		
	}



}
