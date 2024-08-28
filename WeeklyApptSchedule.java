
public class WeeklyApptSchedule{

   private DailyApptSchedule[] apptsForTheWeek;

   public static final int NUM_DAYS = 5;
   public static final String[] DAYS = {"Monday", "Tuesday", "Wednesday",
           "Thursday", "Friday"};
   public enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};

   // No-arg constructor creates an array of DailyApptSchedule
   // for the week
   static int index;
   static String interviewDetails;
   public Day randomDay()
   {
      index = (int)(Math.random()*5);
      Day day = Day.values()[index];
      return day;
   }

   public WeeklyApptSchedule()
   {
      apptsForTheWeek = new DailyApptSchedule[NUM_DAYS];
   }


   /**
    * A method to display the weekly appointment by showing the schedule for each day of the week
    */
   // display weekly appointments
   // Display the set of appointments for the week by showing
   // the schedule for each day.
   //Consider making this private because should the applicants be able to see the schedule?
   public void displayWeeklyAppointments()
   {
      for (int i = 0; i < apptsForTheWeek.length; i++)
      {
         if (apptsForTheWeek[i] == null)
         {
            System.out.println(DAYS[i] + " is free");
         }
         else
         {
            System.out.println(DAYS[i]);
            apptsForTheWeek[i].displayAppointments();
            System.out.println();
         }

      }
   }

   /**
    * A method to create a DailyApptSchedule object
    * @param day represents the day you want to create the object for
    * @return the DailyApptSchedule object
    */
   public DailyApptSchedule createDailyApptSchedule(Day day)
   {
      int indexOfDay = day.ordinal();
      DailyApptSchedule dailySchedule = new DailyApptSchedule();
      apptsForTheWeek[indexOfDay] = dailySchedule;
      return dailySchedule;
   }


   /**
    * A method to add an appointment for a given timeslot on a given day
    * @param appt representing the appointment object
    * @param day representing the day the appointment will be added
    * @param timeSlot representing the time the appointment will be held
    * @return true if the appointment was successful and false otherwise
    */
   // Add an appointment for a given timeslot on a given day.
   // Note: You may find it helpful to invoke day.ordinal()
   // ordinal() is a method automatically defined for enumerations
   // it gives an "index" of a particular value in the enumeration.
   public boolean addAppointment(Appointment appt, Day day, int timeSlot)
   {
      int indexOfDay = day.ordinal();
      if (apptsForTheWeek[indexOfDay] == null)
      {
         apptsForTheWeek[indexOfDay] = createDailyApptSchedule(day);
         return apptsForTheWeek[indexOfDay].addAppointment(timeSlot, appt);

      }
      else
      {
         return apptsForTheWeek[indexOfDay].addAppointment(timeSlot, appt);

      }

   }

   /**
    * A method to add an appointment for a given timeslot on a given day
    * @param name represents the name of the person trying to book the appointment
    * @param day represents the day the appointment will be booked
    * @param timeSlot represents the timeslot the appointment will be held
    * @param purpose represents the purpose of the appointment
    * @param venue represents the location of the appointment
    * @return true if the appointment was successful and false otherwise
    */
   public boolean addAppointment(String name, Day day, int timeSlot, String purpose, String venue)
   {
      int indexOfDay = day.ordinal();
      if (apptsForTheWeek[indexOfDay] == null)
      {
         apptsForTheWeek[indexOfDay] = createDailyApptSchedule(day);
         return apptsForTheWeek[indexOfDay].addAppointment(timeSlot, name, venue, purpose);

      }
      else
      {
         return apptsForTheWeek[indexOfDay].addAppointment(timeSlot, name, venue, purpose  );

      }

   }

   /**
    * A method to schedule an appontment on a random day at a random time
    * @param name represents the name of the Applicant
    * @param venue represents the venue of the interview
    * @param purpose represents the purpose of the appointment
    * @return returns the index of the appointment or -1 if the day is full
    */
   public int addAppointment(String name, String venue, String purpose)
   {
      while (true)
      {
         int position;
         int returnValue;
         Day randomday = randomDay();
         position = randomday.ordinal();
         if (apptsForTheWeek[position] == null)
         {
            DailyApptSchedule dailyschedule = createDailyApptSchedule(randomday);
            returnValue = dailyschedule.addAppointment(name, "Ashesi", "Interview");
            if (returnValue == -1)
            {
               ;
            }
            else{
               interviewDetails = "You have an interview scheduled with the Ashesi admission team on " +DAYS[position] + " at " + dailyschedule.getTimee();
               System.out.println(interviewDetails);
               return returnValue;
            }
         }
         else
         {
            returnValue = apptsForTheWeek[position].addAppointment(name, "Ashesi", "Interview");
            if (returnValue == -1)
            {
               ;
            }
            else{
               return returnValue;
            }
         }
      }



   }

   /**
    * A method that cancels or removes the appointment in a given timeslot on a given day
    * @param day represents the given day the appointment will be cancelled
    * @param timeSlot represents the timeslot that the appointment will be cancelled
    */
   // Cancels (removes) the appointment in a given timeslot on
   // a given day
   public void cancelAppointment(Day day, int timeSlot)
   {
      int indexOfDay = day.ordinal();
      apptsForTheWeek[indexOfDay].removeAppointment(timeSlot);
   }

   /**
    * A method to reschedule an appointment on a given day at a given time
    * @param day represents the day of the appointment that is going to be reschedules
    * @param name represents the name of the person trying to reschedule the appointment
    * @param newTimeSlot represents the new time of the appointment
    */
   public void rescheduleAppointment(Day day, String name, int newTimeSlot)
   {
      int indexOfDay = day.ordinal();
      apptsForTheWeek[indexOfDay].rescheduleAppointment(name, newTimeSlot);
   }

   public String getInterviewDetails()
   {
      return interviewDetails;
   }

}