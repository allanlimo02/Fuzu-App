package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.LeaveActivity;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AllStaffActivityTest extends TestCase {
    @Rule
    public ActivityScenarioRule<AllStaffActivity> activityRule =
            new ActivityScenarioRule<>(AllStaffActivity.class);

}