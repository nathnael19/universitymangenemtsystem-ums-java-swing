import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetail extends JFrame implements ActionListener {

    JLabel heading;
    Choice idChoice;
    JTable table;
    JScrollPane jScrollPane;
    JButton search, print, update, add, cancel;

    public TeacherLeaveDetail() {
        // Heading
        heading = new JLabel("Search by ID number");
        heading.setBounds(30, 20, 150, 30);

        // Choise
        idChoice = new Choice();
        idChoice.setBounds(185, 20, 150, 30);

        String query = "SELECT * FROM `teacherleave`";

        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(query);

            while (resultSet.next()) {
                idChoice.add(resultSet.getString("id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Table
        table = new JTable();

        try {
            GetMyData data = new GetMyData();
            ResultSet resultSet = data.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();

        }

        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 100, 700, 430);

        // Search
        search = new JButton("Search");
        search.setBounds(30, 60, 100, 20);
        search.setFocusable(false);
        search.addActionListener(this);

        // Print
        print = new JButton("Print");
        print.setBounds(140, 60, 100, 20);
        print.setFocusable(false);
        print.addActionListener(this);

        // Search
        add = new JButton("Add");
        add.setBounds(250, 60, 100, 20);
        add.setFocusable(false);
        add.addActionListener(this);

        // Update
        update = new JButton("Update");
        update.setBounds(360, 60, 100, 20);
        update.setFocusable(false);
        update.addActionListener(this);

        // Cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(470, 60, 100, 20);
        cancel.setFocusable(false);
        cancel.addActionListener(this);

        // Adding to the Frame
        add(heading);
        add(idChoice);
        add(jScrollPane);
        add(search);
        add(print);
        add(add);
        add(update);
        add(cancel);

        // Frame Properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocation(370, 160);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "SELECT * FROM `teacherleave` WHERE id = '" + idChoice.getSelectedItem() + "'";
            try {

                GetMyData data = new GetMyData();
                ResultSet resultSet = data.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            } catch (Exception ke) {
                // TODO: handle exception
            }

        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (PrinterException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == add) {
            new TeacherLeave();

        } else if (e.getSource() == update) {

        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

}
