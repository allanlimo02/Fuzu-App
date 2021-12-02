package com.moringaschool.fuzupayapp.HumanResource.HrAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//import com.example.petyfinderip_version2.models.Animal;
import com.example.petyfinderip_version2.models.Animal;
import com.moringaschool.fuzupayapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HrListAdaper  extends RecyclerView.Adapter<HrListAdaper.HrViewHolder> {
   public List<Animal> mHoliday;
   public Context mContext;


   public HrListAdaper(Context context,List<Animal>holidays){
       mContext = context;
       mHoliday = holidays;
   }

    @Override
    public HrListAdaper.HrViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holidayholder,parent,false);
        HrViewHolder viewHolder = new HrViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( HrListAdaper.HrViewHolder holder, int position) {
        holder.bindRestaurant(mHoliday.get(position));
    }

    @Override
    public int getItemCount() {
        return mHoliday.size();
    }

    public class HrViewHolder extends RecyclerView.ViewHolder{
       @BindView(R.id.date) TextView date;
       @BindView(R.id.RealType)TextView Type;
       @BindView(R.id.Celebration) TextView nameOfHoliday;

       private Context mContext;

        public HrViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }


        public void bindRestaurant(Animal holiday) {
            date.setText(holiday.getAge());
            Type.setText(holiday.getType());
            nameOfHoliday.setText(holiday.getName());

        }
    }
}
