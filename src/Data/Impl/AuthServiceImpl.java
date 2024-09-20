package Data.Impl;

import Data.Interface.UserInterface;
import Data.models.Constants.Constants;
import Data.models.Student;
import Data.models.Teacher;
import Data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 20/09/2024, Friday
 **/
public class AuthServiceImpl implements UserInterface {

    private List<User> userList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public User loginUser(String username, String password) {
        for (User u: userList) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                if(u instanceof Student){
                    return (Student)u;
                } else if (u instanceof Teacher) {
                    return (Teacher)u;
                }
                return u;
            }
        }
        return null;
    }

    @Override
    public User registerUser() {
        User user = getInputAndRegister();
        if (user.getRole().equals(Constants.STUDENT)) {
            Student stu = createStudentsData(user);
            return stu;
        } else if(user.getRole().equals(Constants.TEACHER)) {
            Teacher teacher = createTeacherData(user);
            return teacher;
        }
        return user;
    }

    private Student createStudentsData(User user) {
        System.out.println("Please Enter Students Grading:");
        String studentGrade = scanner.nextLine();
        System.out.println("Please Enter Students Age:");
        int studentAge = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(user,studentGrade,studentAge);
        studentList.add(student);
        return student;
    }

    private Teacher createTeacherData(User user) {
        System.out.println("Please Enter Teachers Position:");
        String teachersPosition = scanner.nextLine();
        System.out.println("Please Enter the salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Teacher teacher = new Teacher(user,teachersPosition,salary);
        teacherList.add(teacher);
        return teacher;
    }

    private User getInputAndRegister() {
        System.out.println("Please Enter Your Full Name:");
        String name = scanner.nextLine();
        System.out.println("Please Enter Your desired user name:");
        String username = scanner.nextLine();
        System.out.println("Please Enter Your Address");
        String address = scanner.nextLine();
        System.out.println("Please Enter Your new password:");
        String password = scanner.nextLine();
        System.out.println("Please Enter Your Contact Number:");
        String contactNumber = scanner.nextLine();
        boolean validRole = false;
        String role = Constants.STUDENT;
        do {
            System.out.println(
                    ("Please Enter Your Role: type [%s] " +
                            "for Signing in as a student or " +
                            "[%s] for signing in as a teacher. %n"
                    ).formatted("S","T"));
            char roleInput = scanner.next().charAt(0);
            if(Character.toLowerCase(roleInput) == 't') {
                role = Constants.TEACHER;
                validRole = true;
            } else if (Character.toLowerCase(roleInput) == 's') {
                role = Constants.STUDENT;
                validRole = true;
            } else {
                System.out.println("Invalid Role entered!! Please re-enter it.");
            }
        } while (!validRole);
        scanner.nextLine();
        User user = new User(username,name,address,password,role,contactNumber,0);
        userList.add(user);
        return user;
    }
}
