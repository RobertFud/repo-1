package ExerciseTrackerV2;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class LoginForm extends JDialog
{
    private boolean loggedIn;
    private String username = "healthy";
    private String password = "donut";

    /**
     * Constructs the login form.
     * @param owner This is the owner of the dialog.
     * @param title This is the title of the dialog.
     * @param modal This determines whether you can click
     * on different things in the window when it is open.
     */
    public LoginForm(JFrame owner, String title, boolean modal)
    {
        super(owner,title,modal);
        setupGUI();
    }

    /**
     * This sets up the GUI for the dialog.
     */
    public void setupGUI()
    {
        setBounds(650,270,270,220);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        JButton login = new JButton("Log in");
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new FlowLayout());
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(20);
        panCenter.add(userLabel);
        panCenter.add(userField);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passFeild = new JPasswordField(20);
        panCenter.add(passLabel);
        panCenter.add(passFeild);
        cont.add(panCenter, BorderLayout.CENTER);
        login.addActionListener(new ActionListener() 
        {
            /**
             * When the log in button is pressed it checks if the
             * username and password are correct. If they are then it sets
             * the loggedIn variable to true and if not then it gives the user
             * a message that the username and password are incorrect and sets
             * loggedIn to false and allows them to retry the log in.
             */
            public void actionPerformed(ActionEvent e)
            {
                String enteredPass = new String(passFeild.getPassword());
                String enteredUser = userField.getText();
                if (enteredPass.equals(password) && enteredUser.equals(username))
                {
                    loggedIn = true;
                    setVisible(false);
                }
                else
                {
                    userField.setText("");
                    passFeild.setText("");
                    JOptionPane.showMessageDialog(null, "The username/password you entered was incorrect.");
                    loggedIn = false;
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() 
        {
            /**
             * When the cancel button is pressed then it sets
             * the loggedIn variable to false and closes the dialog.
             */
            public void actionPerformed(ActionEvent e)
            {
                loggedIn = false;
                setVisible(false);
            }
        });
        panSouth.add(login);
        panSouth.add(cancel);
        cont.add(panSouth, BorderLayout.SOUTH);
    }
    
    /**
     * This returns if the user is logged in
     * @return This returns a boolean representing
     * if the user is logged in.
     */
    public boolean isLoggedIn()
    {
        return loggedIn;
    }
}
