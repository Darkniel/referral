package com.neuraweb.cordova.referral;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */

public class Referral extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getReferrer")) {
            String message = args.getString(0);
            Toast.makeText(this.cordova.getActivity(), "Don't panik but your time is up!!!!.", Toast.LENGTH_LONG).show();
            this.getReferrer(message, callbackContext);
            return true;
        }
        return false;
    }
    private void getReferrer(String message, CallbackContext callbackContext) {
        // Context context = cordova.getActivity().getApplicationContext();
        Context context = cordova.getActivity().getApplicationContext();
        // Context context = getActivity().getApplicationContext();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cordova.getActivity());
        String referrer = preferences.getString("referrer", "");
        Toast.makeText(context, referrer, Toast.LENGTH_LONG).show();
        if(!referrer.equalsIgnoreCase(""))
        {
            callbackContext.success(referrer);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
