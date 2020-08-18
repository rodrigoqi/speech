package com.example.ttsestt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity {
    Button btnNarrar, btnVoltarTTS;
    EditText edtTTS;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.getDefault());
                }
            }
        });

        edtTTS = findViewById(R.id.edtTTS);
        btnNarrar = findViewById(R.id.btnNarrar);
        btnVoltarTTS = findViewById(R.id.btnVoltarTTS);

        btnNarrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                narrar(edtTTS.getText().toString());
            }
        });

        btnVoltarTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void narrar(String texto){
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
    }


}