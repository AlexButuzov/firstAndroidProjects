package com.example.lesson008project001ViewById;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityViewById extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_by_id);
        View myTextView = findViewById(R.id.myText);
        TextView myTextInTextView = (TextView) myTextView;
        myTextInTextView.setText("new Text in TextView");

    }

    public void changeText(View view) {
        TextView myTextInTextView = (TextView) findViewById(R.id.myText);;
        myTextInTextView.setText("new Text in TextView ->" + view.getHeight());

    }
}
