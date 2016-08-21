package UI.Report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Main.Main;
import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.Task;
import Report.Report;
import ResourceManagement.Resource;
import ResourceManagement.User;

public class UsageReportWindow extends ReportWindow {

    private JLabel label;
    private JLabel from;
    private JLabel to;
    private JDatePickerImpl fromDate;
	private List<Resource> resources;
    private List<Resource> result;
    private Report rep = new Report();
	private DefaultTableModel model; 
	private JTable table;
	private List<String> selectedProjects;
	private List<Project> projects;

    public UsageReportWindow(User user) {
        super(user);

        ArrayList<String> resourcesName = new ArrayList<>();
      		resources = Main.dbManager.getResources();
      		projects = Main.dbManager.getProjects();

      		for (int i = 0; i < resources.size(); i++) {
      			resourcesName.add(resources.get(i).getName());
      		}
      		makeCheckList(resourcesName);
      		reportButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				report();
    			}
    		});
      		
        label = new JLabel("گزارش جریان چرخشی مصرف");
        label.setSize(120, 25);
        label.setLocation(600, 90);
        super.panel.add(label);

        from = new JLabel("از تاریخ");
        from.setSize(80, 25);
        from.setLocation(610, 120);
        super.panel.add(from);

        to = new JLabel("تا تاریخ");
        to.setSize(80, 25);
        to.setLocation(510, 120);
        super.panel.add(to);

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

    }
    
    public void report() {
    	if(table != null)
        	panel.remove(table);
        	model = new DefaultTableModel(); 
        	table = new JTable(model); 
        	model.addColumn("تا تاریخ");
          	model.addColumn("از تاریخ"); 
          	model.addColumn("نام پروژه"); 
          	model.addColumn("نام منبع"); 
           
        	  JScrollPane scrollPane = new JScrollPane( table );
        	   panel.add( scrollPane, BorderLayout.CENTER );
        	   
        	   scrollPane.setBounds(250, 200, 350, 200);
            table.setLocation(250,200);
          	table.setSize(350,200);
            table.setFillsViewportHeight(true);
            
    	 selectedProjects = new ArrayList<>();
    	 
    	for (int i = 0; i < resources.size(); i++) {
    	
			if (checkBoxes[i].isSelected()) {
//				selectedProjects.add(checkBoxes[i].getText());
				for (int j = 0; j < projects.get(i).getResourceList().size(); j++) {
					if(projects.get(i).getResourceList().get(j).getResource().getName().contains(resources.get(i).getName())){
						
//						model.addRow(new Object[]{
//								
//								projects.get(j).getName() ,
//								resources.get(i).getName()
//								});
//					
				}
				}
//				resourceList = resourceList.substring(0,resourceList.length()-2);
			

			}
		}
    
//    	result = rep.requirementReport(selectedProjects);
   
 
    	
//        panel.add(table.getTableHeader(), BorderLayout.NORTH);
    }


}
