package UI.Employee;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ProjectManagement.Module;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;


public class EditModuleWindow extends UserWindow {

	private JButton saveButton;
	private JButton addresourceButton;
	private JLabel moduleNameLabel;
	private JLabel[] modulesNameLabel = new JLabel[100];
	private JTextField changeNameTextField;
	private JTextField addResourceTextField;
	//private JPanel panel;
	
	public EditModuleWindow(Module module,final User user) {
		super(user);
		setTitle("پنل کارمند");
		
		createLabel("ثبت تغییرات ماژول" , 580,90);

		 createLabel("نام ماژول:" , 580,160);
		 createLabel("نوع تغییر:" , 580,160+40);
		 createLabel("میزان زمان تغییر:" , 580,160+40*2);
		 createLabel("منابع مورد استفاده:" , 580,160+40*3);
		 moduleNameLabel = createLabel("ماژول یک" , 500,160);
		
		 createLabel("از تاریخ:" , 500,160+40*2);
		 createLabel("تا تاریخ:" , 320,160+40*2);

		 changeNameTextField  = new JTextField();
		 changeNameTextField.setSize(350,25);
		 changeNameTextField.setLocation(200,160+40);
		 panel.add(changeNameTextField);
		 
		 modulesNameLabel[0] = createLabel("منبع یک" , 500,160+40*4);
		 modulesNameLabel[1] = createLabel("منبع دو" , 500,160+40*5);
		 modulesNameLabel[2] = createLabel("منبع سه" , 500,160+40*6);

		 addResourceTextField  = new JTextField();
		 addResourceTextField.setSize(150,25);
		 addResourceTextField.setLocation(400,160+40*3);
		 panel.add(addResourceTextField);
		 
			addresourceButton = new JButton("ثبت منبع");
			addresourceButton.setSize(90, 25);
			addresourceButton.setLocation(320,160+40*3);
			panel.add(addresourceButton);
			
			saveButton = new JButton("ثبت تغییرات");
			saveButton.setSize(80, 25);
			saveButton.setLocation(100,520);
			saveButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// display/center the jdialog when the button is pressed
					EmployeeMainWindow em = new EmployeeMainWindow(user);
					dispose();
				}
			});
			panel.add(saveButton);
	
		
	}
	private JLabel createLabel(String s , int x , int y){
		JLabel label = new JLabel(s);
		label.setSize(90,25);
		label.setLocation(x,y);
		panel.add(label);
		return label;
	}
	 @Override
	    public void paint(Graphics g){
		    Graphics2D g2 = (Graphics2D) g;
	        super.paint(g2);
	        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
	        g2.setStroke(dashed);
	        g2.drawRect(115, 150, 560, 370);
	        
	    }


}