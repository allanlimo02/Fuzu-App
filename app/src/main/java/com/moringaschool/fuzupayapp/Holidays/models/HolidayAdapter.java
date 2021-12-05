package com.moringaschool.fuzupayapp.Holidays.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.Holidays.HolidayResponses;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayAdapterViewHolder> {

    private List<HolidayResponses> holidayResponsesList;
    private Context context;

    public HolidayAdapter() {
    }
    public  void setData(HolidayResponses holidayAdapter) {
        this.holidayResponsesList = (List<HolidayResponses>) holidayAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolidayAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new HolidayAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.holidayholder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayAdapterViewHolder holder, int position) {
        HolidayResponses holidayResponses = holidayResponsesList.get(position);
        holder.holidDate.setText(holidayResponses.getDate().toString());
        holder.RealType.setText(holidayResponses.getPublic().toString().trim());
        holder.Celebration.setText(holidayResponses.getName().toString().trim());
//        holder.name.setText(onLeaveResponse.getEmployee().toString().trim());

    }

    @Override
    public int getItemCount() {
        return holidayResponsesList.size();
    }

    public class HolidayAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView holidDate;
        TextView RealType;
        TextView Celebration;
//        TextView date;
        public HolidayAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            holidDate = itemView.findViewById(R.id.holidDate);
            RealType = itemView.findViewById(R.id.RealType);
            Celebration = itemView.findViewById(R.id.Celebration);
//            date = itemView.findViewById(R.id.date);
        }
    }
}
