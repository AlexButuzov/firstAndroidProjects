package com.example.lesson031project001_simpleintents;
/**
 * В этом уроке:
 *
 * - узнаем, что такое Uri и Intent-атрибут data
 * - вызываем системные приложения (браузер, звонилка, карта)
 */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

         Button btnWeb;
         Button btnMap;
         Button btnCall;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnCall = (Button) findViewById(R.id.btnCall);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        }

@Override
public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
        case R.id.btnWeb:
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
        startActivity(intent);
        break;
        case R.id.btnMap:
        intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:55.754283,37.62002"));
        startActivity(intent);
        break;
        case R.id.btnCall:
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:12345"));
        startActivity(intent);
        break;
        }
}
}