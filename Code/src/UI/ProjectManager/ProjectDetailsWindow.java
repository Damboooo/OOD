package UI.ProjectManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ProjectManagement.Project;
import ResourceManagement.User;


public class ProjectDetailsWindow extends UserWindow {

    private JTextField humanResourcesTextField;
    private JTextField userCountTextField;
    private JTextField moduleCountTextField;
    private JTextField technologiesTextField;
    private JTextField developementsCostsTextField;
    private JTextField maintainanceCostsTextField;
    private JTextField physicalResourcesTextField;
    private JButton saveButton;
    //private JPanel panel;

    public ProjectDetailsWindow(User user, final Project project) {
        super(user);
        setTitle("پنل مدیریت پروژه");
        createLabel("اطلاعات تجمیعی پروژه یک:", 550, 90);
        createLabel("تعداد نیروی انسانی ایجاد کننده:", 440, 180 + 35 * 0);
        createLabel("تعداد کاربران:", 440, 180 + 35 * 1);
        createLabel("تعداد ماژول ها:", 440, 180 + 35 * 2);
        createLabel("تکنولوژی مورد استفاده:", 440, 180 + 35 * 3);

        createLabel("هزینه ایجاد:", 440, 180 + 35 * 4);
        createLabel("هزینه نگهداری:", 440, 180 + 35 * 5);
        createLabel("منابع فیزیکی:", 440, 180 + 35 * 6);

        humanResourcesTextField = createTextField(project.getHumanResourceList().size()+"", 220, 180 + 35 * 0);
        humanResourcesTextField.setEditable(false);
        userCountTextField = createTextField(project.getNumberOfUsers()+"", 220, 180 + 35 * 1);
        moduleCountTextField = createTextField(project.getModuleList().size()+"", 220, 180 + 35 * 2);
        moduleCountTextField.setEditable(false);
        technologiesTextField = createTextField(project.getTechnologies(), 220, 180 + 35 * 3);
        developementsCostsTextField = createTextField("یک میلیارد تومان", 220, 180 + 35 * 4);
        maintainanceCostsTextField = createTextField("-", 220, 180 + 35 * 5);
        physicalResourcesTextField = createTextField("سرور - دیتابیس", 220, 180 + 35 * 6);

        saveButton = new JButton("ثبت تغییرات");
        saveButton.setSize(80, 25);
        saveButton.setLocation(100, 520);
        saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmChanges(project);
			}
		});
        panel.add(saveButton);


    }

    private void createLabel(String s, int x, int y) {
        JLabel t = new JLabel(s);
        t.setSize(120, 25);
        t.setLocation(x, y);
        panel.add(t);
        //return t;
    }

    private JTextField createTextField(String s, int x, int y) {
        JTextField t = new JTextField(s);
        t.setSize(180, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
        g2.setStroke(dashed);
        g2.drawRect(115, 150, 560, 370);

    }

    public boolean confirmChanges(Project project) {
    	project.setNumberOfUsers(Integer.parseInt(userCountTextField.getText()));
    	project.setTechnologies(technologiesTextField.getText());
    	dispose();
        return false;
    }


}
