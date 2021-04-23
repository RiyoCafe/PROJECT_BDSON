package com.example.watcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmPassword extends AppCompatActivity {

    private EditText editText1,editText2;
    private Button button;
    private  DatabaseReference ref;
    private FirebaseAuth mAuth;
    private String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmpassword);

        findAllViewId();
        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        ref=FirebaseDatabase.getInstance().getReference().child("Users");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewPassword();
            }
        });
    }

    private void saveNewPassword() {

        String pass=editText1.getText().toString();
        String confirm_pass=editText2.getText().toString();

        if(pass.isEmpty()){
            editText1.setError("Please enter your new password");
            editText1.requestFocus();
        }
        else if(confirm_pass.isEmpty()){
            editText2.setError("Please confirm  your new password");
            editText2.requestFocus();
        }
        else{
            if(pass.equals(confirm_pass)){

                ref.child(currentUserID).child("password").setValue(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ConfirmPassword.this,"Your password changed successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(ConfirmPassword.this,MainActivity.class);
                            //intent.putExtra("num",)
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(ConfirmPassword.this,task.getException().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }else{
                Toast.makeText(ConfirmPassword.this,"Your password did not match",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void findAllViewId() {
        editText1=findViewById(R.id.pass_confirm_pass_activity);
        editText2=findViewById(R.id.confirm_pass_confirm_pass_activity);
        button=findViewById(R.id.submit_confirm_passs_activity);
    }
}