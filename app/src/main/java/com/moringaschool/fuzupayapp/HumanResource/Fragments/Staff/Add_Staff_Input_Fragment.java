package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

        import android.content.Context;
        import android.os.Bundle;

        import androidx.fragment.app.Fragment;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.moringaschool.fuzupayapp.R;

        import butterknife.BindView;
        import butterknife.ButterKnife;

public class Add_Staff_Input_Fragment extends Fragment  implements View.OnClickListener{
    @BindView(R.id.saveDetails)
    Button mSaveDetailsButton;
    @BindView(R.id.employeeCode)
    EditText mEmployeeCodeEditText;
    @BindView(R.id.surname)    EditText mSurnameEditText;
    @BindView(R.id.otherName)    EditText mOtherNameEditText;
    @BindView(R.id.phoneNumber)    EditText mPhoneNumberEditText;
    @BindView(R.id.email)    EditText mEmailEditText;
    @BindView(R.id.idPassportNumber)    EditText mIdPassportNumberEditText;
    @BindView(R.id.nationality)    EditText mNationalityEditText;
    @BindView(R.id.dateOfBirth)   EditText mDateOfBirthEditText;
    @BindView(R.id.position)    EditText mPositionEditText;
    @BindView(R.id.department)    EditText mDepartmentEditText;
    @BindView(R.id.employmentType)    EditText mEmploymentTypeEditText;
    @BindView(R.id.employmentDate)    EditText mEmploymentDateEditText;
    @BindView(R.id.grossSalary)    EditText mGrossSalaryEditText;
    @BindView(R.id.maritalStatus)    EditText mMaritalStatusEditText;
    @BindView(R.id.emergencyContact)    EditText mEmergencyContactEditText;
    @BindView(R.id.emergencyContactPhone)    EditText mEmergencyContactPhoneEditText;
    @BindView(R.id.bankName)    EditText mBankNameEditText;
    @BindView(R.id.branch)    EditText mBranchEditText;
    @BindView(R.id.accountNumber) EditText mAccountNumberEditText;

    public Add_Staff_Input_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add__staff__input_, container, false);
        ButterKnife.bind(this,view);

        mSaveDetailsButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==mSaveDetailsButton){
            validator();
        }

    }
    public void validator(){
        String employeeCode = mEmployeeCodeEditText.getText().toString().trim();
        String surname = mSurnameEditText.getText().toString().trim();
        String otherName = mOtherNameEditText.getText().toString().trim();
        String phoneNumber = mPhoneNumberEditText.getText().toString().trim();
        String email = mEmailEditText.getText().toString().trim();
        String idPassportNumber = mIdPassportNumberEditText.getText().toString().trim();
        String nationality = mNationalityEditText.getText().toString().trim();
        String dateOfBirth = mDateOfBirthEditText.getText().toString().trim();
        String position = mPositionEditText.getText().toString().trim();
        String department = mDepartmentEditText.getText().toString().trim();
        String employmentType = mEmploymentTypeEditText.getText().toString().trim();
        String employmentDate = mEmploymentDateEditText.getText().toString().trim();
        String grossSalary = mGrossSalaryEditText.getText().toString().trim();
        String maritalStatus = mMaritalStatusEditText.getText().toString().trim();
        String emergencyContact = mEmergencyContactEditText.getText().toString().trim();
        String emergencyContactPhone = mEmergencyContactPhoneEditText.getText().toString().trim();
        String bankName = mBankNameEditText.getText().toString().trim();
        String branch = mBranchEditText.getText().toString().trim();
        String accountNumber = mAccountNumberEditText.getText().toString().trim();


    }
}