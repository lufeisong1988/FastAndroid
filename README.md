# FastAndroid
#一款快捷，高效的android开发框架
#Android-Universal-Image-Loader模块
    *多线程下载图片，图片可以来源于网络，文件系统，项目文件夹assets中以及drawable中等
    *支持随意的配置ImageLoader，例如线程池，图片下载器，内存缓存策略，硬盘缓存策略，图片显示选项以及其他的一些配置
    *支持图片的内存缓存，文件系统缓存或者SD卡缓存
    *支持图片下载过程的监听
    *根据控件(ImageView)的大小对Bitmap进行裁剪，减少Bitmap占用过多的内存
    *较好的控制图片的加载过程，例如暂停图片加载，重新开始加载图片，一般使用在ListView,GridView中，滑动过程中暂停加载图片，停止滑动的时候去加载图片
        提供在较慢的网络下对图片进行加载
#LitePal模块
#工具类
    *日志工具类L.java
    *Toast统一管理类
    *SharedPreferences封装类SPUtils
    *单位转换类 DensityUtils
    *SD卡相关辅助类 SDCardUtils
    *屏幕相关辅助类 ScreenUtils
    *App相关辅助类
    *软键盘相关辅助类KeyBoardUtils
    *网络相关辅助类 NetUtils
#EventBus模块
    *是一个发布 / 订阅的事件总线。
     这么说应该包含4个成分：发布者，订阅者，事件，总线。
     那么这四者的关系是什么呢？
     很明显：订阅者订阅事件到总线，发送者发布事件。
     大体应该是这样的关系：
     订阅者可以订阅多个事件，发送者可以发布任何事件，发布者同时也可以是订阅者。
#fastJson模块
    *遵循http://json.org标准，为其官方网站收录的参考实现之一。
    *功能qiang打，支持JDK的各种类型，包括基本的JavaBean、Collection、Map、Date、Enum、泛型。
    *无依赖，不需要例外额外的jar，能够直接跑在JDK上。
    *开源，使用Apache License 2.0协议开源。
#bugTags
    *增加一场崩溃tag的记录和上传