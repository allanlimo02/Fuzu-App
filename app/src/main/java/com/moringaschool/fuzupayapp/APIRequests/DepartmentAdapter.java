package com.moringaschool.fuzupayapp.APIRequests;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentListViewHolder> {

    private List<DepartmentResponse> departmentResponseList;
    private Context context;

    public DepartmentAdapter(){

    }
    public void setData(List<DepartmentResponse> departmentResponseList){
      this.departmentResponseList = departmentResponseList;
      notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DepartmentAdapter.DepartmentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      context = parent.getContext();
      return new DepartmentAdapter.DepartmentListViewHolder(LayoutInflater.from(context).inflate(R.layout.department_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.DepartmentListViewHolder holder, int position) {
       DepartmentResponse departmentResponse= departmentResponseList.get(position);
//

        holder.fullName.setText(departmentResponse.getOther_names().toString().trim());
        holder.department.setText(departmentResponse.getDepartment().toString().trim());
        holder.status.setText(departmentResponse.getStatus().toString().trim());


    }

    @Override
    public int getItemCount() {
        return departmentResponseList.size();
    }

    public class DepartmentListViewHolder extends RecyclerView.ViewHolder{
        TextView fullName;
        TextView department;
        TextView status;


        public DepartmentListViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.fullNameDepartmentOne);
            department = itemView.findViewById(R.id.departmentsListOne);
            status = itemView.findViewById(R.id.statusDepartmentsOne);
        }
    }
}
