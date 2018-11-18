package com.example.hp.codeoverflow2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleDataDisplay extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_data_display);

        tv = (TextView) findViewById(R.id.display);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");
        tv.setText(data);


    }
}
