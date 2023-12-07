package ExerciseTrackerV2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ExerciseData extends JPanel
{
    private JTextField textName;
    private JTextField textDate;
    private JTextField textDur;
    private JTextField textDis;
    private JTextArea tarComment;

    /**
     * This constructs an ExercisePanel panel to be used.
     */
    public ExerciseData()
    {
        setupGUI();
    }
    
    /**
     * This sets up the entire GUI with text feilds
     * for name, date, duration, distance, and a comment.
     */
    public void setupGUI()
    {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(4,1));
        panNorth.add(new JLabel("Name: "));
        textName = new JTextField(12);
        panNorth.add(textName);
        panNorth.add(new JLabel("Date: "));
        textDate = new JTextField(12);
        panNorth.add(textDate);
        panNorth.add(new JLabel("Duration: "));
        textDur = new JTextField(12);
        panNorth.add(textDur);
        panNorth.add(new JLabel("Distance: "));
        textDis = new JTextField(12);
        panNorth.add(textDis);
        add(panNorth,BorderLayout.NORTH);
        JPanel panComment = new JPanel();
        panComment.setLayout(new BorderLayout());
        panComment.add(new JLabel("Add comment:"), BorderLayout.NORTH);
        tarComment = new JTextArea(12,10);
        panComment.add(tarComment);
        add(panComment, BorderLayout.CENTER);
    }


    /**
     * Returns what is typed into the name text field
     * as a String.
     * @return Return what is typed into the name text field as a string
     */
    public String getName()
    {
        return textName.getText();
    }

    /**
     * Returns what is typed into the date text field
     * as a String.
     * @return Returns what is typed into the date text field as a string.
     */
    public String getDate()
    {
        return textDate.getText();
    }

    /**
     * Returns what is typed into the distance text field
     * as a String.
     * @returnReturns what is typed into the distance text field as a String.
     */
    public double getDistance()
    {
        return Double.parseDouble(textDis.getText());
    }

    /**
     * Returns what is typed into the duration text field
     * as a String.
     * @return Returns what is typed into the duration text field as a String.
     */
    public double getDuration()
    {
        return Double.parseDouble(textDur.getText());
    }

    /**
     * Returns what is typed into the comment text field
     * as a String.
     * @return Returns what is typed into the comment text field as a String.
     */
    public String getComment()
    {
        return tarComment.getText();
    }

    /**
     * This sets all the entry fields to be either unable 
     * to be typed in or able to be typed in depending
     * on the parameter.
     * @param enableYN Takes in a true or false parameter
     * that then sets whether the text fields can be typed in
     * based on that boolean.
     */
    public void enableEntries(boolean enableYN)
    {
        textName.setEnabled(enableYN);
        textDate.setEnabled(enableYN);
        textDis.setEnabled(enableYN);
        textDur.setEnabled(enableYN);
        tarComment.setEnabled(enableYN);
    }

    /**
     * Sets all the text fields to be blank
     */
    public void resetEntries()
    {
        textName.setText("");
        textDate.setText("");
        textDis.setText("");
        textDur.setText("");
        tarComment.setText("");
    }
}
