package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JButton signInButton;
    private JButton signUpButton;
    private JTextField textField1;
    private JPasswordField passwordField1;


    public void ButtonSignInAdmin(ActionListener e)
    {
        signInButton.addActionListener(e);
    }

    public void ButtonSignInCasier(ActionListener e)
    {
        signUpButton.addActionListener(e);
    }

    public LoginView()
    {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }
}
