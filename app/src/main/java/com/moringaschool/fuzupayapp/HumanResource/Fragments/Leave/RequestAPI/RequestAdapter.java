package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestAdapterVH> {

    private List<RequestResponse>  requestREspondlist;
    private OnItemClickListener mListener;
    private Context context;

    public RequestAdapter() {
    }
    public  interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
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

        String leaveTitleRes = requestResponse.getLeaveType();
        String date2 = requestResponse.getLeaveDateFrom();
        String duration = requestResponse.getLeaveDateTo();
        String Username3 = requestResponse.getEmployee();

        holder.leaveTitle.setText(leaveTitleRes);
        holder.startdate.setText(date2);
        holder.staffname.setText(Username3);
        holder.duration.setText("Duration: "+0+" Days");

    }

    @Override
    public int getItemCount() {
        return requestREspondlist.size();
    }

    public class RequestAdapterVH extends RecyclerView.ViewHolder {
        TextView leaveTitle;
        TextView startdate;
        TextView duration;
        TextView staffname;
        ImageView iconTick,xIcon;
        public RequestAdapterVH(@NonNull View itemView) {
            super(itemView);
            leaveTitle = itemView.findViewById(R.id.leaveTitle);
            startdate = itemView.findViewById(R.id.date2);
            duration= itemView.findViewById(R.id.duration);
            staffname = itemView.findViewById(R.id.Username3);
            iconTick = itemView.findViewById(R.id.iconTick);
            xIcon = itemView.findViewById(R.id.xIcon);
            iconTick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}
