package com.newlab.mayes.launcher.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceCore {
    public static final String APP_PREFERENCES = "configlauncher";

    private static SharedPreferences getPrefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setString(Context context, String str, String str2) {
        if (context == null) return;
        getPrefs(context).edit().putString(str, str2).apply();
    }

    public void setInt(Context context, String str, int i) {
        if (context == null) return;
        getPrefs(context).edit().putInt(str, i).apply();
    }

    public void setBoolean(Context context, String str, boolean z) {
        if (context == null) return;
        getPrefs(context).edit().putBoolean(str, z).apply();
    }

    public void setLong(Context context, String str, long j) {
        if (context == null) return;
        getPrefs(context).edit().putLong(str, j).apply();
    }

    public void setFloat(Context context, String str, float f) {
        if (context == null) return;
        getPrefs(context).edit().putFloat(str, f).apply();
    }

    public String getString(Context context, String str) {
        if (context == null) return null;
        SharedPreferences prefs = getPrefs(context);
        return prefs.contains(str) ? prefs.getString(str, "") : null;
    }

    public String getString(Context context, String str, String defValue) {
        if (context == null) return defValue;
        return getPrefs(context).getString(str, defValue);
    }

    public int getInt(Context context, String str) {
        if (context == null) return 0;
        return getPrefs(context).getInt(str, 0);
    }

    public int getInt(Context context, String str, int defaultValue) {
        if (context == null) return defaultValue;
        return getPrefs(context).getInt(str, defaultValue);
    }

    public boolean getBoolean(Context context, String str) {
        if (context == null) return false;
        return getPrefs(context).getBoolean(str, false);
    }

    public boolean getBoolean(Context context, String str, boolean defaultValue) {
        if (context == null) return defaultValue;
        return getPrefs(context).getBoolean(str, defaultValue);
    }

    public long getLong(Context context, String str) {
        if (context == null) return 0L;
        return getPrefs(context).getLong(str, 0L);
    }

    public long getLong(Context context, String str, long defaultValue) {
        if (context == null) return defaultValue;
        return getPrefs(context).getLong(str, defaultValue);
    }

    public float getFloat(Context context, String str) {
        if (context == null) return 0.0f;
        return getPrefs(context).getFloat(str, 0.0f);
    }

    public float getFloat(Context context, String str, float defaultValue) {
        if (context == null) return defaultValue;
        return getPrefs(context).getFloat(str, defaultValue);
    }
}
