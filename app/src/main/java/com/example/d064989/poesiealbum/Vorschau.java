package com.example.d064989.poesiealbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Vorschau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorschau);
    }

    public void newEntry(View aView) {
        Intent newE = new Intent(this, Entry1.class);
        startActivity(newE);

    }
}
