package com.moringaschool.fuzupayapp.HumanResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
public class LoginTest extends TestCase {
    @Rule
    public ActivityScenarioRule<Login> activityRule =
            new ActivityScenarioRule<>(Login.class);

    @Test
    public void input_the_login_Text(){
        onView(withId(R.id.emailEditText)).perform(typeText("FuzuPay"))
                .check(matches(withText("FuzuPay")));
    }
//    @Test
//    public void Validates_Pasword_input(){
//        onView(withId(R.id.passwordEditText)).perform(typeText("FuzuPay"))
//                .check(matches(withText("FuzuPay")));
//    }
    @Test
    public void login_button_validation(){
        onView(withId(R.id.findLoginButton)).perform(click());
    }


}