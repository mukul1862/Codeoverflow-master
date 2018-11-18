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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hp.codeoverflow2.Article_Submission;
import com.example.hp.codeoverflow2.R;
import com.example.hp.codeoverflow2.adapters.home_adapter;
import com.example.hp.codeoverflow2.article_activity;
import com.example.hp.codeoverflow2.model.Articlelist;

public class profile_fragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    Articlelist [] arr;
    Button b1;
    TextView tv;
    View view;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.user_profile, container, false);

        b1 = (Button)view.findViewById(R.id.article);
        tv = (TextView)view.findViewById(R.id.number);

        Bundle bundle = getActivity().getIntent().getExtras();
        String phone = bundle.getString("phone");
        tv.setText(phone.toString());

        b1.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void onClick(View view) {

        Bundle bundle = getActivity().getIntent().getExtras();
        String phone = bundle.getString("phone");
        Intent i = new Intent(getActivity(),Article_Submission.class);
        i.putExtra("phone",phone);
        startActivity(i);
    }
}
