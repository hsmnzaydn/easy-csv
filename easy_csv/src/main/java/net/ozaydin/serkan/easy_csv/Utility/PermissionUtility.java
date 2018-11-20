package net.ozaydin.serkan.easy_csv.Utility;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.requestPermissions;

public class PermissionUtility {

    /**
     * Request Runtime permission to user
     * @param activity Referanced activity
     * @param permission Permission Name
     * @param requestCode Requested permission's codce
     * @return
     */
    public static boolean askPermissionForActivity(Activity activity, String permission, int requestCode){
        List<String> permissionList = new ArrayList<>();
        int permissionId = ContextCompat.checkSelfPermission(activity.getApplicationContext(), permission);
        if (permissionId != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(permission);
            requestPermissions(activity, permissionList.toArray(new String[permissionList.size()]), requestCode);
        }else {
            return true;
        }
        return false;
    }



}
