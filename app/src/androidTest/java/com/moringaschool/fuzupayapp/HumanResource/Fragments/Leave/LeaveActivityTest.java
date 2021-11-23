package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;
import com.moringaschool.fuzupayapp.R;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LeaveActivityTest extends TestCase {

    @Rule
    public ActivityScenarioRule<LeaveActivity> activityRule =
            new ActivityScenarioRule<>(LeaveActivity.class);

    //test leave requests button
    @Test
    public void testLeave_requests_button() throws Exception{
        onView(ViewMatchers.withId(R.id.fragmentOneBtn2)).perform(click());
    }
//test on leave button
    @Test
    public void test_onLeave_button() throws Exception {
        onView(ViewMatchers.withId(R.id.fragmentTwoBtn2)).perform(click());
    }

    //test on recyclerview functionality
    @Test
    public void test_recyclerView_functionality() throws Exception {
        onView(ViewMatchers.withId(R.id.recview2)).check(matches(isDisplayed()));
    }
    //Test on radioButton
    @Test
    public void test_radioButton() throws Exception {
        onView(ViewMatchers.withId(R.id.radioButton)).perform(click())
                .check(matches(isDisplayed()));
    }
    //test on approve button
    @Test
    public void test_approve_button() throws Exception {
        onView(ViewMatchers.withId(R.id.approveButton)).perform(click())
                .check(matches(isDisplayed()));
    }
    //test on reject button
    @Test
    public void test_reject_button() throws Exception {
        onView(ViewMatchers.withId(R.id.reject)).perform(click())
                .check(matches(isDisplayed()));
    }
}