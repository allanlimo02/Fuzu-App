package com.moringaschool.fuzupayapp.Finance.Expences;

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
public class ARDActivityTest extends TestCase {

    @Rule
    public ActivityScenarioRule<ARDActivity> activityScenarioRule = new ActivityScenarioRule<>(ARDActivity.class);

//    @Test
//    public void test_textview() throws Exception {
//        onView(ViewMatchers.withId(R.id.Amount)).check(matches(isDisplayed()));
//    }
}