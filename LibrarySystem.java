package com.company;

import java.util.ArrayList;
import java.util.Iterator;

/** The LibrarySystem class is used to generates libraries
 *  and remove them.
 * @author Mohammad Hossein Asadi
 * @version 1.0
 * **/

public class LibrarySystem {
    ArrayList<Library> libraryArrayList = new ArrayList<Library>();
    /**adds a library to LibraryArraylist
     * @param libraryToAdd Library
     * **/

    public void addLibrary(Library libraryToAdd){
        libraryArrayList.add(libraryToAdd);
    }

    /**searches for a library and removes it
     * @param libraryToRemove Library
     * **/
    public void removeLibrary(Library libraryToRemove){
        int index = libraryArrayList.indexOf(libraryToRemove);
       // System.out.println("Found: " + (index == -1?false:true) + ", in position : " + index);
        libraryArrayList.remove(index);
    }
    /**sets an iterator and print all library's information
     * **/
    public  void  printAllLibraries(){
        Iterator<Library> ite=libraryArrayList.iterator();
        while (ite.hasNext()){
            Library l=ite.next();
            System.out.println(l.getName()+"    "+l.getAddress());
        }
    }
}
