/*
 * Robert Fudala
 * 10/11/2023
 * Text Analizer
 * This program takes a text file and
 * finds how many vowels, consonenets, and 
 * words are in the file and can print
 * a summary of that file onto another file.
 */


package TextAnalyzer;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
//C:\Users\robr1\OneDrive\Desktop\story.txt
//C:\Users\robr1\OneDrive\Desktop\text.txt
public class TextAnalyzer 
{
    public static void main(String[] args)
    {
        printWelcome();
        Scanner scan = new Scanner(System.in);
        String fileString;
        do{
        System.out.print("What text file would you like to analyze? ");
        String fileName = scan.nextLine().trim();
        fileString = readFile(fileName);
        if (fileString == null)
        {
            System.out.println("Something went wrong reading the file.");
        }
        } while (fileString == null);
        boolean noError;
        int response = 0;
        /*try
        {
            Scanner fileScan = new Scanner(new File(fileName));
            String fileString = "";
            
            
            while (fileScan.hasNextLine())
            {
                fileString += fileScan.nextLine();
                fileString += " ";
            }
            fileString = fileString.trim();
            */
            

            do
            {
                
                do
                {
                    try
                    {
                        printMenu();
                        response = scan.nextInt();
                        scan.nextLine();
                        noError = false;
                    }
                    catch (Exception ex)
                    {
                        System.out.println("You have to enter the number of your choice. You didn't type a number.\n");
                        noError = true;
                        scan.nextLine();
                    }
                } while (noError);
                
                if (response == 1)
                {
                    /*int totalVowels = 0;
                    for (int i = 0; i < fileString.length(); i++)
                    {
                        if (fileString.substring(i,i+1).toLowerCase().equals("a") || fileString.substring(i,i+1).toLowerCase().equals("e") || fileString.substring(i,i+1).toLowerCase().equals("i") || fileString.substring(i,i+1).toLowerCase().equals("o") || fileString.substring(i,i+1).toLowerCase().equals("u"))
                        {
                            totalVowels++;
                        }
                    }*/
                    System.out.printf("There are %d vowels.\n\n", countVowels(fileString));
                }
                else if (response == 2)
                {
                    /*int totalConsonents = 0;
                    for (int i = 0; i < fileString.length(); i++)
                    {
                        if (((int)(fileString.toUpperCase().charAt(i))) > 65 && ((int)(fileString.toUpperCase().charAt(i))) <= 90 && ((int)(fileString.toUpperCase().charAt(i))) != 65 && ((int)(fileString.toUpperCase().charAt(i))) != 69 && ((int)(fileString.toUpperCase().charAt(i))) != 73 && ((int)(fileString.toUpperCase().charAt(i))) != 79 && ((int)(fileString.toUpperCase().charAt(i))) != 85)
                        {
                            totalConsonents++;
                        }
                    }*/
                    System.out.printf("There are %d consonents.\n\n", countConsonents(fileString));
                }
                else if (response == 3)
                {
                    /*int totalWords = 0;
                    for (int i = 0; i < fileString.length(); i++)
                    {
                        
                    }*/
                    System.out.printf("There are %d words.\n\n", countWords(fileString));
                }
                else if (response == 4)
                {
                    System.out.print("Enter the name of the file to write the summary: ");
                    String answer = scan.nextLine();
                    boolean summaryStatus = writeSummaryToFile(answer, fileString);
                    if (summaryStatus)
                    {
                        System.out.println("The summary was written to a file.\n");
                    }
                    else
                    {
                        System.out.println("Something went wrong opening/writing the file\n");
                    }
                    
                }
                else if (response == 5)
                {}
                else
                {
                    System.out.println("That's not a valid choice.\n");
                }
            } while (response != 5);
            scan.close();
            System.out.println("Thank you for using this program.");

        //}
        /*catch (Exception ex)
        {
            //ex.printStackTrace();
            System.out.println("Something went wrong opening the file");
        }*/

    }

