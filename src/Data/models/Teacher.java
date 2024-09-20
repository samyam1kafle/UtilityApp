package Data.models;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 19/09/2024, Thursday
 **/
public class Teacher extends User {
    private static int idCounter = 1;
    private int ID;
    private String position;

    private double salary;
    private final int canBorrowUpTo = 5;


    public Teacher(User user, String position, double salary) {
        super(user);
        this.ID = idCounter++;
        this.position = position;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCanBorrowUpTo() {
        return canBorrowUpTo;
    }

    @Override
    public String toString() {
        return "[%s] %s \t (Address: %s) \t Contact : %s \t Books Taken: %s%n"
                .formatted(
                        ID,
                        super.getName(),
                        super.getAddress(),
                        super.getContactNumber(),
                        super.getNoOfBooksTaken()
                );
    }
}
