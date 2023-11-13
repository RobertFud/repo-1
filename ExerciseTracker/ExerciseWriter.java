package ExerciseTracker;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class ExerciseWriter 
{
    public static void writeToScreen(ArrayList<Exercise> exercises)
    {
        for (Exercise exercise : exercises)
        {
            System.out.println(exercise);
        }
    }

    public static boolean writeToFile(ArrayList<Exercise> exercises, File file)
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
