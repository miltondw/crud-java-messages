public class Messages {
    int id;
    String message;
    String author_message;
    String date_message;

    public Messages(){}
    public Messages(String message, String author_message, String date_message) {
        this.message = message;
        this.author_message = author_message;
        this.date_message = date_message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor_message() {
        return author_message;
    }

    public void setAuthor_message(String author_message) {
        this.author_message = author_message;
    }

    public String getDate_message() {
        return date_message;
    }

    public void setDate_message(String date_message) {
        this.date_message = date_message;
    }
}
