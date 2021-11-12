package com.moringaschool.fuzupayapp.FragmentAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.Add_Staff_Input_Fragment;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.AllStaff;
import com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.fragmentAddStaff;

public class AdapterFragment extends FragmentStateAdapter {
    public AdapterFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1 :
                return new fragmentAddStaff.DepartmentsFragment();

            case 2:
                return new Add_Staff_Input_Fragment();

        }
        return new AllStaff();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
