package com.exinnos.stockhawk;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by RAMPRASAD on 7/16/2016.
 */
public class StockHawkApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Inititalize Stetho for debugging!
        Stetho.initializeWithDefaults(this);
    }
}
