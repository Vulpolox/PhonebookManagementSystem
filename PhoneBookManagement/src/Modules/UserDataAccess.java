package Modules;

import java.sql.*;
import MyUtils.*;
import Modules.*;
import java.util.ArrayList;

import javax.swing.*;

public class UserDataAccess
{
    private Connection connect;

    // constructor
    public UserDataAccess()
    {
        try { this.connect = Utilities.getConnection(); }
        catch(SQLException e) { e.printStackTrace(); }
    }


    /**
     * pre  -- takes a User
     * post -- hashes the User's password and adds it and the User's username to a new row
     *         in tb_users table in the database; returns true if operation is successful,
     *         otherwise, false
     */
    public boolean registerUser(User user)
    {
        try
        {
            // create the query and the PreparedStatement
            String query = "INSERT INTO tb_users (username, password) VALUES (?, ?)";
            PreparedStatement stm = connect.prepareStatement(query);

            // set the "?" in the PreparedStatement
            stm.setString(1, user.getUsername());
            stm.setString(2, Utilities.hashPassword(user.getPassword()));

            // execute the query and return a boolean corresponding to whether it was successful
            int row = stm.executeUpdate();
            return (row > 0);
        }
        catch (SQLException e) { e.printStackTrace(); }

        return false;
    }

    /**
     * pre  -- takes a User
     * post -- returns true if the User's username is not already in tb_users
     *         ; otherwise, returns false
     */
    public boolean isUniqueUsername(User user)
    {
        try
        {
            // create the query and the PreparedStatement
            String query = "SELECT * FROM tb_users WHERE username = ?";
            PreparedStatement stm = connect.prepareStatement(query);

            // set the "?" in the PreparedStatement
            stm.setString(1, user.getUsername());

            // execute the query and return a boolean corresponding to whether the username is unique
            // in the database
            ResultSet rs = stm.executeQuery();
            return !rs.next();
        }
        catch (SQLException e) { e.printStackTrace(); }

        return false;
    }

    /**
     * pre  -- takes a User
     * post -- returns true if the User's username and the hashed version of the password
     *         are in a row in tb_users within the database; otherwise false
     */
    public boolean isNotRegistered(User user)
    {
        boolean result = false;
        try
        {
            // create the query and the PreparedStatement
            String query = "SELECT * FROM tb_users WHERE username = ? AND password = ?";
            PreparedStatement stm = connect.prepareStatement(query);

            // set the "?" in the PreparedStatement
            stm.setString(1, user.getUsername());
            stm.setString(2, Utilities.hashPassword(user.getPassword()));

            // execute the query and return a boolean corresponding to whether the username is unique
            // in the database
            ResultSet rs = stm.executeQuery();
            result = !rs.next();
            rs.close();
        }
        catch (SQLException e) { e.printStackTrace(); }

        return result;
    }

    /**
     * pre  -- takes a User
     * post -- returns the ID of the user from tb_users
     */
    public int getUserId(User user)
    {
        int userId = -1; // default value to return if the id isn't found
        try
        {
            // create a query and the PreparedStatement for getting the id of the user from the db
            String query = "SELECT id FROM tb_users WHERE username = ?";
            PreparedStatement stm = connect.prepareStatement(query);

            // set the field of the PreparedStatement
            stm.setString(1, user.getUsername());

            // create and manipulate ResultSet to return the id
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                userId = rs.getInt("id");

            // close ResultSet
            rs.close();
        }
        catch (SQLException e) { e.printStackTrace(); }

        return userId;
    }

    /**
     * pre  -- takes a User and a Contact
     * post -- adds the Contact's data to the tb_contacts in the db
     */
    public boolean addContact(User user, Contact contactToAdd)
    {
        try
        {
            // create a query and the PreparedStatement for inserting new contact into tb_contacts
            String query = "INSERT INTO tb_contacts (firstname, lastname, phonenumber, user) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = connect.prepareStatement(query);

            // set the fields of the PreparedStatement
            stm.setString(1, contactToAdd.getFirstname());
            stm.setString(2, contactToAdd.getLastname());
            stm.setString(3, contactToAdd.getPhoneNumber());
            stm.setInt(4, getUserId(user));

            // execute the query and return a boolean corresponding to whether it was successful
            int row = stm.executeUpdate();
            return (row > 0);
        }
        catch (SQLException e) { e.printStackTrace(); }

        return false;
    }

    /**
     * pre  -- takes a User and a Contact
     * post -- removes the Contact's row from tb_contacts in the db
     */
    public boolean removeContact(User user, Contact contactToRemove)
    {
        try
        {
            // create a query and the PreparedStatement for removing contact from tb_contacts
            String query = "DELETE FROM tb_contacts WHERE user = ? AND phonenumber = ?";
            PreparedStatement stm = connect.prepareStatement(query);

            // set the fields of the PreparedStatement
            stm.setInt(1, getUserId(user));
            stm.setString(2, contactToRemove.getPhoneNumber());

            // execute the query and return a boolean corresponding to whether it was successful
            int row = stm.executeUpdate();
            return (row > 0);
        }
        catch (SQLException e) { e.printStackTrace(); }

        return false;
    }

    /**
     * pre  -- takes a User
     * post -- returns an array of Contacts associated with the User from tb_contacts in the db
     */
    public Contact[] getContacts(User user)
    {
        ArrayList<Contact> contacts = new ArrayList<>(); // dynamic array for easily adding contacts
        try
        {
            // create a query and the PreparedStatement for retrieving all contacts associated with the User from tb_contacts
            String query = "SELECT * FROM tb_contacts WHERE user = ?";
            PreparedStatement stm = connect.prepareStatement(query);

            // create and manipulate ResultSet to get all contacts
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                String phoneNumberToAdd = rs.getString("phonenumber");
                String firstNameToAdd = rs.getString("firstname");
                String lastNameToAdd = rs.getString("lastname");

                Contact contactToAdd = new Contact(firstNameToAdd, lastNameToAdd, phoneNumberToAdd);
                contacts.add(contactToAdd);
            }

            // close ResultSet
            rs.close();
        }
        catch (SQLException e) { e.printStackTrace(); }

        return contacts.toArray(new Contact[0]);
    }
}


