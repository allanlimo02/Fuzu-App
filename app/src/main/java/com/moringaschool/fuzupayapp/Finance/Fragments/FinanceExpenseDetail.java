package com.moringaschool.fuzupayapp.Finance.Fragments;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.APIRequests.ExpensesResponse;
import com.moringaschool.fuzupayapp.R;

import org.parceler.Parcels;

public class FinanceExpenseDetail extends Fragment {
    private ExpensesResponse expensesResponse;

    TextView expenseId,staffname,merchantname,TimeClaimed,merchanttxt;

    public static FinanceExpenseDetail newInstance( ExpensesResponse expensesResponse) {
        FinanceExpenseDetail financeExpenseDetail = new FinanceExpenseDetail();
        Bundle args = new Bundle();
        args.putParcelable("data", Parcels.wrap(expensesResponse));
        financeExpenseDetail.setArguments(args);
        return financeExpenseDetail;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        expensesResponse = Parcels.unwrap(getArguments().getParcelable("data"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.finance_expense_detail_fragment, container, false);
        expenseId = view.findViewById(R.id.expenseId);
        staffname = view.findViewById(R.id.staffname);
        merchantname = view.findViewById(R.id.merchantname);
        TimeClaimed = view.findViewById(R.id.TimeClaimed);
        merchanttxt = view.findViewById(R.id.merchanttxt);

        expenseId.setText(expensesResponse.getId());
        staffname.setText(expensesResponse.getName());
        merchantname.setText(expensesResponse.getName());
        TimeClaimed.setText(expensesResponse.getDate_processed());
        merchantname.setText(expensesResponse.getName());

//        Intent intent=getIntent();


        return  view;
    }
}
