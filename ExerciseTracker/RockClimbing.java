package ExerciseTracker;

import java.util.Date;

public class RockClimbing extends Exercise
{
    public double wallHeight;
    public int reps;

    public RockClimbing(String name, Date date, double minutes, String comment, double wallHeight, int reps)
    {
        super(name, date, minutes, comment);
        setWallHeight(wallHeight);
        setReps(reps);
    }

    public void setWallHeight(double wallHeight)
    {
        if (wallHeight < 0)
        {
            this.wallHeight = 0;
        }
        else
        {
            this.wallHeight = wallHeight;
        }
    }
    public void setReps(int reps)
    {
        if (reps < 0)
        {
            this.reps = 0;
        }
        else
        {
            this.reps = reps;
        }
    }

    public double getWallHeight() {
        return wallHeight;
    }
    public int getReps() {
        return reps;
    }
    public String getType()
    {
        return "rock climbing";
    }
    public double getCaloriesBurned()
    {
        return ((wallHeight*reps)/super.getMinutes())*100;
    }
}
