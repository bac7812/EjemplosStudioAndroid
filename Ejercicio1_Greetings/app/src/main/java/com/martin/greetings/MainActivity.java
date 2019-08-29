package com.martin.greetings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acceptButtonOnClick(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();

        Intent intent = new Intent(this, GreetingsActivity.class);
        intent.putExtra("name", name);

        startActivity(intent);
    }
}
