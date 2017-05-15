package com.example.zyang3.bookcssmayeighth;

import java.io.Serializable;

/**
 * Created by zyang3 on 5/8/2017.
 */

public class Book implements Serializable {

    // Labels table name
    public static final String TABLE = "Book";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_title = "title";
    public static final String KEY_cNumber = "cNumber";
    public static final String KEY_cName = "cName";
    public static final String KEY_price = "price";

    // property help us to keep data
    public int book_ID;
    public String title;
    public String courseNumber;
    public String courseName;
    public double price;

    public int getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
