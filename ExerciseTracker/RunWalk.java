package ExerciseTracker;

import java.util.Date;

public class RunWalk extends Exercise
{
    private double distance;

    public RunWalk(String name, Date date, double minutes, String comment, double distance)
    {
        super(name, date, minutes, comment);
        setDistance(distance);
    }

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

    public double getDistance()
    {
        return distance;
    }

    public String getType()
    {
        return "runwalk";
    }
    public double getCaloriesBurned()
    {
        return (distance/super.getMinutes())*9000;
    }
}
