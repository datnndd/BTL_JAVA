package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

import model.entity.User;

public class LoginView extends JFrame implements ActionListener{
    @Serial
    private static final long serialVersionUID = 1L;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        init();
    }
    private void init() {
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        loginButton.addActionListener(this);

        BorderLayout layout = new BorderLayout();

        JPanel panelElements = new JPanel(new GridLayout(2, 2));
        panelElements.setBorder(new EmptyBorder(10,10,10,10));
        panelElements.add(usernameLabel);
        panelElements.add(usernameField);
        panelElements.add(passwordLabel);
        panelElements.add(passwordField);

        JPanel panelLogin = new JPanel(new FlowLayout());
        panelLogin.add(loginButton);
        panelLogin.setBorder(new EmptyBorder(0,10,10,10));

        this.setLayout(layout);
        this.add(panelElements, BorderLayout.CENTER);
        this.add(panelLogin, BorderLayout.SOUTH);
        this.pack();
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(usernameField.getText(), String.valueOf(passwordField.getPassword()));
    }
    public void actionPerformed(ActionEvent e) {}
    public void addLoginButtonListener(ActionListener l) {
        loginButton.addActionListener(l);
    }
}
