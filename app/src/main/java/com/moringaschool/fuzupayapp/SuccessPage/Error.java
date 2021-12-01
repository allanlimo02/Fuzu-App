package com.moringaschool.fuzupayapp.SuccessPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AddStaffMain;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.Add_Staff_Input_Fragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AllStaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.DepartmentsFragment;
import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Error extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.errorText)
    TextView errorClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        ButterKnife.bind(this);

        errorClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            if(view==errorClose){
                startActivity(new Intent(getApplicationContext(), AddStaffMain.class));
                overridePendingTransition(0,0);
            }
    }
}