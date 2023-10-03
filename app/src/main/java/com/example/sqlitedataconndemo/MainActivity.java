package com.example.sqlitedataconndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       db=openOrCreateDatabase("cocsit.db",MODE_PRIVATE,null);
       db.execSQL("create table if not exists mycontact(name varchar(20), mobile varchar(20))");


    }

    public void save(View view) {

        EditText txt1=findViewById(R.id.txt1);
        EditText txt2=findViewById(R.id.txt2);
        String name=txt1.getText().toString();
        String mobile=txt2.getText().toString();
        db.execSQL("insert into mycontact values('"+ name +"','"+ mobile +"')");
        Toast.makeText(this, "Contact Saved", Toast.LENGTH_SHORT).show();


    }

    public void showall(View view) {
    Cursor c =db.rawQuery("select * from mycontact",null);
   String all="";

    while(c.moveToNext())
    {
        String n=c.getString(0);
        String m=c.getString(1);
        all=all+ "\n" + n + "\t" + m;


    }
        Toast.makeText(this, "Data in Mycontact=\n" + all, Toast.LENGTH_SHORT).show();




    }
}