package com.moringaschool.fuzupayapp.HumanResource.LeaveApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class onLeaveAdapter extends RecyclerView.Adapter<onLeaveAdapter.OnLeaveAdapterViewHolder> {

    private List<onLeaveResponse> onLeaveResponseList;
    private Context context;

    public onLeaveAdapter() {
    }
    public  void setData(List<onLeaveResponse> onLeaveResponseList) {
        this.onLeaveResponseList = onLeaveResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OnLeaveAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new OnLeaveAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.on_leave_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OnLeaveAdapterViewHolder holder, int position) {
        onLeaveResponse onLeaveResponse = onLeaveResponseList.get(position);
        holder.leaveTitle.setText(onLeaveResponse.getLeave_type().toString().trim());
       holder.date.setText(onLeaveResponse.getLeave_date_to().toString().trim());
       holder.duration.setText(onLeaveResponse.getLeave_date_to().toString().trim());
       holder.name.setText(onLeaveResponse.getEmployee().toString().trim());

    }

    @Override
    public int getItemCount() {
        return onLeaveResponseList.size();
    }

    public class OnLeaveAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView leaveTitle;
        TextView name;
        TextView duration;
        TextView date;
        public OnLeaveAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            leaveTitle = itemView.findViewById(R.id.leaveTitle);
            name = itemView.findViewById(R.id.name);
            duration = itemView.findViewById(R.id.duration);
            date = itemView.findViewById(R.id.date);
        }
    }
}
