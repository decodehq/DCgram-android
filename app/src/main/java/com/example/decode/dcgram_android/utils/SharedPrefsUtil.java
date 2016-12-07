package com.example.decode.dcgram_android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by root on 06.12.16..
 */

public class SharedPrefsUtil {

    public static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);

        // Commit the edits!
        editor.commit();

    }

    public static boolean loadBoolean(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        boolean result = settings.getBoolean(key, false);
        return result;

    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);

        // Commit the edits!
        editor.commit();

    }

    public static String loadString(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        String result = settings.getString(key, null);
        return result;

    }


    public static void saveInteger(Context context, String key, int value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);

        // Commit the edits!
        editor.commit();

    }

    public static int loadInteger(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        int result = settings.getInt(key, 0);
        return result;
    }

    public static void saveLong(Context context, String key, long value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);

        // Commit the edits!
        editor.commit();

    }

    public static long loadLong(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        long result = settings.getLong(key, 0);
        return result;
    }

    public static void saveFloat(Context context, String key, float value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);

        // Commit the edits!
        editor.commit();

    }

    public static Set<String> loadSet(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> result = settings.getStringSet(key, null);
        if (result == null)
            return null;

        return result;

    }

    public static float loadFloat(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        float result = settings.getFloat(key, 0);
        return result;

    }

    public static void saveSet(Context context, String key, Set<String> value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();


        editor.putStringSet(key, value);
        // Commit the edits!
        editor.commit();
    }
}
