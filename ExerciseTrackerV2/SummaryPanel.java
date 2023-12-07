package ExerciseTrackerV2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import java.util.ArrayList;

public class SummaryPanel extends JPanel
{
    private ArrayList<RunWalkV2> exercises;
    private JTextArea tarSummary;
    private JLabel labelSummary;

    /**
     * Constructs a SummaryPanel
     * @param exercises This is an arraylist of exercises so
     * the SummaryPanel has access to it.
     */
    public SummaryPanel(ArrayList<RunWalkV2> exercises)
    {
        this.exercises = exercises;
        setupGUI();
    }

    /**
     * This sets up the GUI for the summary panel.
     */
    public void setupGUI()
    {
        setLayout(new BorderLayout());
        labelSummary = new JLabel("Exercise Summary");
        add(labelSummary, BorderLayout.NORTH);
        tarSummary = new JTextArea(20,35);
        tarSummary.setEditable(false);
        add(tarSummary, BorderLayout.CENTER);
    }

    /**
     * This updates the Exercise Summary text box with
     * current information.
     */
    public void updateList()
    {
        tarSummary.setText("");
        String text = "";
        for (RunWalkV2 exercise : exercises)
        {
            text += exercise + "\n";
        }
        tarSummary.setText(text);
    }

    /**
     * This sets the text inside the Exercise Summary text box
     * to the parameter.
     * @param text This is a string that the Exercise Summary
     * text box is set to.
     */
    public void setSummary(String text)
    {
        labelSummary.setText(text);
    }
}