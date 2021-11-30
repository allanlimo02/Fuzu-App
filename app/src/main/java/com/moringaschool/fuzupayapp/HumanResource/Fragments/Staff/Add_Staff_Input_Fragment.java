package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;

        import androidx.fragment.app.Fragment;


        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
        import android.widget.VideoView;

        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.BankApploadApiClient;
        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.BankApploadUserRequest;
        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.BankApploadUserResponse;
        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.BankApploadUserService;
        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs.DocsApploadApiClient;
        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs.DocsApploadUserRequest;
        import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs.DocsApploadUserResponse;
        import com.moringaschool.fuzupayapp.R;
        import com.moringaschool.fuzupayapp.SuccessPage.Success;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class Add_Staff_Input_Fragment extends Fragment  implements View.OnClickListener{
    @BindView(R.id.saveDetails) Button mSaveDetailsButton;
    @BindView(R.id.employeeCode) EditText mEmployeeCodeEditText;
    @BindView(R.id.surname)    EditText mSurnameEditText;
    @BindView(R.id.otherName)    EditText mOtherNameEditText;
    @BindView(R.id.phoneNumber)    EditText mPhoneNumberEditText;
    @BindView(R.id.email)    EditText mEmailEditText;
    @BindView(R.id.idPassportNumber)    EditText mIdPassportNumberEditText;
    @BindView(R.id.nationality)    EditText mNationalityEditText;
    @BindView(R.id.dateOfBirth)   EditText mDateOfBirthEditText;
    @BindView(R.id.position)    EditText mPositionEditText;
    @BindView(R.id.departmentDocs)    EditText mDepartmentEditText;
    @BindView(R.id.employmentType)    EditText mEmploymentTypeEditText;
    @BindView(R.id.employmentDate)    EditText mEmploymentDateEditText;
    @BindView(R.id.grossSalary)    EditText mGrossSalaryEditText;
    @BindView(R.id.maritalStatus)    EditText mMaritalStatusEditText;
    @BindView(R.id.emergencyContact)    EditText mEmergencyContactEditText;
    @BindView(R.id.emergencyContactPhone)    EditText mEmergencyContactPhoneEditText;
    @BindView(R.id.bankName)    EditText mBankNameEditText;
    @BindView(R.id.branch)    EditText mBranchEditText;
    @BindView(R.id.accountNumber) EditText mAccountNumberEditText;
//    EditText mBankNameEditText,mBranchEditText,mAccountNumberEditText;
//    Button  mSaveDetailsButton;

    public Add_Staff_Input_Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mBankNameEditText = getView().findViewById(R.id.bankName);
//        mBranchEditText= getView().findViewById(R.id.branch);
//        mAccountNumberEditText = getView().findViewById(R.id.accountNumber);


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
            saveBank(createRequest());
            saveDocs(DocsRequest());
        }

    }
    public BankApploadUserRequest createRequest(){
        BankApploadUserRequest bankApploadUserRequest = new BankApploadUserRequest();
        bankApploadUserRequest.setBank_name(mBankNameEditText.getText().toString().trim());
        bankApploadUserRequest.setBranch_name(mBranchEditText.getText().toString().trim());
        bankApploadUserRequest.setAccount_number(mAccountNumberEditText.getText().toString().trim());


        return bankApploadUserRequest;
    }
    public void saveBank(BankApploadUserRequest bankApploadUserRequest){
        Call<BankApploadUserResponse> bankApploadUserResponseCall= BankApploadApiClient.getService().saveBankDetails(bankApploadUserRequest);
        bankApploadUserResponseCall.enqueue(new Callback<BankApploadUserResponse>() {
            @Override
            public void onResponse(Call<BankApploadUserResponse> call, Response<BankApploadUserResponse> response) {
                if(response.isSuccessful()){
                    Intent m = new Intent(getActivity(), Success.class);
                    startActivity(m);
                    ((Activity) getActivity()).overridePendingTransition(0, 0);
                }
                else{
                    Toast.makeText(getActivity(),"Docs not saved successfully please input the required inputs",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BankApploadUserResponse> call, Throwable t) {
                Toast.makeText(getActivity(),"Request failure"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public DocsApploadUserRequest DocsRequest(){
        DocsApploadUserRequest docsApploadUserRequest = new DocsApploadUserRequest();
        docsApploadUserRequest.setEmployee_id(mEmployeeCodeEditText.getText().toString().trim());
//        converting mDepartment to integer
        String Depart = mDepartmentEditText.getText().toString().trim();
        int DepartmentInt = new Integer(Depart).intValue();
        docsApploadUserRequest.setDepartment(DepartmentInt);
        docsApploadUserRequest.setSurname(mSurnameEditText.getText().toString().trim());
        docsApploadUserRequest.setOther_names(mOtherNameEditText.getText().toString().trim());
        docsApploadUserRequest.setPhone_number(mPhoneNumberEditText.getText().toString().trim());
        docsApploadUserRequest.setPosition(mPositionEditText.getText().toString().trim());
        String Etype = mEmploymentTypeEditText.getText().toString().trim();
        int ReadDep = new Integer(Etype).intValue();
        docsApploadUserRequest.setEmployment_type(ReadDep);
        return docsApploadUserRequest;
    }
    public void saveDocs(DocsApploadUserRequest docsApploadUserRequest){
        Call<DocsApploadUserResponse> docsApploadUserResponseCall= DocsApploadApiClient.getDocsApploadService().saveDocs(docsApploadUserRequest);
        docsApploadUserResponseCall.enqueue(new Callback<DocsApploadUserResponse>() {
            @Override
            public void onResponse(Call<DocsApploadUserResponse> call, Response<DocsApploadUserResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(),"saved successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(),"Not saved successfully",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DocsApploadUserResponse> call, Throwable t) {
                Toast.makeText(getActivity(),"Request failure"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }


//    private BankApploadUserRequest createRequest() {
//    }
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

        if(employeeCode.equals("")){
            mEmployeeCodeEditText.setError("Cannot be blank");
        }else
        if (surname.equals("")){
            mSurnameEditText.setError("Cannot be blank");
        }else
        if(otherName.equals("")){
            mOtherNameEditText.setError("Cannot be blank");
        }else
        if(phoneNumber.equals("")){
            mPhoneNumberEditText.setError("Cannot be blank");
        }else
        if( email.equals("")){
            mEmailEditText.setError("Cannot be blank");
        }else
        if(idPassportNumber.equals("")){
            mIdPassportNumberEditText.setError("Cannot be blank");
        }else
        if(nationality.equals("")){
            mNationalityEditText.setError("Cannot be blank");
        }else
        if(dateOfBirth .equals("")){
            mDateOfBirthEditText.setError("Cannot be blank");
        }else
        if( position .equals("")){
            mPositionEditText.setError("Cannot be blank");
        }else
        if( department .equals("")){
            mDepartmentEditText.setError("Cannot be blank");
        }else
        if(employmentType.equals("")){
            mEmploymentTypeEditText.setError("Cannot be blank");
        }else
        if(employmentDate.equals("")){
            mEmploymentDateEditText.setError("Cannot be blank");
        }else
        if(grossSalary .equals("")){
            mGrossSalaryEditText.setError("Cannot be blank");
        }else
        if(maritalStatus.equals("")){
            mMaritalStatusEditText.setError("Cannot be blank");
        }else if( emergencyContact.equals("")){
            mEmergencyContactEditText.setError("Cannot be blank");
        }else if(emergencyContactPhone.equals("")){
            mEmergencyContactPhoneEditText.setError("Cannot be blank");
        }else if( bankName.equals("")){
            mBankNameEditText.setError("Cannot be blank");
        }else if(  branch.equals("")){
            mBranchEditText.setError("Cannot be blank");
        }else if( accountNumber .equals("")){
            mAccountNumberEditText.setError("Cannot be blank");
        }

    }
}