package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author
 */
public class UpdateMemberScreen extends JFrame implements ActionListener {

    private JFrame UpdateFrame = new JFrame("Membership Management System");
    private JPanel UpdatePanel;
    private JLabel Header;
    private JLabel memberShipID;
    private JLabel memberType;
    private JLabel memberFirstName;
    private JLabel memberLastName;
    private JLabel DOB;
    private JLabel Gender;
    private JLabel Address;
    private JLabel contactInfo;
    private JLabel DiabeticProblem;
    private JLabel BreathingProblem;
    private JLabel Amount;

    private ButtonGroup memberTypeGroup;
    private JRadioButton memberType1;
    private JRadioButton memberType2;
    private JRadioButton memberType3;

    private ButtonGroup genderGroup;
    private JRadioButton memberGender1;
    private JRadioButton memberGender2;

    private ButtonGroup DiabeticGroup;
    private JRadioButton Diabetic1;
    private JRadioButton Diabetic2;

    private ButtonGroup BreathingGroup;
    private JRadioButton Breathing1;
    private JRadioButton Breathing2;

    private JTextField membershipIDInput;
    private JTextField memberFirstNameInput;
    private JTextField memberLastNameInput;
    private JTextField DOBInput;
    private JTextField AddressInput;
    private JTextField contactInfoInput;

    private JButton searchBtn;
    private JButton clearBtn;
    private JButton updateBtn;

