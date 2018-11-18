package com.example.hp.codeoverflow2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.codeoverflow2.adapters.home_adapter;
import com.example.hp.codeoverflow2.model.Articlelist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowArticles extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<Articlelist> arr = new ArrayList<Articlelist>();
    private DatabaseReference mDatabase;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_articles);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("ALLArticle").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for( DataSnapshot e: dataSnapshot.getChildren())
                {
                    Articlelist a =  e.getValue(Articlelist.class);

                    arr.add(a);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView = (ListView) findViewById(R.id.lv_article);

        home_adapter surveyListAdapter = new home_adapter(this, arr);

        listView.setAdapter(surveyListAdapter);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
