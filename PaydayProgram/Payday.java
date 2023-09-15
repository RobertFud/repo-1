/*
 * Created by Robert Fudala
 * 9/15/2023
 * 
 * Asks the user to enter their name, hours worked
 * this week, hourly rate, if they're in a union,
 * and what percent do they want to put towards medical savings.
 * Then it will print out what their gross payment is
 * then the amounts that will be deducted from it and 
 * then the gross payment after the deductions.
 * 
 */

package PaydayProgram;
import java.util.Scanner;
import java.util.Random;

public class Payday 
{
    public static void main(String[] args)
    {
        //Sets up a Scanner variable to be used later
        Scanner scan = new Scanner(System.in);
        
        //Sets up all the variables needed for calculating
        String name;
        double hoursWorked;
        double hourlyRate;
        boolean isUnion = true;
        double medicalSavingsPercent;
        Random random = new Random();
        double incidentPay = random.nextDouble(200);
        double tax;

        //Sets up the variables for the final calculations
        double grossPayInital;
        double grossPayFinal;
        double unionDues = 0;
        double medicalSavings;


        //Prints the Payday V1.0 title card
        System.out.println("**************************************************");
        System.out.printf("%30s", "Payday V1.0\n");
        System.out.println("**************************************************\n");

        //Asks the user for all the required information
        System.out.print("Enter name: ");
        name = scan.nextLine().trim();
        System.out.print("Enter hours worked: ");
        hoursWorked = scan.nextDouble(); scan.nextLine();
        System.out.print("Enter hourly pay rate: ");
        hourlyRate = scan.nextDouble(); scan.nextLine();
        System.out.print("Are you a union member (y or n)? ");
        if (scan.nextLine().trim().equalsIgnoreCase("n"))
        {
            isUnion = !isUnion;
        }
        System.out.print("What percentage do you want to withould for your medical savings account? ");
        medicalSavingsPercent = scan.nextDouble(); scan.nextLine();
        

        //Calculates the money subtracted from the gross pay
        if(random.nextBoolean() == true)
        {
            incidentPay *= -1;
        }
        grossPayInital = hoursWorked * hourlyRate;
        if (isUnion)
        {
            unionDues = grossPayInital * 0.05;
        }
        medicalSavings = grossPayInital * (medicalSavingsPercent/100);
        grossPayFinal = grossPayInital - unionDues - medicalSavings + incidentPay;
        if (grossPayFinal >= 2500)
        {
            tax = grossPayFinal * .25;
            grossPayFinal -= tax;
        }
        else if (grossPayFinal < 2500 && grossPayFinal >= 1500)
        {
            tax = grossPayFinal * .15;
            grossPayFinal -= tax;
        }
        else if (grossPayFinal < 1500 && grossPayFinal >= 500)
        {
            tax = grossPayFinal * .10;
            grossPayFinal -= tax;
        }
        else
        {
            tax = grossPayFinal * .05;
            grossPayFinal -= tax;
        }

        //Prints out the final paycheck
        System.out.println("\n---------PAYCHECK---------");//9 "-"s 8 letters 9 "-"s
        System.out.printf("%-15s%s%8.2f\n", "Gross Pay", "$", grossPayInital);
        System.out.printf("%-15s%s%8.2f\n", "Union Dues", "$", unionDues);
        System.out.printf("%-15s%s%8.2f\n", "Med Deduction", "$", medicalSavings);
        System.out.printf("%-15s%s%8.2f\n", "Incident Pay", "$", (incidentPay));
        System.out.printf("%-15s%s%8.2f\n", "Taxes", "$", tax);
        System.out.printf("%-15s%s%8.2f\n", "Net Pay", "$", grossPayFinal);
        System.out.println("--------------------------"); //26 "-"s
        System.out.println("Prepared for " + name + "\n\nThank you for using this program.");
    }
}
