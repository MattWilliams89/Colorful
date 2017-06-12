package org.polaric.colorful;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_AUTO;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_NO;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_YES;

public class ThemeDelegate {
    private final Context context;
    private Colorful.ThemeColor primaryColor;
    private Colorful.ThemeColor accentColor;
    private boolean translucent;
    private boolean dark;
    private boolean isDayNight;
    private boolean isAmoled;
    @StyleRes
    private int styleResPrimary;
    @StyleRes
    private int styleResAccent;
    @StyleRes
    private int styleResBase;

    ThemeDelegate(Context context, Colorful.ThemeColor primary, Colorful.ThemeColor accent, boolean translucent, boolean dark, boolean isDayNight, boolean isAmoled) {
        this.context = context;
        this.primaryColor = primary;
        this.accentColor = accent;
        this.translucent = translucent;
        this.dark = dark;
        this.isDayNight = isDayNight;
        this.isAmoled = isAmoled;
        long curTime = System.currentTimeMillis();
        styleResPrimary = context.getResources().getIdentifier("primary" + primary.ordinal(), "style", context.getPackageName());
        styleResAccent = context.getResources().getIdentifier("accent" + accent.ordinal(), "style", context.getPackageName());
        styleResBase = isAmoled ? R.style.Colorful_Amoled : R.style.Colorful;

        if (isDayNight) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_AUTO);
        } else if (dark || isAmoled) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        }

        Log.d(Util.LOG_TAG, "ThemeDelegate fetched theme in " + (System.currentTimeMillis() - curTime) + " milliseconds");
    }

    @StyleRes
    public int getStyleResPrimary() {
        return styleResPrimary;
    }

    @StyleRes
    public int getStyleResAccent() {
        return styleResAccent;
    }

    @StyleRes
    public int getStyleResBase() {
        return styleResBase;
    }

    public Colorful.ThemeColor getPrimaryColor() {
        return primaryColor;
    }

    public Colorful.ThemeColor getAccentColor() {
        return accentColor;
    }

    public boolean isTranslucent() {
        return translucent;
    }

    public boolean isDark() {
        return dark;
    }

    public boolean isDayNight() {
        return isDayNight;
    }
}
