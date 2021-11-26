package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestAdapterVH> {

    private List<RequestResponse>  requestREspondlist;
    private Context context;

    public RequestAdapter() {
    }

    public void setData(List<RequestResponse>  requestREspondlist) {
        this.requestREspondlist = requestREspondlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RequestAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        return new RequestAdapter.RequestAdapterVH(LayoutInflater.from(context).inflate(R.layout.leave_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapterVH holder, int position) {
        RequestResponse requestResponse = requestREspondlist.get(position);

        String leaveTitle = requestResponse.getPosition();
        String date2 = requestResponse.getLeave_date_from();
        String duration = requestResponse.getLeave_date_to();
        String Username3 = requestResponse.getEmployee();
        holder.date2.setText(date2);
        holder.leaveTitle.setText(leaveTitle);
        holder.duration.setText(duration);
        holder.Username3.setText(Username3);

    }

    @Override
    public int getItemCount() {
        return requestREspondlist.size();
    }

    public class RequestAdapterVH extends RecyclerView.ViewHolder {
        TextView leaveTitle;
        TextView date2;
        TextView duration;
        TextView Username3;
        public RequestAdapterVH(@NonNull View itemView) {
            super(itemView);
            leaveTitle = itemView.findViewById(R.id.leaveTitle);
            date2 = itemView.findViewById(R.id.date2);
            duration= itemView.findViewById(R.id.duration);
            Username3= itemView.findViewById(R.id.Username3);

        }
    }
}
