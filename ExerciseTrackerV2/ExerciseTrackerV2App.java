package ExerciseTrackerV2;

import java.util.ArrayList;

public class ExerciseTrackerV2App 
{
    public static void main(String[] args)
    {
        ArrayList<RunWalkV2> exercises = new ArrayList<RunWalkV2>();
        ExerciseTrackerWindow ex = new ExerciseTrackerWindow(exercises);
        ex.setVisible(true);
    }
}