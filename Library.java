package com.company;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/**The library class is used to work with books and users
 * by add and remove.it also moderate borrows
 * @author Mohammad Hossein Asadi
 * @version 1.0
 * **/

public class Library {
    private String address;
    private String name;
    public ArrayList<User> users = new ArrayList<User>();
    public ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<Borrow> borrows = new ArrayList<Borrow>();
    public ArrayList<Book> hasBorrowedBook=new ArrayList<Book>();
    /**construct the address and the name of library
     * @param address String
     * @param name String
     * **/
    public Library(String address,String name){
        this.address=address;
        this.name=name;
    }
    /**add a user to arraylist named users
     * and check at first if the user id is duplicate
     * or not.
     * @param userToAdd User
     * **/
    public void addUser(User userToAdd){
        Iterator<User> ite=users.iterator();
        while(ite.hasNext()){
            if (ite.next().getIdNum().equals(userToAdd.getIdNum())){
                System.out.println("the idnum that ("+userToAdd.getFirstName()+" "+userToAdd.getLastName()+") is want to enroll with, already has been enrolled. ");
                return;
            }
        }
        users.add(userToAdd);
    }
    /**searches for a user and removes it
     * @param userToRemove User
     * **/
    public void	removeUser(User userToRemove){
        int index = users.indexOf(userToRemove);
        //System.out.println("Found: " + (index == -1 ? false:true) + ", in position : " + index);
        users.remove(index);

    }
    /**add a book to arraylist named books, if
     * the book has not been added yet.
     * by use of iterator
     * @param bookToAdd Book
     * **/
    public void addBook(Book bookToAdd){
        Iterator<Book> ite=books.iterator();
        while (ite.hasNext()){
            if(bookToAdd.getTitle().equals(ite.next().getTitle())){
                System.out.println("The book "+"("+bookToAdd.getTitle()+")"+" ,already has been added");
                return;
            }
        }
        books.add(bookToAdd);
    }
    /**searches for a book and removes it
     * @param bookToRemove Book
     * **/
    public void	removeBook(Book bookToRemove){
        int index = books.indexOf(bookToRemove);
        //System.out.println("Found: " + (index == -1 ? false:true) + ", in position : " + index);
        books.remove(index);
    }

    /**make a borrow and check at first whether the book
     * has already borrowed or not and check that deadline
     * be greater than issued date.
     * @param bookToBorrow  Book
     * @param borrower  User
     * @param deadline Date
     * **/

    public void borrowBook(Book bookToBorrow, User borrower, Date deadline){
        int index = books.indexOf(bookToBorrow);
        if(index==-1){
            int IOB = hasBorrowedBook.indexOf(bookToBorrow);
            if(IOB==-1){
                System.out.println("The Book you want does not exist now in this library");
            }else{
                System.out.println("The book you want has been borrowed by another user");
            }

        }else {
            //System.out.println("Found: " + (index == -1 ? false : true) + ", in position : " + index);

            Date issuedDate = new Date();
            Borrow B1 = new Borrow(borrower, bookToBorrow, issuedDate, deadline);
            borrows.add(B1);

            if(B1.check()==0){
                borrows.remove(B1);
            }
            hasBorrowedBook.add(bookToBorrow);
            removeBook(bookToBorrow);
            removeUser(borrower);

        }
    }

    /**searches for a borrow and removes it, and
     * check also whether is the book we want to
     * give it back exist or not
     * @param borrow Borrow
     * **/
    public void giveBackBook(Borrow borrow){
        int index = borrows.indexOf(borrow);
        //System.out.println("Found: " + (index == -1 ? false:true) + ", in position : " + index);
        if(index==-1){
            System.out.println("The Book you want to give it back has not been borrowed");
        }else{
            addBook(borrow.getBook());
            addUser(borrow.getBorrower());
            hasBorrowedBook.remove(borrow.getBook());
            borrows.remove(index);
        }
    }

    /**search for passed deadline borrows
     * by doing a couple of steps for each borrow
     * Getting the default zone id
     * Converting the date to Instant
     * Converting the Date to LocalDate
     * to be able to get year, mount and day separately
     * **/
    public void	printPassedDeadlineBorrows(){
        Iterator<Borrow> ite=borrows.iterator();
        while (ite.hasNext()){
            Borrow b=ite.next();

            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant instant = b.getIssuedDate().toInstant();
            LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();

            int currentDate= localDate.getDayOfMonth();
            int currentMonth= localDate.getMonthValue();
            int currentYear= localDate.getYear();

            ZoneId defaultZoneId1 = ZoneId.systemDefault();
            Instant instant1 = b.getDeadlineDate().toInstant();
            LocalDate localDate1 = instant1.atZone(defaultZoneId1).toLocalDate();

            int currentDate1= localDate1.getDayOfMonth();
            int currentMonth1= localDate1.getMonthValue();
            int currentYear1= localDate1.getYear();

            if(currentYear1-currentYear<0 || currentMonth1-currentMonth<0 || currentDate1-currentDate<0){
                System.out.println("printPassedDeadlineBorrows");
                b.print();
            }else {
                System.out.println("remaining time");
                String stry = Integer.toString(currentYear1-currentYear);
                String strm = Integer.toString(currentMonth1-currentMonth);
                String strd = Integer.toString(currentDate1-currentDate);
                System.out.println(strd+" days"+" and "+strm+" month"+" and "+stry+" years");
            }

        }
    }
    /**Getters**/
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
