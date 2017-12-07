package com.example.d064989.poesiealbum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Entry5 extends AppCompatActivity {

    EditText nickNameInput;
    EditText howInput;
    EditText songInput;
    EditText foodInput;
    EditText professionInput;
    ViewGroup view;

    SharedPreferences prefs;

    boolean oneFieldEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry5);

        nickNameInput = findViewById(R.id.nickname);
        howInput = findViewById(R.id.how);
        songInput = findViewById(R.id.song);
        foodInput = findViewById(R.id.food);
        professionInput = findViewById(R.id.profession);

        view = findViewById(android.R.id.content);

        prefs = getPreferences(MODE_PRIVATE);
        if (!(prefs.getAll().size() == 0)) {
            nickNameInput.setText(prefs.getString("nickname", ""));
            howInput.setText(prefs.getString("how", ""));
            songInput.setText(prefs.getString("song", ""));
            foodInput.setText(prefs.getString("food", ""));
            professionInput.setText(prefs.getString("profession", ""));
            createNewEntry(view);
        }

        nickNameInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    loopViews(view);
                }
            }
        });

        howInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    loopViews(view);
                }
            }
        });

        songInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    loopViews(view);
                }
            }
        });

        foodInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    loopViews(view);
                }
            }
        });

        professionInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    loopViews(view);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        prefs = getPreferences(MODE_PRIVATE);

        nickNameInput.setText(prefs.getString("nickname", ""));
        howInput.setText(prefs.getString("how", ""));
        songInput.setText(prefs.getString("song", ""));
        foodInput.setText(prefs.getString("food", ""));
        professionInput.setText(prefs.getString("profession", ""));
    }

    private void loopViews(ViewGroup view) {
        SharedPreferences.Editor e = prefs.edit();
        oneFieldEmpty = false;

        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);

            if (v instanceof EditText) {

                if (!(((EditText) v).length() == 0)) {
                    String name = getResources().getResourceEntryName(v.getId());
                    e.putString(name, ((EditText) v).getText().toString());
                    ((EditText) v).setError(null);
                } else {
                    oneFieldEmpty = true;
                    ((EditText) v).setError("Bitte eintragen!");
                }
            } else if (v instanceof ViewGroup) {

                this.loopViews((ViewGroup) v);
            }
        }
        if (oneFieldEmpty) {
            e.clear();
            e.commit();
        } else {
            e.commit();
            createNewEntry(view);
        }
    }

    private void createNewEntry(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);

            if (v instanceof EditText) {
                v.setEnabled(false);
                ((EditText) v).setCursorVisible(false);
                ((EditText) v).setKeyListener(null);
                v.setBackgroundColor(Color.TRANSPARENT);
            } else if (v instanceof ViewGroup) {

                this.loopViews((ViewGroup) v);
            }
        }
    }

    public void onClicked(View aView) {
        if (aView.getId() == R.id.back) {
            Intent back = new Intent(this, Entry4.class);
            startActivity(back);
        } else {
            Intent next = new Intent(this, Entry6.class);
            startActivity(next);
        }
    }

}


