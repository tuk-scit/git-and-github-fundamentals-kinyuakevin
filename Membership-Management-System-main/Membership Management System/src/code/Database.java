package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author
 */
public class Database {

    public List<Member> members;
    private boolean loaded = false;

    Database() {
        members = new ArrayList();
    }

    public void readOldExcelFile(String filename) throws ParseException {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) //returns a Boolean value  
            {
                String[] member = line.split(",");    // use comma as separator 

                if (member.length == 7) {
                    if ("".equals(member[3])) {
                        continue;
                    }
                    Date DOB = new SimpleDateFormat("dd/MM/yyyy").parse(member[3]);
                    members.add(new Member(member[0], member[1], member[2], DOB, member[4], member[5], Float.valueOf(member[6])));
                }

            }
        } catch (IOException e) {
        }
    }

    public void readExcelFile(String filename) throws ParseException {
        if (loaded) {
            return;
        }
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) //returns a Boolean value  
            {
                String[] member = line.split(",");    // use comma as separator 

                if (member.length == 7) {
                    if ("".equals(member[3])) {
                        continue;

                    }
                    continue;
                }
                if (member.length == 13) {
                    if ("".equals(member[4])) {
                        continue;
                    }
                    Date DOB = new SimpleDateFormat("dd/MM/yyyy").parse(member[4]);
                    members.add(new Member(member[0], member[1], member[2], DOB, member[4], member[5], Float.valueOf(member[12])));
                }

            }
            loaded = true;
        } catch (IOException e) {
        }
    }

    public void saveToExcelFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        for (Member m : members) {
            writer.write(m.toString());
        }
        writer.close();
    }

    public void payMemberFee(String memberID) {
        for (Member m : members) {
            if (m.getMemberShipNumber().equals(memberID)) {
                m.payFee();
            }
        }
    }

    public void insertMember(Member m) {
        members.add(m);
    }

    public void deleteMember(String memberID) {
        Member toDelete = SearchMember(memberID);
        if (toDelete != null) {
            members.remove(toDelete);
        }
    }

    public void updateMember(Member updatedMember) {
        for (Member m : members) {
            if (m.getMemberShipNumber().equals(updatedMember.getMemberShipNumber())) {
                updatedMember.setAmountPaid(m.getAmountPaid());
                members.remove(m);
                members.add(updatedMember);
                return;
            }
        }

    }

    public Member SearchMember(String memberID) {
        for (Member m : members) {
            if (m.getMemberShipNumber().equals(memberID)) {
                return m;
            }
        }
        return null;
    }

}
