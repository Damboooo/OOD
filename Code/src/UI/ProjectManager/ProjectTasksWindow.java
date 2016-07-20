package UI.ProjectManager;

import java.awt.*;
import javax.swing.*;

import ProjectManagement.Task;
import ResourceManagement.User;

public class ProjectTasksWindow extends UI.Employee.UserWindow {

    private Task[] modules = new Task[100];
    private JButton addTaskButton;
    private JLabel label;
    private JComboBox<String> typeComboBox = new JComboBox<String>();

    public ProjectTasksWindow(User user) {
        super(user);
        setTitle("ثبت اطلاعات تغییر ماژول ها");
//		Rectangle r = new Rectangle(0, 0, 100, 100);
//		super.panel.add(r);

        label = new JLabel("فهرست وظیفه ها");
        label.setSize(90, 25);
        label.setLocation(600, 90);
        super.panel.add(label);

        typeComboBox.addItem("بر اساس منبع");
        typeComboBox.addItem("بر اساس زمان");
        panel.add(typeComboBox);
        typeComboBox.setSelectedIndex(0);
        typeComboBox.setBounds(400, 150, 200, 20);


        addTaskButton = new JButton("افزودن وظیفه جدید");
        addTaskButton.setSize(280, 25);
        addTaskButton.setLocation(250, 200 + 30 * 8);
        super.panel.add(addTaskButton);


    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
        g2.setStroke(dashed);
        g2.drawRect(115, 150, 560, 370);

    }



}

	


