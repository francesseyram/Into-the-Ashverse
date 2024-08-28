/**
 * A class to represent a grade
 */
public class Grade{
    //Creating the instance variables
    private int coreMath;
    private int interScience;
    private int english;
    private int best1;
    private int best2;
    private int best3;
    private int aggregate;

    /**
     * the constructor of the class
     * @param coreMath represents the grade in core maths
     * @param interScience represents the grade in Integrated Science
     * @param english represents the grade in English
     * @param best1 represents the grade of the first best elective
     * @param best2 represents the grade of the second-best elective
     * @param best3 represents the grade of the third-best elective
     */
    public Grade(int coreMath, int interScience, int english, int best1, int best2, int best3) {
        this.coreMath = coreMath;
        this.interScience = interScience;
        this.english = english;
        this.best1 = best1;
        this.best2 = best2;
        this.best3 = best3;
    }

    //calculates the aggregate
    public int calculateAggregate(){
        //aggregate computation
        aggregate = coreMath + interScience + english + best1 + best2 + best3;
        return aggregate;
    }

    // Mutator method to get the grade for a particular course
    public int getGrade(String courseName){
        if(courseName.equals("english")){
            return english;
        }
        else if(courseName.equals("coreMath")){
            return coreMath;
        }
        else if(courseName.equals("interScience")){
            return interScience;
        }
        else if(courseName.equals("best1")){
            return best1;
        }
        else if(courseName.equals("best2")){
            return best2;
        }
        else if(courseName.equals("best3")){
            return best3;
        }
        return -1;
    }

    // accessor method for getting the aggregate of the applicant
    public int getAggregate(){
        return aggregate;
    }
}