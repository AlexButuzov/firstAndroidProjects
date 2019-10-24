package com.javarush.lesson021project001_twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.javarush.lesson021project001_twoactivity.R.id.btnActOne;

public class activity_two extends AppCompatActivity implements View.OnClickListener {
    private Button btnActOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        btnActOne = (Button) findViewById(R.id.btnActOne);
    }

    @Override

    /*
    здесь переключимся обратно на главный экран
     */
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnActOne:
                //не сработало
                //setContentView(R.layout.activity_main);
                //не саработало
                Intent intent = getParentActivityIntent();
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
