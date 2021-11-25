package com.moringaschool.fuzupayapp.Finance;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
public class Log_In_financeTest extends TestCase {
    @Rule
    public ActivityScenarioRule<Log_In_finance> activityScenarioRule = new ActivityScenarioRule<Log_In_finance>(Log_In_finance.class);
//test on log in activity
    @Test
    public void test_Log_in_activity()throws Exception {
        onView(ViewMatchers.withId(R.id.textView)).check(matches(isDisplayed()));
    }
    @Test
    public void test_email_input() throws Exception {
        onView(ViewMatchers.withId(R.id.emailEditText)).perform(typeText("FuzuPay"))
        .check(matches(withText("FuzuPay")));
    }
    @Test
    public void test_login_button() throws Exception {
        onView(ViewMatchers.withId(R.id.findLoginButton)).perform(click());
    }
    @Test
    public void test_forgot_password() throws Exception {
        onView(ViewMatchers.withId(R.id.forgetPasswordTextView)).perform(click());
    }
}