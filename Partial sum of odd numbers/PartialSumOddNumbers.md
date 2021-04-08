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
      Integer len2 = 0; 
      Boolean isValid = false;
      Integer reversedNum = 0;
      Integer modulusTen = 0; 
      Integer sumEven = 0;
      Integer sumOdd = 0;

      //Remove the comma first, we know where it is 
      String newString = cardString.substring(0, len-1);
      //Convert credit card number from string to an integer, this also "breaks" if the user enters space(s) or invalid characters
      Integer cardNumb = Integer.parseInt(newString); 
 
      //Checks if card number is atleast 9 digits in length 
      if (cardNumb > 99999999){
        //Reverses the digits of the credit card 
        while(cardNumb != 0){
          //Calculates the partial sum of even numbers
          //Takes each number from right to left using modulus of 
          modulusTen = cardNumb%10; 
          //10 times the reversed number + the numbers from right to left, thus reversing the digits
          reversedNum = modulusTen + 10*reversedNum;
          //To make sure it doesn't keep taking the same value 
          cardNumb = cardNumb/10; 
        }
        //Calculating the partial sum of both even and odd numbers
        // Fix up some values
        len = len - 1;
        len2 = len; 
        modulusTen = 0; 

        //Use for loop to take each number 
        for (int i = 0; i<len; i++){
 
          //First take the number from right to left using modulus
          modulusTen = reversedNum%10;
          //Next remove the number that was used 
          reversedNum = reversedNum/10; 

          System.out.println(i + "." + reversedNum);

          //If the number of the reversed number is in its odd poisition
          if(len2%2 != 0){
            sumOdd = sumOdd + modulusTen; 
          }
          //If the number of the reversed number is in its even poisition 
          else if(len2%2 == 0){
            sumEven = sumEven + modulusTen; 
          }
          
          len2 = len2 -1;
          System.out.println("Sum of even." + sumEven + " Sum of odd. " + sumOdd);



            //Calculates the sum of both partial sums
    
        }


          
        
        //Each digit is doubled
        //if an even number digit is greater than 9, it will take the partial sum
        //If divisible by 10


        
        isValid = true; 
        return isValid; 
      }
      
      //else credit card is invalid
      else{
      return isValid;
      }
    }
  }
      
  

     

