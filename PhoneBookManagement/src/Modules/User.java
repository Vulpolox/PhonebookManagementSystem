package Modules;

public class User
{
    // instance data
    private int id;
    private String username, password;

    // constructors
    public User()
    {
        id = -1;
        username = "";
        password = "";
    }

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    // accessors and mutators
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

