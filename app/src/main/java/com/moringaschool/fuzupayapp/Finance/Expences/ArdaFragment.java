package com.moringaschool.fuzupayapp.Finance.Expences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentAdapter;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentClient;
import com.moringaschool.fuzupayapp.APIRequests.DepartmentResponse;
import com.moringaschool.fuzupayapp.APIRequests.ExpenseApiClient;
import com.moringaschool.fuzupayapp.APIRequests.ExpensesAdapter;
import com.moringaschool.fuzupayapp.APIRequests.ExpensesResponse;
import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceExpenseDetail;
import com.moringaschool.fuzupayapp.Finance.Fragments.FinanceExpenseDetailsActivity;
import com.moringaschool.fuzupayapp.Finance.Pazyroll.financePayroll_1;
import com.moringaschool.fuzupayapp.Finance.SingleStaffFragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.DepartmentsFragment;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArdaFragment extends Fragment implements View.OnClickListener , ExpensesAdapter.ClickedItem {
    @BindView(R.id.SpinnerARD)  Spinner spinner;
    @BindView(R.id.linelayout1)
    LinearLayout linelayout1;
//    @BindView(R.id.linelayout2)
//    LinearLayout linelayout2;
//    @BindView(R.id.linelayout3)
//    LinearLayout linelayout3;
//    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;
    ExpensesAdapter expensesAdapter;

    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.finance_arda_fragment, container, false);
        recyclerView = view.findViewById(R.id.frameLayoutPendingsOne);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));


        expensesAdapter = new ExpensesAdapter(this::ClickedUser);
        getExpenses();
        return view;


     //   ButterKnife.bind(this,view);
//
//        linelayout2.setOnClickListener(this);
//        linelayout3.setOnClickListener(this);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter .createFromResource(context,R.array.approves, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(spinner);


    }

    @Override
    public void onClick(View view) {

    }
    private void getExpenses() {

        Call<List<ExpensesResponse>> expensesList = ExpenseApiClient.getExpensesService().getExpenses();
        expensesList.enqueue(new Callback<List<ExpensesResponse>>() {
            @Override
            public void onResponse(Call<List<ExpensesResponse>> call, Response<List<ExpensesResponse>> response) {
                if (response.isSuccessful()) {
                    List<ExpensesResponse> expensesResponse = response.body();
                   expensesAdapter.setData(expensesResponse);
                    recyclerView.setAdapter(expensesAdapter);
                    // Log.e("successful",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<ExpensesResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void ClickedUser(ExpensesResponse expensesResponse) {
        Log.d("failure",expensesResponse.getAmount().toString());
        startActivity(new Intent(getActivity(), SingleExpenseActivity.class).putExtra("data",expensesResponse));
//        overridePendingTransition(0,0);
    }
}