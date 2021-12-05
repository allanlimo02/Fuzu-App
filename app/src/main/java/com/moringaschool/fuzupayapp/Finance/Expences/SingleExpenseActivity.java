package com.moringaschool.fuzupayapp.Finance.Expences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.APIRequests.ExpensesResponse;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
public class SingleExpenseActivity extends AppCompatActivity {
    @BindView(R.id.expenseIds) TextView expenseId;
    @BindView(R.id.staffname) TextView staffname;
    @BindView(R.id.merchantname) TextView merchantname;
    @BindView(R.id.TimeClaimed) TextView TimeClaimed;
    @BindView(R.id.merchanttxt) TextView merchanttxt;

    private ExpensesResponse expensesResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_expense);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            expensesResponse = (ExpensesResponse) intent.getSerializableExtra("data");
//            expenseId.setText(expensesResponse.getId());
            staffname.setText(expensesResponse.getName());
            merchantname.setText(expensesResponse.getName());
            TimeClaimed.setText(expensesResponse.getDate_processed());
            merchanttxt.setText(expensesResponse.getName());
        }

    }
}