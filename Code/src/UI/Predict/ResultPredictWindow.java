package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ProjectManagement.Module;
import ResourceManagement.Resource;
import ResourceManagement.User;

public class ResultPredictWindow extends UI.Employee.UserWindow {

    private Module[] projects = new Module[6];
    private JLabel[] labels = new JLabel[6];
    private JButton[] editButton = new JButton[6];
    private JButton searchButton;
    private JLabel label;

    private JTextField searchTextField;

    public ResultPredictWindow(User user) {
        super(user);
        setTitle("پنل مدیریت");
        // Rectangle r = new Rectangle(0, 0, 100, 100);
        // super.panel.add(r);

        label = new JLabel("لیست پروژه ها");
        label.setSize(60, 25);
        label.setLocation(600, 90);
        super.panel.add(label);

        searchTextField = new JTextField();
        searchTextField.setSize(300, 25);
        searchTextField.setLocation(250, 150);
        super.panel.add(searchTextField);

        searchButton = new JButton("جستجو");
        searchButton.setSize(65, 25);
        searchButton.setLocation(200, 150);
        super.panel.add(searchButton);

        // ==================================> خوندن از دیتابیس

        for (int i = 0; i < 6; i++) {
            editButton[i] = new JButton("پروژه " + (i + 1));
            editButton[i].setSize(180, 25);
            editButton[i].setLocation(300, 200 + 30 * i);
            super.panel.add(editButton[i]);

            // labels[i] = new JLabel("نام ماژول");
            // labels[i].setSize(120, 25);
            // labels[i].setLocation(600,200+30*i);
            // super.panel.add(labels[i]);
        }

    }

    public boolean addResources() {
        return false;
    }

    public void predict() {

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
        g2.drawRect(115, 150, 560, 370);

    }

}
