package com.neuraweb.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
// public class attribution extends CordovaPlugin {
public class attribution extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        /************* Get referrer ************/
		
        String referrer = intent.getStringExtra("referrer");

        /****************** Save Referrer Value to SharedPreferences **********************/

        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("referrer", referrer);
        edit.apply();
		
    }
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getReferer")) {
            String message = args.getString(0);
            this.getReferer(message, callbackContext);
            return true;
        }
        return false;
    }

    private void getReferer(String message, CallbackContext callbackContext) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String referer = preferences.getString("referrer", "");
        if(!referer.equalsIgnoreCase(""))
        {
            callbackContext.success(referer);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
