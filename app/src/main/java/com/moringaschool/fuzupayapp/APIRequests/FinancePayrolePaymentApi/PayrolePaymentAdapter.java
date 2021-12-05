package com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class PayrolePaymentAdapter extends RecyclerView.Adapter<PayrolePaymentAdapter.PayroleAdapter> {

    private List<PayrolePaymentResponse> payrolePaymentResponses;
    private Context context;

    public PayrolePaymentAdapter() {
    }
    public  void setData(List<PayrolePaymentResponse> payrolePaymentResponses) {
        this.payrolePaymentResponses = payrolePaymentResponses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PayroleAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PayrolePaymentAdapter.PayroleAdapter(LayoutInflater.from(context).inflate(R.layout.financepaymentsholder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PayroleAdapter holder, int position) {
        PayrolePaymentResponse payrolePaymentResponse = payrolePaymentResponses.get(position);
        holder.holderPay.setText(payrolePaymentResponse.getPayId().toString().trim());
        holder.holderMonth.setText(payrolePaymentResponse.getMonth().toString().trim());
        holder.holderPending.setText(payrolePaymentResponse.getPayrollStatus().toString().trim());
        holder.holderDebit.setText(payrolePaymentResponse.getDebitAmount().toString().trim());

    }

    @Override
    public int getItemCount() {
        return payrolePaymentResponses.size();
    }

    public class PayroleAdapter extends RecyclerView.ViewHolder {

        TextView holderPay;
        TextView holderMonth;
        TextView holderPending;
        TextView holderDebit;
        public PayroleAdapter(@NonNull View itemView) {
            super(itemView);
            holderPay = itemView.findViewById(R.id.holderPays);
            holderMonth = itemView.findViewById(R.id.holderMonthPay);
            holderPending = itemView.findViewById(R.id.holderPendingPay);
            holderDebit = itemView.findViewById(R.id.holderDebitPay);
        }
    }
}
