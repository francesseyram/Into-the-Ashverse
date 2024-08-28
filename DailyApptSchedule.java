
/**
 * A class to represent the appointment schedule for a given day.
 * Each day is assumed to have hour-long timeslots starting at 8am and
 * with the final timeslot starting at 4pm
 **/
public class DailyApptSchedule {

  private Appointment[] apptsForTheDay;

  public static final int NUM_SLOTS = 9;
  static String myTime;
  public static final String[] TIMES = {"8am", "9am", "10am", "11am",
                                        "12noon", "1pm", "2pm", "3pm", "4pm"};

  // No-arg constructor creates an empty schedule for a day
  public DailyApptSchedule()
  {
    apptsForTheDay = new Appointment[9];
  }

  /**
   * A method to display the list of appointments for the day
   * In the format:
   *    time: appointment_info
   *    time: appointment_info ... etc
   * Any empty slots (null Appointments in the array) should be listed as Free
   */
  public void displayAppointments()
  {
    for(int i = 0; i < apptsForTheDay.length; i++)
    {
      if (apptsForTheDay[i] == null)
      {
        System.out.println("Free");
      }
      else
      {
        System.out.println(TIMES[i] + ": " + "Appointment for " + apptsForTheDay[i].getStudentName() + " " + "at " + apptsForTheDay[i].getVenue() + " for the purpose of " + apptsForTheDay[i].getPurpose());
      }
    }
  }

  /**
   * A method to add the given appointment to the schedule in the specified timeslot
   * @param whichSlot represents the index of the timeslot (Eg. 0 -> 8am, 1 -> 9am, ...)
   * @param appt represents the appointment object
   * @return true if it was successful and false if not successful
   */
  public boolean addAppointment(int whichSlot, Appointment appt)
  {
    if(apptsForTheDay[whichSlot] != null)
    {
      return false;
    }
    else
    {
      apptsForTheDay[whichSlot] = appt;
      return true;
    }
  }

  /**
   * A method to add an appointment for the given person, venue and purpose to the schedule in the specified timeslot.
   * @param whichSlot represents the index of the timeslot (Eg. 0 -> 8am, 1 -> 9am, ...)
   * @param n represents the name of the student
   * @param v represents the location of the appointment
   * @param p represents the reason for the meeting
   * @return true if it was successful and false if not successful (i.e. if the given slot is invalid or taken)
   */
  public boolean addAppointment(int whichSlot, String n, String v, String p)
  {
    if (apptsForTheDay[whichSlot] != null)
    {
      return false;
    }
    else
    {
      Appointment appoint = new Appointment(n, v, p);
      apptsForTheDay[whichSlot] = appoint;
      return true;
    }


  }

  /**
   * A method to add the given appointment to the schedule in any free timeslot.
   * @param appt represents the appointment object
   * @return the index of the chosen timeslot or -1 if no free timeslot exists.
   */
  public int addAppointment(Appointment appt)
  {
    int accum = 0;
    for (int i = 0; i < apptsForTheDay.length; i++)
    {
      if(apptsForTheDay[i] == null)
      {
        apptsForTheDay[i] = appt;
        accum ++;
        return i;
      }

    }
    if (accum == 0)
    {
      return -1;
    }
    return -1;
  }

  public int generanteRandomNumber()
  {
    int index = (int)(Math.random()*9);
    return index;
  }

  /**
   * A method to add an appointment on at a random time
   * @param n represents the name of the student
   * @param v represents the location of the appointment
   * @param p represents the reason for the meeting
   * @return the index of the chosen timeslot or -1 if no free timeslot exists.
   */
  public int addAppointment(String n, String v, String p)
  {
    n = n.toUpperCase();
    Appointment appoint = new Appointment(n, v, p);
    int accum = 0;
    int index = 0;
    while (true)
    {
      int position = generanteRandomNumber();
      if (apptsForTheDay[position] == null)
      {
        apptsForTheDay[position] = appoint;
        accum ++;
        myTime = TIMES[position];
        break;
      }
      else {
        continue;
      }
    }
    if (accum == 0)
    {
      return -1;
    }
    else
    {
      return index;
    }

  }

