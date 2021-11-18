package com.moringaschool.fuzupayapp.HumanResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.R;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DashboardActivityTest extends TestCase {

    @Rule
    public ActivityScenarioRule<DashboardActivity> activityRule =
            new ActivityScenarioRule<>(DashboardActivity.class);

    @Test
    public void clickManage_Staff_managestaff()throws Exception{
        onView(ViewMatchers.withId(R.id.managestaff)).perform(click());
    }
    @Test
    public void clickdepartments_opensdepartments()throws Exception{
        onView(withId(R.id.onleave)).perform(click());
    }
    @Test
    public void clickaddstaff_addstaffpage()throws Exception{
        onView(withId(R.id.addstaff)).perform(click());
    }
    @Test
    public void clickonleave_opensonleavepage()throws Exception{
        onView(withId(R.id.onleave)).perform(click());
    }

}