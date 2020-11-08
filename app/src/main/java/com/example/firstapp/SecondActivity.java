package com.example.firstapp;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

     private TextView textView;
     private ImageView imageView;
     private TextView textBodyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getBundleExtra("keyIntent");
        Data model = (Data) bundle.getSerializable("keyModel");
        textView = findViewById(R.id.secondTitle);
        textBodyView = findViewById(R.id.bodySecondInfo);
        textBodyView.setMovementMethod(new ScrollingMovementMethod());
        imageView = findViewById(R.id.imageSecondView);
       textView.setText(model.getTitle());
        textBodyView.setText(model.getBodyInfo());
        Glide.with(this).load(model.getImage()).into(imageView);


    }
}