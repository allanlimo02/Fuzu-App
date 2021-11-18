package com.moringaschool.fuzupayapp;

import static org.junit.Assert.*;

import android.widget.TextView;

import com.moringaschool.fuzupayapp.HumanResource.Dashboard.DashboardActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class DashboardActivityTest {
   private DashboardActivity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(DashboardActivity.class)
                .create()
                .resume()
                .get();
    }
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void onCreate() {
//
//
//    }
    @Test
    public  void validateTextViewContext(){
        TextView textView = activity.findViewById(R.id.textView);
        assertTrue("Good Morning".equals(textView.getText().toString()));
    }

}