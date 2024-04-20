package Modules;

import java.sql.*;
import MyUtils.*;
import Modules.*;

import javax.swing.*;

public class UserDataAccess
{
    private Connection connect;

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
            return !rs.next();
        }
        catch (SQLException e) { e.printStackTrace(); }

        return false;
    }
}


