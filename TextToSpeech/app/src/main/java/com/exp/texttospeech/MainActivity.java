package com.exp.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button convertToSpeech;
    EditText input;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertToSpeech = findViewById(R.id.covertToSpeech);
        input = findViewById(R.id.input);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                    textToSpeech.setPitch(0f);
//                    Set<String> a = new HashSet<>();
//                    a.add("male");
//                    Voice voice = new Voice("en-us-x-sfg#male_2-local", new Locale("en", "US"), 400, 200, true, a);
//                    textToSpeech.setVoice(voice);
                }
            }
        });

        convertToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = input.getText().toString();
                if (s.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter some text..", Toast.LENGTH_SHORT).show();
                } else {

                    textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);

                }
            }
        });


    }
}