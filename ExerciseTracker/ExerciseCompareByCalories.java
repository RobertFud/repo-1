package ExerciseTracker;

import java.util.Comparator;

public class ExerciseCompareByCalories implements Comparator<Exercise>
{

    @Override
    public int compare(Exercise myExercise, Exercise otherExercise)
    {
        double myCal = myExercise.getCaloriesBurned();
        double otherCal = otherExercise.getCaloriesBurned();
        if (myCal < otherCal)
        {
            return -1;
        }
        else if (myCal == otherCal)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
