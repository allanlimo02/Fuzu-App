package com.moringaschool.fuzupayapp.FragmentAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.fuzupayapp.R;

public class LeaveRequestAdapter extends RecyclerView.Adapter<LeaveRequestAdapter.ViewHolder> {

    private String leaveName[], dates[], names[],duration[];
    Context mcontext;

    public LeaveRequestAdapter(Context context, String[] name, String[] position, String[] workType , String[] duration) {
        this.mcontext =context;
        this.leaveName = name;
        this.dates = position;
        this.names = workType;
        this.duration=duration;
    }

    @NonNull
    @Override
    public LeaveRequestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        View view=inflater.inflate(R.layout.leave_list_item,parent,false);
        return new LeaveRequestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveRequestAdapter.ViewHolder holder, int position) {
        holder.leaveName.setText(leaveName[position]);
        holder.dates.setText(dates[position]);
        holder.names.setText(names[position]);
        holder.duration.setText(duration[position]);


    }
    @Override
    public int getItemCount() {
        return leaveName.length;
    }

    //second class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView leaveName, dates, names,duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leaveName =itemView.findViewById(R.id.leaveTitle);
            dates =itemView.findViewById(R.id.date);
            names =itemView.findViewById(R.id.name);
            duration=itemView.findViewById(R.id.duration);



//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(context, SIngleStaffActivity.class);
//            String finalname= LeaveRequestAdapter.this.leaveName[itemPosition];
//            String finalposition= LeaveRequestAdapter.this.dates[itemPosition];
//            String finalemployment= LeaveRequestAdapter.this.names[itemPosition];
//            intent.putExtra("name",finalname);
//            intent.putExtra("position",finalposition);
//            intent.putExtra("jobtype",finalemployment);
//            context.startActivity(intent);


        }
    }
}
