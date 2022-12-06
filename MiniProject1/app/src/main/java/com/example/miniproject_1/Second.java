package com.example.miniproject_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Second extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=(EditText) findViewById(R.id.editTextTextPersonName3);
        e2=(EditText)findViewById(R.id.editTextTextPersonName4);
        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        b1=(Button) findViewById(R.id.button3);
        b2=(Button) findViewById(R.id.button4);
        p1=(ProgressBar) findViewById(R.id.progressBar2);
        firebaseAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Second.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();

                if (s1.isEmpty())
                {
                    e1.setError("Please Enter Your Email");
                    return;
                }
                else
                {
                    if (s2.isEmpty())
                    {
                        e2.setError("Please Enter Your Passward");
                        return;
                    }
                    else
                    {
                        p1.setVisibility(View.VISIBLE);
                        firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(Second.this, "Congratulation!! YOU ARE REGISTERED", Toast.LENGTH_SHORT).show();
                                    p1.setVisibility(View.INVISIBLE);
                                    Intent j=new Intent(Second.this, MainActivity.class);
                                    startActivity(j);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(Second.this, "Sorry plz provide valid email & password", Toast.LENGTH_SHORT).show();
                                    p1.setVisibility(View.INVISIBLE);
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}