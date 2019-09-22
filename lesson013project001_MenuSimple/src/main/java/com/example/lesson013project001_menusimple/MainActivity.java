package com.example.lesson013project001_menusimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //За создание меню отвечает метод onCreateOptionsMenu.
    // На вход ему подается объект типа Menu, в который мы и будем добавлять свои пункты.
    // Добавляются они просто, методом add. На вход методу подается текст пункта меню.
    public boolean onCreateOptionsMenu(Menu menu) {
// TODO Auto-generated method stub

        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");
        return super.onCreateOptionsMenu(menu);
    }

    //. Обработчиком
    //является Activity, а метод зовется onOptionsItemSelected.
    // На вход ему передается пункт меню, который был нажат – MenuItem.
    // Определить, какое именно меню было нажато можно по методу getTitle.
    // Давайте выводить всплывающ ее сообщ ение с текстом нажатого пункта меню.
    // На выходе метода надо возвращ ать boolean. И мы снова предоставляем
    //это суперклассу.
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


}
