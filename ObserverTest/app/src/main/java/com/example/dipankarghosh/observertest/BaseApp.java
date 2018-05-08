package com.example.dipankarghosh.observertest;

import android.app.Application;


public class BaseApp extends Application {
    Test test; // Subject which is being observerd
//Class BaseApp is extending the Application Class.

    @Override
    public void onCreate() {
        super.onCreate();
        //oncreate super class is being called.
        test = new Test();
    }

    public Test getObserver(){
        return test;
    }
}
