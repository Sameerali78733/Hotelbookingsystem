import javax.swing.*;
import java.util.GregorianCalendar;
public class Main {
    public static void main(String[] args) {
        //declare variable fro age calculation
        int bornYear,currentYear,ageInYear;
        //get the born year from user as input
        bornYear= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your born year:"));
        System.out.println(bornYear);
        //to get the current year from calendar
        GregorianCalendar calendar = new GregorianCalendar();
        currentYear= calendar.get(GregorianCalendar.YEAR);
        System.out.println(currentYear);
        //to find the age in year
        ageInYear=currentYear-bornYear;
        //to show the age in dialog
        JOptionPane.showMessageDialog(null,"your age is "+ageInYear);

    }
}