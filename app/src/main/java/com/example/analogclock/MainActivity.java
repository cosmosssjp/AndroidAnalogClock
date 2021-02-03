package com.example.analogclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button timerbtn;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerbtn = findViewById(R.id.timer);
        spinner = findViewById(R.id.spinner);

        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(i);
            }
        });

        String[] items = getResources().getStringArray(R.array.my_array);
        ArrayAdapter myAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, items);
        spinner.setAdapter(myAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int itemId = item.getItemId();

        switch (itemId){

            case R.id.settings:
                Intent color = new Intent(MainActivity.this, ColorPickerActivity.class);
                startActivity(color);
                break;
        }
        return true;
    }
}
