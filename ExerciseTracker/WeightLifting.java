package ExerciseTracker;

import java.util.Date;

public class WeightLifting extends Exercise
{
    public double weightLifted;

    public WeightLifting(String name, Date date, double minutes, String comment, double weightLifted)
    {
        super(name, date, minutes, comment);
        setWeightLifted(weightLifted);
    }

    public void setWeightLifted(double weightLifted) 
    {
        if (weightLifted < 0)
        {
            this.weightLifted = 0;
        }
        else
        {
            this.weightLifted = weightLifted;
        }
    }

    public double getWeightLifted() 
    {
        return weightLifted;
    }

    public String getType()
    {
        return "weightlifting";
    }
    public double getCaloriesBurned()
    {
        return (weightLifted/super.getMinutes())*50;
    }

    

    
}
