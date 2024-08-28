/**
 * A class to represent an appointment
 **/
public class Appointment {
  //Instantiating instance variables
  private String studentName;
  private String venue;
  private String purpose;
  
  // Constructor
  public Appointment(String name, String location, String whatFor)
  {
    studentName = name.toUpperCase();
    venue = location;
    purpose = whatFor;
  }

  /**
   * A method to display the name of a student
   * @return the name of the student
   */
  public String getStudentName()
  {
    return studentName.toUpperCase();
  }

  /**
   * A method to display the venue of the appointment
   * @return the venue of the appointment
   */
  public String getVenue() {
    return venue;
  }

  /**
   * A method to display the purpose of the appointment
   * @return the venue of the appointment
   */
  public String getPurpose() {
    return purpose;
  }

  /**
   * A method to change the name of the student
   * @param name represents the new name of the student
   */
  public void setStudentName(String name){
    studentName = name.toUpperCase();
  }

  /**
   * A method to change the location of an appointment
   * @param location which represents the new location of the appointment
   */
  public void setVenue(String location){
    venue = location;
  }

  /**
   * A method to change the purpose of the appointment
   * @param whatFor which represents the new purpose of the appointment
   */
  public void setPurpose(String whatFor){
    purpose = whatFor;
  }

  /**
   * A method to display the details of the scheduled appointment
   */
  // A method to display the details of the appointment
  public void displayDetails() {
    System.out.println("Student name: " + getStudentName());
    System.out.println("Venue: " + getVenue());
    System.out.println("Purpose: " + getPurpose());
  }

  /**
   * A method to display a string representation of the appointment
   * @return the string representation of the appointment
   */
  public String toString()
  {
    return ("Name: " + getStudentName() + ", venue: " + getVenue() +
            ", purpose: " + getPurpose());
  }
}