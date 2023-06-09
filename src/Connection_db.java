import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_db {

    public Connection get_connection(){
        Connection connection;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/message_app","root","");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
