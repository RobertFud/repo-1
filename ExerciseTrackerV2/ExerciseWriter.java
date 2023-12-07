package ExerciseTrackerV2;

import java.util.Scanner;

import ExerciseTracker.Exercise;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class ExerciseWriter 
{
    /**
     * This attempts to write the exercises to the chosen file
     * and returns true if it did not recive an error and false if it did.
     * @param exercises This is the ArrayList of exercises that is
     * being written to the file.
     * @param file THis is the file the exercises are written to.
     * @return This returns true or false depending on if it ran into
     * an error or not.
     */
    public static boolean writeToFile(ArrayList<RunWalkV2> exercises, File file)
    {
        boolean noError;
        try
        {
            Scanner s = new Scanner(file); //TO CAUSE AN ERROR IF THE FILE DOESN'T EXIST
            s.close();
            PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (Exercise exercise : exercises)
            {
                fileWriter.println(exercise);
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
