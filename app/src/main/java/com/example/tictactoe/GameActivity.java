package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.lang.reflect.Array;

public class GameActivity extends AppCompatActivity {

    int turnCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void placeMark(View view) {
        ImageButton btn = (ImageButton)view;
        turnCounter++;
        if (btn.getTag() == null) {
            if (turnCounter % 2 == 0) {
                Log.d("GAME", "CIRCLE");
                btn.setBackgroundResource(R.drawable.circle);
                btn.setTag(R.drawable.circle);
            }
            else {
                btn.setBackgroundResource(R.drawable.cross);
                btn.setTag(R.drawable.cross);
                Log.d("GAME", "CROSS");
            }
        }

        /*
        if(!btn.getTag().equals(R.drawable.circle) && !btn.getTag().equals(R.drawable.circle)) {
            if (turnCounter % 2 == 0) {
                btn.setBackgroundResource(R.drawable.circle);
                btn.setTag(R.drawable.circle);
            }
            else
                btn.setBackgroundResource(R.drawable.cross);
                btn.setTag(R.drawable.cross);
        }

         */
    }
}