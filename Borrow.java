package com.company;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**The Borrow class used to save information of each
 * borrow that has been done.
 * @author Mohammad Hossein Asadi
 * @version 1.0
 **/
public class Borrow {
    private User borrower;
    private Book book;
    private Date issuedDate;
    private Date deadlineDate;
    /**construct the user,book, the date you want to borrow in
     * and the deadline for each borrow.
     * @param borrower User
     * @param book Book
     * @param issuedDate Date
     * @param deadlineDate Date
     **/
    public Borrow(User borrower, Book book, Date issuedDate, Date deadlineDate) {
        this.borrower = borrower;
        this.book = book;
        this.issuedDate = issuedDate;
        this.deadlineDate = deadlineDate;
    }

    /**
     * Setters
     **/

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    /**
     * Getters
     **/

    public User getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    /**
     * check if deadlineDate is grater than issuedDate
     **/
     public int check() {
         if (deadlineDate.getTime()<issuedDate.getTime()) {
             System.out.println("issuedDate is grater than deadlineDate");
             System.out.println("issuedDate:" + issuedDate + "|" + "deadlineDate" + deadlineDate);
             return 0;
         } else {
             return 1;
         }

     }
    /**print all information of each borrow and the remaining time.
     * To find remaining time, it does these steps.
     * Getting the default zone id
     * Converting the date to Instant
     * Converting the Date to LocalDate
     * to be able to get year, mount and day separately
     * **/
    public void print() {
        System.out.println("Borrower => Full Name:" + borrower.getFirstName() + borrower.getLastName() + "| ID:" + borrower.getIdNum());
        System.out.println("Book => Title:" + book.getTitle() + "| Author:" + book.getAuthor());
        System.out.println("IssuedDate =>"+ issuedDate );
        System.out.println("Deadline =>"+ deadlineDate );

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = issuedDate.toInstant();
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();

        int currentDate= localDate.getDayOfMonth();
        int currentMonth= localDate.getMonthValue();
        int currentYear= localDate.getYear();

        ZoneId defaultZoneId1 = ZoneId.systemDefault();
        Instant instant1 =deadlineDate.toInstant();
        LocalDate localDate1 = instant1.atZone(defaultZoneId1).toLocalDate();

        int currentDate1= localDate1.getDayOfMonth();
        int currentMonth1= localDate1.getMonthValue();
        int currentYear1= localDate1.getYear();

        String stry = Integer.toString(currentYear1-currentYear);
        String strm = Integer.toString(currentMonth1-currentMonth);
        String strd = Integer.toString(currentDate1-currentDate);

        System.out.println("Remaining =>"+ strd+" days"+" and "+strm+" month"+" and "+stry+" years" );
    }
}
