package Modules;

import java.util.Comparator;

// A Comparator class for sorting Contacts
public class ContactComparator implements Comparator<Contact>
{
    public int compare(Contact current, Contact next)
    {
        return current.getFirstname().compareTo(next.getFirstname());
    }
}