  public String getTimee()
  {

    return myTime;
  }

  /**
   * Remove the appointment in the given slot
   * @param slot the index of the timeslot
   * @return true if operation was successful and false if not
   */
  public boolean removeAppointment(int slot)
  {
    if (slot <=  apptsForTheDay.length && apptsForTheDay[slot] != null)
    {
      apptsForTheDay[slot] = null;
      return true;
    }
    else
    {
      return false;
    }

  }

  /**
   * Remove the appointment corresponding to the given student name
   * @param n represents the name of the student
   * @return true if operation was successful and false if not
   */
  public boolean removeAppointment(String n)
  {
    n = n.toUpperCase();
      for(int i = 0; i < apptsForTheDay.length; i++)
      {
        if(apptsForTheDay[i].getStudentName() == n)
        {
          apptsForTheDay[i] = null;
          return true;
        }
      }
      return false;
  }

  /**
   * Reschedule an appointment to any available space corresponding to the given Appointment Object
   * @param appt represents the Appointment object
   * @param previousTimeSlot represents the time slot that would be rescheduled
   * @return true if the rescheduling operation was successful and false if not
   */

  public boolean rescheduleAppointment(Appointment appt, int previousTimeSlot)
  {
    for(int i = 0; i< apptsForTheDay.length; i++)
    {
      if (apptsForTheDay[i] == null)
      {
        apptsForTheDay[i] = appt;
        apptsForTheDay[previousTimeSlot] = null;
        return true;
      }
    }
    return false;
  }

  /**
   * Reschedule an appointment to any available space corresponding to the given Appointment Object
   * @param n represents the name of the student who wants to reschedule
   * @return true if the rescheduling operation was successful and false if not
   */

  public boolean rescheduleAppointment(String n)
  {
    n = n.toUpperCase();
    for(int i = 0; i < apptsForTheDay.length; i++)
    {
      if (apptsForTheDay[i] != null)
      {
        if(apptsForTheDay[i].getStudentName().equals(n))
        {
          for(int j = 0; j < apptsForTheDay.length; j++)
          {
            if (apptsForTheDay[j] == null)
            {
              apptsForTheDay[j] = apptsForTheDay[i];
              apptsForTheDay[i] = null;
              return true;
            }
            else
            {
              continue;
            }
          }
        }
      }
      else
      {
        continue;
      }

    }
    return false;
  }

  /**
   * Reschedule an appointment to a given space corresponding to the given Appointment Object
   * @param appt represents the Appointment object to be rescheduled
   * @param previousTimeSlot represents the time slot that would be rescheduled
   * @param newTimeSlot represents the new time slot that the Appointment object would be rescheduled to
   * @return true if the rescheduling operation was successful and false if not
   */

  public boolean rescheduleAppointment(Appointment appt, int previousTimeSlot, int newTimeSlot)
  {
    if (apptsForTheDay[newTimeSlot] == null)
    {
      apptsForTheDay[newTimeSlot] = appt;
      apptsForTheDay[previousTimeSlot] = null;
      return true;
    }
    else
    {
      return false;
    }

  }

  /**
   * Reschedule an appointment to a given space corresponding to the given Appointment Object
   * @param n represents the name of the student trying to reschedule the appointment
   * @param newTimeSlot represents the new time slot that the Appointment object would be rescheduled to
   * @return true if the rescheduling operation was successful and false if not
   */
  public boolean rescheduleAppointment(String n ,int newTimeSlot)
  {
    n = n.toUpperCase();

    if (apptsForTheDay[newTimeSlot] == null)
    {
      for (int j = 0; j < apptsForTheDay.length; j++)
      {
        if (apptsForTheDay[j] != null)
        {
          if (apptsForTheDay[j].getStudentName().equals(n))
          {
            apptsForTheDay[newTimeSlot] = apptsForTheDay[j];
            apptsForTheDay[j] = null;
            return true;
          }
        }
        else{
          continue;
        }

      }
    }
    else
    {
      return false;
    }


   return false;
  }



}





