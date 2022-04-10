package com.example.myproject.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myproject.R;

public class CitizenSettingsActivity extends AppCompatActivity {

    TextView user_name, user_number, user_pass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_settings);
        getSupportActionBar().setTitle("Missing Child");

        user_name = findViewById(R.id.profile_name);
        user_number = findViewById(R.id.profile_number);
        user_pass = findViewById(R.id.profile_password);
        button = findViewById(R.id.c_change_pass_btn);


        // View Profile
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String number = sharedPreferences.getString("number", "");
        String pass = sharedPreferences.getString("password", "");

        user_name.setText(name);
        user_number.setText(number);
        user_pass.setText(pass);

        //OnCLick
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CitizenSettingsActivity.this, CitizenChangePassActivity.class);
                startActivity(intent);
            }
        });

    }
}
