package UI.ProjectManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainPackage.Main;
import ProjectManagement.Project;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;


public class ProjectManagementMainWindow extends UserWindow {


    private JButton projectDetailsButton;
    private JButton projectModulesButton;
    private JButton projectResourcesButton;
    private JButton projectTasksButton;
    private JButton projectRequirementsButton;
    //private JPanel panel;

    public ProjectManagementMainWindow(final User user,final Project project) {
        super(user);
        setTitle("پنل مدیریت پروژه");


        projectDetailsButton = createbutton("اطلاعات تجمیعی پروژه", 300, 180);
        projectDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				ProjectDetailsWindow pd = new ProjectDetailsWindow(user, project);

			}
		});
        projectModulesButton = createbutton("ماژول ها", 300, 230);
        projectModulesButton.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				// display/center the jdialog when the button is pressed
     				ProjectModuleListWindow pd = new ProjectModuleListWindow(user,project);
     		
     			}
     		});
        projectResourcesButton = createbutton("منابع", 300, 230 + 50);
        projectResourcesButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				// display/center the jdialog when the button is pressed
 				ProjectResourcesWindow pd = new ProjectResourcesWindow(user);
 				
 			}
 		});
        projectTasksButton = createbutton("وظیفه ها", 300, 330);
        projectTasksButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				// display/center the jdialog when the button is pressed
 				ProjectResourcesWindow pd = new ProjectResourcesWindow(user);
 			
 			}
 		});
        projectRequirementsButton = createbutton("نیازمندی ها", 300, 330 + 50);
        projectRequirementsButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				// display/center the jdialog when the button is pressed
 				ProjectRequiermentsWindow pd = new ProjectRequiermentsWindow(user);
 			
 			}
 		});

    }

    private JButton createbutton(String s, int x, int y) {
        JButton t = new JButton(s);
        t.setSize(180, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }


    public void projectDetails() {

    }

    public void projectModules() {

    }

    public void projectResources() {

    }

    public void projectTasks() {

    }

}
