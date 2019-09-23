package com.example.hp.myapplication.util;

import android.app.Application;
import android.content.Context;



public class App extends Application {

//    private static RequestQueue requestQueue;
    private static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
//        LitePal.initialize(context);
//        if (requestQueue == null) {
//            synchronized (this) {
//                requestQueue = Volley.newRequestQueue(context);
//            }
//        }
    }

    public static   Context getContext() {
        return context;
    }

//    public static RequestQueue getRequestQueue() {
//        return requestQueue;
//    }
}
