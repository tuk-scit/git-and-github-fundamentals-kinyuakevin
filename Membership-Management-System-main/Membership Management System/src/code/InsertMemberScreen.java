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
public class InsertMemberScreen extends JFrame implements ActionListener {

    private Member toInsert;

    private JFrame InsertFrame = new JFrame("Membership Management System");
    private JPanel InsertPanel;
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

    private JTextField memberFirstNameInput;
    private JTextField memberLastNameInput;
    private JTextField DOBInput;
    private JTextField AddressInput;
    private JTextField contactInfoInput;

    private JButton insertBtn;

    InsertMemberScreen() {

        InsertPanel = new JPanel();
        InsertFrame.getContentPane();
        InsertPanel.setLayout(null);

        Header = new JLabel("Insert a New Member");
        memberShipID = new JLabel("Membership ID : Automatically Generated");
        memberType = new JLabel("Member Type: ");
        memberFirstName = new JLabel("First Name: ");
        memberLastName = new JLabel("Last Name: ");
        DOB = new JLabel("Date of Birth: ");
        Gender = new JLabel("Gender: ");
        Address = new JLabel("Address: ");
        contactInfo = new JLabel("Contact: ");
        DiabeticProblem = new JLabel("Any injuries?: ");
        BreathingProblem = new JLabel("Need guidance?: ");
        insertBtn = new JButton("Insert Member");
        insertBtn.addActionListener(this);

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

        memberFirstNameInput = new JTextField();
        memberLastNameInput = new JTextField();
        DOBInput = new JTextField("DD/MM/YYYY");
        AddressInput = new JTextField();
        contactInfoInput = new JTextField();

        InsertPanel.add(Header);
        InsertPanel.add(memberShipID);

        InsertPanel.add(memberType);
        InsertPanel.add(memberType1);
        InsertPanel.add(memberType2);
        InsertPanel.add(memberType3);

        InsertPanel.add(memberFirstName);
        InsertPanel.add(memberFirstNameInput);

        InsertPanel.add(memberLastName);
        InsertPanel.add(memberLastNameInput);

        InsertPanel.add(Gender);
        InsertPanel.add(memberGender1);
        InsertPanel.add(memberGender2);

        InsertPanel.add(DOB);
        InsertPanel.add(DOBInput);

        InsertPanel.add(Address);
        InsertPanel.add(AddressInput);

        InsertPanel.add(contactInfo);
        InsertPanel.add(contactInfoInput);

        InsertPanel.add(DiabeticProblem);
        InsertPanel.add(Diabetic1);
        InsertPanel.add(Diabetic2);

        InsertPanel.add(BreathingProblem);
        InsertPanel.add(Breathing1);
        InsertPanel.add(Breathing2);

        InsertPanel.add(insertBtn);

        Header.setBounds(230, 10, 400, 30);
        memberShipID.setBounds(10, 30, 400, 30);
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
        DOBInput.setBounds(110, 220, 120, 25);

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

        insertBtn.setBounds(200, 430, 150, 25);

        InsertFrame.add(InsertPanel);
        InsertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        InsertFrame.setSize(600, 500);
        InsertFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Insert Member")) {
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

            this.toInsert = new Member(getMemberType, getFirstName, getLastName, getDateOfBirth, getGender, getAddress, getContact, new Health(getBreath, getDiabetes));

            toInsert.updateFee();
            
            ClubMembership.db.insertMember(toInsert);
            
            JOptionPane.showMessageDialog(InsertFrame,
                    "Member with ID : " + toInsert.getMemberShipNumber() + " has been Inserted!");
            
            memberTypeGroup.clearSelection();
            genderGroup.clearSelection();
            DiabeticGroup.clearSelection();
            BreathingGroup.clearSelection();
            memberFirstNameInput.setText("");
            memberLastNameInput.setText("");
            AddressInput.setText("");
            contactInfoInput.setText("");
            DOBInput.setText("");
        }
    }
}
