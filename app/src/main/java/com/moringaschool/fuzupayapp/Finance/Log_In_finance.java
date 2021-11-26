package com.moringaschool.fuzupayapp.Finance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.R;
import com.moringaschool.fuzupayapp.loginAPI.loginClient;
import com.moringaschool.fuzupayapp.loginAPI.loginRequest;
import com.moringaschool.fuzupayapp.loginAPI.models.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_In_finance extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.findLoginButton)Button mFindLoginButton;
@BindView(R.id.emailEditText) EditText mEmailEditText;
@BindView(R.id.pasw) TextInputEditText password;
@BindView(R.id.passwordEditText) TextInputLayout mPasswordEditText;
@BindView(R.id.forgetPasswordTextView)TextView mForgetPasswordTextView;
@BindView(R.id.progressBar) ProgressBar progressBar;
@BindView(R.id.textView5) TextView textView5;
@BindView(R.id.fillform) TextView fillform;

@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mFindLoginButton.setOnClickListener(this);
        mForgetPasswordTextView.setOnClickListener(this);
        fillform.setOnClickListener(this);


        }

@Override
public void onClick(View v) {
//        initialize the username and password
        if(v==mFindLoginButton){
                if(TextUtils.isEmpty(mEmailEditText.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                        String message = "Cannot submit empty Fields";

                        Toast.makeText(Log_In_finance.this,message,Toast.LENGTH_SHORT).show();
                }
                else {
                        showProgressbar();
                        loginRequest lOginRequest = new loginRequest();
                        lOginRequest.setEmail(mEmailEditText.getText().toString().trim());
                        lOginRequest.setPassword(password.getText().toString().trim());
                        loginUser(lOginRequest);
                }

        }

        if(v==fillform){
                mEmailEditText.setText("hr@fuzupay.com");
                password.setText("123456");
        }

        }
        }
public void loginUser(loginRequest lOginRequest){
        Call<LoginResponse> loginResponseCall = loginClient.getService().loginUser(lOginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {

                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        hideProgressbar();
                        if(response.isSuccessful()){

                                LoginResponse loginResponse = response.body();
                                if(loginResponse.getUser().getRole().getId().toString().trim().equals("2")){
                                startActivity(new Intent(Log_In_finance.this, DashboardActivity.class).putExtra("data",loginResponse));
                                finish();
                                }
                                if(loginResponse.getUser().getRole().getId().toString().trim().equals("4")){

                                        startActivity(new Intent(Log_In_finance.this, Dashboard_Finance.class).putExtra("data",loginResponse));
                                        finish();
                                }
                        }else
                        {
                                String message = "Check Your email And Password ..";
                                Toast.makeText(Log_In_finance.this,message,Toast.LENGTH_SHORT).show();
                        }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                        String message = t.getLocalizedMessage();
                        Toast.makeText(Log_In_finance.this,message,Toast.LENGTH_SHORT).show();
                }
        });
}
        private void showProgressbar(){
        progressBar.setVisibility(View.VISIBLE);
        textView5.setVisibility(View.VISIBLE);

        }
        private void hideProgressbar(){
                progressBar.setVisibility(View.GONE);
                textView5.setVisibility(View.GONE);

        }


}