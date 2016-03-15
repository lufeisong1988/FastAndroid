package frame.jerry.com.fastandroid;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by lufeisong on 16/3/15.
 */
public class FastApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());
    }

    /**
     * 初始化Android-Universal-Image-Loader
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
}
