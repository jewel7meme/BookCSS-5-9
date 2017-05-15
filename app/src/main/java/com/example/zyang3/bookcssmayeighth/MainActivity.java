package com.example.zyang3.bookcssmayeighth;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//public class MainActivity extends ListActivity implements android.view.View.OnClickListener {
public class MainActivity extends Activity{
    Button btnAdd,btnGetAll;
    TextView book_Id;
    private ListView myListView;
    public static ArrayList<String> ArrayofTitle = new ArrayList<String>();
    private static final String numberFormatException = MainActivity.class.getSimpleName();
/*
    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,BookDetail.class);
            intent.putExtra("book_Id",0);
            startActivity(intent);

        }else {

            BookRepo repo = new BookRepo(this);

            ArrayList<HashMap<String, String>> bookList =  repo.getBookList();
            if(bookList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        book_Id = (TextView) view.findViewById(R.id.book_Id);
                        String bookId = book_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),BookDetail.class);
                        objIndent.putExtra("book_Id", Integer.parseInt(bookId));
                        startActivity(objIndent);
                    }
                });
                //ListAdapter adapter = new SimpleAdapter( MainActivity.this,bookList, R.layout.view_book_entry, new String[] { "id","title"}, new int[] {R.id.book_Id, R.id.book_title});
                ListAdapter adapter = new SimpleAdapter(MainActivity.this, bookList, R.layout.view_book_entry, new String[]{"title", "cName", "cNumber", "price"}, new int[]{R.id.book_title, R.id.course_name, R.id.course_number, R.id.book_price});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No book!",Toast.LENGTH_SHORT).show();
            }

        //}
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = (ListView) findViewById(R.id.listView1);

        //btnAdd = (Button) findViewById(R.id.btnAdd);
        //btnAdd.setOnClickListener(this);

        //btnGetAll = (Button) findViewById(R.id.btnGetAll);
        //btnGetAll.setOnClickListener(this);

        //displayBookList();
        final BookRepo repo = new BookRepo(this);
        List bookItems = repo.getAllBooks();
        List bookList = repo.getBookList();
        //ArrayAdapter<Book> adapterBook = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, bookItems);
       //ArrayAdapter<String> adapterString = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArrayofTitle);
        ListAdapter adapter = new SimpleAdapter(MainActivity.this, bookList, R.layout.view_book_entry, new String[]{"title", "cName", "cNumber", "price"}, new int[]{R.id.book_title, R.id.course_name, R.id.course_number, R.id.book_price});
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                book_Id = (TextView) view.findViewById(R.id.book_Id);
                String bookId = book_Id.getText().toString();
                Book selectedBook = repo.getBookById(bookId);
                Intent objIndent = new Intent(getApplicationContext(), BookDetail.class);
                //int bookIDInt = Integer.parseInt(bookId);
                objIndent.putExtra("selectedBook", selectedBook);
                startActivity(objIndent);
            }
        });
        /*
        //myListView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ArrayofTitle);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                book_Id = (TextView) view.findViewById(R.id.book_Id);
                String bookId = book_Id.getText().toString();
                Intent objIndent = new Intent(getApplicationContext(), BookDetail.class);
                //objIndent.putExtra("book_Id", Integer.parseInt(bookId));
                objIndent.putExtra("book_Id", Integer.parseInt(bookId));
                startActivity(objIndent);
            }
        });
        //displayBookList();
*/

    }
/*
    private void displayBookList() {

        BookRepo repo = new BookRepo(this);

        ArrayList<HashMap<String, String>> bookList = repo.getBookList();
        if (bookList.size() != 0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    book_Id = (TextView) view.findViewById(R.id.book_Id);
                    String bookId = book_Id.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(), BookDetail.class);
                    //objIndent.putExtra("book_Id", Integer.parseInt(bookId));
                    objIndent.putExtra("book_Id", Integer.parseInt(bookId));
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, bookList, R.layout.view_book_entry, new String[]{"title", "cName", "cNumber", "price"}, new int[]{R.id.book_title, R.id.course_name, R.id.course_number, R.id.book_price});
            setListAdapter(adapter);



        }

    }*/
}
