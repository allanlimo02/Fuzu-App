package com.moringaschool.fuzupayapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DashboardActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<DashboardActivity> activityScenarioRule = new ActivityScenarioRule<DashboardActivity>(DashboardActivity.class);

//    @Test
//    public void validateTextView() {
//        onView(withId(R.id.textView)).perform(validateTextView("Good Morning");)
//                .check(matches(withText("Good Morning")));
//    }

}
