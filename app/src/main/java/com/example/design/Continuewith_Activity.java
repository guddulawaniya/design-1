package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.design.databinding.ActivityContinuewithBinding;

public class Continuewith_Activity extends AppCompatActivity {

    ActivityContinuewithBinding binding;
    EditText num1;
    EditText num2;
    EditText num3;
    EditText num4;
    EditText num5;
    EditText num6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContinuewithBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Dialog dialog = new otp_verify_fragment(Continuewith_Activity.this);

        num1 = dialog.findViewById(R.id.num1);
        num2 = dialog.findViewById(R.id.num2);
        num3 = dialog.findViewById(R.id.num3);
        num4 = dialog.findViewById(R.id.num4);
        num5 = dialog.findViewById(R.id.num5);
        num6 = dialog.findViewById(R.id.num6);
        binding.sendotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((binding.mobilenumber.getText().toString().trim().length() == 10)) {

                    dialog.setContentView(R.layout.fragment_otp_verify_fragment);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.setCancelable(false);
                    dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                    dialog.show();


                    Button verifyotp = dialog.findViewById(R.id.verifyotp);
                    verifyotp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(!(num1.getText().toString().trim().isEmpty()) &&
                                    !(num2.getText().toString().trim().isEmpty()) &&
                                    !(num3.getText().toString().trim().isEmpty())&&
                                    !(num4.getText().toString().trim().isEmpty()) &&
                                    !(num5.getText().toString().trim().isEmpty()) &&
                                    !(num6.getText().toString().trim().isEmpty()))
                            {
                                dialog.dismiss();
                                Intent intent = new Intent(Continuewith_Activity.this,MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(Continuewith_Activity.this, "OTP Verify ", Toast.LENGTH_SHORT).show();

                            }
                            else
                                Toast.makeText(Continuewith_Activity.this, "Invalid OTP", Toast.LENGTH_SHORT).show();




                        }
                    });

                }
                else
                {
                    binding.mobilenumberlayout.setError("Invalid Number");
                    binding.mobilenumber.requestFocus();

                }
            }
        });
    }

}
