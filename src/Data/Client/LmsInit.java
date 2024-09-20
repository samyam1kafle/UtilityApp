package Data.Client;

import Data.Impl.AuthServiceImpl;
import Data.Impl.UserImpl;
import Data.Interface.StudentInterface;
import Data.Interface.TeacherInterface;
import Data.Interface.UserInterface;
import Data.models.Constants.Constants;
import Data.models.Student;
import Data.models.Teacher;
import Data.models.User;

import java.util.Scanner;
import java.util.SortedMap;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 20/09/2024, Friday
 **/
public class LmsInit {
    private static String divider = "*".repeat(40);
    private static Scanner scanner = new Scanner(System.in);

    private static Teacher teacherObj;
    private static Student studentObj;
    public static void initialize(){
        printWelcomeMessage();
        System.out.println("Are you a new User? if yes Type [L] for Login or To register type [R]");
        char input = scanner.next().charAt(0);
        UserInterface userInterface = new AuthServiceImpl();
        int counter = 0;
        do {
            if(Character.toLowerCase(input) == 'l'){
                counter++;
                scanner.nextLine();
                System.out.println("PLease Enter your username!!");
                String username = scanner.nextLine();
                System.out.println("Please enter your password!!");
                String password = scanner.nextLine();
                User user = userInterface.loginUser(username,password);
                if(user == null){
                    System.out.println("Cannot Find the user. Do you want to register??");
                    System.out.println("Type [Y] for yes [N] for no and terminate application.");
                    counter=0;
                    char userInput = scanner.next().charAt(0);
                    if(Character.toLowerCase(userInput) == 'y'){
                        input = 'r';
                    } else if (Character.toLowerCase(userInput) == 'n') {
                        System.out.println("Exiting Application... Thank you for using our app!!");
                        System.exit(0);
                    }
                }
            } else if (Character.toLowerCase(input) == 'r') {
                counter++;
                User registeredUser = userInterface.registerUser();
                if(registeredUser instanceof Teacher) {
                    teacherObj = (Teacher) registeredUser;
                    TeacherInterface teacherInterface = new UserImpl();
                    teacherInterface.printTeacherData( teacherObj);
                } else if(registeredUser instanceof Student) {
                    studentObj = (Student) registeredUser;
                    StudentInterface studentInterface = new UserImpl();
                    studentInterface.printStudentData(studentObj);
                }

            }
        } while (counter == 0);
        System.out.println(divider);
        scanner.close();
    }


    private static void printWelcomeMessage() {
        System.out.println("Welcome To our Library management System!!!");
        System.out.println(divider);
    }
}
