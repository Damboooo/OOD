package UI.Employee;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import ProjectManagement.Module;
import ResourceManagement.User;
import UI.Accounting.FirstWindow;

public class   ModuleListWindow extends UserWindow{
	
	private Module[] modules = new Module[6];
	//private JLabel[] labels = new JLabel[6];
	private JButton[] editButton = new JButton[6];
	private JButton searchButton;
	private JLabel label;
	
	private JTextField searchTextField;

	public ModuleListWindow(final User user) {
		super(user);
		setTitle("ثبت اطلاعات تغییر ماژول ها");
//		Rectangle r = new Rectangle(0, 0, 100, 100);
//		super.panel.add(r);
		
		label = new JLabel("لیست ماژول ها");
		label.setSize(60, 25);
		label.setLocation(600,90);
		super.panel.add(label);
		
		searchTextField = new JTextField();
		searchTextField.setSize(300, 25);
		searchTextField.setLocation(250,150);
		super.panel.add(searchTextField);
		
		searchButton = new JButton("جستجو");
		searchButton.setSize(65, 25);
		searchButton.setLocation(200,150);
		super.panel.add(searchButton);
		 
//==================================> خوندن از دیتابیس

		for (int i = 0; i < 6; i++) {
			editButton[i] = new JButton("ماژول  "+(i+1));
			editButton[i].setSize(180, 25);
			editButton[i].setLocation(300,200+30*i);
			editButton[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// display/center the jdialog when the button is pressed
					EditModuleWindow em = new EditModuleWindow(new Module(),user);
					dispose();
				}
			});
			super.panel.add(editButton[i]);
			
//			labels[i] = new JLabel("نام ماژول");
//			labels[i].setSize(120, 25);
//			labels[i].setLocation(600,200+30*i);
//			super.panel.add(labels[i]);
		}

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
	
	


