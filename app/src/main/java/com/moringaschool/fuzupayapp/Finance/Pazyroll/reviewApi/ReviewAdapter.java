package com.moringaschool.fuzupayapp.Finance.Pazyroll.reviewApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.reviewAdapterViewHolder>{
    private List<reviewResponse> reviewResponseList;
    private Context context;

    public ReviewAdapter() {
    }
    public  void setData(List<reviewResponse> reviewResponseList) {
        this.reviewResponseList = reviewResponseList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public reviewAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ReviewAdapter.reviewAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.review_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull reviewAdapterViewHolder holder, int position) {
        reviewResponse onreviewResponse = reviewResponseList.get(position);
        holder.officialName.setText(onreviewResponse.getFull_name().toString().trim());
        holder.hours.setText("Hours: 249 hrs");
        holder.gross.setText("Gross Pay: "+ onreviewResponse.getGross_pay().toString().trim());
        holder.commission.setText("Commission: " +onreviewResponse.getMedical_cover().toString().trim());
        holder.deductions.setText("Deductions: " +onreviewResponse.getTax_deducted().toString().trim());
        holder.netPay.setText(onreviewResponse.getNet_pay().toString().trim());
        holder.paymethod.setText("Direct Deposit");
        holder.depodate.setText("30/06/2021");


    }

    @Override
    public int getItemCount() {
        return reviewResponseList.size();
    }

    public class reviewAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView officialName;
        TextView hours;
        TextView gross;
        TextView commission;
        TextView deductions;
        TextView netPay;
        TextView paymethod;
        TextView depodate;

        public reviewAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            officialName = itemView.findViewById(R.id.nameOfficial);
            gross = itemView.findViewById(R.id.gross);
            hours = itemView.findViewById(R.id.Hours);
            depodate = itemView.findViewById(R.id.depodate);
            commission = itemView.findViewById(R.id.commission);
            deductions = itemView.findViewById(R.id.deductionreview);
            netPay = itemView.findViewById(R.id.paymentType);
            paymethod = itemView.findViewById(R.id.PayMethod);
        }
    }
}
