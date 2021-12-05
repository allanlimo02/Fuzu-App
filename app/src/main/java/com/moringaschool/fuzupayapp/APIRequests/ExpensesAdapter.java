package com.moringaschool.fuzupayapp.APIRequests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ExpensesListViewHolder> {

    private List<ExpensesResponse> expensesResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public ExpensesAdapter(ClickedItem clickedItem){
        this.clickedItem= clickedItem;

    }
    public void setData(List<ExpensesResponse> expensesResponseList){
        this.expensesResponseList = expensesResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExpensesAdapter.ExpensesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ExpensesListViewHolder(LayoutInflater.from(context).inflate(R.layout.expense_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesListViewHolder holder, int position) {
        ExpensesResponse  expensesResponse = expensesResponseList.get(position);
//

        holder.expenseId.setText("1");
        holder.staffName.setText(expensesResponse.getName().toString().trim());
        holder.amount.setText(expensesResponse.getAmount().toString().trim());
//        holder.date.setText(); ;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        String time = sdf.format(timeFormat);
        Calendar calender = Calendar.getInstance();
        String date = DateFormat.getDateInstance().format(calender.getTime());
        holder.date.setText(date);

        holder.amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(expensesResponse);
            }
        });
//        holder.date.setText(expensesResponse.getDate_processed().toString().trim());
    }
    public  interface ClickedItem{
        public void ClickedUser(ExpensesResponse expensesResponse);
    }


    @Override
    public int getItemCount() {
        return expensesResponseList.size();
    }


    public static class ExpensesListViewHolder extends RecyclerView.ViewHolder{
        RadioButton expenseId;
        TextView staffName;
        TextView amount;
        TextView date;
        public ExpensesListViewHolder(@NonNull View itemView) {
            super(itemView);
            expenseId = itemView.findViewById(R.id.radio_Expense);
            staffName = itemView.findViewById(R.id.Astaff);
            amount = itemView.findViewById(R.id.Amount);
            date = itemView.findViewById(R.id.ADate);
        }
    }
}
