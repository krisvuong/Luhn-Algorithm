import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
import java.net.URL;

class CustomerSystem{
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";
        
        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)) {
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                generateCustomerDataFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    
    /**
     * Description - Enters customer information into a csv file
     * 
     * @author - Kris Vuong
     * @throws - IOException
     */
    public static void enterCustomerInfo()throws IOException{
      Scanner reader = new Scanner(System.in);    //Initizalize Scanner
      
      //Declare necessary variables for while loops
      boolean validPostal = false;
      boolean validCredit = false;
      
      //Prompt customer information
      System.out.println("Enter first name");
      String first = reader.nextLine() + ",";    //Add comma (delimiter)
      System.out.println("Enter last name");
      String last = reader.nextLine() + ",";
      System.out.println("Enter city");
      String city = reader.nextLine() + ",";
      
      //Prompt postal code input until valid
      String postal = "";
      while (validPostal == false){
        System.out.println("Enter postal code");
        postal = reader.nextLine() + ",";
        validPostal = validatePostalCode(postal);  //calls validatePostalCode method
      }
      
      //Prompt credit card input until valid
      String credit = "";
      while (validCredit == false){
        System.out.println("Enter credit card number");
        credit = reader.nextLine() + ",";
        validCredit = validateCreditCard(credit);  //calls validateCreditCard method
      }
      
      //Create new CSV file
      FileWriter fw = new FileWriter("CustomerFile.csv", true);  //"true": if the file already exists, then data is added to the file rather than overwriting current data
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter (bw);
      
      //Write customer information into CustomerFile.csv
      pw.println();    //Start a new row for each customer's data
      pw.print(uniqueIDGenerator() + ",");    //Calls the ID generator and prints the unique value into the csv with the customer's information
      pw.print(first);
      pw.print(last);
      pw.print(city);
      pw.print(postal);
      pw.print(credit);
      pw.close();    //Close PrintWriter
    }
    
    /**
     * Description - Validates the postal code
     * 
     * @author - Kris Vuong
     * @param inputPostal- String of user's input postal code
     * @return - boolean true/false
     * @throws - FileNotFoundException
     */
    public static boolean validatePostalCode(String inputPostal) throws FileNotFoundException {
      inputPostal = inputPostal.replaceAll(" ", "");  //Remove any blank spaces ("l   4 h  " -> "l4h")
      
      //Check that the inputted postal code is at least three characters
      if(inputPostal.length() >= 3){
        
        //Format the first three characters of the inputted postal to uppercase
        inputPostal = inputPostal.substring(0,3);
        inputPostal = inputPostal.toUpperCase();
        
        //Create a file instance of the csv containing existing postal codes
        File postalCodes = new File("postal_codes.csv");
        Scanner reader = new Scanner(postalCodes);
        
        //Read the first three characters of valid postal codes
        while(reader.hasNextLine()){
          String line = reader.nextLine();
          String validPostal = line.substring(0,line.indexOf('|'));  //Stops at delimiter "|"
          
          //Return TRUE if the inputted postal code matches an existing one
          if(inputPostal.equals(validPostal)){
            return true;
          }
        }
        //Return FALSE and print an error message for an invalid postal code
        System.out.println("Invalid postal code. Retry:");
        return false;
      }
      
      //Return FALSE and print an error message if the inputted postal code is less than three characters
      else{
        System.out.println("Your postal code must be at least three characters.");
        return false;
      }
    }

    
    /*
    *Description:Validates the credit card number that is passed through it
    *@ author - Gordon Wu 
    *@ param cardString - The credit card number that the user inputs. 
    *@ return - returns a boolean that indicates whether the credit card number is valid or not 
    */ 
      
    public static boolean validateCreditCard(String cardString) {    
        //Initialize variables 
        Integer len = cardString.length();
        Integer len2 = 0; 
        Boolean isValid = false;
        Integer reversedNum = 0;
        Integer modulusTen = 0; 
        Integer sumEven = 0;
        Integer sumOdd = 0;
  
        //Remove the comma first since we know where it is 
        String newString = cardString.substring(0, len-1);
        //Convert credit card number from string to an integer, this also "breaks" if the user enters space(s) or invalid characters
        Integer cardNumb = Integer.parseInt(newString); 



        //Checks if card number is atleast 9 digits in length 
        if (cardNumb > 99999999){
          //Reverses the digits of the credit card 
          while(cardNumb != 0){
            //Takes each number from right to left using modulus of 
            modulusTen = cardNumb%10; 
            //10 times the reversed number + the numbers from right to left, thus reversing the digits
            reversedNum = modulusTen + 10*reversedNum;
            reversedNum = modulusTen + 10*reversedNum;            
            //To make sure it doesn't keep taking the same value 
            cardNumb = cardNumb/10; 
          }

          //Calculating the partial sum of both even and odd numbers
          // Fix up some values
          //Changing some values to fit the loops 
          len = len - 1;
          len2 = len; 
          modulusTen = 0; 
          //Use for loop to take each number 
          //Use for loop to take each number
          for (int i = 0; i<len; i++){
            //First take the number from right to left using modulus
            modulusTen = reversedNum%10;
            //Next remove the number that was used 
            reversedNum = reversedNum/10; 

            //If the number of the reversed number is in its odd poisition
            //If the number of the reversed number is in its odd poisition. When the length is odd, we know that the far most right number should be an odd positioned number. 
            if(len2%2 != 0){
              sumOdd = sumOdd + modulusTen; 
            }
            //If the number of the reversed number is in its even poisition 
            //If the number of the reversed number is in its even poisition. When the length is even, we know that the far most right number should be an even positioned number.
            else if(len2%2 == 0){
              modulusTen = modulusTen*2; 
                //If the number multiplied by 2 is greater than 9. 
                if(modulusTen>9){
                  //Initialize integers
                  Integer partialNumber = modulusTen; 
                  Integer modulusTen2 = 0;
                  modulusTen = 0; 

                  //Take the partial sum of the 2 digit number 
                  //Take the partial sum of the 2 digit number
		  //Loops twice
                  for (Integer j = 1 ; j< 3 ;j++){
                    modulusTen2 = partialNumber%10; 
                    modulusTen = modulusTen2 + modulusTen;
                    modulusTen = modulusTen2 + modulusTen;     //Adds the sum of the digits
                    partialNumber /=10;                
                  }
                }
               
              sumEven = sumEven + modulusTen; //Sum of the even positioned numbers
            }
  
            len2 = len2 -1; //Changes the position from odd to even or even to odd
          }
  
          //If the sum of both even and odd are divisible by ten 
          if((sumEven+sumOdd)% 10 == 0){
            isValid = true;
            return isValid; 
          }
          //else credit card is invalid
          else{
          return isValid;
          }
        }
  
        //else credit card is invalid
        else{
          return isValid;        
        }
    }
    
    /**
     * Description - Generates a unique ID value for each customer/run
     * 
     * @author - Kris Vuong
     * @return - int value of ID
     * @throws - IOException
     */
    public static int uniqueIDGenerator()throws IOException{
      String line = "";
      
      //Create new file instance of an existing text file
      File textLine = new File("uniqueID.txt");
      
      //Read the text file using scanner
      Scanner reader = new Scanner(textLine);
      while(reader.hasNextLine()){
        line = reader.nextLine();
      }
      reader.close();
      
      //Convert the .txt file data to an integer
      int count = Integer.parseInt(line);
      
      //Increase the ID value by 1
      count++;
      
      //Write the current ID value into the text file
      FileWriter fwrite = new FileWriter("uniqueID.txt");
      PrintWriter pwrite = new PrintWriter (fwrite);
      
      pwrite.println(count);
      pwrite.close();
      
      //Return the unique ID
      return count;
    }
    
    /**
    * Description - Generates a new csv containing all customer data
    * 
    * @author - Kris Vuong
    * @throws - IOException
    */
    public static void generateCustomerDataFile() throws IOException{
      Scanner reader = new Scanner(System.in);  //Initialize Scanner
      
      //Prompt name of file
      System.out.println("What would you like to name the file?");
      String fileName = reader.nextLine();
      
      //Create empty CSV file
      FileWriter fwrite = new FileWriter(fileName + ".csv");
      BufferedWriter bwrite = new BufferedWriter(fwrite);
      PrintWriter pwrite = new PrintWriter (bwrite);
      
      //Read current CSV containing customer information 
      String line = "";
      File textLine = new File("CustomerFile.csv");
      reader = new Scanner(textLine);
      
      //Write customer data into the new file
      while(reader.hasNextLine()){
        line = reader.nextLine();
        pwrite.println(line);
      }
      reader.close();    //Close Scanner
      pwrite.close();    //Close PrintWriter
      
      //Print file location (directory)
      URL file = CustomerSystem.class.getResource(fileName + ".csv");    //Use URL to locate the directory of the provided file name
      String fileURL = file.toString();    //Converts the URL directory to a String
      String location = (fileURL.substring(5));  //Removes "file:" from the directory
      System.out.println("The customer data file is located in: " + location);
    }
}