    /**
     * Prints the welcome banner without
     * taking or returning variables
     */
    public static void printWelcome()
    {
        System.out.println("*".repeat(79));
        System.out.printf("%54s", "Welcome to TextAnalyzer V1.0\n");
        System.out.println("*".repeat(79) + "\n");
    }
    /**
     * Prints the menu without taking
     * or returning variables
     */
    public static void printMenu()
    {
        System.out.println("Here are your options:");
        System.out.println("1. Count the number of vowels.");
        System.out.println("2. Count the number of consonents.");
        System.out.println("3. Count the number of words.");
        System.out.println("4. Print a summary file.");
        System.out.println("5. Quit");
        System.out.print("Enter the number of your choice: ");
    }
    /**
     * 
     * @param text is the text from the file
     * that is passed into the function
     * @return returns the ammount of vowels
     * in the text string as an int
     */
    public static int countVowels(String text)
    {
        int totalVowels = 0;
        for (int i = 0; i < text.length(); i++)
        {
            if (text.substring(i,i+1).toLowerCase().equals("a") || text.substring(i,i+1).toLowerCase().equals("e") || text.substring(i,i+1).toLowerCase().equals("i") || text.substring(i,i+1).toLowerCase().equals("o") || text.substring(i,i+1).toLowerCase().equals("u"))
            {
                totalVowels++;
            }
        }
        return totalVowels;
    }
    /**
     * 
     * @param text is the text from the file
     * that is passed into the function
     * @return returns the ammount of consonents
     * in the text string as an int
     */
    public static int countConsonents(String text)
    {
        int totalConsonents = 0;
        for (int i = 0; i < text.length(); i++)
        {
            if (((int)(text.toUpperCase().charAt(i))) > 65 && ((int)(text.toUpperCase().charAt(i))) <= 90 && ((int)(text.toUpperCase().charAt(i))) != 65 && ((int)(text.toUpperCase().charAt(i))) != 69 && ((int)(text.toUpperCase().charAt(i))) != 73 && ((int)(text.toUpperCase().charAt(i))) != 79 && ((int)(text.toUpperCase().charAt(i))) != 85)
            {
                totalConsonents++;
            }
        }
        return totalConsonents;
    }
    /**
     * 
     * @param text is the text from the file
     * that is passed into the function
     * @return returns the ammount of words
     * in the text string as an int
     */
    public static int countWords(String text)
    {
        int totalWords = 1;
        for (int i = 0; i < text.length(); i++)
        {
            if (text.substring(i,i+1).equals(" "))
            {
                totalWords++;
            }
        }
        return totalWords;
    }
    /**
     * 
     * @param fileName is the name of the file
     * that wants to be read
     * @return returns the text of the file as a string
     */
    public static String readFile(String fileName)
    {
        try
        {
            Scanner fileScan = new Scanner(new File(fileName));
            String fileString = "";
            
            while (fileScan.hasNextLine())
            {
                fileString += fileScan.nextLine();
                fileString += " ";
            }
            fileString = fileString.trim();
            fileScan.close();
            return fileString;
        }
        catch (Exception ex)
        {
            //ex.printStackTrace();
            return null;
        }

    }
    /**
     * 
     * @param fileToWriteName is the name of the file
     * to write the summary into
     * @param fileToSummarize is the summary of the file
     * @return returns true or false on whether or not an error occurs
     */
    public static boolean writeSummaryToFile(String fileToWriteName, String fileToSummarize)
    {
        boolean noError = true;
        try
        {
            Scanner file = new Scanner(new File(fileToWriteName)); //THIS IS HERE TO MAKE AN ERROR IF THE FILE DOESN'T EXIST
            file.close();
            PrintWriter textWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileToWriteName))));
            textWriter.println("This is the text:");
            textWriter.println(fileToSummarize);
            textWriter.printf("\nThere are %d vowels, %d consonents, and %d words.", countVowels(fileToSummarize), countConsonents(fileToSummarize), countWords(fileToSummarize));
            textWriter.close();
        }
        catch (Exception ex)
        {
            noError = false;
        }

        return noError;
    }
}
