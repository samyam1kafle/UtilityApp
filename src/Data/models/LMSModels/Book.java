package Data.models.LMSModels;

public class Book {
    private int id;
    private static int counter=1;
    private int quantity;
    private String title;
    private String authorName;

    public Book() {}

    public Book(int quantity, String title, String authorName) {
        this.id = this.counter;
        this.quantity = quantity;
        this.title = title;
        this.authorName = authorName;
        this.counter++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Book.counter = counter;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "["+id +"]"+ title + "("+quantity+") By: " +authorName;
    }


}
