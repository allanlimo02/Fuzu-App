package com.moringaschool.fuzupayapp.Finance.Expences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moringaschool.fuzupayapp.Finance.Dashboard_Finance;
import com.moringaschool.fuzupayapp.Finance.Fragments.NewrunFragment;
import com.moringaschool.fuzupayapp.Finance.Payroll2;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ARDActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    @BindView(R.id.SpinnerARD)   Spinner spinner;
    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;
    @BindView(R.id.EPending1)    Button Pending;
    @BindView(R.id.Epayments)Button payments;
    @BindView(R.id.Ecompleted)Button completed;
//    del
    @BindView(R.id.linelayout1) LinearLayout linelayout1;
    @BindView(R.id.linelayout2) LinearLayout linelayout2;
    @BindView(R.id.linelayout3) LinearLayout linelayout3;




    @BindView(R.id.frameLayoutPendings) FrameLayout Rpendings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ardactivity);
        ButterKnife.bind(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter .createFromResource(this,R.array.approve, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Pending.setOnClickListener(this);
        payments.setOnClickListener(this);
        completed.setOnClickListener(this);
        linelayout2.setOnClickListener(this);
        linelayout1.setOnClickListener(this);
        linelayout1.setOnClickListener(this);

        bottomNavigationView.setSelectedItemId(R.id.nav_expenses);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Dashboard_Finance.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_payroll:
                        startActivity(new Intent(getApplicationContext(), Payroll2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_expenses:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutPendings,new ArdaFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {

        if (view == Pending){
            startActivity(new Intent(getApplicationContext(), ARDActivity.class));
            overridePendingTransition(0,0);
            Pending.setBackgroundColor(Color.rgb(0,70,115));
            Pending.setTextColor(Color.WHITE);
            completed.setBackgroundResource(R.drawable.thin_border);
            completed.setTextColor(Color.rgb(0,70,115));
            payments.setBackgroundResource(R.drawable.thin_border);
            payments.setTextColor(Color.rgb(0,70,115));

        }
        if(view==payments){
            payments.setBackgroundColor(Color.rgb(0,70,115));
            payments.setTextColor(Color.WHITE);
            completed.setBackgroundResource(R.drawable.thin_border);
            completed.setTextColor(Color.rgb(0,70,115));
            Pending.setBackgroundResource(R.drawable.thin_border);
            Pending.setTextColor(Color.rgb(0,70,115));
        }
        if(view==completed){
            completed.setBackgroundColor(Color.rgb(0,70,115));
            completed.setTextColor(Color.WHITE);
            payments.setBackgroundResource(R.drawable.thin_border);
            payments.setTextColor(Color.rgb(0,70,115));
            Pending.setBackgroundResource(R.drawable.thin_border);
            Pending.setTextColor(Color.rgb(0,70,115));
        }

    }
}