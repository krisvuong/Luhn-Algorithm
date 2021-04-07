// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
<<<<<<< Updated upstream
import java.io.File;
import java.io.FileNotFoundException;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args) throws FileNotFoundException {
=======
import java.io.*;
// More packages may be imported in the space below

class CustomerSystem{
  
    public static void main(String[] args) throws IOException {
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
              
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    
    public static void enterCustomerInfo() throws FileNotFoundException {
=======
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo() throws IOException {
      Scanner reader = new Scanner(System.in);
      
      boolean validPostal = validatePostalCode();
      
      //Prompt customer info
      System.out.println("Enter first name");
      String first = reader.nextLine();
      System.out.println("Enter last name");
      String last = reader.nextLine();
      System.out.println("Enter city");
      String city = reader.nextLine();
      System.out.println("Enter postal code");
      String postal = reader.nextLine();
      System.out.println("Enter credit card number");
      String credit = reader.nextLine();
      
      //Create CSV file
      FileWriter fw = new FileWriter("CustomerFile.csv", true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter (bw);
      
      //Enter customer info into csv file
      first = first + ",";
      last = last + ",";
      city = city + ",";
      postal = postal + ",";
      credit = credit + ",";
      
      //pw.print(uniqueIDGenerator());  (uncomment this line when merging to main)
      pw.print(first);
      pw.print(last);
      pw.print(city);
      pw.print(postal);
      pw.print(credit);
      pw.println();
      pw.close();
>>>>>>> Stashed changes
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
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}