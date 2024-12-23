import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {

    JLabel firstNameLabel, lastNameLabel, rollNumberLabel, rollNumberId, dobLabel, addressLabel, phoneLabel, emailLabel,
            departmentLabel;
    JTextField firstNameTextField, lastNameTextField, addressTextField, phoneTextField, emailTextField;
    @SuppressWarnings("rawtypes")
    JComboBox departmentComboBox;
    JDateChooser dobDateChooser;
    JButton submitButton, cancelButton;

    static Random random = new Random();
    static long idNum = Math.abs(random.nextLong() % 80000);
    String idNumber = ""+idNum;

    @SuppressWarnings({"rawtypes", "unchecked"})
    AddTeacher() {
        // Heading Title
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(200, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 26));
        // First Name
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(30, 80, 90, 30);

        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(150, 80, 150, 30);

        // Last Name
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(350, 80, 90, 30);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(470, 80, 150, 30);

        // Roll Number
        rollNumberLabel = new JLabel("ID No.");
        rollNumberLabel.setBounds(30, 120, 90, 30);

        // Roll Number ID
        rollNumberId = new JLabel(idNumber);
        rollNumberId.setBounds(150, 120, 150, 30);

        // Date of Birth
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(350, 120, 90, 30);

        dobDateChooser = new JDateChooser();
        dobDateChooser.setBounds(470, 120, 150, 30);

        // Address
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(30, 160, 90, 30);

        addressTextField = new JTextField();
        addressTextField.setBounds(150, 160, 150, 30);

        // Phone Number
        phoneLabel = new JLabel("Phone No");
        phoneLabel.setBounds(350, 160, 160, 30);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(470, 160, 150, 30);

        // Email
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(30, 200, 90, 30);

        emailTextField = new JTextField();
        emailTextField.setBounds(150, 200, 150, 30);

        // Department
        String[] departments = {"Software Engineering", "Computer Science", "Mechanical Engineering",
            "Chemical Engineering", "Power and Control", "Electronics and Comunication", "Material Engineering",
            "Architecture", "Water Resource", "Civil Engineering", "Pharmacy", "Geology", "Applied Mathematics",
            "Applied Physics", "Applied Biology"};

        departmentLabel = new JLabel("Department");
        departmentLabel.setBounds(350, 200, 90, 30);

        departmentComboBox = new JComboBox(departments);
        departmentComboBox.setBounds(470, 200, 150, 30);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(230, 300, 110, 30);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(
                380, 300, 110, 30);

        // Adding to Frame
        add(heading);
        //
        add(firstNameLabel);
        add(firstNameTextField);
        //
        add(lastNameLabel);
        add(lastNameTextField);
        //
        add(rollNumberLabel);
        add(rollNumberId);
        //
        add(dobLabel);
        add(dobDateChooser);
        //
        add(addressLabel);
        add(addressTextField);
        //
        add(phoneLabel);
        add(phoneTextField);
        //
        add(emailLabel);
        add(emailTextField);
        //
        add(departmentLabel);
        add(departmentComboBox);

        //
        add(submitButton);
        //
        add(cancelButton);

        // Frame Properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocation(370, 160);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String id = idNumber;
            String dob = ((JTextField) dobDateChooser.getDateEditor().getUiComponent()).getText();
            String address = addressTextField.getText();
            String phoneNumber = phoneTextField.getText();
            String email = emailTextField.getText();
            String department = departmentComboBox.getSelectedItem().toString();

            // Exeption Handling Method
            while (!(firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || address.isEmpty()
                    || phoneNumber.isEmpty() || email.isEmpty())) {

                String query = "INSERT INTO `teachers` (`id`,`firstName`,`lastName`,`dob`,`address`,`phoneNumber`,`email`,`department`) VALUES (?,?,?,?,?,?,?,?)";
                MySQLDatabase database = new MySQLDatabase();

                try (Connection connection = database.getConnection()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, firstName);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setString(4, dob);
                    preparedStatement.setString(5, address);
                    preparedStatement.setString(6, phoneNumber);
                    preparedStatement.setString(7, email);
                    preparedStatement.setString(8, department);

                    preparedStatement.executeUpdate();
                } catch (SQLException de) {
                    // TODO Auto-generated catch block
                    de.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Succesfully Added!!");
                setVisible(false);
                break;

            }

        } else if (e.getSource() == cancelButton) {
            setVisible(false);

        }

    }

}
