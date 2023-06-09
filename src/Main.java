import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option=0;
        String[] options={"create message","get messages","update message","delete message","exit"};
        do {
            System.out.println("------------");
            System.out.println("App Messages");
            for (int i = 0; i <options.length ; i++) {
                System.out.println(i+1+"."+options[i]);
            }
            option=sc.nextInt();
            switch (option){
                case 1:
                    MessagesServices.createMessage();
                    break;
                case 2:
                    MessagesServices.getMessages();
                    break;
                case 3:
                    MessagesServices.updateMessage();
                    break;
                case 4:
                    MessagesServices.deleteMessage();
                    break;
                default:
                    break;
            }
        }while (option!=5);

        Connection_db connection = new Connection_db();
        try(Connection cnt=connection.get_connection()){

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}