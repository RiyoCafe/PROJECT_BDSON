package com.example.watcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation toanim,bottomanim;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        toanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        imageView=findViewById(R.id.imageView4);
        textView=findViewById(R.id.textView3);
        imageView.setAnimation(toanim);
        textView.setAnimation(bottomanim);



    }
}