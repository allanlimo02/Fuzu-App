//package com.moringaschool.fuzupayapp.HumanResource.HrAdapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities.EmployeesDetails_Pojo;
//import com.moringaschool.fuzupayapp.R;
//
//import java.util.List;
//
//public class ListAdapter extends ArrayAdapter<EmployeesDetails_Pojo> {
//    private List<EmployeesDetails_Pojo> employeesDetails_pojoList;
//    private Context context;
//
//    public ListAdapter(Context context,List<EmployeesDetails_Pojo> employeesDetails_pojoList) {
////        super(employeesDetails_pojoList, android.R.layout.simple_list_item_1,context);
//        this.employeesDetails_pojoList = employeesDetails_pojoList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        View view = layoutInflater.inflate(R.layout.activity_all_staff,parent,false);
//        EmployeesDetails_Pojo employeesDetails_pojo = this.employeesDetails_pojoList.get(position);
//
//    }
//}
