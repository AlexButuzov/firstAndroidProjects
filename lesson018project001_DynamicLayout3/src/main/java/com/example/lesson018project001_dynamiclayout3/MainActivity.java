package com.example.lesson018project001_dynamiclayout3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    /*
    компонент SeekBar.
    Он похож на полосу прокрутки и позволяет задавать
    какое-либо значение из диапазона.
    У этого компонента есть свойства max и progress.
    Max – это какое значение выдает SeekBar, когда он выкручен на максимум.
    Progress – это текущее значение ползунка.
     */
    private SeekBar sbWeight;
    private Button btn1;
    private Button btn2;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();
    }

    /*
    Для SeekBar нужен будет обработчик, который будет реагировать на изменения.
    Это мы поручим Activity.
    Для этого надо добавить к описанию класса implements OnSeekBarChangeListener:
    Обработчик содержит три метода. Из названий понятно, что:

    - onStartTrackingTouch срабатывает, когда начинаем тащить ползунок
    - onProgressChanged срабатывает все время, пока значение меняется
    - onStopTrackingTouch срабатывает, когда отпускаем ползунок

     */
    //- onProgressChanged срабатывает все время, пока значение меняется
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        int leftValue = progress;
        int rightValue = seekBar.getMax() - progress;
        // настраиваем вес
        lParams1.weight = leftValue;
        lParams2.weight = rightValue;
        // в текст кнопок пишем значения переменных
        btn1.setText(String.valueOf(leftValue));
        btn2.setText(String.valueOf(rightValue));
    }

    //- onStartTrackingTouch срабатывает, когда начинаем тащить ползунок
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    //- onStopTrackingTouch срабатывает, когда отпускаем ползунок
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}