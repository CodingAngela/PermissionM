package com.example.permisssonm;
import static android.content.Context.POWER_SERVICE;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionUtils {

    private String name;
    public PermissionUtils(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static void requestPostNotification(Context context) {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 200);
        } else {
            Toast.makeText(context, "已经获取通知权限", Toast.LENGTH_SHORT).show();
        }
    }

    public static void requestReadPhoneState(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE}, 201);
        } else {
            Toast.makeText(context, "已经获取拨打和管理电话权限", Toast.LENGTH_SHORT).show();
        }
    }

    public static void requestAccessExternalStroage(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_MEDIA_IMAGES}, 203);
            } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_VIDEO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_MEDIA_VIDEO}, 204);
            } else {
                Toast.makeText(context, "已经获取访问图片和视频权限", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 205);
            } else {
                Toast.makeText(context, "已经获取访问图片和视频权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void requestAccessExternalAudio(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_MEDIA_AUDIO}, 206);
            } else {
                Toast.makeText(context, "已经获取访问音频权限", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 207);
            } else {
                Toast.makeText(context, "已经获取访问音频权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void requestInternet(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.INTERNET}, 208);
        } else {
            Toast.makeText(context, "已经获取网络权限", Toast.LENGTH_SHORT).show();
        }
    }

    public static void requestBodySenSorsFrontground(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BODY_SENSORS}, 209);
        } else {
            Toast.makeText(context, "已经获取身体传感器前台权限", Toast.LENGTH_SHORT).show();
        }
    }

    public static void requestBodySenSorsBackground(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "请先获取身体传感器前台权限", Toast.LENGTH_SHORT).show();
        } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS_BACKGROUND) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BODY_SENSORS_BACKGROUND}, 210);
        } else {
            Toast.makeText(context, "已经获取身体传感器后台权限", Toast.LENGTH_SHORT).show();
        }
    }

    public static void requestAccessCoarseLocation(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 211);
        } else {
            Toast.makeText(context, "已经获取模糊位置权限", Toast.LENGTH_SHORT).show();
        }
    }

    public static void requestAccessFineLocation(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "请先获取模糊位置权限", Toast.LENGTH_SHORT).show();
        } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 212);
        } else {
            Toast.makeText(context, "已经获取精准位置权限", Toast.LENGTH_SHORT).show();
        }
    }


    public static void requestIgnoreBatteryOptimization(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(POWER_SERVICE);
        boolean hasIgnored = powerManager.isIgnoringBatteryOptimizations(context.getPackageName());

        if (!hasIgnored) {
            Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            if (intent.resolveActivity(context.getPackageManager()) != null){
                context.startActivity(intent);
            }
        } else {
            Toast.makeText(context, "已经忽略电池优化", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingIgnoreBatteryOptimization(Context context) {
        if (Build.BRAND.equals("OnePlus") || Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            boot_intent.addCategory(Intent.CATEGORY_DEFAULT);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingAppDrawOverlay(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("oplus.intent.action.settings.MANAGE_APP_OVERLAY_PERMISSION");
//          boot_intent.setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
//          ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/com.android.settings.Settings.OverlaySettingsActivity");
//          boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$AppDrawOverlaySettingsActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingUsageAccess(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.USAGE_ACCESS_SETTINGS");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(boot_intent);

        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$UsageAccessSettingsActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingAccessibility(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.ACCESSIBILITY_SETTINGS");
//          boot_intent.setAction("android.settings.ACCESSIBILITY_SETTINGS_FOR_SUW");
//          boot_intent.setAction("com.android.settings.ACCESSIBILITY_COLOR_SPACE_SETTINGS");
//          boot_intent.setAction("android.settings.CAPTIONING_SETTINGS");
//          boot_intent.setAction("com.android.settings.TTS_SETTINGS");
//          boot_intent.setAction("android.settings.REWARD_ACCESSIBILITY_SETTINGS");
//          ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/com.oplus.settings.feature.accessibility.AccessibilityServiceWarningExActivity");
//          boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
//          boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);

        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$AccessibilitySettingsActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingAppDetails(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//            boot_intent.setAction("android.settings.APPLICATION_SETTINGS");
//            boot_intent.setAction("android.settings.PICTURE_IN_PICTURE_SETTINGS");
//            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/com.android.settings.applications.InstalledAppDetailsTop");
//            boot_intent.setComponent(componentName);
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.applications.InstalledAppDetails");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingManageWriteSetting(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.action.MANAGE_WRITE_SETTINGS");
//            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/com.android.settings.applications.InstalledAppDetailsTop");
//            boot_intent.setComponent(componentName);
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$AppWriteSettingsActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingManageAppExternalSources(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            boot_intent.setAction("android.settings.ALL_APPS_NOTIFICATION_SETTINGS");
            boot_intent.setAction("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$ManageAppExternalSourcesActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingNotificationAccessSettings(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$NotificationAccessSettingsActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingNotificationAppList(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.ALL_APPS_NOTIFICATION_SETTINGS");
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$NotificationAppListActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingNetworkDashboard(Context context) {
        if (Build.BRAND.equals("OnePlus")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boot_intent.setAction("android.settings.WIRELESS_SETTINGS");
            context.startActivity(boot_intent);
        } else if (Build.BRAND.equals("google")) {
            Intent boot_intent = new Intent();
            boot_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = ComponentName.unflattenFromString("com.android.settings/.Settings$NetworkDashboardActivity");
            boot_intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            boot_intent.setComponent(componentName);
            context.startActivity(boot_intent);
        } else {
            Toast.makeText(context, "待实现", Toast.LENGTH_SHORT).show();
        }
    }

    public static void settingScheduleExactAlarms(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if(alarmManager.canScheduleExactAlarms()) {
                Toast.makeText(context, "可以设置精准时间事件", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                context.startActivity(intent);
            }
        }
    }


}

