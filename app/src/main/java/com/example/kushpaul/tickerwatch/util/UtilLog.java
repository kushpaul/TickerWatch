package com.example.kushpaul.tickerwatch.util;

import android.util.Log;

/**
 * Created by KushPaul on 6/26/17.
 */

public class UtilLog {
    private static boolean isLog = false;

    public static void setIsLog(boolean b){
        isLog=b;
    }

    public static void d(String s, String v) {
        if(isLog) {
            Log.d(s, v);
        }
    }
    public static void v(String tag, String msg) {
        if(isLog) {
            Log.d(tag, msg);
        }
    }
}