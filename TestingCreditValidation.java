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
            
        //Prints credit number as well because code won't run in this case
        System.out.println(validCredit + credit);
      }
      reader.close();
    }


    
    /*Docstrings here
    *Description:
    *@ param.
    *@
    */ 
      
    public static boolean validateCreditCard(String cardString) {    
        //Initalize variables 
        Integer len = cardString.length();
        System.out.println(len);
        /*
        //Remove the comma first, only need to take the index and don't need to actually find the comma since we know where it is
        String newString = (cardString.charAt(len, 1));
        }
        //Convert credit card number from string to an integer
      }
        */
          //Integer cardNumber = Integer.parseInt(newString); 
        
        


          
          //System.out.println(cardNum);
          //Declare variables
          Boolean isValid = false;
          return isValid;
    }

 
      //Checks if the card number is atleast 9 digits in length
      
      /*
   
            
            if (cardNumb < 99999999){
                System.out.println("Passes the 9 digits");
                
                isValid = true; 
              
              //Partial sum validation will be here
            
            }
         
          
        //If credit card is invalid
        else{
            return isValid;
       
        }
        
        //Maybe return whether its valid or not
      }
      */ 
  
}

     

