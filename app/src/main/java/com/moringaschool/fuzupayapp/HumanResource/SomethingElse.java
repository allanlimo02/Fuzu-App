package com.moringaschool.fuzupayapp.HumanResource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SomethingElse extends AppCompatActivity {
    private RadioButton mRadioButton;
//    @BindView(R.id.addStaffButton)
//    Button mAddStaffButton;

   // @BindView(R.id.radioButton) RadioButton mRadioButton;
 //   @BindView(R.id.radio_two) RadioButton mRadioButton;
    @BindView(R.id.radioGroup) RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mAddStaffButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.activity_staff);
//
//                ButterKnife.bind(this);
//
//                int radioId = mRadioGroup.getCheckedRadioButtonId();
//                mRadioButton = findViewById(radioId);
//            }
//        });





    }
    public void checkButton(View v){
        int radioId = mRadioGroup.getCheckedRadioButtonId();
        mRadioButton = findViewById(radioId);

        Toast.makeText(this,"selected radio button"+mRadioButton.getText(),Toast.LENGTH_SHORT).show();

    }
}