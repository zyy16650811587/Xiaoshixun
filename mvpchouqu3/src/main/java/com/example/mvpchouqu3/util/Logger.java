package com.example.mvpchouqu3.util;

import android.util.Log;

import com.example.mvpchouqu3.base.Constants;


public class Logger {
    public static void logD(String tag,String msg){
        if (Constants.isDebug){//打印的开关
            Log.d(tag, "logD: "+msg);
        }
    }

    public static void print(String msg){
        if (Constants.isDebug){
            System.out.print(msg);
        }
    }
}
