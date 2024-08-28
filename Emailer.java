/**
 * A class to represent an Emailer
 */

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;

public class Emailer {
    //instance variables
    private String name;
    private int dummyInt;

    private String recipient;

    //Final string for verification mail subject
    private final String VERIFICATIONEMAILSUBJECT = "One Time Password";

    private String verificationBody;

    //Final string for interview details subject
    private final String INTERVIEWDETAILSSUBJECT = "Information About Your Interview With Ashesi";

    private String interviewDetailsBody;

    //Final string for application success subject
    private final String APPLICATIONSUCCESSSUBJECT = "WELCOME TO ASHESI CLASS OF 2028!";

    //final string for application success body
    private final String APPLICATIONSUCCESSBODY = "Dear Applicant," +
            "\n" +
            "\nCongratulations on your admission to Ashesi University!" +
            "\n" +
            "\nKindly find attached your admission package which gives you important information. " +
            "You are required to read through the documents carefully, scan and submit the following via the online portal " +
            "(preferred) or to acceptance@ashesi.edu.gh as soon as you make payment:" +
            "\n" +
            "\n1. Completed & signed acceptance form" +
            "\n2. Completed & signed textbook lease form" +
            "\n3. Completed payment breakdown form" +
            "\n4. Completed & signed health screening/vaccination form (to be submitted before 4th January)" +
            "\n5. Biodata page of your passport (For International Students only) – " +
            "Please note that failure to provide this will result in the withdrawal of your admission offer." +
            "\n" +
            "\nTo enroll at Ashesi you will need to make at least 50% payment of the tuition amount by the deadline stated in your offer letter to secure your slot." +
            "\n" +
            "\nFor on-campus housing requests (offers and contracts) please contact housing@ashesi.edu.gh." +
            "\n" +
            "\nWe look forward to welcoming you to the Ashesi Class of 2028." +
            "\n" +
            "\nRegards," +
            "\n" +
            "\nAshesi Admissions" +
            "\n" +
            "\n- – – – – – – – – – – -" +
            "\nPlease do not reply to this message";

    //Final string for application failure subject
    private final String APPLICATIONFAULIRESUBJECT = "Ashesi University Application Update";

    //Final string for application failure body
    private final String APPLICATIONFAILUREBODY = "Dear Applicant," +
            "\n" +
            "\nThank you for submitting your application to Ashesi University." +
            "\n" +
            "\nAfter a careful review of your application and supporting credentials, we regret to inform you that we are unable to offer you admission." +
            "\n" +
            "\nWe wish you the very best." +
            "\n" +
            "\nKind regards," +
            "\n" +
            "\nAshesi Admissions";

    //constructor
    public Emailer(String recipient) {
        this.name = null;
        this.recipient = recipient;
        this.dummyInt = 0;
        this.interviewDetailsBody = null;
        this.verificationBody = null;
    }

    //overloaded constructors
    public Emailer(String recipient, String verificationBody) {
        this.name = null;
        this.recipient = recipient;
        this.verificationBody = verificationBody;
        this.dummyInt = 0;
        this.interviewDetailsBody = null;
    }

    public Emailer(String name,String recipient, String interviewDetailsBody, int dummyInt){
        this.name = name;
        this.recipient = recipient;
        this.interviewDetailsBody = interviewDetailsBody;
        this.dummyInt = dummyInt;
        this.verificationBody = null;
    }

    public Emailer(String name,String recipient, int dummyInt){
        this.name = name;
        this.recipient = recipient;
        this.dummyInt = dummyInt;
        this.verificationBody = null;
        this.interviewDetailsBody = null;
    }

    //mutator methods
    public void setName(String name){
        this.name = name;
    }
    public void setVerificationBody(String verificationBody){
        this.verificationBody = "Kindly find below your generated OTP." + "\n\n" + verificationBody;
    }

    public void setInterviewDetailsBody(String interviewDetailsBody){
        this.interviewDetailsBody = "Dear Applicant,\n\n" +interviewDetailsBody;
    }

    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

    /**
     * A method to send a verification email
     */
    public void sendVerificationEmail() {
        if(verificationBody == null){
            System.out.println("The verification email has not been initialised!");
        }
        else {
            try {
                String subject = URLEncoder.encode(VERIFICATIONEMAILSUBJECT, "UTF-8").replaceAll("\\+", "%20");
                String body = verificationBody;

                String mailtoURI = "mailto:" + recipient +
                        "?subject=" + subject +
                        "&body=" + body;

                Desktop.getDesktop().mail(new URI(mailtoURI));
            } catch (Exception e) {
                System.out.println("Failed to open email client.");
            }
        }
    }

    /**
     * A method to send application successfull Email
     */
    public void sendApplicationSuccessEmail() {
        try {
            String subject = URLEncoder.encode(APPLICATIONSUCCESSSUBJECT, "UTF-8").replaceAll("\\+", "%20");
            String body = URLEncoder.encode(APPLICATIONSUCCESSBODY, "UTF-8").replaceAll("\\+", "%20");

            // Use %0D%0A to represent a new line in the body
            body = body.replace("\n", "%0D%0A");

            String mailtoURI = "mailto:" + recipient +
                    "?subject=" + subject +
                    "&body=" + body;

            Desktop.getDesktop().mail(new URI(mailtoURI));
        } catch (Exception e) {
            System.out.println("Failed to open email client.");
        }
    }

    /**
     * A method to send application failure email
     */
    public void sendFailureEmail() {
        try {
            String subject = URLEncoder.encode(APPLICATIONFAULIRESUBJECT, "UTF-8").replaceAll("\\+", "%20");
            String body = URLEncoder.encode(APPLICATIONFAILUREBODY, "UTF-8").replaceAll("\\+", "%20");

            // Use %0D%0A to represent a new line in the body
            body = body.replace("\n", "%0D%0A");

            String mailtoURI = "mailto:" + recipient +
                    "?subject=" + subject +
                    "&body=" + body;

            Desktop.getDesktop().mail(new URI(mailtoURI));
        } catch (Exception e) {
            System.out.println("Failed to open email client.");
        }
    }

    /**
     * A method to send interview details email
     */
    public void sendInterviewDetailsEmail() {
        if(interviewDetailsBody == null){
            System.out.println("The interview details email has not been initialised!");
        }
        else {
            try {
                String subject = URLEncoder.encode(INTERVIEWDETAILSSUBJECT, "UTF-8").replaceAll("\\+", "%20");
                String body = URLEncoder.encode(interviewDetailsBody, "UTF-8").replaceAll("\\+", "%20");

                // Use %0D%0A to represent a new line in the body
                body = body.replace("\n", "%0D%0A");

                String mailtoURI = "mailto:" + recipient +
                        "?subject=" + subject +
                        "&body=" + body;

                Desktop.getDesktop().mail(new URI(mailtoURI));
            } catch (Exception e) {
                System.out.println("Failed to open email client.");
            }
        }
    }
}
