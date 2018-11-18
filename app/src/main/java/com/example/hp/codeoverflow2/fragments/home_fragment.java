package com.example.hp.codeoverflow2.fragments;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.codeoverflow2.ArticleDataDisplay;
import com.example.hp.codeoverflow2.R;
import com.example.hp.codeoverflow2.adapters.home_adapter;
import com.example.hp.codeoverflow2.article_activity;
import com.example.hp.codeoverflow2.model.Articlelist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class home_fragment extends Fragment implements AdapterView.OnItemClickListener {
    ArrayList<Articlelist> arr = new ArrayList<Articlelist>();
    private DatabaseReference mDatabase;
    private ListView listView;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Log.d("survey",list.toString());

        mDatabase = FirebaseDatabase.getInstance().getReference();
        view = inflater.inflate(R.layout.activity_article_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.lv_article);
        mDatabase.child("ALLArticle").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot e : dataSnapshot.getChildren()) {
                    Articlelist a = e.getValue(Articlelist.class);

                    arr.add(a);
                }

                home_adapter surveyListAdapter = new home_adapter(getActivity(), arr);

                listView.setAdapter(surveyListAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {




    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String s ="";
        Intent i= new Intent(getContext(),ArticleDataDisplay.class);
        String a = arr.get(position).data.toString();
        i.putExtra("data",a);
        startActivity(i);

    }


}
