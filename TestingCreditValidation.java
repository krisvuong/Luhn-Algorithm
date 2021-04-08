/*
 * 
 * Date:April 5, 2021
 * Name:Gordon Wu
 * Teacher:Mr.Ho
 * Description:Validating credit card
 * */


//Import packages
import java.util.Scanner;

class creditCardInfo{
    public static void main(String[] args) {
      Scanner reader = new Scanner(System.in);
        
      //This will be here to test if it works
      boolean validCredit = false;
      String credit = "";
      while (validCredit == false){
        System.out.println("Enter credit card number");
        credit = reader.nextLine() + ","; 
            
        //Calls the method and assigns valid credit its new value
        validCredit = validateCreditCard(credit);
            
        
      }
      reader.close();
    }


    /*
    *Description:Validates the credit card number that is passed through it
    *@ param cardString - The credit card number but is a string  
    *@ return - returns a boolean whether the card is valid or not 
    */ 
      
    public static boolean validateCreditCard(String cardString) {    
      //Initalize variables 
      Integer len = cardString.length();
      Boolean isValid = false;
      //Integer sumEven = 0;
      //Integer sumOdd = 0;
        
      //Remove the comma first, we know where it is 
      String newString = cardString.substring(0, len-1);
      
      //Convert credit card number from string to an integer, this also "breaks" if the user enters space(s) or invalid characters
      Integer cardNumb = Integer.parseInt(newString); 
      
      //Checks if card number is atleast 9 digits in length 
      if (cardNumb < 99999999){
        System.out.println("Passes the 9 digits");
        
        //Reverses the digits of the credit card

        //Calculates the partial sum of even numbers
        
        //Calculates the partial sum of the odd numbers

        //Calculates the sum of both partial sums

        //If divisible by 10

        //else 
        return isValid; 
      }


      //If credit card is invalid
      else{
        return isValid;
      }
    }
      
  
}

     

