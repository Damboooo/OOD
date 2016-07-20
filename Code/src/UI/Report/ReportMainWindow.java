package UI.Report;
import javax.swing.JButton;
import javax.swing.JPanel;
import ResourceManagement.User;
import UI.Predict.UserWindow;


public class ReportMainWindow extends UserWindow {

	private JButton resourceReportButton;
	private JButton usageReportButton;
	private JButton requirementReportButton;
	//private JPanel panel;
	
	public ReportMainWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");
		
		resourceReportButton = new JButton("گزارش گیری منابع موجود");
		resourceReportButton.setSize(180, 25);
		resourceReportButton.setLocation(300,230);
		super.panel.add(resourceReportButton);
		
		usageReportButton = new JButton("گزارش گیری جریان چرخشی مصرف");
		usageReportButton.setSize(180,25);
		usageReportButton.setLocation(300,280);
		super.panel.add(usageReportButton);
		

		requirementReportButton = new JButton("گزارش گیری منابع مورد نیاز");
		requirementReportButton.setSize(180,25);
		requirementReportButton.setLocation(300,320);
		super.panel.add(requirementReportButton);
	}



}
