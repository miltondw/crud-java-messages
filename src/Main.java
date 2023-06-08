import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection_db connection = new Connection_db();
        try(Connection cnt=connection.get_connection()){

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}