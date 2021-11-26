package com.moringaschool.fuzupayapp.APIRequests.StaffApiResources;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models.StaffResponse;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> implements View.OnClickListener{

    private List<StaffResponse> staffResponses;
//    StaffResponse stRes;
    private Context context;
    private ClickedItem clickedItem;
    private ItemOnclickPosition itemOnclickPosition;

    public StaffAdapter() {

    }

    public void StaffAdapterFilled(List<StaffResponse> staffResponses, ItemOnclickPosition itemOnclickPosition) {
        this.staffResponses = staffResponses;
        this.itemOnclickPosition=itemOnclickPosition;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view
        context=parent.getContext();
        return new StaffAdapter.StaffViewHolder(LayoutInflater.from(context).inflate(R.layout.hr_staff_recyclerview_item,parent,false));
//                (LayoutInflater.from(context).inflate(R.layout.hr_staff_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        StaffResponse staffRes= staffResponses.get(position);

        holder.fullname.setText(staffRes.getOtherNames());
        holder.role.setText(staffRes.getPosition());
        holder.workStatus.setText(staffRes.getEmploymentType());
//        holder.workStatus.setText(staffRes.getDepartment());
    }
    public interface ClickedItem{
        void onClickItem(int position);

    }

    @Override
    public int getItemCount() {
        return staffResponses.size();
    }

    @Override
    public void onClick(View v) {


    }

    public static class StaffViewHolder extends RecyclerView.ViewHolder{
        TextView fullname,role, workStatus;

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname=itemView.findViewById(R.id.staffname);
            role=itemView.findViewById(R.id.positions);
            workStatus=itemView.findViewById(R.id.worktype);
        }
    }
}
