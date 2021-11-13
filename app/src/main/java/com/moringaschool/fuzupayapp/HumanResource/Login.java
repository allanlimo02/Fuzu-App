package com.moringaschool.fuzupayapp.HumanResource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Login extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findLoginButton) Button mFindLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.forgetPasswordTextView) TextView mForgetPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mFindLoginButton.setOnClickListener(this);
        mForgetPasswordTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        initialize the username and password

        String userEmail = mEmailEditText.getText().toString().trim();
        String userPassword = mPasswordEditText.getText().toString().trim();

//        logic
        if(v==mFindLoginButton){

            if(userEmail.equals("")){
                mEmailEditText.setError("Email cannot be blank");
            }
            else if(userPassword.equals("")){
                mPasswordEditText.setError("password cannot be blank");
            }
            else{
                Intent intent = new Intent(Login.this, DashboardActivity.class);
                startActivity(intent);
            }
        }

    }
}