package com.fintech.fasthub.base;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import com.fintech.fasthub.pages.FastHubMainPage;

import org.junit.Before;

//@RunWith(AndroidJUnit4.class)
public class ApplicationBaseRunner {
    protected FastHubMainPage app = new FastHubMainPage(getDevice());

    @Before
    public void setUp() {
        getDevice().pressHome();
        getDevice().pressBack();
    }

    private UiDevice getDevice() {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }
}