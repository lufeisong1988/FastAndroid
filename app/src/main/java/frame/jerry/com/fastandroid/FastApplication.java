package frame.jerry.com.fastandroid;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.litepal.LitePalApplication;

/**
 * Created by lufeisong on 16/3/15.
 */
public class FastApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());
        initLitePal(getApplicationContext());
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
}
