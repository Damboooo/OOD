package UI.Report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import MainPackage.Main;
import Predict.Predict;
import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.Task;
import Report.Report;
import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.Predict.ResultPredictWindow;

public class RequirementReportWindow extends ReportWindow {

    private JButton searchButton;
    private JTextField searchTextField;
    private JLabel label;
    private List<Project> projects;
    private List<Project> result;
    private Report rep = new Report();
	private DefaultTableModel model; 
	private JTable table;
	List<String> selectedProjects;



    public RequirementReportWindow(User user) {
        super(user);
        ArrayList<String> projectsName = new ArrayList<>();
		projects = Main.dbManager.getProjects();

		for (int i = 0; i < projects.size(); i++) {
			projectsName.add(projects.get(i).getName());
		}
		makeCheckList(projectsName);
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report();
			}
		});
		
      
		
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
        searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

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
    public void report() {
    	if(table != null)
        	panel.remove(table);
        	model = new DefaultTableModel(); 
        	table = new JTable(model); 
        	model.addColumn("منابع مورد نیاز");
          	model.addColumn("نام پروژه"); 
           
        	  JScrollPane scrollPane = new JScrollPane( table );
        	   panel.add( scrollPane, BorderLayout.CENTER );
        	   
        	   scrollPane.setBounds(250, 200, 350, 200);
            table.setLocation(250,200);
          	table.setSize(350,200);
            table.setFillsViewportHeight(true);
            
    	 selectedProjects = new ArrayList<>();
    	 String resourceList = new String();
    	for (int i = 0; i < projects.size(); i++) {
    		resourceList = "";
			if (checkBoxes[i].isSelected()) {
//				selectedProjects.add(checkBoxes[i].getText());
				System.out.println(projects.get(i)
						.getResourceList()
						.get(0).
						getResource().getName());
				for (int j = 0; j < projects.
						get(i).
						getResourceList()
						.size();
						j++) {
					resourceList = resourceList+projects.get(i).getResourceList().get(j).getResource().getName()+" ، ";
				}
				resourceList = resourceList.substring(0,resourceList.length()-2);
				model.addRow(new Object[]{ resourceList ,projects.get(i).getName()});

			}
		}
    
//    	result = rep.requirementReport(selectedProjects);
   
 
    	
//        panel.add(table.getTableHeader(), BorderLayout.NORTH);
    }

	

}
