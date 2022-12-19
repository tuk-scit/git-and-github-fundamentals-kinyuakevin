package code;

import java.text.ParseException;

/**
 *
 * @author
 */
public class ClubMembership {

    static Database db = new Database();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            db.readOldExcelFile("customerlist.csv");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        MainScreen ClubMemberShipScreen = new MainScreen();
    }

}
