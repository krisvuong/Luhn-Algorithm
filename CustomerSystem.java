// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
import java.net.URL;
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

            if (userInput.equals(enterCustomerOption)){
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
    
    public static void enterCustomerInfo() throws IOException {
    }
    
    //VALIDATE POSTAL CODE
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
    public static void generateCustomerDataFile() throws IOException {
      Scanner reader = new Scanner(System.in);
      
      //Prompt user to enter name of customer file
      System.out.println("What would you like to name the file?");
      String fileName = reader.nextLine();
      
      //Create empty CSV file
      FileWriter fwrite = new FileWriter(fileName + ".csv");
      BufferedWriter bwrite = new BufferedWriter(fwrite);
      PrintWriter pwrite = new PrintWriter (bwrite);
      
      //Read current existing file of customer information 
      String line = "";
      File textLine = new File("CustomerFile.csv");
      reader = new Scanner(textLine);
      
      //Write customer information into new file
      while(reader.hasNextLine()){
        line = reader.nextLine();
        pwrite.println(line);
      }
      reader.close();
      pwrite.close();
      
      //Print customer file location (directory)
      URL file = CustomerSystem.class.getResource(fileName + ".csv");
      String fileURL = file.toString();
      String location = (fileURL.substring(5));
      System.out.println("The customer data file is located in: " + location);
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}