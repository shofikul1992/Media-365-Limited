package com.media360.ltd.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 28/09/2017.
 */

public class DevicePermission {

    // Set Location Permission  Mothod
    public static void setLocationPermission(Activity activity) {
        final int REQUEST_CODE_ASK_PERMISSIONS = 123;
        if (Build.VERSION.SDK_INT > 22) {
            String readLocationPermission = Manifest.permission.ACCESS_FINE_LOCATION;
            int hasReadLocationPermission = activity.checkSelfPermission(readLocationPermission);

            List<String> permissions = new ArrayList<String>();
            if (hasReadLocationPermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(readLocationPermission);
            }

            if (!permissions.isEmpty()) {
                String[] params = permissions.toArray(new String[permissions.size()]);
                activity.requestPermissions(params, REQUEST_CODE_ASK_PERMISSIONS);
            }
        }
    }


}
