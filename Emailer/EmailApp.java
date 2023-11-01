package Emailer;
/*
 * Robert Fudala
 * 11/1/2023
 * 
 * This program uses Email.java and EmailWriter.java to
 * simulate an email system by asking the user whether they
 * want to create an email, list their emails, send their emails,
 * write their emails to a file, or exit. If they choose to create an
 * email it will ask the user the nessecary information to create the email
 * and then creates the information. If they choose to list their emails then
 * it will list their current emails. If they choose to send their emails then
 * it will send their emails. If they choose to write to a file then it will ask
 * for the name of the file to write to and then attempt to write to that file and
 * say whether or not it was successful. If they chhose to exit then it will exit
 * and if they choose an invalid option it will say it is invalid.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class EmailApp 
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int answer;
        ArrayList<Email> emails = new ArrayList<Email>();

        printWelcomeBanner();
        do
        {
            try
            {
                printMenu();
                answer = scan.nextInt();
            }
            catch (Exception ex)
            {
                answer = 0;
            }
            scan.nextLine();

            if (answer == 1)
            {
                System.out.print("Enter recipients' email: ");
                String recipients = scan.nextLine().trim();
                System.out.print("Enter subject: ");
                String subject = scan.nextLine().trim();
                System.out.print("Enter body: ");
                String body = scan.nextLine().trim();
                emails.add(new Email(recipients, subject, body));
                System.out.println();
            }
            else if (answer == 2)
            {
                EmailPrinter.printToScreen(emails);
            }
            else if (answer == 3)
            {
                for (Email email: emails)
                {
                    email.send();
                }
                System.out.println("All emails have been sent.\n");
            }
            else if (answer == 4)
            {
                System.out.print("Enter the name of the file to save: ");
                String fname = scan.nextLine().trim();
                if (EmailPrinter.writeToFile(emails, fname))
                {
                    System.out.println("Emails were saved successfully.\n");
                }
                else
                {
                    System.out.println("Something went wrong writing to the file.]n");
                }
            }
            else if (answer == 5){}
            else
            {
                System.out.println("That is not a valid option.\n");
            }

        } while(answer != 5);
        scan.close();
        System.out.println("\nThank you for using this program!");
    }
    /**
     * This prints the welcome banner
     */
    public static void printWelcomeBanner()
    {
        System.out.println("*".repeat(80));
        System.out.printf("%50s", "Emailer Version 1.0\n");
        System.out.println("*".repeat(80));
    }
    /**
     * This prints the menu
     */
    public static void printMenu()
    {
        System.out.println("Here are your choices:");
        System.out.println("1. Write email");
        System.out.println("2. List emails");
        System.out.println("3. Send emails");
        System.out.println("4. Save emails to file");
        System.out.println("5. Exit");
        System.out.print("Enter the number of your choice: ");
    }
}
