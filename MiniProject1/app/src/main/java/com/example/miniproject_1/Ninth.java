package com.example.miniproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ninth extends AppCompatActivity {
    Button b1,b2,b3;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth);
        b1=(Button)findViewById(R.id.button30);
        b2=(Button)findViewById(R.id.button31);
        b3=(Button)findViewById(R.id.button32);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ninth.this, Third.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    String cameraid=cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraid,true);
                }
                catch (CameraAccessException e){

                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    String cameraid=cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraid,false);
                }
                catch (CameraAccessException e){

                }
            }
        });
    }
}