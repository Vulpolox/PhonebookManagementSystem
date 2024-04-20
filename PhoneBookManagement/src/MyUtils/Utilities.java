package MyUtils;

import java.sql.*;
import java.security.*;

public class Utilities
{
    private static final String URL = "jdbc:mysql:///phonebook_db2";
    private static final String USER = "root";
    private static final String PASSWORD = "Password123";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

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
}
