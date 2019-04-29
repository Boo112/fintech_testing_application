package com.fintech.fasthub;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.fastaccess.App;
import com.fastaccess.helper.PrefHelper;
import com.fintech.fasthub.base.Application;
import com.fintech.fasthub.pages.FastHubPage;

import org.junit.Test;

import static org.junit.Assert.*;

public class test extends Application {

    @Test
    public void tredningTest() {
        app.open();
        app.openMainMenu();
        app.clickToMainMenu("Trending");
        assertEquals("Trending", app.getTitleWindow());
    }

    @Test
    public void changeThemeTest() throws UiObjectNotFoundException {
        app.open();
        app.openMainMenu();
        app.clickToMainMenu("Settings");
        app.clickToMainMenu("Theme");
        app.scrollForwardTheme(2);
        app.clickThemeButtonOk();
        // assertEquals("Trending",app.getTitleWindow());
    }

    @Test
    public void toastTest() throws UiObjectNotFoundException {
        app.open();
        app.openMainMenu();
        app.clickToMainMenu("Send feedback");
        app.clickButtonWithName("OK");
        app.intputTextInEditText("hello");
        app.clickButtonWithName("Description");
      //  assertTrue(app.fdsfds("Description", "Xiaomi"));

        // assertEquals("Trending",app.getTitleWindow());
    }

    @Test
    public void aboutTest() throws UiObjectNotFoundException {
        app.open();
        app.openMainMenu();
        app.scrollForwardMenuToItemName("About");
        app.clickToMainMenu("About");
        assertEquals("Changelog", app.getTextFromItem("Changelog"));
    }

    @Test
    public void restorePurchasesTest() throws UiObjectNotFoundException {
        app.open();
        app.openMainMenu();
        app.scrollForwardMenuToItemName("Restore Purchases");
        app.clickToMainMenu("Restore Purchases");
       // assertEquals("Changelog", app.getTextFromItem("Changelog"));
    }

}
