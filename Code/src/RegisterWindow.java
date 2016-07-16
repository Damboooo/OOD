import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.*;
import org.jdatepicker.impl.*;

public class RegisterWindow extends JFrame {
	private JTextField[] textField = new JTextField[4];
	private JLabel[] label = new JLabel[6];
    private JPanel panel;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

	public RegisterWindow(User user) {
		setBounds(300, 100, 800, 600);
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		setVisible(true);
		
		for (int i = 0; i < 4; i++) {	
			int j = 0;
			if (i>2)
				j=1;
	
		       createTextField("" , 480-300*j,40+30*(i%3),120,25);
	   	}
		 createLabel("نام:" , 630,40,70,25);
		 createLabel("نام خانوادگی:" , 630,40+30,70,25);
		 createLabel("کد ملی:" , 630,40+30*2,70,25);
		 createLabel("نام کاربری:" , 630-300,40,70,25);
		 createLabel("کلمه عبور:" , 630-300,40+30*1,70,25);
		 createLabel("تکرار کلمه عبور:" , 630-300,40+30*2,70,25);
		 
		passwordField1 = new JPasswordField();
		passwordField1.setSize(120, 25);
		passwordField1.setLocation(180,70);
		panel.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setSize(120, 25);
		passwordField2.setLocation(180,100);
		panel.add(passwordField2);
		

		createLabel("تاریخ تولد:" , 630,130,70,25);
		//JDatePicker datePicker = new JDatePicker();
			datePicker();
	}
	private void createLabel(String s , int x , int y , int w , int h){
		JLabel label = new JLabel(s);
		label.setSize(w,h);
		label.setLocation(x,y);
		panel.add(label);
	}
   private void createTextField(String s , int x , int y , int w , int h){
		JTextField t = new JTextField(s);
		t.setSize(w,h);
		t.setLocation(x,y);
		panel.add(t);
	}
	
   private void datePicker(){
	   UtilDateModel model = new UtilDateModel();
	 //model.setDate(20,04,2014);
	 // Need this...
	 Properties p = new Properties();
	 p.put("text.today", "Today");
	 p.put("text.month", "Month");
	 p.put("text.year", "Year");
	 
	 JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	 // Don't know about the formatter, but there it is...
	 JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

   }
}
 class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}
