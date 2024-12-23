import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JLabel firstNameLabel, lastNameLabel, rollNumberLabel, dobLabel, addressLabel, phoneLabel, emailLabel,
            departmentLabel, dobDateChooser, firstName, lastName, idlbl, department;
    JTextField addressTextField, phoneTextField, emailTextField;

    JButton submitButton, cancelButton;
    Choice idChoice;

    UpdateTeacher() {
        // Heading Title
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(200, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 25));

        // Heading
        JLabel heading2 = new JLabel("Select ID number");
        heading2.setBounds(30, 60, 150, 30);

        // Choise
        idChoice = new Choice();
        idChoice.setBounds(185, 60, 150, 30);

        String queryId = "SELECT * FROM `teachers`";

        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(queryId);

            while (resultSet.next()) {
                idChoice.add(resultSet.getString("id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        // First Name
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(30, 120, 90, 30);

        firstName = new JLabel();
        firstName.setBounds(150, 120, 150, 30);
        firstName.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Last Name
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(350, 120, 90, 30);

        lastName = new JLabel();
        lastName.setBounds(470, 120, 150, 30);

        lastName.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Roll Number
        rollNumberLabel = new JLabel("ID No.");
        rollNumberLabel.setBounds(30, 160, 90, 30);

        // Roll Number ID
        idlbl = new JLabel();
        idlbl.setBounds(150, 160, 150, 30);

        idlbl.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Date of Birth
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(350, 160, 90, 30);

        dobDateChooser = new JLabel();
        dobDateChooser.setBounds(470, 160, 150, 30);
        dobDateChooser.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Address
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(30, 200, 90, 30);

        addressTextField = new JTextField();
        addressTextField.setBounds(150, 200, 150, 30);

        // Phone Number
        phoneLabel = new JLabel("Phone No");
        phoneLabel.setBounds(350, 200, 160, 30);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(470, 200, 150, 30);

        // Email
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(30, 240, 90, 30);

        emailTextField = new JTextField();
        emailTextField.setBounds(150, 240, 150, 30);

        // Department
        departmentLabel = new JLabel("Department");
        departmentLabel.setBounds(350, 240, 90, 30);

        department = new JLabel();
        department.setBounds(470, 240, 200, 30);

        department.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Submit Button
        submitButton = new JButton("Update");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(230, 320, 110, 30);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(
                380, 320, 110, 30);

        String queryUpdate = "SELECT * FROM `students` WHERE id='" + idChoice.getSelectedItem() + "'";

        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(queryUpdate);

            while (resultSet.next()) {
                firstName.setText(resultSet.getString("firstName"));
                lastName.setText(resultSet.getString("lastName"));
                idlbl.setText(resultSet.getString("id"));
                dobDateChooser.setText(resultSet.getString("dob"));
                department.setText(resultSet.getString("department"));
                addressTextField.setText(resultSet.getString("address"));
                phoneTextField.setText(resultSet.getString("phoneNumber"));
                emailTextField.setText(resultSet.getString("email"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        idChoice.addItemListener((ItemEvent ie) -> {
            String queryFirstName = "SELECT * FROM `teachers` WHERE id='" + idChoice.getSelectedItem() + "'";

            try {
                GetMyData data = new GetMyData();
                ResultSet resultSet = data.statement.executeQuery(queryFirstName);

                while (resultSet.next()) {
                    firstName.setText(resultSet.getString("firstName"));
                    lastName.setText(resultSet.getString("lastName"));
                    idlbl.setText(resultSet.getString("id"));
                    dobDateChooser.setText(resultSet.getString("dob"));
                    department.setText(resultSet.getString("department"));
                    addressTextField.setText(resultSet.getString("address"));
                    phoneTextField.setText(resultSet.getString("phoneNumber"));
                    emailTextField.setText(resultSet.getString("email"));
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        });

        // Adding to Frame
        add(heading);
        //
        add(firstNameLabel);
        add(firstName);
        //
        add(lastNameLabel);
        add(lastName);
        //
        add(rollNumberLabel);
        add(idlbl);
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
        add(department);

        add(heading2);
        add(idChoice);

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
            String id = idlbl.toString();
            String address = addressTextField.getText();
            String phoneNumber = phoneTextField.getText();
            String email = emailTextField.getText();

            // Exeption Handling Method
            while (!(address.isEmpty()
                    || phoneNumber.isEmpty() || email.isEmpty())) {

                String query = "UPDATE `students` SET `address`='" + address + "',`phoneNumber`='" + phoneNumber + "',`email`='" + email + "' WHERE id='" + id + "'";
                try {

                    GetMyData data = new GetMyData();
                    data.statement.executeQuery(query);

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
