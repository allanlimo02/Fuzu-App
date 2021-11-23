package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

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
public class AddStaffMainTest extends TestCase {

    @Rule
    public ActivityScenarioRule<AddStaffMain> activityScenarioRule = new ActivityScenarioRule<AddStaffMain>(AddStaffMain.class);

    //tet on allStaff button and that its navigates to it
    @Test
    public void test_allStaff_button() throws Exception {
        onView(ViewMatchers.withId(R.id.fragmentOneBtn)).perform(click())
                .check(matches(isDisplayed()));
    }
    //Test on departments button
    @Test
    public void test_departments_button() throws Exception {
        onView(ViewMatchers.withId(R.id.fragmentTwoBtn)).perform(click())
                .check(matches(isDisplayed()));
    }
    //test on add staff button
    @Test
    public void test_addStaff_button() throws Exception {
        onView(ViewMatchers.withId(R.id.fragmentThreeBtn)).perform(click())
                .check(matches(isDisplayed()));
    }
    //test radio buttons on add staff fragment
    @Test
    public void test_input_radio_button() throws Exception {
        onView(ViewMatchers.withId(R.id.radio_one)).perform(click());
    }
    @Test
    public void test_upload_button() throws Exception {
        onView(ViewMatchers.withId(R.id.radio_two)).perform(click());
    }
    //test recyclerviews
//    @Test
//    public void test_Staff_recyclerviewLayout() throws Exception {
//        onView(ViewMatchers.withId(R.id.ourFrameLayout)).check(matches(isDisplayed()));
//    }
}