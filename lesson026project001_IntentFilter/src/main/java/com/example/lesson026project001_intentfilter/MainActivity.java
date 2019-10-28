package com.example.lesson026project001_intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * - вызываем Activity, используя неявный вызов и Intent Filter
 *
 * Сделаем мы это с помощью трех Activity:
 * - первое будет содержать две кнопки: Show time и Show date
 * - второе будет отображать время
 * - третье будет отображать дату
 *
 * Нажатие на кнопку Show time будет вызывать второе Activity,
 * а нажатие на кнопку Show date – третье Activity.
 * Но реализуем мы это не через прямое указание классов Activity в Intent,
 * а через Intent Filter.
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTime =  (Button) findViewById(R.id.btnTime);
        Button btnDate = (Button) findViewById(R.id.btnDate);
        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);

    }

    /*
    обрабатываем нажате и вызываем по действиб
     */
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case  R.id.btnTime:
                intent = new Intent("com.example.intent.action.showtime");
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("com.example.intent.action.showdate");
                startActivity(intent);
                break;
        }

    }
}
