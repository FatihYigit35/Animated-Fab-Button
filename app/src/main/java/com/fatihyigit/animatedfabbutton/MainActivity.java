package com.fatihyigit.animatedfabbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabMain, fabAdd, fabPhoto;
    private Animation fab_close, fab_open, turn_back, turn_forward;
    private Boolean fabStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.fabMain);
        fabAdd = findViewById(R.id.fabAdd);
        fabPhoto = findViewById(R.id.fabPhoto);

        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        turn_back = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.turn_back);
        turn_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.turn_forward);

        fabMain.setOnClickListener(v -> {
            if (fabStatus) {
                fabMain.startAnimation(turn_back);
                fabAdd.startAnimation(fab_close);
                fabAdd.setClickable(false);
                fabPhoto.startAnimation(fab_close);
                fabPhoto.setClickable(false);
                fabStatus = false;
            } else {
                fabMain.startAnimation(turn_forward);
                fabAdd.startAnimation(fab_open);
                fabAdd.setClickable(true);
                fabPhoto.startAnimation(fab_open);
                fabPhoto.setClickable(true);
                fabStatus = true;
            }
        });
    }
}