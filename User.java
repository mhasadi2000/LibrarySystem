package com.company;

/**The User class is used to save information of users
 * and has print method
 * @author Mohammad Hossein Asadi
 * @version 1.0
 * **/
public class User {
    private String firstName;
    private String lastName;
    private String idNum;
    /**construct the first name, last name and id of each student
     * @param firstName String
     * @param lastName String
     * @param idNum String
     **/
    public User(String firstName,String lastName,String idNum){
        this.firstName=firstName;
        this.lastName=lastName;
        this.idNum=idNum;
    }
    /**Setters**/
    public void setFirstName(String fName) {
        firstName = fName;
    }
    public void setLastName(String lName) {
        lastName = lName;
    }
    public void setIdNum(String iNum) {
        idNum = iNum;
    }
    /**Getters**/
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getIdNum() {
        return idNum;
    }
    /**check if the user id is duplicate**/

    /**prints info of the student**/
    public void print(){
        System.out.println("Full Name:"+ firstName +lastName+ "|"+ "ID:"+ idNum );
    }
}
