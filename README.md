# CommonLibrary
初始化(必须)
    CommonConfig.init(this)
    
    implementation 'com.github.mcl0505:common:1.0.1'
    
## 常用工具
1：AndroidManifestUtil  获取AndroidManifes.xml中配置的数据

2：AppExecutorsHelper 线程池封装

3：AppUtil  apk常规操作，里面有说明

4：BaseActivityManager  Activity 管理

5：BitmapUtil  图像操作

6：DateUtil  时间工具类

7：InfoVerify  信息正则验证

8：LiveDataBus  事件传递

9：LogUtil  日志打印

10：MD5Util  MD5生成

11：MmkvUtil  数据临时存储

12：ScreenUtils  屏幕操作工具

13：SdkVersionUtil  版本相关

14：SoftInputUtil  软键盘的显示与隐藏

15：StatusBarUtils  状态栏工具

16：CrashHandler  异常捕获  再Application 中使用：CrashHandler.instance.init(this)

## 常用扩展函数
1：点击事件  0.5 秒内只能点击一次  可自定义
    view.singleClick{}
    
2：视图隐藏与显示  true=显示   false=隐藏
    view.visibleOrGone(true)
    
3：if  else  代替 
    ().yes{}.no{}
    
4:吐司  Android 11 Toast的setView 被废弃，采用基础使用
    "".toast()
    
5:获取资源文件
    Int.getString()   获取String 字符串
    Int.getColor()    获取颜色
    Int.getDrawable() 获取Drawable
    Int.getStringArray()  获取数组资源
    
6：ViewModel 事件观察
      observe(mViewModel.uiXxx,{
            //这里返回对应的数据
        })

7：EditText 赋值
    EditText.setEditContent("")
    
8：文件的操作  可以阅读 FileExt.kt


