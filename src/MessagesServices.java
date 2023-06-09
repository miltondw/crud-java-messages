import java.util.Scanner;

public class MessagesServices {
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Message");
        String msg = sc.nextLine();
        System.out.println("Name author");
        String author = sc.nextLine();

        Messages message = new Messages();
        message.setMessage(msg);
        message.setAuthor_message(author);
        MessagesDAO.createMessage(message);
    }
    public static void getMessages(){
        for (Messages m: MessagesDAO.getMessages()) {
            System.out.println("ID: "+m.getId());
            System.out.println("Message: "+m.getMessage());
            System.out.println("Author: "+m.getAuthor_message());
            System.out.println("Date: "+m.getDate_message());
            System.out.println("");
        }
    }
    public static void updateMessage(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Message");
        String msg = sc.nextLine();

        System.out.println("Id Message:");
        int id = sc.nextInt();

        Messages updateMessage= new Messages();
        updateMessage.setId(id);
        updateMessage.setMessage(msg);
        MessagesDAO.updateMessage(updateMessage);
    }
    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Id Message:");
        int id = sc.nextInt();
        MessagesDAO.deleteMessage(id);
    }
}