    UpdateMemberScreen() {

        UpdatePanel = new JPanel();
        UpdateFrame.getContentPane();
        UpdatePanel.setLayout(null);

        Header = new JLabel("Update an Existing Member");
        memberShipID = new JLabel("Membership ID : ");
        memberType = new JLabel("Member Type: ");
        memberFirstName = new JLabel("First Name: ");
        memberLastName = new JLabel("Last Name: ");
        DOB = new JLabel("Date of Birth: ");
        Gender = new JLabel("Gender: ");
        Address = new JLabel("Address: ");
        contactInfo = new JLabel("Contact: ");
        DiabeticProblem = new JLabel("Any injuries?: ");
        BreathingProblem = new JLabel("Need guidance?: ");
        searchBtn = new JButton("Search Member");
        searchBtn.addActionListener(this);
        updateBtn = new JButton("Update Now");
        updateBtn.addActionListener(this);
        updateBtn.setEnabled(false);

        clearBtn = new JButton("Clear All");
        clearBtn.addActionListener(this);

        memberTypeGroup = new ButtonGroup();
        memberType1 = new JRadioButton("1. Individual");
        memberType1.setActionCommand("Individual");
        memberType2 = new JRadioButton("2. Family");
        memberType2.setActionCommand("Family");
        memberType3 = new JRadioButton("3. Visitor");
        memberType3.setActionCommand("Visitor");
        memberTypeGroup.add(memberType1);
        memberTypeGroup.add(memberType2);
        memberTypeGroup.add(memberType3);

        genderGroup = new ButtonGroup();
        memberGender1 = new JRadioButton("1. Male");
        memberGender1.setActionCommand("Male");
        memberGender2 = new JRadioButton("2. Female");
        memberGender2.setActionCommand("Female");
        genderGroup.add(memberGender1);
        genderGroup.add(memberGender2);

        DiabeticGroup = new ButtonGroup();
        Diabetic1 = new JRadioButton("Yes");
        Diabetic1.setActionCommand("Yes");
        Diabetic2 = new JRadioButton("No");
        Diabetic2.setActionCommand("No");
        DiabeticGroup.add(Diabetic1);
        DiabeticGroup.add(Diabetic2);

        BreathingGroup = new ButtonGroup();
        Breathing1 = new JRadioButton("Yes");
        Breathing1.setActionCommand("Yes");
        Breathing2 = new JRadioButton("No");
        Breathing2.setActionCommand("No");
        BreathingGroup.add(Breathing1);
        BreathingGroup.add(Breathing2);

        membershipIDInput = new JTextField();

        memberFirstNameInput = new JTextField();
        memberFirstNameInput.setEditable(true);

        memberLastNameInput = new JTextField();
        memberLastNameInput.setEditable(true);

        DOBInput = new JTextField();
        DOBInput.setEditable(true);

        AddressInput = new JTextField();
        AddressInput.setEditable(true);

        contactInfoInput = new JTextField();
        contactInfoInput.setEditable(true);

        UpdatePanel.add(membershipIDInput);
        UpdatePanel.add(Header);
        UpdatePanel.add(memberShipID);

        UpdatePanel.add(memberType);
        UpdatePanel.add(memberType1);
        UpdatePanel.add(memberType2);
        UpdatePanel.add(memberType3);

        UpdatePanel.add(memberFirstName);
        UpdatePanel.add(memberFirstNameInput);

        UpdatePanel.add(memberLastName);
        UpdatePanel.add(memberLastNameInput);

        UpdatePanel.add(Gender);
        UpdatePanel.add(memberGender1);
        UpdatePanel.add(memberGender2);

        UpdatePanel.add(DOB);
        UpdatePanel.add(DOBInput);

        UpdatePanel.add(Address);
        UpdatePanel.add(AddressInput);

        UpdatePanel.add(contactInfo);
        UpdatePanel.add(contactInfoInput);

        UpdatePanel.add(DiabeticProblem);
        UpdatePanel.add(Diabetic1);
        UpdatePanel.add(Diabetic2);

        UpdatePanel.add(BreathingProblem);
        UpdatePanel.add(Breathing1);
        UpdatePanel.add(Breathing2);

        UpdatePanel.add(searchBtn);
        UpdatePanel.add(clearBtn);
        UpdatePanel.add(updateBtn);

        Header.setBounds(220, 0, 400, 30);
        clearBtn.setBounds(400, 180, 150, 25);

        memberShipID.setBounds(10, 30, 200, 20);
        membershipIDInput.setBounds(110, 30, 120, 25);

        memberType.setBounds(10, 60, 100, 30);
        memberType1.setBounds(110, 60, 100, 30);
        memberType2.setBounds(210, 60, 100, 30);
        memberType3.setBounds(310, 60, 100, 30);

        memberFirstName.setBounds(10, 100, 100, 20);
        memberFirstNameInput.setBounds(110, 100, 120, 25);

        memberLastName.setBounds(10, 140, 100, 20);
        memberLastNameInput.setBounds(110, 140, 120, 25);

        Gender.setBounds(10, 180, 100, 20);
        memberGender1.setBounds(110, 180, 100, 25);
        memberGender2.setBounds(210, 180, 100, 25);

        DOB.setBounds(10, 220, 100, 20);
        DOBInput.setBounds(110, 220, 200, 25);

        contactInfo.setBounds(10, 260, 100, 20);
        contactInfoInput.setBounds(110, 260, 120, 25);

        Address.setBounds(10, 300, 100, 20);
        AddressInput.setBounds(110, 300, 120, 25);

        DiabeticProblem.setBounds(10, 350, 200, 30);
        Diabetic1.setBounds(210, 350, 100, 30);
        Diabetic2.setBounds(310, 350, 100, 30);

        BreathingProblem.setBounds(10, 380, 200, 30);
        Breathing1.setBounds(210, 380, 100, 30);
        Breathing2.setBounds(310, 380, 100, 30);

        searchBtn.setBounds(100, 430, 150, 25);

        updateBtn.setBounds(300, 430, 150, 25);

        UpdateFrame.add(UpdatePanel);
        UpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateFrame.setSize(600, 500);
        UpdateFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search Member")) {
            Member getMember = ClubMembership.db.SearchMember(this.membershipIDInput.getText());
            if (getMember == null) {
                JOptionPane.showMessageDialog(UpdateFrame, "Member with ID : " + this.membershipIDInput.getText() + " not Found!");
            } else {

                this.memberFirstNameInput.setText(getMember.getFirstName());
                this.memberLastNameInput.setText(getMember.getLastName());
                this.contactInfoInput.setText(getMember.getContact());
                this.AddressInput.setText(getMember.getAddress());
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                this.DOBInput.setText(formatter.format(getMember.getDateOfBirth()));
                this.Gender.setText(getMember.getGender());

                if (getMember.getGender().equals("Male")) {
                    this.memberGender1.setSelected(true);
                } else {
                    this.memberGender2.setSelected(true);
                }

                switch (getMember.getMemberType()) {
                    case "Individual" ->
                        this.memberType1.setSelected(true);
                    case "Family" ->
                        this.memberType2.setSelected(true);
                    default ->
                        this.memberType3.setSelected(true);
                }

                if (getMember.getHealthInfo().isBreathingProblem()) {
                    this.Breathing1.setSelected(true);
                } else {
                    this.Breathing2.setSelected(true);
                }

                if (getMember.getHealthInfo().isDiabeticProblem()) {
                    this.Diabetic1.setSelected(true);
                } else {
                    this.Diabetic2.setSelected(true);
                }

                updateBtn.setEnabled(true);
            }

        } else if (e.getActionCommand().equals("Clear All")) {
            memberTypeGroup.clearSelection();
            genderGroup.clearSelection();
            DiabeticGroup.clearSelection();
            BreathingGroup.clearSelection();
            memberFirstNameInput.setText("");
            memberLastNameInput.setText("");
            AddressInput.setText("");
            contactInfoInput.setText("");
            DOBInput.setText("");
        } else if (e.getActionCommand().equals("Update Now")) {
            Date getDateOfBirth = null;
            String getMemberType = this.memberTypeGroup.getSelection().getActionCommand();
            String getFirstName = this.memberFirstNameInput.getText();
            String getLastName = this.memberLastNameInput.getText();
            try {
                getDateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(this.DOBInput.getText());
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            String getGender = this.genderGroup.getSelection().getActionCommand();
            String getAddress = this.AddressInput.getText();
            String getContact = this.contactInfoInput.getText();
            boolean getBreath = false;
            boolean getDiabetes = false;
            if (this.DiabeticGroup.getSelection().getActionCommand().equals("Yes")) {
                getDiabetes = true;
            }

            if (this.BreathingGroup.getSelection().getActionCommand().equals("Yes")) {
                getBreath = true;
            }

            Member updatedMember = new Member(getMemberType, getFirstName, getLastName, getDateOfBirth, getGender, getAddress, getContact, new Health(getBreath, getDiabetes));

            updatedMember.setMemberShipNumber(this.membershipIDInput.getText());

            ClubMembership.db.updateMember(updatedMember);

            JOptionPane.showMessageDialog(UpdateFrame,
                    "Member with ID : " + this.membershipIDInput.getText() + " has been updated successfully!");
        }
    }
}
