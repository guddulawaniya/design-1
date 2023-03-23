package com.example.design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.design.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {

    ActivityLoginBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        progressDialog = new ProgressDialog(Login_Activity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login your account");
        mAuth = FirebaseAuth.getInstance();
        binding.createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,Sign_up_Activity.class));
                finish();
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
                    progressDialog.show();
                    mAuth.signInWithEmailAndPassword(binding.emailln.getText().toString(), binding.loginpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else if (binding.emailln.getText().toString().isEmpty())
                {

                    binding.logintablayout.setError("Enter Valid Id");
                    binding.emailln.requestFocus();
                }
                else
                {
                    binding.passlayoutlg.setError("Enter Valid Password");
                    binding.loginpass.requestFocus();

                }
            }
        });

        if (mAuth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(Login_Activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }



}