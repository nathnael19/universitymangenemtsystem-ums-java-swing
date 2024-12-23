import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener {

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int widthSize = (int) Math.round(size.getWidth());
    int heightSize = (int) Math.round(size.getHeight());

    HomePage() {
        setTitle("ADAMA SCIENCE AND TECHNOLOGY UNIVERSITY STUDENT MANAGEMENT SYSTEM");
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(50, 100);
        setJMenuBar(menuBar);

        // Photo
        JLabel photoLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("icons/third.jpg");
        Image image = imageIcon.getImage().getScaledInstance(widthSize, heightSize, Image.SCALE_DEFAULT);
        photoLabel.setBounds(0, 0, widthSize, heightSize);
        ImageIcon newIcon = new ImageIcon(image);
        photoLabel.setIcon(newIcon);

        // New Informations Menu
        JMenu newInformation = new JMenu("New Informations");
        JMenuItem newInfoItem = new JMenuItem("New Teacher Information");
        newInfoItem.addActionListener(this);
        JMenuItem newInfoItem2 = new JMenuItem("New Student Information");
        newInfoItem2.addActionListener(this);

        newInformation.add(newInfoItem);
        newInformation.add(newInfoItem2);

        // View Details Menu
        JMenu viewDetails = new JMenu("View Details");
        JMenuItem viewDetailsItem1 = new JMenuItem("View Teacher Details");
        viewDetailsItem1.addActionListener(this);
        JMenuItem viewDetailsItem2 = new JMenuItem("View Student Details");
        viewDetailsItem2.addActionListener(this);

        viewDetails.add(viewDetailsItem1);
        viewDetails.add(viewDetailsItem2);

        // Apply Leave Menu
        JMenu applyLeave = new JMenu("Apply Leave");
        JMenuItem applyLeaveItem1 = new JMenuItem("Teacher Leave");
        applyLeaveItem1.addActionListener(this);
        JMenuItem applyLeaveItem2 = new JMenuItem("Student Leave");
        applyLeaveItem2.addActionListener(this);

        applyLeave.add(applyLeaveItem1);
        applyLeave.add(applyLeaveItem2);

        // Leave Detail Menu
        JMenu leaveDetail = new JMenu("Leave Detail");
        JMenuItem leaveDetailItem1 = new JMenuItem("Teacher Leave Details");
        leaveDetailItem1.addActionListener(this);
        JMenuItem leaveDetailItem2 = new JMenuItem("Student Leave Details");
        leaveDetailItem2.addActionListener(this);

        leaveDetail.add(leaveDetailItem1);
        leaveDetail.add(leaveDetailItem2);

        // Examination Menu
        JMenu examinationJMenu = new JMenu("Examination");
        JMenuItem examinatioMenuItem1 = new JMenuItem("Examination Result");
        examinatioMenuItem1.addActionListener(this);
        JMenuItem examinationMenuItem2 = new JMenuItem("Enter Mark");
        examinationMenuItem2.addActionListener(this);

        examinationJMenu.add(examinatioMenuItem1);
        examinationJMenu.add(examinationMenuItem2);

        // Update Detail Menu
        JMenu updataDetailJMenu = new JMenu("Update Detail");
        JMenuItem updateDetailItem1 = new JMenuItem("Update Teacher Information");
        updateDetailItem1.addActionListener(this);
        JMenuItem updateDetailItem2 = new JMenuItem("Update Student Information");
        updateDetailItem2.addActionListener(this);

        updataDetailJMenu.add(updateDetailItem1);
        updataDetailJMenu.add(updateDetailItem2);

        // Utility Menu
        JMenu utilityJMenu = new JMenu("Utility");
        JMenuItem utilityJMenuItem1 = new JMenuItem("Notepad");
        utilityJMenuItem1.addActionListener(this);
        JMenuItem utitlityJMenuItem2 = new JMenuItem("Calculator");
        utitlityJMenuItem2.addActionListener(this);

        utilityJMenu.add(utilityJMenuItem1);
        utilityJMenu.add(utitlityJMenuItem2);

        // Exit Menu
        JMenu exitJMenu = new JMenu("Exit");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        exitJMenu.add(exit);

        // About Menu
        JMenu aboutMenu = new JMenu("About");
        JMenuItem abtMenu = new JMenuItem("About");
        aboutMenu.add(abtMenu);
        abtMenu.addActionListener(this);

        // Adding Menu Bars
        menuBar.add(newInformation);
        menuBar.add(viewDetails);
        menuBar.add(applyLeave);
        menuBar.add(leaveDetail);
        menuBar.add(examinationJMenu);
        menuBar.add(updataDetailJMenu);
        menuBar.add(utilityJMenu);
        menuBar.add(aboutMenu);
        menuBar.add(exitJMenu);

        // Frame Properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(widthSize, heightSize);
        add(photoLabel);
        setVisible(true);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {

        String msg = e.getActionCommand();
        if (msg.equals("Exit")) {
            System.exit(0);
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("New Teacher Information")) {
            new AddTeacher();
        } else if (msg.equals("Teacher Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Student Leave Details")) {
            new TeacherLeaveDetail();
        } else if (msg.equals("Teacher Leave Details")) {
            new StudentLeaveDetail();
        } else if (msg.equals("About")) {
            new About();
        } else if (msg.equals("Update Teacher Information")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Information")) {
            new UpdateStudent();
        } else if (msg.equals("View Teacher Details")) {
            new ViewTeacher();
        } else if (msg.equals("View Student Details")) {
            new ViewStudent();
        } else if (msg.equals("Enter Mark")) {
            new EnterMarks();
        } else if (msg.equals("Examination Result")) {
            new ExaminationResult();
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

}
