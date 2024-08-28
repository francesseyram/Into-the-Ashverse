/**
 * A class that mimics the application process of a person to Ashesi University
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IntoTheAshverse{
    public static void main(String[]args){

        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Welcome To The Application Portal For Ashesi University!!");
            System.out.print("Do You Want To Apply For Admission To Ashesi? ");
            String userInput = scanner.next();

            if (userInput.equalsIgnoreCase("Yes")) {
                System.out.print("Enter Your Email Address: ");
                String emailAddress = scanner.next();
                System.out.println();

                OTPGenerator OTP = new OTPGenerator();
                String generatedOTP = OTP.getGeneratedPassword();
                Emailer personEmail = new Emailer(emailAddress, generatedOTP);
                personEmail.sendVerificationEmail();
                Thread.sleep(30000);

                System.out.println(generatedOTP);

                boolean otpVerified = false;
                int attempts = 0;
                while (!otpVerified && attempts < 3) {
                    System.out.print("Enter the OTP generated: ");
                    String inputOTP = scanner.next();

                    int verificationResult = OTP.verifyOTP(inputOTP);
                    if (verificationResult == 1) {
                        System.out.println("OTP Successfully Verified");
                        System.out.println("Congratulations. You Can Continue With Your Application Process.");
                        System.out.println();
                        otpVerified = true;
                    } else if (verificationResult == -1) {
                        System.out.println("Invalid OTP. Please try again.");
                        attempts++;
                    } else if (verificationResult == 0) {
                        System.out.println("The code has expired.");
                        System.out.println("Please start the application process again.");
                        System.exit(1);
                    }
                }

                if (!otpVerified) {
                    System.out.println("You've reached the maximum number of attempts.");
                    System.out.println("Please start the application process again.");
                    System.exit(1);
                }

                System.out.println("Kindly Fill In Your Details: ");
                System.out.print("Enter Your First Name: ");
                String firstName = scanner.next();
                personEmail.setName(firstName);

                System.out.print("Enter Your Surname: ");
                String surName = scanner.next();

                System.out.print("Enter Your Age: ");
                int userAge = scanner.nextInt();


                System.out.print("Enter Your Date of Birth(dd/mm/yyyy): ");
                String userDate = scanner.next();
                Date userDateOfBirth = date.parse(userDate);

                System.out.print("Enter Your Place of Birth: ");
                String userPlaceOfBirth = scanner.next();

                System.out.print("Enter Your Current Residence: ");
                String userResidence = scanner.next();

                System.out.print("Enter Your Phone Number: ");
                String userPhoneNumber = scanner.next();


                Applicant Applicant1 = new Applicant(firstName, userAge, userDateOfBirth, userPlaceOfBirth, userResidence, emailAddress, userPhoneNumber);
                Applicant1.extraApplicationQuestion();

                System.out.println("Thank You For Filling in Your Personal Information!!");
                System.out.println("Next We Move To Your Education Background.");
                System.out.println();

                System.out.print("Enter The Name of The Senior High School You Went To: ");
                String userSchool = scanner.next();


                System.out.print("Enter Your Grade for Core Mathematics: ");
                int math = scanner.nextInt();


                System.out.print("Enter Your Grade for Integrated Science: ");
                int science = scanner.nextInt();


                System.out.print("Enter Your Grade for English Language: ");
                int english = scanner.nextInt();


                System.out.print("Enter The Grade For Your first best subject: ");
                int best1 = scanner.nextInt();


                System.out.print("Enter The Grade For Your second best subject: ");
                int best2 = scanner.nextInt();


                System.out.print("Enter The Grade For Your third best subject: ");
                int best3 = scanner.nextInt();
                System.out.println();

                Grade personGrade = new Grade(math, science, english, best1, best2, best3);
                EducationHistory personEducationHistory = new EducationHistory(userSchool, personGrade);

                System.out.print("Do You Need Financial Aid? ");
                String financialAidRequest = scanner.next();
                System.out.println();

                if (financialAidRequest.equalsIgnoreCase("No")) {
                    Applicant1.setFinancialAidRequest(false);

                    System.out.println("What Course Would You like To Apply For? ");
                    String programSelection = Applicant1.applyToProgram();

                    Applicant1.setAppliedProgram(programSelection);
                    Program personProgram = new Program(programSelection);
                    System.out.println();

                    Enrolment enrolment = new Enrolment(emailAddress, Applicant1, personEducationHistory);
                    System.out.println("Kindly Check Your Email For More Details.");
                    enrolment.apply(personProgram);
                    FileSave.storeInfo(enrolment);
                } else if (financialAidRequest.equalsIgnoreCase("Yes")) {
                    System.out.print("What percentage of financial aid would you require? ");
                    int financialAidAmount = scanner.nextInt();
                    System.out.println();

                    System.out.print("Why do you need financial aid? ");
                    String financialAidReason = scanner.next();
                    System.out.println();

                    Applicant1.setFinancialAidRequest(true);
                    FinancialAidEnrollment person1FinancialAid = new FinancialAidEnrollment(emailAddress, Applicant1, personEducationHistory, financialAidAmount, financialAidReason);
                    FileSave.storeInfo(person1FinancialAid);

                    System.out.println("What Course Would You like To Apply For? ");
                    String programSelection = Applicant1.applyToProgram();
                    programSelection = programSelection + "_Finance";

                    Applicant1.setAppliedProgram(programSelection);
                    Program personProgram = new Program(programSelection);
                    System.out.println();

                    System.out.println("Kindly Check Your Email For More Details.");
                    person1FinancialAid.apply(personProgram);
                }
            }
            else if(userInput.equalsIgnoreCase("No")) {
                System.out.println("That's Quite Unfortunate. We hope to see you soon!!");
                System.exit(0);
            }
            else{
                System.out.println("Please check your input and try again.");
                System.exit(1);
            }
        }
        catch (Exception e){
            System.out.println("There was an Error in your application" +
                    "process. Kindly start over");
        }
    }
}
