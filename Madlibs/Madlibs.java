package Madlibs;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;

// C:\Users\robr1\OneDrive\Desktop\Madlibs
// STRINGS HAVE .replace()

public class Madlibs 
{
    public static void main(String[] args)
    {
        printBanner();
        Scanner scan = new Scanner(System.in);
        String fileLocation;// = "c:\\temp\\ml";
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
        partsOfSpeech.put("adj", adj);
        partsOfSpeech.put("adv", adv);
        partsOfSpeech.put("pastverb", pastverb);
        partsOfSpeech.put("plunoun", plunoun);
        partsOfSpeech.put("pluverb", pluverb);
        partsOfSpeech.put("singnoun", singnoun);
        partsOfSpeech.put("singverb", singverb);
        ArrayList<String> fileString = new ArrayList<String>();

        if (adj == null || adv == null || pastverb == null || plunoun == null || pluverb == null || singnoun == null || singverb == null)
        {
            System.out.println("Something went wrong reading the madlib files");
            return;
        }

        do
        {
            System.out.print("Enter a story number or q to quit: ");
            response = scan.nextLine().trim();
            if (checkFile(new File(fileLocation,("story" + response + ".txt"))))
            {
                //System.out.println("That story exists!!!\n");
                

            }
            else if (response.toLowerCase().equals("q")){}
            else
            {
                System.out.println("That story does not exist. Choose again.\n");
            }
        } while(!(response.toLowerCase().equals("q")));
    }

    public static void printBanner()
    {
        System.out.println("*".repeat(65));
        System.out.printf("*%42s%22s\n", "Welcome to Madlibs V1.0","*");
        System.out.println("*".repeat(65));
        System.out.println("\nThis program generates random stories using wordlists you supply.\n");
    }
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
            //System.out.println(fileString);
            fileScan.close();
            return fileString.split("\t");
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    //public static 
}
