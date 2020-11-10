package com.example.unibudget;

import android.app.Application;

import com.parse.Parse;


public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("eCTzNXqC1JLrcuznmngsAA2MBnhdzbIy1e96FJg9")
                .clientKey("rIL6Lm8q0UmBi3SFpn527oLmOLjt0JGvrpTmPTrI")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
