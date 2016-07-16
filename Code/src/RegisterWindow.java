import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame {
	private JTextField[] textField = new JTextField[6];
	private JLabel[] label = new JLabel[6];
    private JPanel panel;

	public RegisterWindow(User user) {
		setBounds(300, 100, 800, 600);
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		setVisible(true);
		
		for (int i = 0; i < 6; i++) {	
			int j = 0;
			if (i>2)
				j=1;
		textField[i] = new JTextField();
		textField[i].setSize(120, 25);
		textField[i].setLocation(530-200*j,40+30*(i%3));
		panel.add(textField[i]);
		
		label[i] = new JLabel("‰«„:");
		label[i].setSize(60, 25);
		label[i].setLocation(680-200*j,40+30*(i%3));
		panel.add(label[i]);
		}
	}

	
}
