package frame.jerry.com.fastandroid.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.litepal.crud.DataSupport;

import java.util.List;

import frame.jerry.com.fastandroid.R;
import frame.jerry.com.fastandroid.eventbus.EventTest;
import frame.jerry.com.fastandroid.model.Album;
import frame.jerry.com.fastandroid.utils.LogUtils;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .showImageForEmptyUri(0)
            .showImageOnFail(0)
            .showImageOnLoading(0)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        iv = (ImageView) findViewById(R.id.iv);
        ImageLoader.getInstance().displayImage("http://macprovid.vo.llnwd.net/o43/hub/media/1090/6882/01_headline_Muse.jpg", iv, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
            }
        });
//        Album album = new Album();
//        album.setName("张学友");
//        album.setPrice(129.9);
//        album.setPublisher("传媒公司");
//        album.setSales(70);
//        album.setSerial("xueyou");
//        album.save();
//        Album album2 = new Album();
//        album2.setName("蔡依林");
//        album2.setPrice(129.9);
//        album2.setPublisher("传媒公司");
//        album2.setSales(70);
//        album2.setSerial("jolin");
//        album2.save();
//        Singer singer = new Singer();
//        singer.setName("周杰伦");
//        singer.setAge(26);
//        singer.setMale(true);
//        singer.save();
        List<Album> albums = DataSupport.findAll(Album.class,true);
//        for (Album album : albums) {
//            LogUtils.i("album : name = " + album.getName()
//                    + " ; price = " + album.getPrice()
//                    + " ; sales = " + album.getSales());
//            List<Singer> singers = album.getSingers();
//            for (Singer singer1 : singers) {
//                LogUtils.i("singer1 : name = " + singer1.getName()
//                        + " ; age = " + singer1.getAge()
//                        + " ; male = " + singer1.isMale()
//                        + " ; id = " + singer1.getId());
//
//            }
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                    MainActivity.this.startActivity(new Intent(MainActivity.this, EventBusActivity.class));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        String JSON2String = JSON.toJSONString(albums);
        LogUtils.i("JSON2String = " + JSON2String + "\n\n");
        List<Album> String2JSONArray = JSON.parseArray(JSON2String, Album.class);
//        for (Album album : String2JSONArray) {
//            LogUtils.i("String2JSONArray = " + album.getId() + " ; "
//                    + album.getName() + " ; "
//                    + album.getPrice() + " ; "
//                    + album.getPublisher() + " ; "
//                    + album.getSerial() + " ; "
//                    + album.getRelease());
//        }
        Album album = JSON.parseObject(JSON.toJSONString(String2JSONArray.get(0)),Album.class);
        LogUtils.i("String2JSONArray = " + album.getId() + " ; "
                + album.getName() + " ; "
                + album.getPrice() + " ; "
                + album.getPublisher() + " ; "
                + album.getSerial() + " ; "
                + album.getRelease());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe//必须申明
    public void onEvent(EventTest event) {
        LogUtils.i(event.getTitle());

    }
}
