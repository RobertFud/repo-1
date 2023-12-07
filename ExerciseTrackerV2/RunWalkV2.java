package ExerciseTrackerV2;

import java.util.Date;
import ExerciseTracker.Exercise;
import java.util.ArrayList;

public class RunWalkV2 extends Exercise
{
    private double distance;

    /**
     * Constructs a RunWalkV2 with the given
     * name, date, minutes, comment, and distance.
     */
    public RunWalkV2(String name, Date date, double minutes, String comment, double distance)
    {
        super(name, date, minutes, comment);
        setDistance(distance);
    }

    /**
     * This sets the distance variable.
     * @param distance This takes in a double
     * and set the distance variable to it.
     */
    public void setDistance(double distance)
    {
        if (distance < 0)
        {
            this.distance = 0;
        }
        else
        {
            this.distance = distance;
        }
    }

    /**
     * This returns the distance traveled as a double.
     */
    public double getDistance()
    {
        return distance;
    }

    /**
     * This returns the type of exercise it is as a String.
     */
    public String getType()
    {
        return "runwalk";
    }
    /**
     * This returns the calories burned as a double.
     */
    public double getCaloriesBurned()
    {
        return (distance/super.getMinutes())*9000;
    }
    /**
     * This returns the total calories burned from the
     * given ArrayList of RunWalkV2s.
     * @param exercises This is an ArrayList of RunWalkV2 that
     * will be calculated.
     * @return This returns the total calories burned from adding
     * all the calories burned from all the RunWalkV2's in the ArrayList as a double.
     */
    public double getTotalCaloriesBurned(ArrayList<RunWalkV2> exercises)
    {
        double totalCal = 0;
        for (RunWalkV2 exercise : exercises)
        {
            totalCal += exercise.getCaloriesBurned();
        }
        return totalCal;
    }

    /**
     * This returns the information of the RunWalkV2 in
     * a tabbed summary format as a String.
     */
    @Override
    public String toString()
    {
        return String.format("%s\t%s\t%s\t%.2f", getName(), getType(), super.sd.format(getDate()), super.getMinutes());
    }
}