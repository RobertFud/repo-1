package ExerciseTrackerV2;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ExerciseTrackerWindow extends JFrame
{
    private ArrayList<RunWalkV2> exercises;
    private SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
    private ExerciseTrackerWindow thisFrame = this;
    private ExerciseData exData;
    private JButton addExercise;

    /**
     * Constructs an ExerciseTrackerWindow
     * @param exercises This is the arraylist of exercises so the window
     * has access to it.
     */
    public ExerciseTrackerWindow(ArrayList<RunWalkV2> exercises)
    {
        this.exercises = exercises;
        setupGUI();
    }

    /**
     * This sets up the GUI for the window.
     */
    public void setupGUI()
    {
        setBounds(400,170,760,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercise Tracker V2.0");
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());
        exData = new ExerciseData();
        SummaryPanel sumPan = new SummaryPanel(exercises);
        cont.add(exData,BorderLayout.WEST);
        cont.add(sumPan, BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        addExercise = new JButton("Add Exercise");
        enableEntries(false);
        addExercise.addActionListener(new ActionListener() 
        {
            /**
             * When the add exercise button is pressed it takes in the entries
             * from the text fields and then checks if they cause an error.
             * If they do cause an error then the RunWalk exercise is
             * not added to the list and then gives the user a message
             * that they entered information incorrectly otherwise
             * it adds the RunWalk exercise to the list.
             */
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<String> errors = new ArrayList<String>();
                String name = exData.getName();
                double duration = 0;
                double distance = 0;
                Date date = null;
                try
                {
                    date = sd.parse(exData.getDate());
                }
                catch (Exception ex)
                {
                    errors.add("The date must be entered in a mm/dd/yyyy format.");
                    date = null;
                }
                try
                {
                    if (exData.getDuration() > 0)
                    {
                        duration = exData.getDuration();
                    }
                    else
                    {
                        errors.add("The duration must be greater than 0.");
                    }
                }
                catch (Exception ex)
                {
                    errors.add("The duration must be a non-zero number.");
                    duration = 0;
                }
                try
                {
                    if (exData.getDistance() > 0)
                    {
                        distance = exData.getDistance();
                    }
                    else
                    {
                        errors.add("The distance must be greater than 0.");
                    }
                }
                catch (Exception ex)
                {
                    errors.add("The distance must be a non-zero number.");
                    distance = 0;
                }
                String comment = exData.getComment();

                if (errors.size() > 0)
                {
                    String errorMessage = "";
                    for (String error : errors)
                    {
                        errorMessage += error + " ";
                    }   
                    JOptionPane.showMessageDialog(null, "These errors occured: " + errorMessage);
                    exData.resetEntries();
                }
                else
                {
                    RunWalkV2 runwalk = new RunWalkV2(name, date, duration, comment, distance);
                    exercises.add(runwalk);
                    sumPan.setSummary(String.format("Exercise Summary (%.2f burned)", runwalk.getTotalCaloriesBurned(exercises)));
                    sumPan.updateList();
                    exData.resetEntries();
                    repaint(); //refresh
                }
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(addExercise);
        cont.add(panSouth,BorderLayout.SOUTH);
        setupMenu();
    }

    /**
     * This sets up the menu for the GUI.
     */
    public void setupMenu()
    {
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menuFile = new JMenu("File");
        bar.add(menuFile);
        JMenuItem fileLogin = new JMenuItem("Log in");
        fileLogin.addActionListener(new ActionListener() 
        {
            /**
             * When the log in menu item is pressed then it brings
             * up the log in form and then checks if the user
             * logged in correctly and if they did it enables the
             * entry fields otherwise they stay disabled.
             */
            public void actionPerformed(ActionEvent e)
            {
                LoginForm login = new LoginForm(thisFrame, "Login", true);
                login.setVisible(true);
                if (login.isLoggedIn())
                {
                    enableEntries(true);
                }
                else
                {
                    enableEntries(false);
                }
            }
        });
        JMenuItem fileLogout = new JMenuItem("Log out");
        fileLogout.addActionListener(new ActionListener() 
        {
            /**
             * When the log out menu item is pressed then all the 
             * entry fields are disabled.
             */
            public void actionPerformed(ActionEvent e)
            {
                enableEntries(false);
            }
        });
        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.addActionListener(new ActionListener() 
        {
            /**
             * When the save menu item is pressed it brings up
             * the file chooser to choose what file to write the
             * exercises to. It then calls the ExerciseWriter class to
             * write to teh file and then will give a message to the user
             * on whether or not the file writing was successful.
             */
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser chooser = new JFileChooser();
                File f;
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    f = chooser.getSelectedFile();
                    if (ExerciseWriter.writeToFile(exercises, f))
                    {
                        JOptionPane.showMessageDialog(null, "Exercises were saved.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Something went wrong saving the exercises.");
                    }
                }
            }
        });
        JMenuItem fileExit = new JMenuItem("Exit");
        menuFile.add(fileLogin);
        menuFile.add(fileLogout);
        menuFile.add(fileSave);
        menuFile.add(fileExit);
        fileExit.addActionListener(new ActionListener() 
        {
            /**
             * When the exit menu item is pressed then it closes
             * the window.
             */
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        JMenu menuHelp = new JMenu("Help");
        bar.add(menuHelp);
        JMenuItem helpAbout = new JMenuItem("About");
        helpAbout.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                /**
                 * When the about menu item is pressed it gives the user
                 * a message with information about the program.
                 */
                JOptionPane.showMessageDialog(null, "Exercise Tracker V2.0 - CPSC 24500 Fall 2023");
            }
        });
        menuHelp.add(helpAbout);

    }

    /**
     * Depending on if the parameter is true or false
     * this uses the ExerciseData class's enableEntries to
     * enable or disable the text fields along with disabling
     * or enabling the add exercise button.
     * @param enableYN This is a boolean that either enables
     * or disables the text fields and add exercise button.
     */
    public void enableEntries(boolean enableYN)
    {
        exData.enableEntries(enableYN);
        addExercise.setEnabled(enableYN);
    }
}
