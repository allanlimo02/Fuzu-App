package com.moringaschool.fuzupayapp.APIRequests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class PayrollAdapter extends RecyclerView.Adapter<PayrollAdapter.PayrollAdapterViewHolder> {

    private List<PayrollResponse> payrollResponseList;
    private Context context;

    public PayrollAdapter(){

    }
    public void setData(List<PayrollResponse> payrollResponseList){
        this.payrollResponseList = payrollResponseList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PayrollAdapter.PayrollAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new PayrollAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.payroll_finance_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PayrollAdapter.PayrollAdapterViewHolder holder, int position) {
         PayrollResponse payrollResponse = payrollResponseList.get(position);
//         String payId = payrollResponse.getPay_id();
//         String month = payrollResponse.getMonth();
//         String debitAmount = payrollResponse.getDebit_amount();
//         String paymentStatus = payrollResponse.getPayroll_status();

        holder.payId.setText(payrollResponse.getPay_id().toString().trim());
        holder.month .setText(payrollResponse.getMonth().toString().trim());
        holder.debitAmount.setText(payrollResponse.getDebit_amount().toString().trim());
        holder.paymentStatus.setText(payrollResponse.getPayroll_status().toString().trim());


    }

    @Override
    public int getItemCount() {
        return payrollResponseList.size();
    }

    public class PayrollAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView payId;
        TextView month;
        TextView debitAmount;
        TextView paymentStatus;


        public PayrollAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            payId = itemView.findViewById(R.id.payIdOne);
            month = itemView.findViewById(R.id.monthMain);
            debitAmount = itemView.findViewById(R.id.debitAmountMain);
            paymentStatus = itemView.findViewById(R.id.paymentStatus);

        }
    }
}
