package Madlibs;

/*
 * Robert Fudala
 * 10/19/2023
 * Madlibs
 * 
 * This function takes in the location of the madlibs files
 * and story files and then asks the user which story would
 * they like to make a madlib out of. Then it makes the madlib
 * and prints it out for the user. It repeats this until
 * the user quits.
 */

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Madlibs 
{
    public static void main(String[] args)
    {
        printBanner();
        Scanner scan = new Scanner(System.in);
        String fileLocation;
        System.out.print("Enter the name of the folder where the stories and wordlists are.\nOr just press Enter to accept the default location: ");
        fileLocation = scan.nextLine().trim();
        System.out.println();

        String response;
        String[] adj = fileToArray(new File(fileLocation,"adj.txt"));
        String[] adv = fileToArray(new File(fileLocation,"adv.txt"));
        String[] pastverb = fileToArray(new File(fileLocation,"pastverb.txt"));
        String[] plunoun = fileToArray(new File(fileLocation,"plunoun.txt"));
        String[] pluverb = fileToArray(new File(fileLocation,"pluverb.txt"));
        String[] singnoun = fileToArray(new File(fileLocation,"singnoun.txt"));
        String[] singverb = fileToArray(new File(fileLocation,"singverb.txt"));
        LinkedHashMap<String,String[]> partsOfSpeech = new LinkedHashMap<String,String[]>();
        ArrayList<String> fileStrings = new ArrayList<String>();
        String[] listOfSpeech = {"adj","adv","pastverb","plunoun","pluverb","singnoun","singverb"};
        Random random = new Random();

        partsOfSpeech.put("adj", adj);
        partsOfSpeech.put("adv", adv);
        partsOfSpeech.put("pastverb", pastverb);
        partsOfSpeech.put("plunoun", plunoun);
        partsOfSpeech.put("pluverb", pluverb);
        partsOfSpeech.put("singnoun", singnoun);
        partsOfSpeech.put("singverb", singverb);

        do
        {
            System.out.print("Enter a story number or q to quit: ");
            response = scan.nextLine().trim();
            if (checkFile(new File(fileLocation,("story" + response + ".txt"))))
            {
                fileStrings = fileToArrayList(new File(fileLocation,("story" + response + ".txt")));
                for (int i = 0; i < listOfSpeech.length; i++)
                {
                    for (int j = 0; j < fileStrings.size(); j++)
                    {
                        while(fileStrings.get(j).indexOf("<" + listOfSpeech[i] + ">") >= 0)
                        {
                            //I'M SORRY THIS LOOKS SO BAD I JUST REALLY WANTED TO USE LINKEDHASHMAPS BUT THEY MADE THIS SO MUCH MORE COMPLICATED THAN IT HAD TO BE.
                            fileStrings.set(j,fileStrings.get(j).replaceFirst("<" + listOfSpeech[i] + ">", partsOfSpeech.get(listOfSpeech[i])[random.nextInt(partsOfSpeech.get(listOfSpeech[i]).length)]));
                        }
                    }
                }
                System.out.println("\nHere is your Madlib:\n");
                for (String storys : fileStrings)
                {
                    System.out.println(storys);
                }
                System.out.println();
            }
            else if (response.toLowerCase().equals("q")){}
            else
            {
                System.out.println("That story does not exist. Choose again.\n");
            }
        } while(!(response.toLowerCase().equals("q")));
        System.out.println("Thank you for using this program.");
        scan.close();
    }
    /**
     * Simply prints out the welcome banner
     * with no parameter or return
     */
    public static void printBanner()
    {
        System.out.println("*".repeat(65));
        System.out.printf("*%42s%22s\n", "Welcome to Madlibs V1.0","*");
        System.out.println("*".repeat(65));
        System.out.println("\nThis program generates random stories using wordlists you supply.\n");
    }
    /**
     * 
     * @param file is the file that the user entered
     * @return the return is true if the file exists
     * or false if the file doesn't exist
     */
    public static boolean checkFile(File file)
    {
        boolean noError;
        try
        {
            Scanner fileTest = new Scanner(file);
            fileTest.close();
            noError = true;
        }
        catch (Exception ex)
        {
            noError = false;
        }
        return noError;
    }
    /**
     * 
     * @param file takes in a file
     * @return the return is an array of strings
     * of the file that was passed in breaking it
     * up at the end of lines
     */
    public static String[] fileToArray(File file)
    {
        try
        {
            Scanner fileScan = new Scanner(file);
            String fileString = "";
            while (fileScan.hasNextLine())
            {
                fileString += fileScan.nextLine();
                fileString += "\t";
            }
            fileScan.close();
            return fileString.split("\t");
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    /**
     * 
     * @param file takes in a file
     * @return the return is an ArrayList of strings
     * of the file that was passed in breaking it
     * up at the end of lines
     */
    public static ArrayList<String> fileToArrayList(File file)
    {
        try
        {
            Scanner fileScan = new Scanner(file);
            ArrayList<String> fileArrayList = new ArrayList<String>();
            while (fileScan.hasNextLine())
            {
                fileArrayList.add(fileScan.nextLine());
            }
            fileScan.close();
            return fileArrayList;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
