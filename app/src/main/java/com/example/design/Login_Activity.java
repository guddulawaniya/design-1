package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.design.databinding.ActivityLoginBinding;

public class Login_Activity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,Sign_up_Activity.class));
            }
        });
        binding.forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,Continuewith_Activity.class));
            }
        });
        binding.Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(binding.emailln.getText().toString().isEmpty()) &&
                !(binding.loginpass.getText().toString().isEmpty()))
                {
                    startActivity(new Intent(Login_Activity.this,MainActivity.class));
                }
                else if (binding.emailln.getText().toString().isEmpty())
                {
                    binding.emailln.setError("Enter the Email id");
                    binding.emailln.requestFocus();
                }
                else
                {
                    binding.loginpass.setError("Enter the Password");
                    binding.loginpass.requestFocus();

                }
            }
        });
    }
}