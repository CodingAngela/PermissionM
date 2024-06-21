package com.example.permisssonm;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PermissionUtils> permissionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPermission();
        PermissionAdapter adapter = new PermissionAdapter(MainActivity.this, R.layout.permission_item, permissionList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PermissionUtils permissionUtils = permissionList.get(position);
//                Toast.makeText(MainActivity.this, permission.getName(), Toast.LENGTH_SHORT).show();
                switch (permissionUtils.getName()) {
                    case "获取发送通知权限":
                        PermissionUtils.requestPostNotification(MainActivity.this);
                        break;
                    case "获取读取通话状态和移动网络信息权限":
                        PermissionUtils.requestReadPhoneState(MainActivity.this);
                        break;
                    case "获取访问照片和视频权限":
                        PermissionUtils.requestAccessExternalStroage(MainActivity.this);
                        break;
                    case "获取访问音频文件权限":
                        PermissionUtils.requestAccessExternalAudio(MainActivity.this);
                        break;
                    case "获取前台使用身体传感器权限":
                        PermissionUtils.requestBodySenSorsFrontground(MainActivity.this);
                        break;
                    case "获取后台使用身体传感器权限":
                        PermissionUtils.requestBodySenSorsBackground(MainActivity.this);
                        break;
                    case "获取模糊位置信息权限":
                        PermissionUtils.requestAccessCoarseLocation(MainActivity.this);
                        break;
                    case "获取精准位置信息权限":
                        PermissionUtils.requestAccessFineLocation(MainActivity.this);
                        break;
                    case "获取使用网络权限":
                        PermissionUtils.requestInternet(MainActivity.this);
                        break;
                    case "获取忽略电池优化权限":
                        PermissionUtils.requestIgnoreBatteryOptimization(MainActivity.this);
                        break;
                    case "设置电池优化":
                        PermissionUtils.settingIgnoreBatteryOptimization(MainActivity.this);
                        break;
                    case "设置悬浮窗":
                        PermissionUtils.settingAppDrawOverlay(MainActivity.this);
                        break;
                    case "设置允许查看应用使用情况":
                        PermissionUtils.settingUsageAccess(MainActivity.this);
                        break;
                    case "设置无障碍功能":
                        PermissionUtils.settingAccessibility(MainActivity.this);
                        break;
                    case "设置应用详情":
                        PermissionUtils.settingAppDetails(MainActivity.this);
                        break;
                    case "设置允许修改系统权限":
                        PermissionUtils.settingManageWriteSetting(MainActivity.this);
                        break;
                    case "设置允许安装来自此来源的应用":
                        PermissionUtils.settingManageAppExternalSources(MainActivity.this);
                        break;
                    case "设置设备和应用通知":
                        PermissionUtils.settingNotificationAccessSettings(MainActivity.this);
                        break;
                    case "设置通知和状态栏管理":
                        PermissionUtils.settingNotificationAppList(MainActivity.this);
                        break;
                    case "设置无线和网络":
                        PermissionUtils.settingNetworkDashboard(MainActivity.this);
                        break;
                    case "设置允许精准事件闹钟提醒":
                        PermissionUtils.settingScheduleExactAlarms(MainActivity.this);
                        break;
                    case "启动前台服务":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            PermissionUtils.requestPostNotification(MainActivity.this);
                        }
                        Intent intent = new Intent(MainActivity.this, ForegroundService.class);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            startForegroundService(intent);
                        } else {
                            startService(intent);
                        }

                    default:

                }
            }
        });


    }

    private void initPermission() {
        PermissionUtils p1 = new PermissionUtils("获取发送通知权限");
        permissionList.add(p1);
        PermissionUtils p2 = new PermissionUtils("获取读取通话状态和移动网络信息权限");
        permissionList.add(p2);
        PermissionUtils p3 = new PermissionUtils("获取访问照片和视频权限");
        permissionList.add(p3);
        PermissionUtils p18 = new PermissionUtils("获取访问音频文件权限");
        permissionList.add(p18);
        PermissionUtils p19 = new PermissionUtils("获取前台使用身体传感器权限");
        permissionList.add(p19);
        PermissionUtils p20 = new PermissionUtils("获取后台使用身体传感器权限");
        permissionList.add(p20);
        PermissionUtils p21 = new PermissionUtils("获取模糊位置信息权限");
        permissionList.add(p21);
        PermissionUtils p22 = new PermissionUtils("获取精准位置信息权限");
        permissionList.add(p22);

        PermissionUtils p4 = new PermissionUtils("获取使用网络权限");
        permissionList.add(p4);
        PermissionUtils p5 = new PermissionUtils("获取忽略电池优化权限");
        permissionList.add(p5);
        PermissionUtils p6 = new PermissionUtils("设置电池优化");
        permissionList.add(p6);
        PermissionUtils p7 = new PermissionUtils("设置悬浮窗");
        permissionList.add(p7);
        PermissionUtils p8 = new PermissionUtils("设置允许查看应用使用情况");
        permissionList.add(p8);
        PermissionUtils p9 = new PermissionUtils("设置无障碍功能");
        permissionList.add(p9);
        PermissionUtils p10 = new PermissionUtils("设置应用详情");
        permissionList.add(p10);
        PermissionUtils p11 = new PermissionUtils("设置允许修改系统权限");
        permissionList.add(p11);
        PermissionUtils p12 = new PermissionUtils("设置允许安装来自此来源的应用");
        permissionList.add(p12);
        PermissionUtils p13 = new PermissionUtils("设置设备和应用通知");
        permissionList.add(p13);
        PermissionUtils p14 = new PermissionUtils("设置通知和状态栏管理");
        permissionList.add(p14);
        PermissionUtils p15 = new PermissionUtils("设置无线和网络");
        permissionList.add(p15);
        PermissionUtils p16 = new PermissionUtils("设置允许精准事件闹钟提醒");
        permissionList.add(p16);
        PermissionUtils p17 = new PermissionUtils("启动前台服务");
        permissionList.add(p17);

    }
}