package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.fuzupayapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_Staff_Upload_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_Staff_Upload_Fragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.chooseFile) TextView chooseFile;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public Add_Staff_Upload_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Add_Staff_Upload_Fragment newInstance(String param1, String param2) {
        Add_Staff_Upload_Fragment fragment = new Add_Staff_Upload_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  uploadButton=(Button) uploadButton.findViewById(R.id.uploadButton);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add__staff__upload_, container, false);
        ButterKnife.bind(this,view);
        chooseFile.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v ==  chooseFile){

            Intent intent = new  Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 2);







        }
    }
}