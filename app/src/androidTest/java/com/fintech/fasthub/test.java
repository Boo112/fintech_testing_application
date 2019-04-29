package com.fintech.fasthub;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.fintech.fasthub.base.ApplicationBaseRunner;

import org.junit.Test;

import static org.junit.Assert.*;

public class test extends ApplicationBaseRunner {

    @Test
    public void tredningTest() {
        app.openApplication();
        app.openMainMenu();
        app.clickToMainMenu("Trending");
        assertEquals("Trending", app.getTitleWindow());
    }

    @Test
    public void changeThemeTest() throws UiObjectNotFoundException {
        app.openApplication();
        app.openMainMenu();
        app.clickToMainMenu("Settings");
        app.clickToMainMenu("Theme");
        app.scrollForwardThemeMenu(2);
        app.clickThemeButtonOk();
        // assertEquals("Trending",app.getTitleWindow());
    }

    @Test
    public void toastTest() throws UiObjectNotFoundException {
        app.openApplication();
        app.openMainMenu();
        app.clickToMainMenu("Send feedback");
        app.clickButtonWithName("OK");
        app.intputTextInEditText("hello");
        app.clickButtonWithName("Description");
        assertTrue(app.getText("Xiaomi"));
        assertTrue(app.getText("Redmi 4X"));

        app.clickSubmitButton();

        // assertEquals("Trending",app.getTitleWindow());
    }

    @Test
    public void aboutTest() throws UiObjectNotFoundException {
        app.openApplication();
        app.openMainMenu();
        app.scrollMenuToItemName("About");
        app.clickToMainMenu("About");
        assertEquals("Changelog", app.getTextFromItem("Changelog"));
    }

    @Test
    public void restorePurchasesTest() throws UiObjectNotFoundException {
        app.openApplication();
        app.openMainMenu();
        app.scrollMenuToItemName("Restore Purchases");
        app.clickToMainMenu("Restore Purchases");
       // assertEquals("Changelog", app.getTextFromItem("Changelog"));
    }

}
