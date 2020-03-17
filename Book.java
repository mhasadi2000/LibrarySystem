package com.company;

/**The Book class is used to save information
 * of each book and include print method
 * @author Mohammad Hossein Asadi
 * @version 1.0
 * **/
public class Book {
    private String title;
    private String author;
    /**construct the title and author of each book
     * @param title String
     * @param author String
     **/
    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    /**Setters**/
    public void setTitle(String title) {
        this.title=title;
    }
    public void setAuthor(String author) {
        this.author=author;
    }
    /**Getter**/
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    /**prints info of the student**/
    public void print(){
        System.out.println("Title:"+ title +"| Author:"+ author );

    }
}
