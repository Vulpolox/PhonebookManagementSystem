package Modules;

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


    // overridden methods
    @Override
    public String toString() { return String.format("%-15s %-15s %-10s", this.firstname, this.lastname, this.phoneNumber); }
}