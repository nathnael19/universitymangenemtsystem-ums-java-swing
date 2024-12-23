import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ExaminationResult extends JFrame implements ActionListener {

    JButton submitButton, cancelButton;
    JTextField search;
    JTable table;

    ExaminationResult() {
        //Heading
        JLabel heading = new JLabel("Check Results");
        heading.setFont(new Font("serif", Font.BOLD, 17));
        heading.setBounds(50, 20, 200, 30);

        //Search
        search = new JTextField();
        search.setBounds(50, 70, 150, 30);
        search.setEditable(false);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(230, 70, 100, 30);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(370, 70, 100, 30);

        table = new JTable();

        try {
            GetMyData data = new GetMyData();
            String query = "SELECT * FROM `students`";
            ResultSet resultSet = data.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();

        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 120, 850, 300);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 0).toString());

            }

        });

        // Adding to Frame
        add(heading);
        add(search);
        add(submitButton);
        add(cancelButton);
        add(jScrollPane);

        // Frame Properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 400);
        setLocation(300, 160);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            new Marks(search.getText());
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }

    }

}
