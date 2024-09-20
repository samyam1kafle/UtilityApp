package Data.models;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 19/09/2024, Thursday
 **/
public class Student extends User {
    private static int idCounter = 1;
    private final int canBorrowUpTo = 1;

    private int ID;

    private String studentGrade;

    private int studentAge;

    public Student(User user, String studentGrade, int studentAge) {
        super(user);
        this.studentGrade = studentGrade;
        this.studentAge = studentAge;
        this.ID = idCounter++;
    }

    public int getID() {
        return ID;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
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
