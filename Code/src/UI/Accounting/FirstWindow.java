package UI.Accounting;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow extends JFrame {


    private JButton loginButton;
    private JButton registerButton;
    private JPanel panel;

    public FirstWindow() {
        //setLayout(null);
        setTitle("خوش آمدید");
        setSize(400, 200);
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        setVisible(true);

        loginButton = new JButton("ورود");
        loginButton.setSize(80, 25);
        loginButton.setLocation(150, 50);
        loginButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        panel.add(loginButton);

        registerButton = new JButton("ثبت نام");
        registerButton.setSize(80, 25);
        registerButton.setLocation(150, 85);
        registerButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
            	register();
            }
        });
        panel.add(registerButton);


    }


    private void login() {
        // display/center the jdialog when the button is pressed
        LoginWindow lw = new LoginWindow();
        dispose();
    }

    private void register() {
        // display/center the jdialog when the button is pressed
        RegisterWindow rw = new RegisterWindow(null);
        dispose();
    }
}
