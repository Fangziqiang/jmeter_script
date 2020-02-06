Android APP的常见概念

# 获取APP的信息

## APP信息

- 获取当前界面元素：adb shell dumpsys activity top
- 获取任务列表：adb shell dumpsys activity activities 

## App入口

- ```
  adb logcat |grep -i Displayed
  ```

  windows使用findstr替代grep
  
- ```
  aapt dump badging mobike.apk |grep launchable-activity
  ```

- ```
  apkanalyzer最新版本的sdk中才有
  ```

## 启动应用

- adb shell am start -W -n com.xueqiu.android/.view.WelcomeActivityAlias -S

  am：avtivity manager 管理应用活动

  -S：启动前先杀掉某个进程

  





