package ExerciseTracker;

import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Exercise implements Comparable<Exercise>
{
    protected SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
    private String name;
    private Date date;
    private double minutes;
    private String comment;

    public Exercise(String name, Date date, double minutes, String comment)
    {
        setName(name);
        setDate(date);
        setMinutes(minutes);
        setComment(comment);
    }
    public Exercise()
    {
        this("", new Date(), 0, "");
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    public void setMinutes(double minutes)
    {
        if (minutes < 0)
        {
            this.minutes = 0;
        }
        else
        {
            this.minutes = minutes;
        }
    }

    public Date getDate()
    {
        return date;
    }
    public String getName()
    {
        return name;
    }
    public String getComment()
    {
        return comment;
    }
    public double getMinutes()
    {
        return minutes;
    }

    @Override
    public String toString()
    {
        return String.format("%s\t%s\t%s\t%.2f", getType(), getName(), sd.format(getDate()), getCaloriesBurned());
    }
    @Override
    public int compareTo(Exercise other)
    {
        return date.compareTo(other.getDate());
    }

    public abstract String getType();
    public abstract double getCaloriesBurned();
}