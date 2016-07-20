package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ResourceManagement.User;

public class PredictMainWindow extends UserWindow {

	private JButton resourcePredictButton;
	private JButton requirementPredictButton;
	private JLabel label;
	
	// private JPanel panel;

	public PredictMainWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");
		
		label = new JLabel("جستجو در پروژه های مشابه برای پیش بینی");
		label.setSize(280, 25);
		label.setLocation(340, 152);
		super.panel.add(label);
		
		resourcePredictButton = new JButton("پیش بینی منابع");
		resourcePredictButton.setSize(180, 25);
		resourcePredictButton.setLocation(300, 230);
		super.panel.add(resourcePredictButton);

		requirementPredictButton = new JButton("پیش بینی نیازمندی های ضروری");
		requirementPredictButton.setSize(180, 25);
		requirementPredictButton.setLocation(300, 280);
		super.panel.add(requirementPredictButton);

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);


		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(270, 210, 250, 170);

		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);

	}

}
