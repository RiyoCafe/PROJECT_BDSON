package com.example.watcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class HomePageActivity extends AppCompatActivity {
    private Button button;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        button=findViewById(R.id.logout_homepage);
        mAuth=FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                //Paper.book().destroy();
                Intent intent=new Intent(HomePageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}