package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.lang.reflect.Array;

public class GameActivity extends AppCompatActivity {

    int turnCounter = 0;
    boolean isGameOver = false;
    ImageButton[] grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageButton topRightBtn = findViewById(R.id.topRightBtn);
        ImageButton topMidBtn = findViewById(R.id.topMidBtn);
        ImageButton topLeftBtn = findViewById(R.id.topLeftBtn);
        ImageButton midRightBtn = findViewById(R.id.midRightBtn);
        ImageButton midMidBtn = findViewById(R.id.midMidBtn);
        ImageButton midLeftBtn = findViewById(R.id.midLeftBtn);
        ImageButton botRightBtn = findViewById(R.id.botRightBtn);
        ImageButton botMidBtn = findViewById(R.id.botMidBtn);
        ImageButton botLeftBtn = findViewById(R.id.botLeftBtn);
        grid = new ImageButton[]{
                topRightBtn, topMidBtn, topLeftBtn,
                midRightBtn, midMidBtn, midLeftBtn,
                botRightBtn, botMidBtn, botLeftBtn };
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void placeMark(View view) {

        Log.d("TURN", "Turn #" + turnCounter);

        if (isGameOver)
            return;

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

        if (checkWin() != -1) {
            findViewById(checkWin()).setVisibility(View.VISIBLE);
            isGameOver = true;
        } else if (turnCounter == 9)
            isGameOver = true;
    }

    public void resetGame(View view) {
        if(checkWin() != -1)
            findViewById(checkWin()).setVisibility(View.INVISIBLE);
        for (ImageButton btn : grid) {
            btn.setBackgroundResource(0);
            btn.setTag(null);
        }
        turnCounter = 0;
        isGameOver = false;
    }

    public int checkWin() {
        if (checkEqual(findViewById(R.id.topLeftBtn).getTag(),
                findViewById(R.id.topRightBtn).getTag(),
                findViewById(R.id.topMidBtn).getTag()))
            return R.id.topHorStrike;
        else if (checkEqual(findViewById(R.id.midLeftBtn).getTag(),
                findViewById(R.id.midRightBtn).getTag(),
                findViewById(R.id.midMidBtn).getTag()))
            return R.id.midHorStrike;
        else if (checkEqual(findViewById(R.id.botLeftBtn).getTag(),
                findViewById(R.id.botRightBtn).getTag(),
                findViewById(R.id.botMidBtn).getTag()))
            return R.id.botHorStrike;
        else if (checkEqual(findViewById(R.id.topLeftBtn).getTag(),
                findViewById(R.id.midLeftBtn).getTag(),
                findViewById(R.id.botLeftBtn).getTag()))
            return R.id.leftVerStrike;
        else if (checkEqual(findViewById(R.id.topRightBtn).getTag(),
                findViewById(R.id.midRightBtn).getTag(),
                findViewById(R.id.botRightBtn).getTag()))
            return R.id.rightVerStrike;
        else if (checkEqual(findViewById(R.id.topMidBtn).getTag(),
                findViewById(R.id.midMidBtn).getTag(),
                findViewById(R.id.botMidBtn).getTag()))
            return R.id.midVerStrike;
        else if (checkEqual(findViewById(R.id.topLeftBtn).getTag(),
                findViewById(R.id.midMidBtn).getTag(),
                findViewById(R.id.botRightBtn).getTag()))
            return R.id.tlbrDiagStrike;
        else if (checkEqual(findViewById(R.id.topRightBtn).getTag(),
                findViewById(R.id.midMidBtn).getTag(),
                findViewById(R.id.botLeftBtn).getTag()))
            return R.id.trblDiagStrike;
        return -1;
    }

    public boolean checkEqual(Object x, Object y, Object z) {
        try {
            return x.equals(y) && y.equals(z) && z.equals(x);
        } catch (NullPointerException e) {
            return false;
        }
    }
}