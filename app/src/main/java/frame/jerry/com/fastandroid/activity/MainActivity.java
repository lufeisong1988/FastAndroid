package frame.jerry.com.fastandroid.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import org.litepal.crud.DataSupport;

import java.util.List;

import frame.jerry.com.fastandroid.R;
import frame.jerry.com.fastandroid.model.Album;
import frame.jerry.com.fastandroid.model.Singer;

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
        iv = (ImageView) findViewById(R.id.iv);
        ImageLoader.getInstance().displayImage("http://macprovid.vo.llnwd.net/o43/hub/media/1090/6882/01_headline_Muse.jpg", iv, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                LogUtil.printLog("imageLoader started : imageUrl = " + imageUri);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                LogUtil.printLog("imageLoader failed : imageUrl = " + imageUri);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                LogUtil.printLog("imageLoader complete : imageUrl = " + imageUri);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                LogUtil.printLog("imageLoader cancell : imageUrl = " + imageUri);
            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                LogUtil.printLog("imageLoader ProgressUpdate : total = " + total + " : current = " + current);
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
        Singer singer = new Singer();
        singer.setName("周杰伦");
        singer.setAge(26);
        singer.setMale(true);
        singer.save();
        List<Album> albums = DataSupport.select("name", "price")
                .where("name=?", "周杰伦")
                .find(Album.class);
        for (Album album : albums) {
            LogUtil.printLog("album : name = " + album.getName()
                    + " ; price = " + album.getPrice()
                    + " ; sales = " + album.getSales());
            List<Singer> singers = album.getSingers();
            for (Singer singer1 : singers) {
                LogUtil.printLog("singer1 : name = " + singer1.getName()
                        + " ; age = " + singer1.getAge()
                        + " ; male = " + singer1.isMale()
                        + " ; id = " + singer1.getId());

            }
        }
    }

}
