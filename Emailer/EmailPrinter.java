package Emailer;
/*
 * Robert Fudala
 * 11/1/2023
 * 
 * This is a library class that either prints out an ArrayList of emails
 * or write them to a file.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailPrinter 
{
    /**
     * This takes in an ArrayList of emails and prints those emails to the screen
     * @param emails An ArrayList of emails
     */
    public static void printToScreen(ArrayList<Email> emails)
    {
        for (Email email : emails)
        {
            System.out.println(email);
        }
    }

    /**
     * This takes in an ArrayList of emails and the name of the file that
     * the user wants to write the emails to and returns true if an error did not occur and false if one did
     * @param emails An ArrayList of emails
     * @param fname The name of the file that the user wants to write the emails to
     * @return returns true if there wasn't an error and false if there was 
     */
    public static boolean writeToFile(ArrayList<Email> emails, String fname)
    {
        boolean noError;
        try
        {
            Scanner fscan = new Scanner(fname); //CAUSES AN ERROR IF THE FILE DOESN'T EXIST
            fscan.close();
            PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
            for (Email email : emails)
            {
                fileWriter.println(email.toTabedString());
            }
            fileWriter.close();
            noError = true;
        }
        catch (Exception ex)
        {
            noError = false;
        }
        return noError;
    }
}
