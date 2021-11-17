package com.moringaschool.fuzupayapp;

import static org.junit.Assert.*;

import android.widget.TextView;

import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

public class DashboardActivityTest {
    DashboardActivity dashboardActivity;

    @Before
    public void setUp() throws Exception {

        dashboardActivity = Robolectric.buildActivity(DashboardActivity.class)
                .create()
                .resume()
                .get();
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {


    }
    @Test
    public  void testTextView(){
        TextView gmorning=dashboardActivity.findViewById(R.id.textView);
        assertTrue("Good Morning".equals(gmorning.getText().toString()));
    }

    @Test
    public void onClick() {
    }
}