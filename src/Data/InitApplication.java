package Data;

import Data.Client.LmsInit;
import Data.models.Notepad;
import Data.models.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InitApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ToDo> todoList = new ArrayList<>();
    private static List<Notepad> notepadList = new ArrayList<>();

    private static String divider = "-".repeat(40);
    public static void init() {
        System.out.println("Welcome to Utility Tools!\nPlease select which app you want to use. \nType [N] for Notepad, [T] for Todo list! and [L] for Library Management System!!! ");
        try{
            char userChoice = scanner.next().charAt(0);
            char toLower = Character.toLowerCase(userChoice);
            if(toLower == 't'){
                initTodo(toLower);
            } else if (toLower == 'n') {
                initNotepad(toLower);
            }  else if (toLower == 'l') {
                initLMS(toLower);
            } else {
                System.out.println("Invalid selection please select again");
                System.out.println(divider);
                init();
            }
        }catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }

    private static void initLMS(char toLower) {
        LmsInit init = new LmsInit();
        init.initialize();
    }

    private static void initNotepad(char menuFor) {
        System.out.println("Welcome to our Notepad application!");
        boolean takeNextInput = true;
        while (takeNextInput) {
            System.out.println("Enter the operation you want to perform!");
            int choice = userChoice(menuFor);
            if (choice == 5) {
                System.out.println("Thank You for using our app :) See you again next time!!");
                takeNextInput = false;
            }else if (choice > 0 || choice < 5) {
                switch (choice){
                    case 1 -> {
                        addNotepadData();
                        holdForXSeconds(1000);
                    }
                    case 2 -> {
                        viewNotepadList();
                        holdForXSeconds(4000);
                    }
                    case 3 -> {
                        editNotes();
                        holdForXSeconds(1000);
                    }
                    case 4 -> {
                        deleteNoteTask();
                        holdForXSeconds(1000);
                    }
                    default -> {
                        takeNextInput = false;
                        break;
                    }
                }
            } else {
                System.out.println("Invalid choice Please choose from [1-5] depending upon the operation you want to perform");
            }
            System.out.println(divider);
        }
    }

    private static void deleteNoteTask() {
        System.out.println("please enter the id of the Note you want to remove!");
        System.out.println("The List we currently have!");
        viewNotepadList();
        System.out.println(divider);
        int id = scanner.nextInt();
        Notepad toRemove = getNotepadItem(id,true);
        if(toRemove != null){
            notepadList.remove(toRemove);
        }
        System.out.println(toRemove+ "\n" + "Is removed!");
    }

    private static void editNotes() {
        System.out.println("Your Current Notes.");
        viewNotepadList();
        System.out.println(divider);
        System.out.println("Please Enter the Id of the Note you want to edit!");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Notepad val: notepadList) {
            if(val.getId() == id){
                System.out.println("Enter The New Title");
                String newTitle = scanner.nextLine();
                System.out.println("Enter The New Description");
                String newDescription = scanner.nextLine();
                val.setTitle(newTitle);
                val.setDescription(newDescription);
                break;
            }
        }

    }

    private static void viewNotepadList() {
        for (Notepad data: notepadList) {
            System.out.println(data);
        }
    }

    private static void initTodo(char menuFor) {
        System.out.println("Welcome to our ToDo list application!");
        System.out.println(divider);
        boolean takeNextInput = true;
        while (takeNextInput) {
            System.out.println("Enter the operation you want to perform!");
            int choice = userChoice(menuFor);
            if (choice == 5) {
                System.out.println("Thank You for using our app :) See you again next time!!");
                takeNextInput = false;
            } else if (choice > 0 || choice < 5) {
                switch (choice){
                    case 1 -> {
                       addTodoData();
                       holdForXSeconds(1000);
                    }
                    case 2 -> {
                        viewTodoList();
                        holdForXSeconds(4000);
                    }
                    case 3 -> {
                        markAsCompleteTodo();
                        holdForXSeconds(1000);
                    }
                    case 4 -> {
                        deleteTodoTask();
                        holdForXSeconds(1000);
                    }
                    default -> {
                        takeNextInput = false;
                    }
                }
            } else {
                System.out.println("Invalid choice Please choose from [1-5] depending upon the operation you want to perform");
            }
            System.out.println(divider);
        }

    }

    private static void deleteTodoTask() {
        System.out.println("please enter the id of the object you want to remove!");
        System.out.println("The List we currently have!");
        viewTodoList();
        System.out.println(divider);
        int id = scanner.nextInt();
        ToDo toRemove = getTodoItem(id,true);
        if(toRemove != null){
            todoList.remove(toRemove);
        }
        System.out.println(toRemove+ "\n" + "Is removed!");
    }
    private static Notepad getNotepadItem(int id,boolean returnObj) {
        for (Notepad val: notepadList) {
            if(val.getId() == id){
                if (returnObj) {
                    return val;
                }
                break;
            }
        }
        return null;
    }
    private static ToDo getTodoItem(int id,boolean returnObj) {
        for (ToDo val: todoList) {
            if(val.getId() == id){
                if (returnObj) {
                    return val;
                } else {
                    val.setCompleted(true);
                }
                break;
            }
        }
        return null;
    }

    private static void markAsCompleteTodo() {
        System.out.println("Current items in the List.");
        viewTodoList();
        System.out.println(divider);
        System.out.println("Please Enter the Id of the task you want to mark as complete!");
        int id = scanner.nextInt();
        for (ToDo val: todoList) {
            if(val.getId() == id){
                val.setCompleted(true);
                break;
            }
        }

    }

    private static void viewTodoList() {
        for (ToDo data: todoList) {
            System.out.println(data);
        }
    }

    private static void addTodoData() {
        scanner.nextLine();
        System.out.println("Enter the Todo Task description");
        String description = scanner.nextLine();
        ToDo data = new ToDo();
        data.setId(data.getIncrementedId());
        data.setDescription(description);
        todoList.add(data);
        System.out.println("Successfully added to the todo list!");
        System.out.println(divider);
    }

    private static void addNotepadData() {
        scanner.nextLine();
        System.out.println("Please Enter the title for the note!");
        String title = scanner.nextLine();
        System.out.println("Enter the Notepad Content");
        String content = scanner.nextLine();
        Notepad data = new Notepad();
        data.setId(data.getIncrementedId());
        data.setDescription(content);
        data.setTitle(title);
        notepadList.add(data);
        System.out.println("Note Successfully Added!");
        System.out.println(divider);
    }


    private static void holdForXSeconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static int userChoice(char menuFor){

        printMenu(menuFor);
        System.out.println("-".repeat(40));
        return scanner.nextInt();

    }
    private static void printMenu(char menuFor) {
        String menu = "";
        if(menuFor == 't'){
          menu += "1. Add Task\n" +
                  "2. View Tasks\n" +
                  "3. Mark Task as Completed\n" +
                  "4. Delete Task\n" +
                  "5. Exit";
        } else if (menuFor == 'n') {
            menu += "1. Create Note\n" +
                    "2. View Notes\n" +
                    "3. Edit Note\n" +
                    "4. Delete Note\n" +
                    "5. Exit";
        }
        System.out.println(menu);
    }
}
