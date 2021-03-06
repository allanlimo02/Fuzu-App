package com.moringaschool.fuzupayapp.HumanResource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Login extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findLoginButton) Button mFindLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) TextInputLayout mPasswordEditText;
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
        TextInputEditText userPassword = new TextInputEditText(mPasswordEditText.getContext());
//        Editable userPassword = mPasswordEditText.getEditText().getText();

//        logic
        if(v==mFindLoginButton){
            Intent intent = new Intent(Login.this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

//            if(userEmail.equals("")){
//                mEmailEditText.setError("Email cannot be blank");
//            }
//            else if(userPassword.equals("")){
//                mPasswordEditText.setError("password cannot be blank");
//            }
//            else{
//                Intent intent = new Intent(Login.this, DashboardActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//            }

        }

    }
}
