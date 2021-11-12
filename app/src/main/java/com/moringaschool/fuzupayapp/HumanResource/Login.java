package com.moringaschool.fuzupayapp.HumanResource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;

public class Login extends AppCompatActivity {
    @BindView(R.id.findLoginButton) Button mFindLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.forgetPasswordTextView) TextView mForgetPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}