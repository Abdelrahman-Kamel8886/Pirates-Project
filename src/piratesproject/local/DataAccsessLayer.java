package piratesproject.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import piratesproject.models.UserModel;
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

    public int setOnlineState(String userName, int state) {
        // we need to set CONST_ONLINE_STATE in consts class and add database table ; 
        // and we need to change the table name ; 
        int rs = 0;
        int CONST_ONLINE_STATE = 1;
        int CONST_OFLINE_STATE = 0;
        try {

            String myStatment
                    = "UPDATE UsersTable SET userisOnline = ? " + "WHERE userName = ?";

            PreparedStatement pst = connection.prepareStatement(myStatment);

            pst.setString(1, userName);

            if (state == CONST_ONLINE_STATE) {
                pst.setInt(2, CONST_ONLINE_STATE);
            } else {
                pst.setInt(2, CONST_OFLINE_STATE);
            }
            rs = pst.executeUpdate();

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccsessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void status(UserModel user) {
        try {
            String myStatment
                    = "INSERT INTO localUserTable VALUES(?,?,?,?,?)";
            
            PreparedStatement pst = connection.prepareStatement(myStatment);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getUserName());
            pst.setInt(4, user.getScore());
            pst.setInt(5, user.getGamesPlayed());
        } catch (SQLException ex) {
            Logger.getLogger(DataAccsessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
