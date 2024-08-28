/**
 * A class to represent Financial Aid enrollment
 */
public class FinancialAidEnrollment extends Enrolment {
    //instance variables
    private int aidAmount;
    private String aidReason;

    /**
     * The constructor of the class
     * @param recipient represents the name of the recipient
     * @param aidAmount represents how much aid the recipient wants
     * @param aidReason represents the reason they want the financial aid
     * @param applicant represents the applicant to the school
     * @param educationHistory represents the education history of the applicant
     */
    public FinancialAidEnrollment(String recipient, Applicant applicant, EducationHistory educationHistory, int aidAmount, String aidReason){
        super(recipient, applicant, educationHistory);
        this.aidAmount = aidAmount;
        this.aidReason = aidReason;
    }

    /**
     * A method to display a string representation of the financial aid enrollment
     * @return the string representation of the financial aid enrollment
     */
    @Override
    public String toString() {
        return super.toString() + "FinancialAidEnrollment{" +
                "aidAmount=" + aidAmount +
                ", aidReason='" + aidReason +
                "} \n";
    }
}
