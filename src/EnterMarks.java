import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class EnterMarks extends JFrame implements ActionListener {
    JButton submitButton, cancelButton;
    JLabel heading, semesterLabel, subjectLabel, markLabel;
    JTextField sub1, sub2, sub3, sub4, sub5, mark1, mark2, mark3, mark4, mark5;

    JComboBox idBox, semesterBox;
    Choice idChoice;

    EnterMarks() {

        JLabel photoLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("icons/exam.jpg");
        Image image = imageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        photoLabel.setBounds(400, 2, 400, 300);
        ImageIcon newIcon = new ImageIcon(image);
        photoLabel.setIcon(newIcon);
        
        // Heading
        heading = new JLabel("Search by ID number");
        heading.setBounds(30, 20, 150, 30);

        // Choise
        idChoice = new Choice();
        idChoice.setBounds(185, 20, 150, 30);

        // Semester
        semesterLabel = new JLabel("Select a Semester");
        semesterLabel.setBounds(30, 70, 150, 30);

        String semester[] = {"1st Semester", "2nd Semester"};
        // Choise
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(185, 70, 150, 30);

        // Getting Data From Students Table and Using it as an input for our choise box
        String query = "SELECT * FROM `students`";

        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(query);

            while (resultSet.next()) {
                idChoice.add(resultSet.getString("id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        //Subject
        subjectLabel = new JLabel("Subjects");
        subjectLabel.setBounds(30, 120, 100, 20);

        //Mark
        markLabel = new JLabel("Marks");
        markLabel.setBounds(200, 120, 100, 20);

        sub1 = new JTextField();
        sub1.setBounds(30, 150, 140, 30);

        sub2 = new JTextField();
        sub2.setBounds(30, 190, 140, 30);

        sub3 = new JTextField();
        sub3.setBounds(30, 230, 140, 30);

        sub4 = new JTextField();
        sub4.setBounds(30, 270, 140, 30);

        sub5 = new JTextField();
        sub5.setBounds(30, 310, 140, 30);

        mark1 = new JTextField();
        mark1.setBounds(200, 150, 140, 30);

        mark2 = new JTextField();
        mark2.setBounds(200, 190, 140, 30);

        mark3 = new JTextField();
        mark3.setBounds(200, 230, 140, 30);

        mark4 = new JTextField();
        mark4.setBounds(200, 270, 140, 30);

        mark5 = new JTextField();
        mark5.setBounds(200, 310, 140, 30);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(40, 370, 110, 30);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(180, 370, 110, 30);

        // Adding to Frame
        add(submitButton);
        add(cancelButton);
        add(idChoice);
        add(heading);
        add(semesterLabel);
        add(semesterBox);
        add(photoLabel);
        add(subjectLabel);
        add(markLabel);
        add(sub1);
        add(sub2);
        add(sub3);
        add(sub4);
        add(sub5);
        add(mark1);
        add(mark2);
        add(mark3);
        add(mark4);
        add(mark5);

        // Frame Properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 450);
        setLocation(410, 130);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {

            String id = idChoice.getSelectedItem();
            String sem = semesterBox.getSelectedItem().toString();

            String s1 = sub1.getText();
            String m1 = mark1.getText();
            String s2 = sub2.getText();
            String m2 = mark2.getText();
            String s3 = sub3.getText();
            String m3 = mark3.getText();

            String s4 = sub4.getText();
            String m4 = mark4.getText();

            String s5 = sub5.getText();
            String m5 = mark5.getText();

            //Inserting Data into subject and mark table
            String query = "INSERT INTO `subject` (`id`,`semester`,`sub1`,`sub2`,`sub3`,`sub4`,`sub5`) VALUES (?,?,?,?,?,?,?)";
            String query2 = "INSERT INTO `mark` (`id`,`semester`,`mark1`,`mark2`,`mark3`,`mark4`,`mark5`) VALUES (?,?,?,?,?,?,?)";

            MySQLDatabase database = new MySQLDatabase();

            try (Connection connection = database.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);

                preparedStatement.setString(1, id);
                preparedStatement.setString(2, sem);
                preparedStatement.setString(3, s1);
                preparedStatement.setString(4, s2);
                preparedStatement.setString(5, s3);
                preparedStatement.setString(6, s4);
                preparedStatement.setString(7, s5);

                preparedStatement2.setString(1, id);
                preparedStatement2.setString(2, sem);
                preparedStatement2.setString(3, m1);
                preparedStatement2.setString(4, m2);
                preparedStatement2.setString(5, m3);
                preparedStatement2.setString(6, m4);
                preparedStatement2.setString(7, m5);

                preparedStatement2.executeUpdate();

                preparedStatement.executeUpdate();
            } catch (SQLException de) {
                // TODO Auto-generated catch block
                System.err.println(de.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Succesfully Added!!");
            setVisible(false);

        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }

}
