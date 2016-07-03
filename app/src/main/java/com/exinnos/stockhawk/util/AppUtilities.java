package com.exinnos.stockhawk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by RAMPRASAD on 7/3/2016.
 */
public class AppUtilities {


    /**
     * Check device network condition
     * @param context
     * @return true if network connected,otherwise return false.
     */
    public static boolean checkNetworkCondition(Context context){
        boolean isConnected;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }
}
