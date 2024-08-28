# Into the Ashverse

**Authors:**  
- McNobert Amoah
- Caleb Okwesie Arthur
- Frances Seyram Fiahagbe  
- Jason Papa Kwame Agyeman-Darko  
  

## Introduction

**Into the Ashverse** is an educational program application and enrollment system designed to streamline the application process for institutions. The system mimics a real-world student application process, complete with secure authentication via OTPs, detailed application handling, and even email notifications to provide a seamless and immersive experience for users.

This Java-based project is built to manage various tasks, including handling applicant information, checking program eligibility, processing applications, and managing enrollment decisions.

## Solution Design

### 1. **Person Class**
   - Represents a generic person with attributes like name, email, phone number, age, residence, date of birth, and place of birth.

### 2. **Applicant Class** (Inherits from Person)
   - Represents an applicant for an educational program.
   - Inherits attributes and methods from the Person class.
   - Adds attributes such as education history, applied programs, and financial aid request details.
   - Provides methods for applying to programs, answering application questions, and requesting financial aid.

### 3. **Program Class**
   - Represents an educational program offered by an institution.
   - Contains attributes like the program's name, cutoff grade, and methods to check an applicant's eligibility.

### 4. **OTPGenerator Class**
   - Handles the generation and verification of one-time passwords (OTPs) for secure authentication.

### 5. **Emailer Class**
   - Facilitates sending emails related to the application and enrollment processes, including verification emails, application details, and interview invitations.

### 6. **EducationHistory Class**
   - Represents the education history of an applicant, including attributes like school name and grades.

### 7. **Grade Class**
   - Represents the grades or transcript of an applicant.
   - Provides a method to calculate the applicant's aggregate based on their transcript.

### 8. **Decision Class**
   - Represents decisions related to an applicant's enrollment process, such as application status, appointment date, and confirmation number.
   - Provides methods to set decision status and schedule appointments.

### 9. **Appointment Class**
   - Represents an appointment scheduled as part of the enrollment process.
   - Contains attributes like the appointment date and methods for scheduling.

### 10. **Enrolment Class**
   - Handles the process of enrolling a person (applicant) into a program.
   - Provides a method to apply for enrollment, taking a person, grade, and program as parameters.

### 11. **FinancialAidEnrolment Class** (Inherits from Enrolment)
   - Represents a specialized type of enrollment for financial aid applications.
   - Contains additional attributes related to financial aid, such as the aid amount and reason.

## Relationships

- **Applicant** inherits from Person and has relationships with OTPGenerator, Emailer, Program, and EducationHistory.
- **Enrolment** interacts with Program, Person, and Grade.
- **Decision** is related to Appointment.
- **FinancialAidEnrolment** is a specialized version of Enrolment.

## UML Diagram

[UML Diagram](https://github.com/francesseyram/Into-the-Ashverse/blob/main/Into%20the%20Ashverse.iml)

## Project Summary

Into the Ashverse provides a structured and efficient platform for managing educational program applications and enrollments. The system ensures that the application process is as realistic as possible, including generating OTPs for security, handling detailed educational backgrounds, and managing the financial aid process.

By implementing this project, educational institutions can improve their application processes, making them more streamlined, secure, and user-friendly.

## References

- Korsah, A. (2024). DailyApptSchedule
- Korsah, A. (2024). WeeklyApptSchedule
- Korsah, A. (2024). Appointment
