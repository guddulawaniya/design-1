package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.example.design.databinding.ActivityContinuewithBinding;

public class Continuewith_Activity extends AppCompatActivity {

    ActivityContinuewithBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContinuewithBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.mobilenumber.getText().toString().isEmpty())
                {
                    otp_verify_fragment otp_verify_fragment = new otp_verify_fragment();
                    otp_verify_fragment.show(getSupportFragmentManager(),"otp verify");
                }
            }
        });
    }
}