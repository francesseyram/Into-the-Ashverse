/**
 * A class to represent an Enrolment
 */
public class Enrolment
{
    //Creating the instance variables
    private String receipient;
    private Applicant applicant;
    private EducationHistory educationHistory;
    private boolean decisionStatus;

    //constructor
    public Enrolment(String recipient, Applicant applicant, EducationHistory educationHistory) {
        this.receipient = recipient;
        this.applicant = applicant;
        this.educationHistory = educationHistory;
    }

    /**
     * A method that allows an enrolled applicant to apply
     * @param program represents the program of choice of the applicant
     * @return a decision object which represents whether the process was successful or not
     */
    public Decision apply(Program program) throws InterruptedException {
        //Creating a decision object
        Decision decision = new Decision();

        //creating an Emailer object with the name of the recipient
        Emailer email = new Emailer(receipient);

        // Checks to see if the applicant is eligible based on the program and grade
        if(program.isApplicantEligible(educationHistory.getGrade())) {
              /*
            If they are eligible it creates an appointment, emails them
             and sets their decision status to true and returns the object
             */
            decision.scheduleAppointment(applicant.getName());
            email.setInterviewDetailsBody(decision.getGetInterviewDetails());
            email.sendInterviewDetailsEmail();
            Thread.sleep(40000);
            decision.set_status(true);
            decisionStatus = decision.getStatus();
            email.sendApplicationSuccessEmail();
            return decision;
        }
        else {
            /*
        If they are not eligible sends them a failure email
        and sets their status to false and returns the decision
         */
           decision.set_status(false);
           decisionStatus = decision.getStatus();
           email.sendFailureEmail();
           return decision;
        }
    }

    /**
     * A method to display a string representation of the enrollment
     * @return the string representation of the enrollment
     */
    @Override
    public String toString() {
        return "Name: " + applicant.getName() +
                "\nAge: " + applicant.getAge() +
                "\nDate of Birth: " + applicant.getDateOfBirth() +
                "\nPlace of Birth: " + applicant.getPlaceOfBirth() +
                "\nSchool: " + educationHistory.getSchoolName() +
                "\nAggregate Score: " + educationHistory.getGrade().getAggregate() +
                "\nAccepted?: " + decisionStatus +
                "\n"
                ;
    }
}



