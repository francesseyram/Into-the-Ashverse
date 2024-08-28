/**
 * A class that saves students information in a file
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSave {

    /**
     * Writes the toString of the Enrolment object to the file
     * Contains the student's name, age, date of birth, place of birth, school and aggregate WASSCE score
     * @param enrolment
     */
    public static void storeInfo(Enrolment enrolment) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("StudentDatabase.txt", true));
            String info = enrolment.toString();
            writer.write(info);
            writer.write("\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Error opening the file or error writing to the file");
        }
    }

    /**
     * An overloaded method rites the toString of the FinancialAIdEnrolment object to the file
     * Contains the student's name, age, date of birth, place of birth, school and aggregate WASSCE score
     * in addition contains the financial aid the person requests for and the reasons.
     * @param enrolment
     */
    public static void storeInfo(FinancialAidEnrollment enrolment) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("StudentDatabase.txt", true));
            String info = enrolment.toString();
            writer.write(info);
            writer.write("\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Error opening the file or error writing to the file");
        }
    }
}
