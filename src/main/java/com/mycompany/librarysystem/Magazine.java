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

public class Magazine extends Book {

    private int issueNo;
    private SimpleDateFormat releaseDate;

    public Magazine(int issueNo, SimpleDateFormat releaseDate, String title, Author author, String genre, int version, SimpleDateFormat date) {
        super(title, author, genre, version, date);
        this.issueNo = issueNo;
        this.releaseDate = releaseDate;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public SimpleDateFormat getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(SimpleDateFormat releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Magazine{" + "issueNo=" + issueNo + ", releaseDate=" + releaseDate + '}';
    }

}
