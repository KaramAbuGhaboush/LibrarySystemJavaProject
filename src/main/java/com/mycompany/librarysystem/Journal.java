/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */
import java.util.Date;

public class Journal extends Book {

    private int ConferenceNo;
    private String ConferenceName;

    public Journal(int ConferenceNo, String ConferenceName, String title, Author author, String genre, int version, Date date) {
        super(title, author, genre, version, date);
        this.ConferenceNo = ConferenceNo;
        this.ConferenceName = ConferenceName;
    }

    Journal() {
    }

    public int getConferenceNo() {
        return ConferenceNo;
    }

    public void setConferenceNo(int ConferenceNo) {
        this.ConferenceNo = ConferenceNo;
    }

    public String getConferenceName() {
        return ConferenceName;
    }

    public void setConferenceName(String ConferenceName) {
        this.ConferenceName = ConferenceName;
    }

    @Override
    public String toString() {
        return "Journal{" + "ConferenceNo=" + ConferenceNo + ", ConferenceName=" + ConferenceName + '}';
    }

}
