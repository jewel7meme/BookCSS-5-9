package com.example.zyang3.bookcssmayeighth;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookDetail extends ActionBarActivity {//implements android.view.View.OnClickListener{

    //Button btnSave ,  btnDelete;
    Button btnClose;
    TextView editTextTitle;
    TextView editTextCourseName;
    TextView editTextCourseNumer;
    TextView editTextPrice;
    protected String _Book_Id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        //btnSave = (Button) findViewById(R.id.btnSave);
        //btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextTitle = (TextView) findViewById(R.id.editTextBookTitle);
        editTextCourseName = (TextView) findViewById(R.id.editTextCourseName);
        editTextCourseNumer = (TextView) findViewById(R.id.editTextCourseNumber);
        editTextPrice = (TextView) findViewById(R.id.editTextBookPrice);

        //btnSave.setOnClickListener(this);
        //btnDelete.setOnClickListener(this);
        //btnClose.setOnClickListener(this);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        Book bookNew = (Book)extras.getSerializable("selectedBook");
        editTextTitle.setText(bookNew.getTitle());
        editTextCourseName.setText(bookNew.getCourseName());
        editTextCourseNumer.setText(bookNew.getCourseNumber());
        editTextPrice.setText(String.valueOf(bookNew.getPrice()));
        /*//_Book_Id =0;
        Intent intent = getIntent();
       // _Book_Id =intent.getIntExtra("book_Id", 0);
        Bundle extras = getIntent().getExtras();
        _Book_Id = extras.getString("book_Id");
        BookRepo repo = new BookRepo(this);
        Book book = new Book();
        book = repo.getBookById(_Book_Id);

        editTextTitle.setText(book.title);
        editTextCourseName.setText(book.courseName);
        editTextCourseNumer.setText(book.courseNumber);
        editTextPrice.setText(String.valueOf(book.price));
*/

    }



    /*public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            BookRepo repo = new BookRepo(this);
            Book book = new Book();
            book.title = editTextTitle.getText().toString();
            book.courseName = editTextCourseName.getText().toString();
            book.courseNumber = editTextCourseNumer.getText().toString();
            book.price = Double.parseDouble(editTextPrice.getText().toString());
            book.book_ID=_Book_Id;

            if (_Book_Id==0){
                _Book_Id = repo.insert(book);

                Toast.makeText(this,"New Book Insert",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(book);
                Toast.makeText(this,"Book Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            BookRepo repo = new BookRepo(this);
            repo.delete(_Book_Id);
            Toast.makeText(this, "Book Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }*/

}
