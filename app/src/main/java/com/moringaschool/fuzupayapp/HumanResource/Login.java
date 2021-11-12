package com.moringaschool.fuzupayapp.HumanResource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.MainActivity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findLoginButton)
    Button mFindLoginButton;
    @BindView(R.id.emailEditText)
    EditText mEmailEditText;
    @BindView(R.id.passwordEditText)
    EditText mPasswordEditText;
    @BindView(R.id.forgetPasswordTextView)
    TextView mForgetPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFindLoginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mFindLoginButton) {
            String location = mFindLoginButton.getText().toString();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            loginWithPassword();
        }
    }

    private void loginWithPassword() {
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        if (email.equals("")) {
            mEmailEditText.setError("Please enter your email");
            return;
        }
        if (password.equals("")) {
            mPasswordEditText.setError("Password cannot be blank");
            return;
        }

    }
}
