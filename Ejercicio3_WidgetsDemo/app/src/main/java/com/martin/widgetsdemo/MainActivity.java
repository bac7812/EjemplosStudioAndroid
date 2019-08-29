package com.martin.widgetsdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;

public class MainActivity extends Activity {
    private EditText editText;
    private Button button;
    private TextClock tClock;
    private ImageView imageView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cambio de zona horaria
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        tClock = findViewById(R.id.textClock);

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.london_radiobutton:
                        tClock.setTimeZone("Europe/London");
                        break;

                    case R.id.beijing_radiobutton:
                        tClock.setTimeZone("CST6CDT");
                        break;

                    case R.id.newyork_radiobutton:
                        tClock.setTimeZone("America/New_York");
                        break;
                }
            }
        });


        //cambio del texto del botón
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(editText.getText());
            }
        });


        //efectos de imagen
        imageView = findViewById(R.id.imageView);
        CheckBox transparencyCB = findViewById(R.id.transparency_checkbox);
        CheckBox tintCB = findViewById(R.id.tint_checkbox);
        CheckBox reSizeCB = findViewById(R.id.reSize_checkbox);

        transparencyCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    imageView.setAlpha(.1f);
                }else{
                    imageView.setAlpha(1f);
                }
            }
        });

        tintCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                } else {
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }
            }
        });

        reSizeCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });


        //mostrar u ocultar cliente web
        Switch sw = findViewById(R.id.switch1);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.es");
        webView.setVisibility(View.INVISIBLE);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    webView.setVisibility(View.VISIBLE);
                }else{
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
