
import java.awt.*;

import javax.swing.*;

public class About extends JFrame {

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int widthSize = (int) Math.round(size.getWidth());
    int heightSize = (int) Math.round(size.getHeight());
    JLabel lbl, description;

    About() {

        lbl = new JLabel("<html>University <br> Management <br>System</html>");
        lbl.setBounds(20, 20, 150, 70);
        lbl.setFont(new Font("serif", Font.BOLD, 20));

        description = new JLabel();
        description.setText("<html><p>This Java Project allows you to add,update and apply withdraw for Students and Teachers and also accepts students assesements and exams.<p><p>It uses MySQL database by XAMPP inorder for saving and other information about students and teachers.</p><br><p>Group Members</p><table><th>Name</th><th>ID</th><tr><td>Nathnael Nigussie<td><td>UGR/31038/15</td></tr><tr><td>Samuel Mandefro<td><td>UGR/31038/15</td></tr><tr><td>Leul Nigussie<td><td>UGR/31038/15</td></tr><tr><td>Waqjira Tessema<td><td>UGR/31038/15</td></tr><tr><td>Filebar Nigussie<td><td>UGR/31038/15</td></tr></table></html>");
        description.setBounds(20, 70, 580, 400);
        description.setFont(new Font("san-serif", Font.PLAIN, 17));

        // Frame Properties
        setVisible(true);
        setLayout(null);
        setSize(600, 500);
        setLocation(400, 120);
        
        //Adding to Frames
        add(lbl);
        add(description);

    }

}
