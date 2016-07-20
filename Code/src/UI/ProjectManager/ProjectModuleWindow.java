package UI.ProjectManager;

import java.awt.*;
import javax.swing.*;

import ResourceManagement.Resource;
import ResourceManagement.User;

public class ProjectModuleWindow extends UI.Employee.UserWindow {


    private JButton editButton;
    private JButton deleteButton;
    private JLabel label;
    private JTable table;

    // private JPanel panel;

    public ProjectModuleWindow(User user) {
        super(user);
        setTitle(" پنل مدیریت پروژه");

        label = new JLabel("ماژول یک در پروزه یک");
        label.setSize(280, 25);
        label.setLocation(560, 90);
        super.panel.add(label);

        label = new JLabel("تاریخچه تغییرات");
        label.setSize(280, 25);
        label.setLocation(520, 170);
        super.panel.add(label);

        editButton = new JButton("ویرایش");
        editButton.setSize(65, 25);
        editButton.setLocation(220, 440);
        panel.add(editButton);

        deleteButton = new JButton("حذف");
        deleteButton.setSize(65, 25);
        deleteButton.setLocation(140, 440);
        panel.add(deleteButton);

    }

    private JLabel createLabel(String s, int x, int y) {
        JLabel label = new JLabel(s);
        label.setSize(90, 25);
        label.setLocation(x, y);
        panel.add(label);
        return label;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);

        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
        g2.setStroke(dashed);
        //g2.drawRect(270, 210, 250, 190);
        g2.drawRect(115, 150, 560, 370);

        // Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
        // BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

    }


    public void edit() {

    }

    public boolean confirmChanges() {
        return false;
    }

    public boolean delete() {
        return false;
    }
}
