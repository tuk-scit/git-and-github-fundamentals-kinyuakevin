package code;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Member {

    private String memberShipNumber;
    private String memberType;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private String gender;
    private String address;
    private String contact;
    private Health healthInfo;
    private float amountPaid;
    private float Balance;

    private void setRandomMemberShipNumber() {

        // chose a Character random from this String 
        String NumericString = "0123456789";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (NumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(NumericString
                    .charAt(index));
        }

        memberShipNumber = sb.toString();
    }

    private void inputHealthInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you have Diabetic Issue: ");
        this.healthInfo.setDiabeticProblem(sc.nextBoolean());
        System.out.print("Do you have Beathing Issue: ");
        this.healthInfo.setBreathingProblem(sc.nextBoolean());
    }

    public Member(String memberShipNumber, String firstName, String lastName, Date dateOfBirth, String gender, String address, float amountPaid) {
        this.memberShipNumber = memberShipNumber;
        this.memberType = "Default";
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = new Date();
        this.gender = gender;
        this.address = address;
        this.contact = "NA";
        this.healthInfo = new Health();
        this.amountPaid = amountPaid;
        this.Balance = 0;

    }

    public Member(String memberType, String firstName, String lastName, Date dateOfBirth, String gender, String address, String contact, Health health) {
        setRandomMemberShipNumber();
        this.memberType = memberType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        healthInfo = health;
        this.dateOfJoining = new Date();

        //200 Pounds is a member ship fee for all and should be paid on first month
        if (memberType.equals("Individual")) {
            this.Balance = 200 + 36;
        } else if (memberType.equals("Family")) {
            this.Balance = 200 + 60;
        } else if (memberType.equals("visitor")) {
            this.Balance = 250;
        }
    }

    public void payFee() {
        this.amountPaid += this.Balance;
        this.Balance = 0;
    }

    public void updateFee() {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(this.dateOfJoining);

        int months = cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH);

        int days = cal1.get(Calendar.DATE) - cal2.get(Calendar.DATE);

        if (months > 0) {
            if (memberType.equals("Individual")) {
                this.Balance = months * 36;
            } else if (memberType.equals("Family")) {
                this.Balance = months * 60;
            }
        }
        if (days > 0) {
            if (memberType.equals("visitor")) {
                this.Balance = days * 250;
            }
        }

    }

    public String getMemberShipNumber() {
        return memberShipNumber;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Health getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(Health healthInfo) {
        this.healthInfo = healthInfo;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setMemberShipNumber(String memberShipNumber) {
        this.memberShipNumber = memberShipNumber;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float Balance) {
        this.Balance = Balance;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return memberShipNumber + "," + memberType + "," + firstName + "," + lastName + "," + formatter.format(dateOfBirth) + "," + formatter.format(dateOfJoining) + "," + gender + "," + address + "," + contact + "," + healthInfo + Balance + "," + amountPaid + "\n";
    }

}
