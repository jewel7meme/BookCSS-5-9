package com.example.zyang3.bookcssmayeighth;

/**
 * Created by zyang3 on 5/8/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookRepo {
    private DBHelper dbHelper;

    public BookRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Book book) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Book.KEY_title, book.title);
        values.put(Book.KEY_cName, book.courseName);
        values.put(Book.KEY_cNumber, book.courseNumber);
        values.put(Book.KEY_price, book.price);

        // Inserting Row
        long book_Id = db.insert(Book.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) book_Id;
    }

    public void delete(int book_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Book.TABLE, Book.KEY_ID + "= ?", new String[] { String.valueOf(book_Id) });
        db.close(); // Closing database connection
    }

    public void update(Book book) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Book.KEY_title, book.title);
        values.put(Book.KEY_cName, book.courseName);
        values.put(Book.KEY_cNumber, book.courseNumber);
        values.put(Book.KEY_price, book.price);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Book.TABLE, values, Book.KEY_ID + "= ?", new String[] { String.valueOf(book.book_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getBookList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Book.KEY_ID + "," +
                Book.KEY_title + "," +
                Book.KEY_cName + "," +
                Book.KEY_cNumber + "," +
                Book.KEY_price  +
                " FROM " + Book.TABLE;

        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> book = new HashMap<String, String>();
                book.put("id", cursor.getString(cursor.getColumnIndex(Book.KEY_ID)));
                book.put("title", cursor.getString(cursor.getColumnIndex(Book.KEY_title)));
                book.put("cName", cursor.getString(cursor.getColumnIndex(Book.KEY_cName)));
                bookList.add(book);

                String title = cursor.getString(cursor.getColumnIndex(Book.KEY_title)) + "\n" +
                cursor.getString(cursor.getColumnIndex(Book.KEY_cName));
                MainActivity.ArrayofTitle.add(title);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return bookList;

    }

    public List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<Book>();
        //Select All Query
        String selectQuery = "SELECT * FROM " + Book.TABLE;

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setBook_ID(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setCourseName(cursor.getString(2));
                book.setCourseNumber(cursor.getString(3));
                book.setPrice(cursor.getDouble(4));


                String brief = cursor.getString(1) + "\n" + cursor.getString(2)
                        + "\n" + cursor.getString(3)
                        + "\n" + cursor.getString(4);
                MainActivity.ArrayofTitle.add(brief);
                // Adding contact to list
                bookList.add(book);
            } while (cursor.moveToNext());
        }
            return bookList;
    }

    public Book getBookById(String Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Book.KEY_ID + "," +
                Book.KEY_title + "," +
                Book.KEY_cName + "," +
                Book.KEY_cNumber + "," +
                Book.KEY_price  +
                " FROM " + Book.TABLE
                + " WHERE " +
                Book.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Book book = new Book();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                book.book_ID =cursor.getInt(cursor.getColumnIndex(Book.KEY_ID));
                book.title =cursor.getString(cursor.getColumnIndex(Book.KEY_title));
                book.courseName  =cursor.getString(cursor.getColumnIndex(Book.KEY_cName));
                book.courseNumber =cursor.getString(cursor.getColumnIndex(Book.KEY_cNumber));
                book.price =cursor.getDouble(cursor.getColumnIndex(Book.KEY_price));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return book;
    }
}
