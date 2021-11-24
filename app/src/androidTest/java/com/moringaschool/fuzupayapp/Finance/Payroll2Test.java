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
public class Payroll2Test extends TestCase {

    @Rule
    public ActivityScenarioRule<Payroll2> activityScenarioRule = new ActivityScenarioRule<Payroll2>(Payroll2.class);

    @Test
    public void test_new_run_button() throws Exception {
        onView(ViewMatchers.withId(R.id.newrun)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_payroll_button() throws Exception {
        onView(ViewMatchers.withId(R.id.payroll)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_staff_button() throws Exception {
        onView(ViewMatchers.withId(R.id.staff)).perform(click())
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_new_frameLayout() throws Exception {
        onView(ViewMatchers.withId(R.id.nframe)).perform(click())
                .check(matches(isDisplayed()));
    }
}