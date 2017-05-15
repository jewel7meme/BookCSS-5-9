package com.example.zyang3.bookcssmayeighth;

/**
 * Created by zyang3 on 5/8/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 6;

    // Database Name
    private static final String DATABASE_NAME = "bookCSS.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_BOOK = "CREATE TABLE " + Book.TABLE  + "("
                + Book.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Book.KEY_title + " TEXT, "
                + Book.KEY_cName + " TEXT, "
                + Book.KEY_cNumber + " TEXT, "
                + Book.KEY_price + " DOUBLE )";

        db.execSQL(CREATE_TABLE_BOOK);
        addBookData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Book.TABLE);

        // Create tables again
        onCreate(db);

    }
 public void addBookData(SQLiteDatabase db){
     try{
         db.beginTransaction();;
         ContentValues cv = new ContentValues();

         cv.put(Book.KEY_title, "Database Systems Design, Implementation, & Management");
         cv.put(Book.KEY_cName, "Database Modeling");
         cv.put(Book.KEY_cNumber, "CIS 3107");
         cv.put(Book.KEY_price, 120.00);
         db.insert(Book.TABLE, null, cv);

         cv.put(Book.KEY_title, "PHP and MySQL for Dynamic Web Sites Visual QuickPro Guide");
         cv.put(Book.KEY_cName, "Server-Side Web Development");
         cv.put(Book.KEY_cNumber, "CIS 4034");
         cv.put(Book.KEY_price, 38.24);
         db.insert(Book.TABLE, null, cv);

         db.setTransactionSuccessful();


     }
     finally {
         db.endTransaction();
     }
 }
}
