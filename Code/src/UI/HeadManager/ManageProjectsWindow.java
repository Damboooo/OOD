package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JLabel;

import ResourceManagement.User;

public class ManageProjectsWindow extends UI.Employee.UserWindow {

	private JButton projectsListButton;
	private JButton newProjectButton;
	
	//private JPanel panel;
   
	public ManageProjectsWindow(User user) {
		super(user);
		setTitle("پنل مدیریت ");
		
		projectsListButton = createbutton("مشاهده فهرست پروژه ها" , 300,230+50);
		newProjectButton = createbutton("ایجاد پروژه جدید" , 300,330);

		JLabel t = new JLabel("مدیریت پروژه ها");
		t.setSize(120,25);
		t.setLocation(550,90);
		panel.add(t);

		
	}
	   private JButton createbutton(String s , int x , int y ){
			JButton t = new JButton(s);
			t.setSize(250,25);
			t.setLocation(x-35,y);
			panel.add(t);
			return t;
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
