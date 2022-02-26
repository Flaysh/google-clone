/*Google Clone Application - Data Structures for Jackson Library, to create the POJO's
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.dataStructs;
public class PreviousSearch {
    private String query;

    //user ID is the Session ID
    private String userID;

    public PreviousSearch(String query,String userID) {
        this.query = query;
        this.userID = userID;
    }

    public String getQuery() {
        return query;
    }

    public String getUserID() {
        return userID;
    }
}
