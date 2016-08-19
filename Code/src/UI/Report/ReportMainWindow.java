package UI.Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ResourceManagement.User;
import UI.Accounting.FirstWindow;


public class ReportMainWindow extends UserWindow {

    private JButton resourceReportButton;
    private JButton usageReportButton;
    private JButton requirementReportButton;
    //private JPanel panel;

    public ReportMainWindow(final User user) {
        super(user);
        setTitle("پنل مدیریت");

        resourceReportButton = new JButton("گزارش گیری منابع موجود");
        resourceReportButton.setSize(180, 25);
        resourceReportButton.setLocation(300, 230);
        resourceReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				ResourceReportWindow rw = new ResourceReportWindow(user);
			}
		});
        super.panel.add(resourceReportButton);

        usageReportButton = new JButton("گزارش گیری جریان چرخشی مصرف");
        usageReportButton.setSize(180, 25);
        usageReportButton.setLocation(300, 280);
        usageReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				UsageReportWindow ur = new UsageReportWindow(user);
			}
		});
        super.panel.add(usageReportButton);


        requirementReportButton = new JButton("گزارش گیری منابع مورد نیاز");
        requirementReportButton.setSize(180, 25);
        requirementReportButton.setLocation(300, 330);
        requirementReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				RequirementReportWindow rr = new RequirementReportWindow(user);
			}
		});
        super.panel.add(requirementReportButton);
    }

    public void resourceReport() {

    }

    public void requirementReport() {

    }

    public void usageReport() {

    }


}
