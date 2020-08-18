package com.example.ttsestt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnIrTTS, btnIrSTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrTTS = findViewById(R.id.btnIrTTS);
        btnIrSTT = findViewById(R.id.btnIrSTT);

        btnIrTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                janelaTTS();
            }
        });

        btnIrSTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                janelaSTT();
            }
        });
    }

    private void janelaTTS(){
        Intent janela = new Intent(this, TextToSpeechActivity.class);
        startActivity(janela);
    }

    private void janelaSTT(){
        Intent janela = new Intent(this, SpeechToTextActivity.class);
        startActivity(janela);
    }

}