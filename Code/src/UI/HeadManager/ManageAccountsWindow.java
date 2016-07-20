package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JLabel;

import ResourceManagement.User;

public class ManageAccountsWindow extends UI.Employee.UserWindow {

	private JButton accountsListButton;
	private JButton guestsListButton;

	//private JPanel panel;
	
	public ManageAccountsWindow(User user) {
		super(user);
		setTitle("پنل مدیریت ");
		
		accountsListButton = createbutton("مشاهده فهرست حساب های کاربری" , 300,230+50);
		guestsListButton = createbutton("مشاهده فهرست کاربران تایید نشده" , 300,330);

		JLabel t = new JLabel("مدیریت حساب های کاربری");
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
