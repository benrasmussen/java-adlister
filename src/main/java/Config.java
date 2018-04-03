// Create a class named Config.java that will hold our database configuration. Add this file to the .gitignore.

// This class should have 3 private instance properties, url, user, and password, all of which should be strings,
// as well as getters for those properties.


public class Config {
    private String url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private String user = "benrasmussen";
    private String password = "code";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
