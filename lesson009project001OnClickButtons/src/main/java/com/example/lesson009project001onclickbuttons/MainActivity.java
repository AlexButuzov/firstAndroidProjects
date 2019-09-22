package com.example.lesson009project001onclickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvOut;
    private Button btnOk;
    private Button btnCancel;

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnOk:
                    tvOut.setText("Ввод Ок, слушатель - внутренний объект");
                    break;
                case R.id.btnCancel:
                    tvOut.setText("ВВод Cansel, слушатель - внутренний объект -> переключение на слушатель Activity");
                    btnCancel.setOnClickListener(this);
                    btnOk.setOnClickListener(this);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        tvOut= (TextView) findViewById(R.id.tvOut);
        btnOk= (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(clickListener);
        btnOk.setOnClickListener(clickListener);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOk:
                tvOut.setText("Ввод Ок, слушатель - Activity объект");
                break;
            case R.id.btnCancel:
                tvOut.setText("ВВод Cansel, слушатель - Activity  -> переключение на слушатель внутренний объект");
                btnCancel.setOnClickListener(clickListener);
                btnOk.setOnClickListener(clickListener);
                break;
        }
    }
}
