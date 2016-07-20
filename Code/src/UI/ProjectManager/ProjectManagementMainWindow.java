package UI.ProjectManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ResourceManagement.User;


public class ProjectManagementMainWindow extends UI.Employee.UserWindow {


    private JButton projectDetailsButton;
    private JButton projectModulesButton;
    private JButton projectResourcesButton;
    private JButton projectTasksButton;
    private JButton projectRequirementsButton;
    //private JPanel panel;

    public ProjectManagementMainWindow(User user) {
        super(user);
        setTitle("پنل مدیریت پروژه");


        projectDetailsButton = createbutton("اطلاعات تجمیعی پروژه", 300, 180);
        projectModulesButton = createbutton("ماژول ها", 300, 230);
        projectResourcesButton = createbutton("منابع", 300, 230 + 50);
        projectTasksButton = createbutton("وظیفه ها", 300, 330);
        projectRequirementsButton = createbutton("نیازمندی ها", 300, 330 + 50);


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
