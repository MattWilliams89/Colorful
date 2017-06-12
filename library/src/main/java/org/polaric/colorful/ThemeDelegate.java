package org.polaric.colorful;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_AUTO;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_YES;

public class ThemeDelegate {
    private final Context context;
    private Colorful.ThemeColor primaryColor;
    private Colorful.ThemeColor accentColor;
    private boolean translucent;
    private boolean dark;
    private boolean isDayNight;
    @StyleRes
    private int styleResPrimary;
    @StyleRes
    private int styleResAccent;
    @StyleRes
    private int styleResBase;

    ThemeDelegate(Context context, Colorful.ThemeColor primary, Colorful.ThemeColor accent, boolean translucent, boolean dark, boolean isDayNight) {
        this.context = context;
        this.primaryColor = primary;
        this.accentColor = accent;
        this.translucent = translucent;
        this.dark = dark;
        this.isDayNight = isDayNight;
        long curTime = System.currentTimeMillis();
        styleResPrimary = context.getResources().getIdentifier("primary" + primary.ordinal(), "style", context.getPackageName());
        styleResAccent = context.getResources().getIdentifier("accent" + accent.ordinal(), "style", context.getPackageName());
        styleResBase = R.style.Colorful;

        if (isDayNight) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_AUTO);
        }
        else if (dark) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM);
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
