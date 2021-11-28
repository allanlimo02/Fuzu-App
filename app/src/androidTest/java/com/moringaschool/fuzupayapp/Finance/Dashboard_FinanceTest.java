package com.moringaschool.fuzupayapp.Finance;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.moringaschool.fuzupayapp.R;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Dashboard_FinanceTest extends TestCase {
   @Rule
   public ActivityScenarioRule<Dashboard_Finance> activityScenarioRule = new ActivityScenarioRule<Dashboard_Finance>(Dashboard_Finance.class);
//test to check if activity is working
    @Test
    public void testDashboard_display() throws Exception{
        onView(ViewMatchers.withId(R.id.textView)).check(matches(isDisplayed()));
    }
    //test on run payroll button
    @Test
    public void test_runPayroll() throws Exception {
        onView(ViewMatchers.withId(R.id.approvebutton)).perform(click())
                .check(matches(isDisplayed()));
    }
    //test on quick nav
//    @Test
//    public void testQuicknav_advanceRequests() throws Exception {
//        onView(ViewMatchers.withId(R.id.advancerequest)).perform(click())
//                .check(matches(isDisplayed()));
//    }
//    @Test
//    public void testQuicknav_Approve_expenses() throws Exception {
//        onView(ViewMatchers.withId(R.id.approveExpense)).perform(click())
//                .check(matches(isDisplayed()));
//    }
    @Test
    public void testQuicknav_manage_staffs() throws Exception {
        onView(ViewMatchers.withId(R.id.managestaff)).perform(click())
                .check(matches(isDisplayed()));
    }
    //recyclerView test
//    @Test
//    public void test_holiday_recyclerview()throws Exception {
//        onView(ViewMatchers.withId(R.id.holidaysRecyclerview)).check(matches(isDisplayed()));
//    }
    //test on bottomnav
    @Test
    public void test_bottom_navigation() throws Exception {
        onView(ViewMatchers.withId(R.id.bottom_navigation)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_bottom_navigation_home() throws Exception {
        onView(ViewMatchers.withId(R.id.nav_home)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_bottom_navigation_payroll() throws Exception {
        onView(ViewMatchers.withId(R.id.nav_payroll)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_bottom_navigation_expenses() throws Exception {
        onView(ViewMatchers.withId(R.id.nav_expenses)).perform(click())
                .check(matches(isDisplayed()));
    }
}