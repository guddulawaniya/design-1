package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.design.databinding.ActivitySignUpBinding;

public class Sign_up_Activity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(binding.usernamesp.getText().toString().isEmpty()) &&
                !(binding.emailsp.getText().toString().isEmpty()) &&
                !(binding.passwordsp.getText().toString().isEmpty()))
                {
                    startActivity(new Intent(Sign_up_Activity.this,Login_Activity.class));
                }
            }
        });

        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_up_Activity.this,Login_Activity.class));
            }
        });
        binding.continuemobilenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_up_Activity.this,Continuewith_Activity.class));
            }
        });
    }
}