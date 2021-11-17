package com.moringaschool.fuzupayapp.FragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.SIngleStaffActivity;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.SingleStaffFragment;
import com.moringaschool.fuzupayapp.R;

public class DepartmentAdapter  extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {

    private String nameArray[], roleArray[], jobTypeArray[];
    Context context;

    public DepartmentAdapter(Context context, String[] name, String[] position, String[] workType) {
        this.context =context;
       this.nameArray = name;
        this.roleArray = position;
        this.jobTypeArray = workType;
    }

    @NonNull
    @Override
    public DepartmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater1=LayoutInflater.from(context);
        View view=inflater1.inflate(R.layout.staff_rec_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.ViewHolder holder, int position) {
        holder.name.setText(nameArray[position]);
        holder.position.setText(roleArray[position]);
        holder.employmentType.setText(jobTypeArray[position]);

    }
    @Override
    public int getItemCount() {
        return nameArray.length;
    }

    //second class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name,position,employmentType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.staffname);
            position=itemView.findViewById(R.id.position);
            employmentType=itemView.findViewById(R.id.workType);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(context, SIngleStaffActivity.class);
            String finalname=nameArray[itemPosition];
            String finalposition=roleArray[itemPosition];
            String finalemployment=jobTypeArray[itemPosition];
            intent.putExtra("name",finalname);
            intent.putExtra("position",finalposition);
            intent.putExtra("jobtype",finalemployment);
            context.startActivity(intent);


        }
    }
}
