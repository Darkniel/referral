package com.neuraweb.cordova.referral;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Referral extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getReferrer")) {
            this.getReferrer(callbackContext);
            return true;
        }
        return false;
    }
    private void getReferrer(CallbackContext callbackContext) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cordova.getActivity());
        String referrer = preferences.getString("referrer", "");
        if(!referrer.equalsIgnoreCase(""))
        {
            callbackContext.success(referrer);
        } else {
            callbackContext.error("sin referido");
        }
    }
}
