import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessagesDAO {
    public static void createMessage(Messages message){
        Connection_db connection = new Connection_db();
        try(Connection cnt=connection.get_connection()){
            PreparedStatement ps;
            try {
                String query="INSERT INTO message_app.messages(message,author_message,date_message) VALUES (?,?,current_timestamp())";
                ps=cnt.prepareStatement(query);
                ps.setString(1,message.getMessage());
                ps.setString(2,message.getAuthor_message());
                ps.executeUpdate();
                System.out.println("Created Message");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Messages> getMessages(){
        List<Messages> messagesList=new ArrayList<>();
        Connection_db connection = new Connection_db();
        try(Connection cnt=connection.get_connection()){
            PreparedStatement ps;
            ResultSet res;
            try {
                String query="SELECT * FROM message_app.messages";
                ps=cnt.prepareStatement(query);
                res= ps.executeQuery();
                while (res.next()){
                    Messages m=new Messages();
                    m.setId(res.getInt("id"));
                    m.setMessage(res.getString("message"));
                    m.setAuthor_message(res.getString("author_message"));
                    m.setDate_message(res.getString("date_message"));
                    messagesList.add(m);
                }
            } catch (SQLException e) {
                System.out.println("Error get messages");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messagesList;
    }
    public static void updateMessage(Messages message){
        Connection_db connection = new Connection_db();
        try(Connection cnt=connection.get_connection()){
            PreparedStatement ps;
            try {
                String query="UPDATE `message_app`.`messages` SET `message` = ? WHERE (`id` = ?)";
                ps=cnt.prepareStatement(query);
                ps.setString(1,message.getMessage());
                ps.setInt(2,message.getId());
                ps.executeUpdate();
                System.out.println("Updated Message");
            } catch (SQLException e) {
                System.out.println("Was not found update message.");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteMessage(int id){
        Connection_db connection = new Connection_db();
        try(Connection cnt=connection.get_connection()){
            PreparedStatement ps;
            try {
                String query="DELETE FROM message_app.messages WHERE id = ?";
                ps=cnt.prepareStatement(query);
                ps.setInt(1,id);
                ps.executeUpdate();
                int countRowsUpdated = ps.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.out.println("Was not found.");
                } else {
                    System.out.println("Has been deleted successfully.");
                }
            } catch (SQLException e) {
                System.out.println("Was not found message.");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
