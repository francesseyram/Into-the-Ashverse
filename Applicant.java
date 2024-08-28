/**
 * A class to represent an Applicant
 */

// Importing the Date class
import java.util.Date;

// Importing the Scanner class
import java.util.Scanner;

public class Applicant extends Person{
    // Creating a scanner object to take input from the user
    Scanner keyboard = new Scanner(System.in);

    //Instantiating instance variables
    private final String placeOfBirth;
    private String residence;
    private String phoneNo;
    private String email;
    private String appliedProgram;

    private EducationHistory educationHistory ;
    private boolean financialAidRequest;


    /**
     * The constructor of the class
     * @param name represents the name of the applicant
     * @param age represents the age of the applicant
     * @param dateOfBirth represents the date of birth of the applicant
     * @param placeOfBirth represents the place of birth of the applicant
     * @param residence represents where the applicant lives
     * @param email represents the email of the applicant
     * @param phoneNo represents the phone number of the applicant
     */
    public Applicant(String name, int age, Date dateOfBirth,String placeOfBirth, String residence, String email, String phoneNo){
        //calls the constructor of the parent class
        super(name, age, dateOfBirth);

        //sets the remaining attributes
        this.placeOfBirth = placeOfBirth;
        this.residence = residence;
        this.email = email;
        this.phoneNo = phoneNo;
        this.educationHistory = getEducationHistory();
    }

    //definition of mutator methods
    public void setResidence(String residence) {
        this.residence = residence;
    }
    public void setFinancialAidRequest(boolean financialAidRequest){
        this.financialAidRequest = financialAidRequest;
    }
    public void setAppliedProgram(String appliedProgram){
        this.appliedProgram = appliedProgram;
    }
    public void setEducationHistory(EducationHistory educationHistory){
        this.educationHistory = educationHistory;
    }

    //definition of mutator methods
    public String getAppliedProgram() {
        return appliedProgram;
    }

    public String getEmail() {
        return email;
    }

    public EducationHistory getEducationHistory() {
        return educationHistory;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getResidence(){
        return residence;
    }

    public String getPlaceOfBirth(){
        return placeOfBirth;
    }

    public boolean getFinancialAidRequest(){
        return financialAidRequest;
    }

    /**
     * This method allows an applicant to apply for a particular program at Ashesi
     * @return a string that is the program of choice
     */
    public String applyToProgram(){
        System.out.println("These are the courses available in Ashesi: " +
                "\n1. Business_Administration" +
                "\n2. Management_Information_Systems" +
                "\n3. Economics" +
                "\n4. Computer_Science " +
                "\n5. Computer_Engineering " +
                "\n6. Mechanical_Engineering " +
                "\n7. Electrical_Engineering " +
                "\n8. Mechatronics_Engineering " +
                "\n Kindly Type The Course Out As It Appears Above.");
        String userInput = keyboard.next();
        return userInput;
    }

    /**
     * A method that asks the applicant extra questions which are relevant for thier admission
     */
    public void extraApplicationQuestion(){
        System.out.print("Special talents: ");
        String talent = keyboard.next();

        System.out.print("Medical conditions: ");
        String condition = keyboard.next();

        //Extraneous information but still personal
        System.out.println("Parent's Contact Information");
        System.out.print("Father's name: ");
        String fatherName = keyboard.next();

        System.out.print("Father's Number: ");
        String fatherNumber = keyboard.next();

        System.out.print("Father's Occupation: ");
        String fatherOccupation = keyboard.next();

        System.out.print("Mother's name: ");
        String motherName = keyboard.next();

        System.out.print("Mother's Number: ");
        String motherNumber = keyboard.next();

        System.out.print("Mother Occupation: ");
        String motherOccupation = keyboard.next();
    }
}
