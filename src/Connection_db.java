import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_db {

    public Connection get_connection(){
        Connection connection;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/message_app","root","4Rdu1N01");
            if(connection != null) System.out.println("Connection db port=3306");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
