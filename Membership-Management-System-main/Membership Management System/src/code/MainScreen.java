package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author
 */
public class MainScreen extends JFrame implements ActionListener {

    private JFrame mainFrame = new JFrame("Membership Management System");
    private JPanel mainPanel;
    private JLabel Header;
    private JButton insertMemberBtn;
    private JButton searchMemberBtn;
    private JButton deleteMemberBtn;
    private JButton updateMemberBtn;
    private JButton showAllMembersBtn;
    private JButton saveMembersBtn;
    private JButton loadMembersBtn;
    private JButton payFeesBtn;

    MainScreen() {
        setLayout(new BorderLayout());
        JLabel bg = new JLabel(new ImageIcon("/home/kevin/Documents/projo/Membership-Management-System-main/Membership Management System/src/code/image.jpg"));
        bg.setLayout(new FlowLayout());
        //mainFrame.setContentPane(new JLabel(new ImageIcon("/home/kevin/Documents/projo/Membership-Management-System-main/Membership Management System/src/code/image.jpg")));
        mainPanel = new JPanel();
        mainFrame.getContentPane();
        mainPanel.setLayout(null);

        Header = new JLabel("Membership Management System Console");
        insertMemberBtn = new JButton("Insert New Member");
        searchMemberBtn = new JButton("Search Existing Member");
        deleteMemberBtn = new JButton("Delete Existing Member");
        updateMemberBtn = new JButton("Update Existing Member");
        showAllMembersBtn = new JButton("Show All Members");
        saveMembersBtn = new JButton("Save Data");
        loadMembersBtn = new JButton("Load Data");
        payFeesBtn = new JButton("Pay Member Fee");

        Header.setBounds(120, 10, 400, 30);
        insertMemberBtn.setBounds(140, 50, 200, 30);
        searchMemberBtn.setBounds(140, 100, 200, 30);
        deleteMemberBtn.setBounds(140, 150, 200, 30);
        updateMemberBtn.setBounds(140, 200, 200, 30);
        showAllMembersBtn.setBounds(140, 250, 200, 30);
        saveMembersBtn.setBounds(140, 300, 200, 30);
        loadMembersBtn.setBounds(140, 350, 200, 30);
        payFeesBtn.setBounds(140, 400, 200, 30);

        insertMemberBtn.addActionListener(this);
        searchMemberBtn.addActionListener(this);
        showAllMembersBtn.addActionListener(this);
        deleteMemberBtn.addActionListener(this);
        loadMembersBtn.addActionListener(this);
        saveMembersBtn.addActionListener(this);
        updateMemberBtn.addActionListener(this);
        payFeesBtn.addActionListener(this);

        mainPanel.add(Header);
        mainPanel.add(insertMemberBtn);
        mainPanel.add(searchMemberBtn);
        mainPanel.add(deleteMemberBtn);
        mainPanel.add(updateMemberBtn);
        mainPanel.add(showAllMembersBtn);
        mainPanel.add(saveMembersBtn);
        mainPanel.add(loadMembersBtn);
        mainPanel.add(payFeesBtn);

        mainPanel.add(bg);
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 480);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Insert New Member")) {
            InsertMemberScreen insertScreen = new InsertMemberScreen();
        } else if (e.getActionCommand().equals("Search Existing Member")) {
            SearchMemberScreen searchScreen = new SearchMemberScreen();
        } else if (e.getActionCommand().equals("Show All Members")) {
            ShowMemberScreen showScreen = new ShowMemberScreen();
        } else if (e.getActionCommand().equals("Delete Existing Member")) {
            DeleteMemberScreen deleteScreen = new DeleteMemberScreen();
        } else if (e.getActionCommand().equals("Load Data")) {
            try {
                ClubMembership.db.readExcelFile("customerlist.csv");
                JOptionPane.showMessageDialog(this.mainFrame, "Data has been loaded from customerlist.csv!");

            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getActionCommand().equals("Save Data")) {
            try {
                ClubMembership.db.saveToExcelFile("customerlist.csv");
                JOptionPane.showMessageDialog(this.mainFrame, "Data has been Saved from customerlist.csv!");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getActionCommand().equals("Update Existing Member")) {
            UpdateMemberScreen updateScreen = new UpdateMemberScreen();
        } else if (e.getActionCommand().equals("Pay Member Fee")) {
            PayFeeScreen payScreen = new PayFeeScreen();
        }

    }

}
