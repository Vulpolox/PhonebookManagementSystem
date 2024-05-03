package Modules;

import java.util.Comparator;

public class Contact
{
    // instance data
    private String firstname, lastname, phoneNumber;

    // constructor
    public Contact(String firstname, String lastname, String phoneNumber)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    // accessors and mutators
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // methods

    public String rightPad(String input, char fillChar, int targetLength)
    {
        if (input.length() > targetLength)           // if the input's length is greater than targetLength, truncate it
            return input.substring(0, targetLength);
        else if (input.length() == targetLength)     // if the input's length is equal to targetLength, return it
            return input;
        else                                         // otherwise, pad input by appending fillChar until it's length is equal to targetLength
        {
            StringBuilder paddedString = new StringBuilder(input);
            for (int i = paddedString.length() ; i < targetLength ; i++)
                paddedString.append(fillChar);

            return paddedString.toString();
        }
    }

    // overridden methods
    @Override
    public String toString()
    {
        return String.format("%s %s %s", rightPad(this.firstname, ' ', 15),
                                         rightPad(this.lastname, ' ', 15),
                                         rightPad(this.phoneNumber, ' ', 15));
    }

}

