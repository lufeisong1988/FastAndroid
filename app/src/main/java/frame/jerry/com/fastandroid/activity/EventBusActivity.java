package frame.jerry.com.fastandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import frame.jerry.com.fastandroid.R;
import frame.jerry.com.fastandroid.eventbus.EventTest;

/**
 * Created by lufeisong on 16/3/17.
 */
public class EventBusActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        findViewById(R.id.send_eventbus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventTest("我向mainactivity发送一个主题"));
            }
        });
    }
}
