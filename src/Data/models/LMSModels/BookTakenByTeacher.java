package Data.models.LMSModels;

import Data.models.Notepad;

public class BookTakenByTeacher extends Book {
    private static int teacherId = 1;
    private int id;
    private String teacherName;
    private String teacherAddr;

    private Book addBook;
    public BookTakenByTeacher(){super();}

    public BookTakenByTeacher(String name, String addr,Book book) {
        super();
        this.id = teacherId;
        this.teacherName = name;
        this.teacherAddr = addr;
        this.addBook = book;
        teacherId++;
    }
    public static int getTeacherId() {
        return teacherId;
    }

    public static void setTeacherId(int teacherId) {
        BookTakenByTeacher.teacherId = teacherId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAddr() {
        return teacherAddr;
    }

    public void setTeacherAddr(String teacherAddr) {
        this.teacherAddr = teacherAddr;
    }

    public int getSuperId(){
        System.out.println("Supeeeeerrrrrrrrrrrrrrrr!!!!!!!!!!!!");
        printBookDetails();
        return super.getId();
    }

    private void printBookDetails() {
        System.out.println(this.addBook.getAuthorName());
    }
}
