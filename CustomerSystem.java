// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args) throws IOException {
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
          // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
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
     * Enter customer information.
     * 
     * Customer ID, first name, last name, city, postal code and credit card number are entered into a csv file.
     * The uniqueIDGenerator, validatePostalCode and validateCreditCard methods are called.
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
      //while (validCredit == false){         (uncomment when validateCreditCard is merged)
        System.out.println("Enter credit card number");
        credit = reader.nextLine() + ",";
        //validCredit = validateCreditCard();  //calls validatePostalCode method (uncomment when validateCreditCard is merged)
      //}
      
      //Create new CSV file
      FileWriter fw = new FileWriter("CustomerFile.csv", true);  //"true": if the file already exists, then data is added to the file rather than overwriting current data
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter (bw);
      
      //Write customer information into CustomerFile.csv
      //pw.print(uniqueIDGenerator());         (uncomment this line when uniqueIDGenerator is merged)
      pw.print(first);
      pw.print(last);
      pw.print(city);
      pw.print(postal);
      pw.print(credit);
      pw.println();  //Start a new row for each customer
      pw.close();    //Close PrintWriter
    }
    
    /**
     * Validate the postal code.
     * 
     * The input postal code is validated by comparing its first three characters against a .csv file with existing postal codes.
     * 
     * @author - Kris Vuong
     * @param - String inputPostal
     * @return - boolean true/false
     * @throws - FileNotFoundException
     */
    public static boolean validatePostalCode(String inputPostal) throws FileNotFoundException {
      //Check that the inputted postal code is at least three characters
      inputPostal = inputPostal.replaceAll(" ", "");  //remove any blank spaces
      if(inputPostal.length() >= 3){
        
        //Format the inputted postal code
        inputPostal = inputPostal.toUpperCase();
        inputPostal = inputPostal.substring(0,3);
        
        //Declare the file of existing postal codes
        File postalCodes = new File("postal_codes.csv");
        Scanner reader = new Scanner(postalCodes);
        
        //Read the first three characters of existing postal codes (ex. L4H)
        while(reader.hasNextLine()){
          String line = reader.nextLine();
          String validPostal = line.substring(0,line.indexOf('|'));
          
          //Return TRUE if the inputted postal code matches an existing one
          if(inputPostal.equals(validPostal)){
            return true;
          }
        }
        //Return FALSE for a non-existent postal code
        System.out.println("Invalid postal code. Retry:");
        return false;
      }
      
      //Error if the inputted postal code is less than three characters
      else{
        System.out.println("Your postal code must be at least three characters.");
        return false;
      }
    }
    
    //VALIDATE CREDIT CARD
    public static void validateCreditCard(){
    }
    
    //GENERATE CUSTOMER DATA FILE
    public static void generateCustomerDataFile(){
      
      
      
    }
    
    /**
     * Generate a unique ID value
     * 
     * A text file containing a single integer is used as a counter to generate a unique ID value for each run.
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
    
    
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}