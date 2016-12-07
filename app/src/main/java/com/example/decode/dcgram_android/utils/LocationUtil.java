package com.example.decode.dcgram_android.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import timber.log.Timber;

/**
 * Created by root on 06.12.16..
 */

public class LocationUtil {

    public static String getAddress(Activity context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//            String provider = locationManager.getBestProvider(new Criteria(), true);


            Location locations = getLastKnownLocation(context); //locationManager.getLastKnownLocation(provider)
            List<String> providerList = locationManager.getAllProviders();
            Timber.d("locations: " + locations);
            if (null != locations && null != providerList && providerList.size() > 0) {
                double longitude = locations.getLongitude();
                double latitude = locations.getLatitude();
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                try {
                    List<Address> listAddresses = geocoder.getFromLocation(latitude, longitude, 1);
                    if (null != listAddresses && listAddresses.size() > 0) {
                        String _Location = listAddresses.get(0).getAddressLine(0) + ", " + listAddresses.get(0).getLocality();
                        return _Location;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            Timber.d("exception: " + e);
        }
        return null;
    }

    private static Location getLastKnownLocation(Context context) {
        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Timber.d("permission not granted!");
            return null;
        }
        LocationManager mLocationManager = (LocationManager)context.getSystemService(context.LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }
}
