package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author
 */
public class PayFeeScreen extends JFrame implements ActionListener {

    private JFrame PayFrame = new JFrame("Membership Management System");
    private JPanel PayPanel;

    private JLabel Header;
    private JLabel memberShipID;
    private JLabel memberType;
    private JLabel memberName;
    private JLabel balanceAmount;
    private JTextField membershipIDInput;
    private JButton payBtn;
    private JButton searchBtn;

    PayFeeScreen() {
        PayPanel = new JPanel();
        PayFrame.getContentPane();
        PayPanel.setLayout(null);

        Header = new JLabel("Payment Screen");

        memberShipID = new JLabel("Please specify membership number: ");
        memberType = new JLabel("Member Type: ");
        memberName = new JLabel("Welcome Mr. : ");
        balanceAmount = new JLabel("Your Balance Amount is: ");

        membershipIDInput = new JTextField();

        payBtn = new JButton("Pay Fee");
        payBtn.addActionListener(this);
        payBtn.setEnabled(false);

        searchBtn = new JButton("Fetch Amount");

        searchBtn.addActionListener(this);

        PayPanel.add(Header);
        PayPanel.add(memberShipID);
        PayPanel.add(memberType);
        PayPanel.add(memberName);
        PayPanel.add(balanceAmount);
        PayPanel.add(membershipIDInput);
        PayPanel.add(payBtn);
        PayPanel.add(searchBtn);

        Header.setBounds(150, 0, 400, 30);
        memberShipID.setBounds(10, 30, 250, 20);
        membershipIDInput.setBounds(230, 30, 120, 25);

        memberName.setBounds(10, 60, 300, 30);
        memberType.setBounds(10, 80, 300, 20);
        balanceAmount.setBounds(10, 100, 300, 20);

        searchBtn.setBounds(45, 200, 150, 25);

        payBtn.setBounds(180, 200, 150, 25);

        PayFrame.add(PayPanel);
        PayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PayFrame.setSize(400, 400);
        PayFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Pay Fee")) {
            Member getMember = ClubMembership.db.SearchMember(this.membershipIDInput.getText());
            if (getMember.getBalance() == 0) {
                JOptionPane.showMessageDialog(PayFrame,
                        "Member with ID : " + this.membershipIDInput.getText() + " has no pending dues");;
            } else {
                ClubMembership.db.payMemberFee(this.membershipIDInput.getText());
                this.payBtn.setEnabled(true);
                JOptionPane.showMessageDialog(PayFrame,
                        "Member with ID : " + this.membershipIDInput.getText() + " Fees has been Paid!");

                memberType.setText("Member Type: ");
                memberName.setText("Welcome Mr. : ");
                balanceAmount.setText("Your Balance Amount is: ");
            }

        } else if (e.getActionCommand().equals("Fetch Amount")) {
            Member getMember = ClubMembership.db.SearchMember(this.membershipIDInput.getText());
            if (getMember == null) {
                JOptionPane.showMessageDialog(PayFrame, "Member with ID : " + this.membershipIDInput.getText() + " not Found!");
            } else {
                this.memberType.setText(this.memberType.getText() + getMember.getMemberType());
                this.memberName.setText(this.memberName.getText() + getMember.getFirstName() + " " + getMember.getLastName());
                this.balanceAmount.setText(this.balanceAmount.getText() + getMember.getBalance());
                this.payBtn.setEnabled(true);
            }

        }
    }
}
