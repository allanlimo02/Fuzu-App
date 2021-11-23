package com.moringaschool.fuzupayapp.Finance.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.Finance.Expences.Finance_Approve_Activity;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinanceExpenseDetailsActivity extends AppCompatActivity implements View.OnClickListener{
@BindView(R.id.backtext)
    TextView backtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_expense_details);
        ButterKnife.bind(this);

        backtext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==backtext){
            startActivity(new Intent(getApplicationContext(), Finance_Approve_Activity.class));
            overridePendingTransition(0,0);
        }
    }
}