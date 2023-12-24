/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Magazine extends Book {

    private int issueNo;
    private Date releaseDate;

    public Magazine(int issueNo, String title, Author author, String genre, int version, Date date) {
        super(title, author, genre, version, date);
        this.issueNo = issueNo;
        this.releaseDate = date;
    }

    Magazine() {
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Magazine{" + "issueNo=" + issueNo + ", releaseDate=" + releaseDate + '}';
    }

}
