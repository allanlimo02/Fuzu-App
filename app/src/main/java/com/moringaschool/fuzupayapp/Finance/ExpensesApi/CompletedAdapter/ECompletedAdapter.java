package com.moringaschool.fuzupayapp.Finance.ExpensesApi.CompletedAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.Finance.ExpensesApi.EcompletedResponse;
import com.moringaschool.fuzupayapp.HumanResource.onLeaveResponse;
import com.moringaschool.fuzupayapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class ECompletedAdapter extends RecyclerView.Adapter<ECompletedAdapter.ECompletedViewHolder> {
    public List<EcompletedResponse> ecompletedResponseList;
    public Context context;

    public ECompletedAdapter() {
    }

    public  void setData(List<EcompletedResponse> ecompletedResponseList) {
        this.ecompletedResponseList = ecompletedResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ECompletedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ECompletedViewHolder(LayoutInflater.from(context).inflate(R.layout.finance_staff_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ECompletedViewHolder holder, int position) {
        EcompletedResponse ecompletedResponse = ecompletedResponseList.get(position);
        holder.fullName.setText(ecompletedResponse.getName().toString().trim());
        holder.position.setText(ecompletedResponse.getName().toString().trim());
        holder.status.setText(ecompletedResponse.getStatus().toString().trim());

    }

    @Override
    public int getItemCount() {
        return ecompletedResponseList.size();
    }

    public class ECompletedViewHolder extends RecyclerView.ViewHolder {
        TextView fullName;
        TextView position;
        TextView status;
        public ECompletedViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.staffname);
            position = itemView.findViewById(R.id.position);
            status = itemView.findViewById(R.id.statuses);
        }
    }
}
