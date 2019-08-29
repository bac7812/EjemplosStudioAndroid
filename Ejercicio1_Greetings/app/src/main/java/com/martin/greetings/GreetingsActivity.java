package com.martin.greetings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        String name = getIntent().getStringExtra("name");
        TextView greetingTextView = (TextView) findViewById(R.id.greetingTextView);

        greetingTextView.setText("¡Hola " + name + "!");
    }
}
