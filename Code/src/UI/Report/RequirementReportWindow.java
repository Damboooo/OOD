package UI.Report;

import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ProjectManagement.Module;
import ProjectManagement.Task;
import ResourceManagement.Resource;
import ResourceManagement.User;

public class RequirementReportWindow extends ReportWindow {

    private JButton searchButton;
    private JTextField searchTextField;
    private JLabel label;


    public RequirementReportWindow(User user) {
        super(user);

        label = new JLabel("گزارش منابع مورد نیاز");
        label.setSize(120, 25);
        label.setLocation(600, 90);
        super.panel.add(label);


        searchTextField = new JTextField();
        searchTextField.setSize(300, 25);
        searchTextField.setLocation(250, 135);
        super.panel.add(searchTextField);

        searchButton = new JButton("جستجو");
        searchButton.setSize(65, 25);
        searchButton.setLocation(200, 135);
        super.panel.add(searchButton);

    }

    private JLabel createLabel(String s, int x, int y) {
        JLabel label = new JLabel(s);
        label.setSize(400, 25);
        label.setLocation(x, y);
        panel.add(label);
        return label;
    }

    private JCheckBox createCheckBox(String s, int x, int y) {

        JCheckBox checkBoxes = new JCheckBox(s);
        checkBoxes.setSize(100, 20);
        checkBoxes.setLocation(x, y);
        panel.add(checkBoxes);
        return checkBoxes;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);

        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
        g2.setStroke(dashed);
        g2.drawRect(115, 150, 560, 370);

        // Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
        // BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

    }

    public void search() {

    }

}
