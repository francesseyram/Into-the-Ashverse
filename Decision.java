/**
 * A class to represent a Decision
 */

public class Decision
{
	//Instantiating instance variables
	private boolean status;
	static String getInterviewDetails;

	public Decision() {
		this.status = false;
	}

	/*Creating weekly 4 weeklyapptschedule objects because interviews
          will last a month(depends on the number of students we choose to accept)
         */
	static WeeklyApptSchedule week1 = new WeeklyApptSchedule();
	static WeeklyApptSchedule week2 = new WeeklyApptSchedule();
	static WeeklyApptSchedule week3 = new WeeklyApptSchedule();
	static WeeklyApptSchedule week4 = new WeeklyApptSchedule();

	//Accessor methods
	public void set_status(boolean newStatus)
	{
		this.status = newStatus;
	}

	/**
	 * This method schedules an appointment
	 * @param nameofApplicant represents the name of the applicant
	 * @return a boolean that represents whether the process was successful
	 */
	public boolean scheduleAppointment(String nameofApplicant)
	{
		if(week1.addAppointment(nameofApplicant, "Ashesi", "Interview") != -1)
		{
			getInterviewDetails = week1.getInterviewDetails();

			//week1.addAppointment(nameofApplicant, "Ashesi", "Interview");
			return true;
		}
		else if (week2.addAppointment(nameofApplicant, "Ashesi", "Interview") != -1)
		{
			//week2.addAppointment(nameofApplicant, "Ashesi", "Interview");
			getInterviewDetails = week2.getInterviewDetails();
			return true;
		}
		else if (week3.addAppointment(nameofApplicant, "Ashesi", "Interview") != -1)
		{
			//week3.addAppointment(nameofApplicant, "Ashesi", "Interview");
			getInterviewDetails = week3.getInterviewDetails();
			return true;
		}
		else if (week4.addAppointment(nameofApplicant, "Ashesi", "Interview") != -1)
		{
			//week4.addAppointment(nameofApplicant, "Ashesi", "Interview");
			getInterviewDetails = week4.getInterviewDetails();
			return true;
		}
		else
		{
			System.out.println("Dear applicant, you have unfortunately missed the window for interviews");
			return false;
		}

	}

	//gets interview details
	public String getGetInterviewDetails() {
		return getInterviewDetails;
	}

	// Returns the status of the applicants decision
	public boolean getStatus(){
		return this.status;
	}
}

