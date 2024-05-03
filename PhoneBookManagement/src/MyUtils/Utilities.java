package MyUtils;

import Modules.Contact;

import javax.swing.*;
import java.sql.*;
import java.security.*;

public class Utilities
{
    private static final String URL = "jdbc:mysql:///phonebook_db2";
    private static final String USER = "root";
    private static final String PASSWORD = "Password123";

    public static Connection getConnection() throws SQLException
    { return DriverManager.getConnection(URL, USER, PASSWORD); }

    /**
     * pre  -- takes a String password
     * post -- returns a hashed password
     */
    public static String hashPassword(String password) {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : hashedBytes)
            {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        }

        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * pre  -- takes two String passwords
     * post -- returns true if the passwords match, otherwise false
     */
    public static boolean isPasswordMatching(String password1, String password2) { return password1.equals(password2); }


    /**
     * pre  -- takes a DefaultListModel and a Contact[]
     * post -- adds all the contacts from Contact[] to the DefaultListModel;
     *         is for initialization of the JList in the ContactsView
     */
    public static void populateContactList(DefaultListModel<Contact> contactList, Contact[] rawData)
    {
        // add all array elements to the ListModel
        for (Contact contact : rawData)
            contactList.addElement(contact);
    }


    public static void filterContactList(DefaultListModel<Contact> contactList, Contact[] underlyingData,
                                         String filterName)
    {
        // remove all the Contacts from the ListModel
        contactList.removeAllElements();

        // if filterName is an empty String, populate the ListModel with all of underlyingData
        if (filterName.isEmpty())
            populateContactList(contactList, underlyingData);

        // otherwise, add all elements from underlyingData whose name fields contain filterName
        else
            for (Contact contact : underlyingData)
            {
                // combine the firstname and lastname fields of the contact into a single string
                String fullName = contact.getFirstname().concat(contact.getLastname());

                // if fullName contains filterName, add it to the ListModel
                if (fullName.toLowerCase().contains(filterName.toLowerCase()))
                {
                    contactList.addElement(contact);
                }
            }

    }
}




// javax.mail.jar
