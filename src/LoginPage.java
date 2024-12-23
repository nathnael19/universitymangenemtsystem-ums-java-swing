import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    static JTextField usernameTextField, passwordTextField;
    static JLabel usernameLabel, passwordLabel, photoLabel;
    static JButton loginbtn, cancelbtn;

    public LoginPage() {
        // For Username
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30, 20, 100, 30);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(130, 20, 150, 30);

        // For Password
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 80, 100, 30);

        passwordTextField = new JTextField();
        passwordTextField.setOpaque(true);
        passwordTextField.setBounds(130, 80, 150, 30);

        // Photo Login
        photoLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("icons/second.jpg");
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        photoLabel.setBounds(300, 30, 200, 150);
        ImageIcon newIcon = new ImageIcon(image);
        photoLabel.setIcon(newIcon);

        // For Login Button
        loginbtn = new JButton("Login");
        loginbtn.setFocusable(false);
        loginbtn.addActionListener(this);
        loginbtn.setBounds(30, 150, 100, 30);
        loginbtn.setBackground(Color.BLACK);
        loginbtn.setForeground(Color.WHITE);

        // For Cancel Button
        cancelbtn = new JButton("Cancel");
        cancelbtn.setFocusable(false);
        cancelbtn.addActionListener(this);
        cancelbtn.setBounds(180, 150, 100, 30);
        cancelbtn.setBackground(Color.BLACK);
        cancelbtn.setForeground(Color.WHITE);

        // Adding Objects To the Frame
        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(photoLabel);
        add(loginbtn);
        add(cancelbtn);

        // Frame Properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocation(380, 250);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    // a function for evaluation
    void loginUser(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            setVisible(false);
            new HomePage();

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");

        }
    }

    public static void main(String[] args) {
        new LoginPage();
        
        //This CreateDataBase Create a database while running for the first time
        new CreateDataBase();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbtn) {
            loginUser(usernameTextField.getText(), passwordTextField.getText());

        } else if (e.getSource() == cancelbtn) {
            System.exit(0);
        }
    }

}
