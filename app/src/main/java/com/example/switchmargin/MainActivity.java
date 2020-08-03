package com.example.switchmargin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(MainActivity.this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnok = findViewById(R.id.btnOk);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner.getSelectedItem().toString();
                if ("крупная".equals(item)) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_BIG);
                }
                if ("средняя".equals(item)) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                }
                if ("мелкая".equals(item)) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                }
            }
        });
    }
}