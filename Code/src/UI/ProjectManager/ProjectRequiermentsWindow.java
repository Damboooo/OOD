package UI.ProjectManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ResourceManagement.User;


public class ProjectRequiermentsWindow extends UI.Employee.UserWindow {


	private JButton[] editButtons = new JButton[100];
	
	public ProjectRequiermentsWindow(User user) {
		super(user);
		setTitle("پنل مدیریت پروژه");
		
		createLabel("فهرست منابع انسانی " , 560,98);
		createLabel("نیروی انسانی یک" , 480,98+30);
		createLabel("نیروی انسانی دو" , 480,98+60);
		
		createLabel("فهرست منابع فیزیکی " , 560,198);
		createLabel("سرور" , 480,198+30);
		createLabel("دیتابیس" ,480,198+60);
		
		createLabel("فهرست منابع مالی " , 560,298);
		createLabel("هزینه مالی یک" , 480,298+30);
		createLabel("هزینه مالی دو" , 480,298+60);
		
		createLabel("فهرست منابع دانشی " , 560,398);
		createLabel("دانش یک" , 410,398+30);
		createLabel("دانش دو" , 410,398+60);
		
		createbutton("مشاهده و ویرایش", 280, 98+30);
		createbutton("مشاهده و ویرایش", 280,98+60 );
		createbutton("مشاهده و ویرایش", 280,198+30 );
		createbutton("مشاهده و ویرایش", 280, 198+60);
		createbutton("مشاهده و ویرایش", 280,298+30 );
		createbutton("مشاهده و ویرایش", 280, 298+60);
		createbutton("مشاهده و ویرایش", 280,398+30 );
		createbutton("مشاهده و ویرایش", 280,398+60 );
		

		
	}
	   private void createLabel(String s , int x , int y ){
			JLabel t = new JLabel(s);
			t.setSize(200,25);
			t.setLocation(x,y);
			panel.add(t);
			//return t;
		}


	   private JButton createbutton(String s , int x , int y ){
			JButton t = new JButton(s);
			t.setSize(100,25);
			t.setLocation(x,y);
			panel.add(t);
			return t;
		}
	   
	   @Override
	    public void paint(Graphics g){
		    Graphics2D g2 = (Graphics2D) g;
	        super.paint(g2);
	        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
	        g2.setStroke(dashed);
	        g2.drawRect(115, 150, 560, 70);
	        g2.drawRect(115, 250, 560, 70);
	        g2.drawRect(115, 350, 560, 70);
	        g2.drawRect(115, 450, 560, 70);
	        
	    }
	

}
