package com.moringaschool.fuzupayapp;

import static org.junit.Assert.assertTrue;

import android.widget.EditText;

import com.moringaschool.fuzupayapp.HumanResource.Login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class LoginTest {
    private Login login ;

    @Before
    public void setUp() throws Exception{
        login = Robolectric.buildActivity(Login.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void emailIsValid() {
        EditText emailEditText = login.findViewById(R.id.emailEditText);
        assertTrue("judy@gmail.com".equals(emailEditText.getText().toString()));
    }
}
