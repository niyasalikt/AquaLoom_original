package com.example.niyasali.nav;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_homepage);
        /*TextView textView=(TextView)findViewById(R.id.textview1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(homepage.this, "clicked login", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(homepage.this,Main3Activity.class);
                startActivity(intent);

            }
        });*/

        ImageButton button=(ImageButton)findViewById(R.id.btnReg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(homepage.this, "clciked register", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(homepage.this,register.class);
                startActivity(intent);


            }
        });
        /*if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        {

        }*/
    }
}
