package com.example.design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.design.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up_Activity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    FirebaseDatabase database;
    FirebaseAuth mAuth;
    ProgressDialog Loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        Loading = new ProgressDialog(Sign_up_Activity.this);
        Loading.setTitle("Creating Account");
        Loading.setMessage("Please Wait While Creating Account");

        getSupportActionBar().hide();

        binding.createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(binding.usernamesp.getText().toString().isEmpty()) &&(binding.usernamesp.getText().toString().length()<20) &&
                !(binding.emailsp.getText().toString().isEmpty()) &&
                !(binding.passwordsp.getText().toString().isEmpty() && (binding.passwordsp.getText().toString().length()<15)))
                {

                    Loading.show();
                    mAuth.createUserWithEmailAndPassword(binding.emailsp.getText().toString(),
                            binding.passwordsp.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override

                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Loading.dismiss();
                            if (task.isSuccessful()) {
                                module user = new module(binding.usernamesp.getText().toString(), binding.emailsp.getText().toString(),
                                        binding.passwordsp.getText().toString());

                                String id = task.getResult().getUser().getUid();

                                database.getReference().child("Users").child(id).setValue(user);
                                Toast.makeText(Sign_up_Activity.this, "User Created successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Sign_up_Activity.this, Login_Activity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Sign_up_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else if (binding.usernamesp.getText().toString().isEmpty())
                {
                    binding.usertextlayout.setError("Invalid Username");
                    binding.usernamesp.requestFocus();
                } else if (binding.emailsp.getText().toString().isEmpty()) {
                    binding.emaillayoutsp.setError("Invalid Email");
                    binding.emailsp.requestFocus();
                }
                else {
                    binding.passlayoutsp.setError("Invalid Password");
                    binding.passwordsp.requestFocus();
                }
            }
        });

        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_up_Activity.this,Login_Activity.class));
                finish();
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

class module
{
    String username,email,password;

    public module(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}