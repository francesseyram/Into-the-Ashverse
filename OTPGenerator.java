/**
 * A class to represent a One Time Password Generator
 */

import java.util.Random;

public class OTPGenerator {
    //instance variables
    private String generatedPassword;

    private long generatedTime;

    //constructor
    public OTPGenerator(){
        generateOTP();
    }

    /**
     * A method that generates an OTP
     * @return a string that is the one time password
     */
    private String generateOTP(){
        Random random = new Random();
        StringBuilder otpBuilder = new StringBuilder();
        for(int i = 0; i < 5 ; i++){
            int randomNumber = random.nextInt(10);
            otpBuilder.append(randomNumber);
        }
        generatedPassword = otpBuilder.toString();
        generatedTime = System.currentTimeMillis();
        return generatedPassword;
    }

    /**
     * A method that verifies the one time password
     * @param input string representing the inputted OTP
     * @return an int. 1 if it is equal and -1 if not
     */
    public int verifyOTP(String input){
        int expiryTimeInMilliSeconds = 60000;
        if(System.currentTimeMillis() - generatedTime > expiryTimeInMilliSeconds){
            return 0;
        }
        if(input.equals(generatedPassword)){
            return 1;
        }
        else{
            return -1;
        }
    }

    //Accessor method
    public String getGeneratedPassword(){
        return generatedPassword;
    }

    //String representation of the object
    public String toString(){
        return "Generated Password: " + generatedPassword;
    }

}
