package com.fintech.fasthub.pages;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.SearchCondition;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FastHubPage {
    private static final String PACKAGE = "com.fastaccess.github.debug";
    private static final long TIMEOUT = TimeUnit.SECONDS.toMillis(10);
    private final UiDevice device;
    private final Context context;
    private final Intent intent;

    public FastHubPage(UiDevice device) {
        this.device = device;
        this.context = InstrumentationRegistry.getInstrumentation().getContext();
        this.intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE);
    }

    public void openApplication() {
        String launcherPackage = device.getLauncherPackageName();
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), TIMEOUT);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        device.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), TIMEOUT);
    }

    public void openMainMenu() {
        device.findObject(By.clazz("android.widget.ImageButton").
                desc("‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎")).click();
    }

    public void clickToMainMenu(String nameItemMenu) {
        waitFindObject(By.text(nameItemMenu)).click();
    }

    public String getTitleWindow() {
        BySelector title = By.res("com.fastaccess.github.debug:id/toolbar").clazz("android.widget.TextView");
        device.wait(Until.findObject(title), TIMEOUT);
        return device.findObject(By.res("com.fastaccess.github.debug:id/toolbar"))
                .findObject(By.clazz("android.widget.TextView"))
                .getText();
    }

    public void clickButtonWithName(String buttonName) {
        waitFindObject(By.text(buttonName)).click();
    }

    public void scrollForwardThemeMenu(int steps) throws UiObjectNotFoundException {
        UiSelector uiSelector = new UiSelector().scrollable(true).className("android.support.v4.view.ViewPager");
        UiScrollable theme = new UiScrollable(uiSelector);
        theme.setAsHorizontalList();
        theme.scrollForward(steps);
    }

    public void scrollMenuToItemName(String name) throws UiObjectNotFoundException {
        UiSelector uiSelector = new UiSelector().scrollable(true).className("android.support.v7.widget.RecyclerView");
        UiScrollable theme = new UiScrollable(uiSelector);
        theme.scrollDescriptionIntoView(name);
    }

    public void clickThemeButtonOk() {
        device.findObject(By.res("com.fastaccess.github.debug:id/apply")).click();
    }

    public void intputTextInEditText(String text) {
        waitFindObject(By.clazz("android.widget.EditText")).setText(text);
    }

    public boolean in(String text) {
        BySelector title = By.res("com.fastaccess.github.debug:id/editText)");
        device.wait(Until.findObject(title), TIMEOUT);
        return device.findObject(By.res("com.fastaccess.github.debug:id/editText)"))
                .getText().contains(text);

        //return waitFindObject(By.res("com.fastaccess.github.debug:id/editText)")).getText().contains(text);
    }

    public String getTextFromItem(String itemName) {
        return waitFindObject(By.text(itemName)).getText();
    }

    private UiObject2 waitFindObject(BySelector byselector) {
        SearchCondition<UiObject2> condition = Until.findObject(byselector);
        return Objects.requireNonNull(device.wait(condition, TIMEOUT));
    }

}

