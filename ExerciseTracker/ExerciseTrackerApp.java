package ExerciseTracker;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.io.File;

public class ExerciseTrackerApp
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        ExerciseCompareByCalories calorieSorter = new ExerciseCompareByCalories();
        int response = 0;
        printBanner();

        do
        {
            try
            {
                printMenu();
                response = scan.nextInt();
                scan.nextLine();
            }
            catch (Exception ex)
            {
                scan.nextLine();
                System.out.println("You needed to enter an integer. Try again.");
                System.out.println();
                response = 0;
            }

            if (response == 1)
            {
                System.out.println("Describe your workout");
                System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
                String answer = scan.nextLine();
                if (answer.trim().toUpperCase().equals("R"))
                {
                    String name = null;
                    String date = null;
                    double time = 0;
                    double distance = 0;
                    String comment = null;
                    System.out.print("Enter a name for the workout: ");
                    name = scan.nextLine();
                    System.out.print("Enter date of workout: ");
                    date = scan.nextLine();
                    System.out.print("How long did you work out in minutes: ");
                    try
                    {
                        time = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Enter distance you ran or walked in miles: ");
                        distance = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Enter a comment about the workout: ");
                        comment = scan.nextLine();
                    }
                    catch (Exception ex)
                    {
                        scan.nextLine();
                        System.out.println("Not a valid input.");
                        continue;
                    }

                    try
                    {
                        exercises.add(new RunWalk(name, sd.parse(date), time, comment, distance));
                        System.out.println();
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Something went wrong creating the workout.");
                    }

                }
                else if (answer.trim().toUpperCase().equals("W"))
                {
                    String name = null;
                    String date = null;
                    double time = 0;
                    String comment = null;
                    double weightLifted = 0;

                    System.out.print("Enter a name for the workout: ");
                    name = scan.nextLine();
                    System.out.print("Enter date of workout: ");
                    date = scan.nextLine();
                    System.out.print("How long did you work out in minutes: ");
                    try
                    {
                        time = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Enter total weight lifted in pounds: ");
                        weightLifted = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Enter a comment about the workout: ");
                        comment = scan.nextLine();
                    }
                    catch (Exception ex)
                    {
                        scan.nextLine();
                        System.out.println("Not a valid input.");
                        continue;
                    }

                    try
                    {
                        exercises.add(new WeightLifting(name, sd.parse(date), time, comment, weightLifted));
                        System.out.println();
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Something went wrong creating the workout.");
                    }
                }
                else if (answer.trim().toUpperCase().equals("C"))
                {
                    String name = null;
                    String date = null;
                    double time = 0;
                    String comment = null;
                    double wallHeight = 0;
                    int reps = 0;

                    System.out.print("Enter a name for the workout: ");
                    name = scan.nextLine();
                    System.out.print("Enter date of workout: ");
                    date = scan.nextLine();
                    System.out.print("How long did you work out in minutes: ");
                    try
                    {
                        time = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Enter the height of the wall in feet: ");
                        wallHeight = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Enter number of times you climbed it: ");
                        reps = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter a comment about the workout: ");
                        comment = scan.nextLine();
                    }
                    catch (Exception ex)
                    {
                        scan.nextLine();
                        System.out.println("Not a valid input.");
                        continue;
                    }

                    try
                    {
                        exercises.add(new RockClimbing(name, sd.parse(date), time, comment, wallHeight, reps));
                        System.out.println();
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Something went wrong creating the workout.");
                    }
                }
                else
                {
                    System.out.println("Not a valid choice.");
                }
            }
            else if (response == 2)
            {
                System.out.print("Enter the name of the file to save: ");
                String fname = scan.nextLine();
                if (ExerciseWriter.writeToFile(exercises, new File(fname)))
                {
                    System.out.println("Your exercises were written to the file.");
                    System.out.println();
                }
                else
                {
                    System.out.println("Something went wrong writing to the file.");
                    System.out.println();
                }

            }
            else if (response == 3)
            {
                Collections.sort(exercises);
                System.out.println("Here are the exercises sorted by date:");
                ExerciseWriter.writeToScreen(exercises);
                System.out.println();
            }
            else if (response == 4)
            {
                Collections.sort(exercises, calorieSorter);
                System.out.println("Here are the exercises sorted by calories:");
                ExerciseWriter.writeToScreen(exercises);
                System.out.println();
            }
            else if (response == 5) {}

        } while (response != 5);
        scan.close();
        System.out.println("Congratulations on staying in shape!");
    }

    public static void printBanner()
    {
        System.out.println("********************************************************************************");
        System.out.println(" ".repeat(28) + "EXERCISE TRACKER V1.0");
        System.out.println("********************************************************************************");
    }
    public static void printMenu()
    {
        System.out.println("These are your choices:");
        System.out.println("1. Add an exercise");
        System.out.println("2. Print exercises to file");
        System.out.println("3. List sorted by date");
        System.out.println("4. List sorted by calories burned");
        System.out.println("5. Exit");
        System.out.print("Enter the number of your choice: ");
    }
}
