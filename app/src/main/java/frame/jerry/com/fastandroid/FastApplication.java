package frame.jerry.com.fastandroid;

import android.app.Application;
import android.content.Context;

import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.litepal.LitePalApplication;

/**
 * Created by lufeisong on 16/3/15.
 */
public class FastApplication extends Application {
    BugtagsOptions options = new BugtagsOptions.Builder().
            trackingLocation(true).//是否获取位置，默认 true
            trackingCrashLog(true).//是否收集crash，默认 true
            trackingConsoleLog(true).//是否收集console log，默认 true
            trackingUserSteps(true).//是否收集用户操作步骤，默认 true
            trackingNetworkURLFilter("(.*)").//自定义网络请求跟踪的 url 规则，默认 null
            build();
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());
        initLitePal(getApplicationContext());
        initBugtags();
    }

    /**
     * 初始化Android-Universal-Image-Loader类库
     * @param ctx
     */
    void initImageLoader(Context ctx){
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(ctx);
        config.threadPriority(Thread.NORM_PRIORITY - 1)
        .tasksProcessingOrder(QueueProcessingType.LIFO)
        .diskCacheSize(50*1024*1024)//50M
        .denyCacheImageMultipleSizesInMemory()
        .diskCacheFileNameGenerator(new Md5FileNameGenerator())
        .writeDebugLogs();
        ImageLoader.getInstance().init(config.build());
    }

    /**
     * 初始化LitPal数据库类库
     * @param ctx
     */
    void initLitePal(Context ctx){
        LitePalApplication.initialize(ctx);
    }

    /**
     * 初始化bugtags
     */
    void initBugtags(){
        Bugtags.start("d8c103ffa7d787b7fa5f8297735b65de", this, Bugtags.BTGInvocationEventNone, options);
    }
}
