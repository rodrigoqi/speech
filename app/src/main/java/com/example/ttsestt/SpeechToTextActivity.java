package com.example.ttsestt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Locale;

public class SpeechToTextActivity extends AppCompatActivity {
    EditText edtSTT;
    Button btnCapturar, btnVoltarSTT;
    LinearLayoutCompat layoutSTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);

        edtSTT = findViewById(R.id.edtSTT);
        btnCapturar = findViewById(R.id.btnCapturar);
        btnVoltarSTT = findViewById(R.id.btnVoltarSTT);
        layoutSTT = findViewById(R.id.layoutSTT);

        edtSTT.setMovementMethod(new ScrollingMovementMethod());

        btnCapturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturar();
            }
        });

        btnVoltarSTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void capturar(){
        Intent iSTT = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        iSTT.putExtra(RecognizerIntent.EXTRA_PROMPT, "Desembucha tchê!");
        startActivityForResult(iSTT, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> resultado =
                        data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String textoReconhecido = resultado.get(0);

                edtSTT.setText(textoReconhecido);

                if(textoReconhecido.toUpperCase().contains("FECHAR A APLICAÇÃO")
                        ||textoReconhecido.toUpperCase().contains("FECHAR APLICAÇÃO")){
                    finishAffinity();
                }

                if(textoReconhecido.toUpperCase().contains("FUNDO VERDE")){
                    layoutSTT.setBackgroundColor(Color.GREEN);
                }

                if(textoReconhecido.toUpperCase().contains("FUNDO VERMELHO")){
                    layoutSTT.setBackgroundColor(Color.RED);
                }

                if(textoReconhecido.toUpperCase().contains("FUNDO AZUL")){
                    layoutSTT.setBackgroundColor(Color.BLUE);
                }

                if(textoReconhecido.toUpperCase().contains("FUNDO AMARELO")){
                    layoutSTT.setBackgroundColor(Color.YELLOW);
                }

            }
        }
    }

}