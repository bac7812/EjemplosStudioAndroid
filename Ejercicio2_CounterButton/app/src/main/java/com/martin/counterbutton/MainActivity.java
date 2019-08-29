package com.martin.counterbutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int contar = 0;
    private TextView pushTextView;
    private Button pushButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushButton = (Button) findViewById(R.id.pushButton);
        pushTextView = (TextView) findViewById(R.id.pushTextView);

        pushTextView.setText(getString(R.string.pushMessage) + " " + 0);

        CheckBox enableCheck = (CheckBox) findViewById(R.id.enableCheckBox);
        enableCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                pushButton.setEnabled(b);
            }
        });
    }

    public void pushButtonOnClick(View view) {
        pushTextView.setText(getString(R.string.pushMessage) + " " + ++contar);
    }
}
