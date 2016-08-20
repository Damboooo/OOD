package UI.Predict;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ResourceManagement.User;
import UI.Accounting.LoginWindow;
import UI.Accounting.FirstWindow;


public class PredictMainWindow extends UserWindow {

    private JButton resourcePredictButton;
    private JButton requirementPredictButton;
//	private JLabel label;

    // private JPanel panel;

    public PredictMainWindow(final User user) {
        super(user);
        setTitle("پنل پیش بینی");

//		label = new JLabel("جستجو در پروژه های مشابه برای پیش بینی");
//		label.setSize(280, 25);
//		label.setLocation(340, 152);
//		super.panel.add(label);

        resourcePredictButton = new JButton("پیش بینی منابع");
        resourcePredictButton.setSize(180, 25);
        resourcePredictButton.setLocation(300, 230);
        super.panel.add(resourcePredictButton);
        resourcePredictButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            resourcePredict();
            }
        });

        requirementPredictButton = new JButton("پیش بینی نیازمندی های ضروری");
        requirementPredictButton.setSize(180, 25);
        requirementPredictButton.setLocation(300, 280);
        super.panel.add(requirementPredictButton);
        requirementPredictButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            requirementPredict();
            }
        });
    }

    //@Override
//	public void paint(Graphics g) {
//		Graphics2D g2 = (Graphics2D) g;
//		super.paint(g2);
//
//
//		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
//				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
//		g2.setStroke(dashed);
//		g2.drawRect(270, 210, 250, 170);
//
//		// Stroke simple = new BasicStroke(1, BasicStroke.JOIN_ROUND,
//		// BasicStroke.JOIN_ROUND, 0, new float[]{5},0);
//
//	}

    public void resourcePredict() {
   
        ResourcePredictWindow rpw = new ResourcePredictWindow(user);
        dispose();

    }

    public void requirementPredict() {
    	RequirementPredictWindow qpw = new RequirementPredictWindow(user);
    	dispose();

    }

}
