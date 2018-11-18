package com.example.hp.codeoverflow2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.codeoverflow2.model.Articlelist;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class Article_Submission extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText et;
    EditText title;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article__submission);
        submit = (Button) findViewById(R.id.submit);
        et = (EditText) findViewById(R.id.data);
        title = (EditText) findViewById(R.id.title);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox3);
        c3 = (CheckBox) findViewById(R.id.checkBox4);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String tags="";

        if(c1.isChecked())
            tags=tags+":"+c1.getText();

        if(c2.isChecked())
            tags=tags+":"+c2.getText();

        if(c3.isChecked())
            tags=tags+":"+c3.getText();


        Bundle bundle = getIntent().getExtras();
        String phone = bundle.getString("phone");
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();

        Articlelist al = new Articlelist();
        al.title = title.getText().toString();
        al.author = phone.toString();
        al.data = et.getText().toString();
        al.tags = tags;
        /*mDatabase.child("Article").child(phone).child(date.toString()).child("data").setValue(et.getText().toString());
        mDatabase.child("Article").child(phone).child(date.toString()).child("submitted").setValue(phone);
        mDatabase.child("Article").child(phone).child(date.toString()).child("tags").setValue(tags);

        mDatabase.child("ALLArticle").child(date.toString()).child("data").setValue(et.getText().toString());
        mDatabase.child("ALLArticle").child(date.toString()).child("submitted").setValue(phone);
        mDatabase.child("ALLArticle").child(date.toString()).child("tags").setValue(tags);*/

        mDatabase.child("Article").child(phone).child(date.toString()).setValue(al);
        mDatabase.child("ALLArticle").child(date.toString()).setValue(al);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Article submitted",
                Toast.LENGTH_SHORT);

        toast.show();
        finish();

    }
}
