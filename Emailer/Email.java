package Emailer;
/*
 * Robert Fudala
 * 11/1/2023
 * 
 * This is an email class that contains all nesseccary information
 * to represent an email and methods to print the email.
 */

public class Email 
{
    private String[] recipients;
    private String subject;
    private String body;
    private boolean sent;  

    /**
     * This constructs an Email object
     * @param recipients takes in a string that is then split up into 
     * an array of strings that are the email adresses of the recipients
     * @param subject takes in a string that is the subject line of the email
     * @param body takes in a string that is the body of the email
     */
    public Email(String recipients, String subject, String body)
    {
        setRecipients(recipients);
        setSubject(subject);
        setBody(body);
        sent = false;
    }
    /**
     * This contructs a defualt email
     */
    public Email()
    {
        this("","no subject","");
    }

    /**
     * This returns a string of the recipients seperated by commas
     * @return returns a string of the recipients
     */
    public String getRecipients()
    {
        String recipientsString = "";
        for (String recipient : recipients)
        {
            recipientsString += recipient + ",";
        }
        recipientsString = recipientsString.substring(0, recipientsString.length()-1);
        return recipientsString;
    }
    /**
     * This returns the subject line as a string
     * @return returns a string of the subject line
     */
    public String getSubject()
    {
        return subject;
    }
    /**
     * This returns the body of the email as a string
     * @return returns a string of the body of the email
     */
    public String getBody()
    {
        return body;
    }
    /**
     * This returns the sent status of the email
     * @return returns a boolean of the sent status of the email
     */
    public boolean getStatus()
    {
        return sent;
    }

    /**
     * This sets the recipients of the email by splitting a string into an array
     * @param recipients A string that contains the recipients of the email
     */
    public void setRecipients(String recipients)
    {
        this.recipients = recipients.split(" ");
    }
    /**
     * This sets the subject of the email
     * @param subject A string that is the subject line of the email
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    /**
     * This sets the body of the email
     * @param body A string of the body of the email
     */
    public void setBody(String body) 
    {
        this.body = body;
    }

    /**
     * This changes the status of the email from false to true
     * representing the email has been sent
     */
    public void send()
    {
        sent = true;
    }

    /**
     * This formats the data into a string with the
     * lines to, subject, status, and body with the
     * corrisponding information for the email filled into
     * the correct lines.
     * @return Returns the formated email as a string
     */
    @Override
    public String toString()
    {
        String email = "";
        email += "To:             " + getRecipients() + "\n";
        email += "Subject:        " + getSubject() + "\n";
        email += "Status:         ";
        if (getStatus())
        {
            email += "sent\n";
        }
        else
        {
            email += "not sent\n";
        }
        email += "Body:\n" + getBody() + "\n";
        return email;
    }
    /**
     * This formats the information of the email by giving the information
     * and seperating the information by tabs
     * @return Returns the tabed formated email as a string
     */
    public String toTabedString()
    {
        String email = "";
        email += getRecipients() + "\t" + getSubject() + "\t" + getBody() + "\t";
        if (getStatus())
        {
            email += "sent\n";
        }
        else
        {
            email += "not sent\n";
        }
        return email;
    }
}
