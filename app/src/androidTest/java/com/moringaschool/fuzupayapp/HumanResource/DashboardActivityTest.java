package com.moringaschool.fuzupayapp.HumanResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
//Test on approve button
    @Test
    public void testClickApprove_leave_requests() throws Exception {
        onView(ViewMatchers.withId(R.id.approvebutton)).perform(click());
    }
    //Test on Quick navigation buttons

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

    //Test on bottom navigation button
    @Test
    public void testBottomNavigation_navHome() throws Exception {
        onView(withId(R.id.nav_home)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void testBottomNavigation_navStaff() throws Exception {
        onView(withId(R.id.nav_staff)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void testBottomNavigation_navLeave() throws Exception {
        onView(withId(R.id.nav_leave)).perform(click())
                .check(matches(isDisplayed()));
    }

}