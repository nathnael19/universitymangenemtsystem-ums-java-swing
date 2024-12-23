import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class StudentLeave extends JFrame implements ActionListener {

    JButton submitButton, cancelButton;
    JLabel heading, heading2, dateLabel;
    @SuppressWarnings("rawtypes")
    JComboBox timeBox;
    Choice idChoice;
    JDateChooser dateChooser;

    StudentLeave() {
        // Heading
        heading = new JLabel("Apply Leave (Student)");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setBounds(40, 50, 400, 30);

        // Search by Id
        heading2 = new JLabel("Search by Id No");
        heading2.setBounds(40, 100, 400, 30);

        // Choise
        idChoice = new Choice();
        idChoice.setBounds(40, 130, 200, 25);

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

        // Date
        dateLabel = new JLabel("Date");
        dateLabel.setBounds(40, 180, 100, 30);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(40, 210, 200, 30);

        // Time Duration
        heading2 = new JLabel("Time Duration");
        heading2.setBounds(40, 260, 400, 30);

        // Id ComboBox
        String[] timeStrings = {"Full Day", "", ""};
        timeBox = new JComboBox<>(timeStrings);
        timeBox.setBounds(40, 290, 200, 30);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(40, 360, 110, 30);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(180, 360, 110, 30);

        // Adding to Frame
        add(heading);
        //
        add(heading2);
        //
        add(idChoice);
        //
        add(dateLabel);
        //
        add(dateChooser);
        //
        add(timeBox);
        //
        add(submitButton);
        //
        add(cancelButton);

        // Frame Properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(490, 500);
        setLocation(410, 130);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String id = idChoice.getSelectedItem();
            String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String duration = timeBox.getSelectedItem().toString();

            String queryy = "INSERT INTO `studentleave` (`id`,`date`,`duration`) VALUES (?,?,?)";
            MySQLDatabase database = new MySQLDatabase();

            try (Connection connection = database.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(queryy);

                preparedStatement.setString(1, id);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, duration);

                preparedStatement.executeUpdate();
            } catch (SQLException de) {
                // TODO Auto-generated catch block
                de.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Succesfully Added!!");
            setVisible(false);

        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }

}
