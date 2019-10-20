package com.javarush.lesson020project001_simpleanimation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        // константы для ID пунктов меню
        final int MENU_ALPHA_ID = 1;
        final int MENU_SCALE_ID = 2;
        final int MENU_TRANSLATE_ID = 3;
        final int MENU_ROTATE_ID = 4;
        final int MENU_COMBO_ID = 5;

        TextView tv;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tv = (TextView) findViewById(R.id.tv1);
            // регистрируем контекстное меню для компонента tv
            registerForContextMenu(tv);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenuInfo menuInfo) {

            switch (v.getId()) {
                case R.id.tv1:
                    // добавляем пункты
                    menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                    menu.add(0, MENU_SCALE_ID, 0, "scale");
                    menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
                    menu.add(0, MENU_ROTATE_ID, 0, "rotate");
                    menu.add(0, MENU_COMBO_ID, 0, "combo");
                    break;
            }
            menu.setGroupVisible(0,true);
            super.onCreateContextMenu(menu, v, menuInfo);
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            Animation anim = null;
            // определяем какой пункт был нажат
            switch (item.getItemId()) {
                case MENU_ALPHA_ID:
                    // создаем объект анимации из файла anim/myalpha
                    anim = AnimationUtils.loadAnimation(this, R.anim.my_alpha);
                    break;
                case MENU_SCALE_ID:
                    anim = AnimationUtils.loadAnimation(this, R.anim.my_scale);
                    break;
                case MENU_TRANSLATE_ID:
                    anim = AnimationUtils.loadAnimation(this, R.anim.my_trans);
                    break;
                case MENU_ROTATE_ID:
                    anim = AnimationUtils.loadAnimation(this, R.anim.my_rotate);
                    break;
                case MENU_COMBO_ID:
                    anim = AnimationUtils.loadAnimation(this, R.anim.my_combo);
                    break;
            }
            // запускаем анимацию для компонента tv
            tv.startAnimation(anim);
            return super.onContextItemSelected(item);
        }
    }
