// Create a class named MySQLAdsDao that implements the Ads interface

// This class should have a private instance property named connection of type Connection that is initialized in the constructor.
// Define your constructor so that it accepts an instace of your Config class so that it can obtain the database credentials.
// implement the methods in the Ads interface
// your methods should retrieve ads from the database and insert new ads into the database

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            while ( rs.next() ) {
                Ad ad = new Ad(1, rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            System.out.printf("Inserting a new ad: user_id: %s title: %s", ad.getUserId(), ad.getTitle());
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong inserting the new ad", e);
        }
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() +"', "
                + "'" + ad.getDescription() + "')";
    }

}




