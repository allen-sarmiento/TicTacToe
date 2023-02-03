package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button singlePlayerBtn = findViewById(R.id.singlePlayerBtn);
        Button twoPlayerBtn = findViewById(R.id.twoPlayerBtn);
        Button settingsBtn = findViewById(R.id.settingsBtn);
        Button rateUsBtn = findViewById(R.id.rateUsBtn);

        singlePlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToGameActivity();
            }
        });
    }

    public void switchToGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}