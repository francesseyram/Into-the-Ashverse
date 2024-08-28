/**
 * A class to represent the educational History of a person
 */
public class EducationHistory {
    //instance variables
    String schoolName;
    Grade grade;

    //constructor
    EducationHistory(String schoolName, Grade grade){
        this.schoolName = schoolName;
        this.grade = grade;
    }

    /**
     * This sets the grade of an applicant
    * @param grade This takes a grade object
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * This returns the grade object of the person
     * @return grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * This returns the school name of the person
     * @return school name
     */
    public String getSchoolName(){
        return schoolName;
    }
}
