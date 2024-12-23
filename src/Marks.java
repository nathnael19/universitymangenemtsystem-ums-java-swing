import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame implements ActionListener {

    String idNum;
    JLabel idlbl, myId, semester, semesterName;
    JButton cancelButton;

    Marks(String idNum) {
        this.idNum = idNum;

        JLabel heading = new JLabel("ASTU");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(200, 10, 400, 20);

        JLabel heading2 = new JLabel("Result of Examination 2024");
        heading2.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading2.setBounds(100, 40, 400, 20);

        idlbl = new JLabel("ID Number " + idNum);
        idlbl.setFont(new Font("Tahoma", Font.ITALIC, 16));
        idlbl.setBounds(30, 80, 250, 20);

        semester = new JLabel("Semester");
        semester.setBounds(30, 110, 100, 20);

        semesterName = new JLabel();
        semesterName.setBounds(120, 110, 100, 20);

        JLabel sub1 = new JLabel();
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sub1.setBounds(30, 150, 100, 20);

        JLabel sub2 = new JLabel();
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sub2.setBounds(30, 180, 100, 20);

        JLabel sub3 = new JLabel();
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sub3.setBounds(30, 210, 100, 20);

        JLabel sub4 = new JLabel();
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sub4.setBounds(30, 240, 100, 20);

        JLabel sub5 = new JLabel();
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sub5.setBounds(30, 270, 100, 20);

        String query1 = "SELECT * FROM `subject` WHERE id ='" + idNum + "'";
        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(query1);

            while (resultSet.next()) {
                semesterName.setText(resultSet.getString("semester"));
                sub1.setText(resultSet.getString("sub1"));
                sub2.setText(resultSet.getString("sub2"));
                sub3.setText(resultSet.getString("sub3"));
                sub4.setText(resultSet.getString("sub4"));
                sub5.setText(resultSet.getString("sub5"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query2 = "SELECT * FROM `mark` WHERE id ='" + idNum + "'";
        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(query2);

            while (resultSet.next()) {
                semesterName.setText(resultSet.getString("semester"));

                sub1.setText("<html><table><tr>" + sub1.getText() + "<td>" + resultSet.getString("mark1") + "</td><td></td></tr></table></html>");
                sub2.setText("<html><table><tr>" + sub2.getText() + "<td>" + resultSet.getString("mark2") + "</td><td></td></tr></table></html>");
                sub3.setText("<html><table><tr>" + sub3.getText() + "<td>" + resultSet.getString("mark3") + "</td><td></td></tr></table></html>");
                sub4.setText("<html><table><tr>" + sub4.getText() + "<td>" + resultSet.getString("mark4") + "</td><td></td></tr></table></html>");
                sub5.setText("<html><table><tr>" + sub5.getText() + "<td>" + resultSet.getString("mark5") + "</td><td></td></tr></table></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(370, 400, 100, 30);

        // Adding to Frame
        add(heading);
        add(heading2);
        add(idlbl);
        add(sub1);
        add(sub2);
        add(sub3);
        add(sub4);
        add(sub5);
        add(semester);
        add(semesterName);
        add(cancelButton);

        // Frame Properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 500);
        setLocation(400, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelButton) {
            setVisible(false);
        }

    }

}
