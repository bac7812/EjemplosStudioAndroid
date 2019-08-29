package com.martin.material;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_battery:
                Toast.makeText(this,"Tienes la bateria baja", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_mouse:
                Toast.makeText(this,"Tienes el ratón", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_hot:
                Toast.makeText(this,"Tienes llenar los mensajes", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_sad:
                Toast.makeText(this,"Estas triste", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
