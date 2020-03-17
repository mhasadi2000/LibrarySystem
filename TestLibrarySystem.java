package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**The TestLibrarySystem class includes main method
 * and it used to test all the classes and their methods.
 * this class checks all methods of classes by this order:
 * creat a librarySystem. creat 2 libraries and adding them to the librarySystem
 * creat 5 users and add them to each library
 * check: enroll a user with the same idnum
 * creat 5 books and add them to  each libraries
 * check: create another book whit the same title to check the method
 * print information of all libraries
 * print the number of books, users and borrowers for each library(three times in the code)
 * make tow borrows
 * passed deadline
 * give back book
 * print some of books and users
 * remove the first library then print all libraries
 * @author Mohammad Hossein Asadi
 * @version 1.0
 **/
public class TestLibrarySystem {
    /**the main method for testing all methods
     * and their functionality.
     **/
    public static void main(String[] args) throws ParseException {
        System.out.println("... START TESTING SYSTEM ...");
        /*creat a librarySystem.
          creat 2 libraries and adding them to the librarySystem**/
        LibrarySystem SLab=new LibrarySystem();
        Library Lib1=new Library("5529","Pirozi");
        Library Lib2=new Library("5540","Nirohavaii");
        SLab.addLibrary(Lib1);
        SLab.addLibrary(Lib2);
        /*creat 5 users and add them to the first library**/
        User U11=new User("Mohammad","karimy","9831001");
        User U12=new User("Hasan","Abasi","9831002");
        User U13=new User("Hamid","Hosseiny","9831003");
        User U14=new User("Ali","Taheri","9831004");
        User U15=new User("Alireza","Molaii","9831005");
        Lib1.addUser(U11);
        Lib1.addUser(U12);
        Lib1.addUser(U13);
        Lib1.addUser(U14);
        Lib1.addUser(U15);
        /*creat 5 users and add them to the second library**/
        User U21=new User("Amir","Moradi","9831011");
        User U22=new User("Hamid","Rezaii","9831012");
        User U23=new User("Karim","Shahidi","9831013");
        User U24=new User("Alireza","Asadi","9831014");
        User U25=new User("Ahmad","Zarif","9831015");
        Lib2.addUser(U21);
        Lib2.addUser(U22);
        Lib2.addUser(U23);
        Lib2.addUser(U24);
        Lib2.addUser(U25);
        System.out.println("--------------------");
        /*check: enroll a user with the same idnum**/
        User U26=new User("Ali","Zarif","9831015");
        Lib2.addUser(U26);
        /*creat 5 books and add them to the first library**/
        Book B11=new Book("Nameh","Samadi");
        Book B12=new Book("catch","Simson");
        Book B13=new Book("How","Alex");
        Book B14=new Book("Things","Bob");
        Book B15=new Book("solution","Robert");
        Lib1.addBook(B11);
        Lib1.addBook(B12);
        Lib1.addBook(B13);
        Lib1.addBook(B14);
        Lib1.addBook(B15);
        /*creat 5 books and add them to the second library**/
        Book B21=new Book("Baray to","Mohseni");
        Book B22=new Book("give me","Tomas");
        Book B23=new Book("The persuit of happiness","Alex");
        Book B24=new Book("sky","Boss");
        Book B25=new Book("soleiman","Daniel");
        Lib2.addBook(B21);
        Lib2.addBook(B22);
        Lib2.addBook(B23);
        Lib2.addBook(B24);
        Lib2.addBook(B25);
        System.out.println("--------------------");
        /*check: create another book whit the same title to check the method**/
        Book B16=new Book("solution","Robert");
        Lib1.addBook(B16);
        System.out.println("--------------------");
        /*print information of all libraries **/
        SLab.printAllLibraries();
        System.out.println("--------------------");
        /*print the number of books, users and borrowers for each library**/
        System.out.println("number of books in Lib1: "+Lib1.books.size());
        System.out.println("number of users in Lib1: "+Lib1.users.size());
        System.out.println("number of borrowers in Lib1: "+Lib1.borrows.size());
        System.out.println("number of books in Lib2: "+Lib2.books.size());
        System.out.println("number of users in Lib2: "+Lib2.users.size());
        System.out.println("number of borrowers in Lib2: "+Lib2.borrows.size());
        /*set a deadline date and make a borrow **/
        String sDate1="31/12/2020";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Lib1.borrowBook(B11,U11,date1);
        /*set a deadline date and make another borrow **/
        String sDate2="20/10/2020";
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
        Lib2.borrowBook(B21,U23,date2);
        System.out.println("--------------------");
        /*passed deadline**/
        Lib1.printPassedDeadlineBorrows();
        Lib2.printPassedDeadlineBorrows();
        System.out.println("--------------------");
        /*print the number of books, users and borrowers for each library**/
        System.out.println("number of books in Lib1: "+Lib1.books.size());
        System.out.println("number of users in Lib1: "+Lib1.users.size());
        System.out.println("number of borrowers in Lib1: "+Lib1.borrows.size());
        System.out.println("number of books in Lib2: "+Lib2.books.size());
        System.out.println("number of users in Lib2: "+Lib2.users.size());
        System.out.println("number of borrowers in Lib2: "+Lib2.borrows.size());
        /*give back book**/
        Lib1.giveBackBook(Lib1.borrows.get(0));
        System.out.println("--------------------");
        /*print the number of books, users and borrowers for each library**/
        System.out.println("number of books in Lib1: "+Lib1.books.size());
        System.out.println("number of users in Lib1: "+Lib1.users.size());
        System.out.println("number of borrowers in Lib1: "+Lib1.borrows.size());
        System.out.println("number of books in Lib2: "+Lib2.books.size());
        System.out.println("number of users in Lib2: "+Lib2.users.size());
        System.out.println("number of borrowers in Lib2: "+Lib2.borrows.size());
        System.out.println("--------------------");
        Lib2.borrows.get(0).print();
        System.out.println("--------------------");
        /*print some of books and users**/
        Lib1.books.get(2).print();
        Lib1.users.get(3).print();
        B11.print();
        U13.print();
        System.out.println("--------------------");
        /*remove the first library then print all libraries**/
        SLab.removeLibrary(Lib1);
        SLab.printAllLibraries();
        System.out.println("--------------------");
        System.out.println("//End Testing//");
        System.out.println("//Thank you for your attention//");

    }
}
