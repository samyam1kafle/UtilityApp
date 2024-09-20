package Data.Impl;

import Data.Interface.StudentInterface;
import Data.Interface.TeacherInterface;
import Data.models.Student;
import Data.models.Teacher;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 20/09/2024, Friday
 **/
public class UserImpl implements StudentInterface, TeacherInterface {
    @Override
    public void printStudentData(Student user) {
        System.out.println(
                ("[%s] %n " +
                        "Name: %s%n " +
                        "Username: %s%n" +
                        "Role: %s%n" +
                        "Age: %s%n " +
                        "Grade: %s%n " +
                        "Can Borrow up to: %s%n " +
                        "Address: %s%n " +
                        "Contact Number: %s%n").formatted(
                        user.getID(),
                        user.getName(),
                        user.getUsername(),
                        user.getRole(),
                        user.getStudentAge(),
                        user.getStudentGrade(),
                        user.getCanBorrowUpTo(),
                        user.getAddress(),
                        user.getContactNumber()
                )
        );
    }

    @Override
    public void printTeacherData(Teacher user) {
        System.out.println(
                ("[%s] %n " +
                        "Name: %s%n " +
                        "Username: %s%n" +
                        "Role: %s%n" +
                        "Position: %s%n " +
                        "Salary: %s%n " +
                        "Can Borrow up to: %s%n " +
                        "Address: %s%n " +
                        "Contact Number: %s%n").formatted(
                        user.getID(),
                        user.getName(),
                        user.getUsername(),
                        user.getRole(),
                        user.getPosition(),
                        user.getSalary(),
                        user.getCanBorrowUpTo(),
                        user.getAddress(),
                        user.getContactNumber()
                )
        );
    }
}
