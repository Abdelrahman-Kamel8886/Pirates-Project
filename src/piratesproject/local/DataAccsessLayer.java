package piratesproject.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import piratesproject.utils.Consts;

public class DataAccsessLayer {

    private static Connection connection;
    private static ResultSet resultSet;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Consts.DATABASE_URL);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }

    }
    
}
