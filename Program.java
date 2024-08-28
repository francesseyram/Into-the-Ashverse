/**
 *A class to represent a program
 */
public class Program {


    enum Programs {
        // An enum of Programs
        BUSINESS_ADMINISTRATION,
        MANAGEMENT_INFORMATION_SYSTEMS,
        COMPUTER_SCIENCE,
        ECONOMICS,
        COMPUTER_ENGINEERING,
        MECHANICAL_ENGINEERING,
        ELECTRICAL_ENGINEERING,
        MECHATRONICS_ENGINEERING,
        BUSINESS_ADMINISTRATION_FINANCE,
        ECONOMICS_FINANCE,
        COMPUTER_SCIENCE_FINANCE,
        MANAGEMENT_INFORMATION_SYSTEMS_FINANCE,
        COMPUTER_ENGINEERING_FINANCE,
        MECHANICAL_ENGINEERING_FINANCE,
        ELECTRICAL_ENGINEERING_FINANCE,
        MECHATRONICS_ENGINEERING_FINANCE
    }
    // instance variables
    private int cutOffGrade;
    public static final int CUT_OFF_GRADE = 36;

    // constructor
    Program(String programName){
        if(programName.equalsIgnoreCase("Business_Administration")){
            this.changeCutOffGrade(Programs.BUSINESS_ADMINISTRATION);
        }
        else if(programName.equalsIgnoreCase("Business_Administration_Finance")){
            this.changeCutOffGrade(Programs.BUSINESS_ADMINISTRATION_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Management_ Information_Systems")){
            this.changeCutOffGrade(Programs.MANAGEMENT_INFORMATION_SYSTEMS);
        }
        else if(programName.equalsIgnoreCase("Management_Information_Systems_Finance")){
            this.changeCutOffGrade(Programs.MANAGEMENT_INFORMATION_SYSTEMS_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Economics")){
            this.changeCutOffGrade(Programs.ECONOMICS);
        }
        else if(programName.equalsIgnoreCase("Economics_Finance")){
            this.changeCutOffGrade(Programs.ECONOMICS_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Computer_Science")){
            this.changeCutOffGrade(Programs.COMPUTER_SCIENCE);
        }
        else if(programName.equalsIgnoreCase("Computer_Science_Finance")){
            this.changeCutOffGrade(Programs.COMPUTER_SCIENCE_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Computer_Engineering")){
            this.changeCutOffGrade(Programs.COMPUTER_ENGINEERING);
        }
        else if(programName.equalsIgnoreCase("Computer_Engineering_Finance")){
            this.changeCutOffGrade(Programs.COMPUTER_ENGINEERING_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Mechanical_Engineering")){
            this.changeCutOffGrade(Programs.MECHANICAL_ENGINEERING);
        }
        else if(programName.equalsIgnoreCase("Mechanical_Engineering_Finance")){
            this.changeCutOffGrade(Programs.MECHANICAL_ENGINEERING_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Electrical_Engineering")){
            this.changeCutOffGrade(Programs.ELECTRICAL_ENGINEERING);
        }
        else if(programName.equalsIgnoreCase("Electrical_Engineering_Finance")){
            this.changeCutOffGrade(Programs.ELECTRICAL_ENGINEERING_FINANCE);
        }
        else if(programName.equalsIgnoreCase("Mechatronics_Engineering")){
            this.changeCutOffGrade(Programs.MECHATRONICS_ENGINEERING);
        }
        else if(programName.equalsIgnoreCase("Mechatronics_Engineering_Finance")){
            this.changeCutOffGrade(Programs.MECHATRONICS_ENGINEERING_FINANCE);
        }
    }

    /**
     * A method to change the cut-off grade
     * @param program represents the program
     */
    private void changeCutOffGrade(Programs program){
        switch (program){
            case BUSINESS_ADMINISTRATION, ECONOMICS:
                cutOffGrade = 36;
                break;
            case BUSINESS_ADMINISTRATION_FINANCE, ECONOMICS_FINANCE:
                cutOffGrade = 30;
                break;
            case COMPUTER_SCIENCE, MANAGEMENT_INFORMATION_SYSTEMS:
                cutOffGrade = 20;
                break;
            case COMPUTER_SCIENCE_FINANCE, MANAGEMENT_INFORMATION_SYSTEMS_FINANCE:
                cutOffGrade = 15;
                break;
            case COMPUTER_ENGINEERING, MECHANICAL_ENGINEERING, ELECTRICAL_ENGINEERING,
                 MECHATRONICS_ENGINEERING:
                cutOffGrade = 10;
                break;
            case COMPUTER_ENGINEERING_FINANCE, MECHANICAL_ENGINEERING_FINANCE, ELECTRICAL_ENGINEERING_FINANCE, MECHATRONICS_ENGINEERING_FINANCE:
                cutOffGrade = 7;
                break;
        }
    }

    //Accessor methods
    public int getCutOffGrade(){
        return this.cutOffGrade;
    }


    /**
     * A method that checks whether an applicant is eligible using their grade
     * @param grade represents the grade
     * @return whether applicant is eligible
     */
    public boolean isApplicantEligible(Grade grade)
    {
        return grade.calculateAggregate() <= cutOffGrade;
    }

}
