package code;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class ShowMemberScreen {

    private JFrame showFrame = new JFrame("Membership Management System");
    private JPanel showPanel;
    private JTable membersTable;

    ShowMemberScreen() {

        showPanel = new JPanel();

        showPanel.setLayout(new BorderLayout());
        String column[] = {"MemberID", "Member Type", "Full Name", "DOB", "Joining Date", "Gender", "Address", "Contact", "Injuries", "Guidance", "Amount Paid", "Balance"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        membersTable = new JTable(tableModel);
        if (ClubMembership.db.members.isEmpty()) {
            JOptionPane.showMessageDialog(showFrame, "The database is empty!");
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        for (Member M : ClubMembership.db.members) {
            Object[] row = {M.getMemberShipNumber(), M.getMemberType(), M.getFirstName() + " " + M.getLastName(), formatter.format(M.getDateOfBirth()), M.getDateOfJoining(), M.getGender(), M.getAddress(), M.getContact(), M.getHealthInfo().isBreathingProblem(), M.getHealthInfo().isDiabeticProblem(), M.getAmountPaid(), M.getBalance()};
            tableModel.addRow(row);
        }

        showPanel.add(new JScrollPane(membersTable));
        showFrame.add(showPanel);
        showFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showFrame.setSize(850, 500);
        showFrame.setVisible(true);
    }
}
