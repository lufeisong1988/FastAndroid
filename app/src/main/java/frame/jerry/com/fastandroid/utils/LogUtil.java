package frame.jerry.com.fastandroid.utils;

import android.util.Log;

/**
 * Created by lufeisong on 15/12/1.
 * 全局打印log
 */
public class LogUtil {
    private static boolean debug = true;

    public final static String TAG = "FastAndroid";
    public static void printLog(String log){
        if(debug)
            Log.i(TAG, log);
    }
    public static void printLog(String tag,String log){
        if(debug)
             Log.i(tag, log);
    }

}
