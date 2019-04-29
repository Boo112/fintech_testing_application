package com.fintech.fasthub.base;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import com.fintech.fasthub.pages.FastHubPage;

import org.junit.Before;

//@RunWith(AndroidJUnit4.class)
public class Application {
    protected FastHubPage app=new FastHubPage(getDevice());

@Before
    public void setUp() {
        getDevice().pressHome();
        getDevice().pressBack();
    }

    private UiDevice getDevice() {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

}