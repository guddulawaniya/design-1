package com.example.design;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.design.databinding.FragmentOtpVerifyFragmentBinding;


public class otp_verify_fragment extends DialogFragment {


    FragmentOtpVerifyFragmentBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOtpVerifyFragmentBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment


        binding.verifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((binding.num1.getText().toString().trim().length()==1) &&
                        (binding.num2.getText().toString().trim().length()==1) &&
                        (binding.num3.getText().toString().trim().length()==1)  &&
                        (binding.num4.getText().toString().trim().length()==1) &&
                        (binding.num5.getText().toString().trim().length()==1) &&
                        (binding.num6.getText().toString().trim().length()==1))
                {
                    Toast.makeText(getContext(), "OTP Verify ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),MainActivity.class);
                    startActivity(intent);

                }

            }
        });

        return binding.getRoot();
    }


    private  void moveotpnumber()
    {
        binding.num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty())
                {
                    binding.num2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty())
                {
                    binding.num1.requestFocus();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty())
                {
                    binding.num3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty())
                {
                    binding.num2.requestFocus();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty())
                {
                    binding.num4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.num4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty())
                {
                    binding.num3.requestFocus();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty())
                {
                    binding.num5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.num5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

                if (!s.toString().trim().isEmpty())
                {
                    binding.num4.requestFocus();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty())
                {
                    binding.num6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.num6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

                if (!s.toString().trim().isEmpty())
                {
                    binding.num5.requestFocus();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}