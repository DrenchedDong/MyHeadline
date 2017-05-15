package dongting.bwei.com.headline.activity.leftactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.igexin.sdk.PushManager;

import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.services.PushIntentService;
import dongting.bwei.com.headline.utils.PreferencesUtils;

/**
 * 作者:${董婷}
 * 日期:2017/5/12
 * 描述:
 */

public class SetupActivity extends Activity {

    private CheckBox cb_pushMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_layout);

        cb_pushMessage = (CheckBox) findViewById(R.id.pushMessage);



        Boolean push = PreferencesUtils.getValueByKey(SetupActivity.this, "push", false);

        if (push == false) {

            PushManager.getInstance().turnOffPush(SetupActivity.this);
        }


        cb_pushMessage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked == false) {
                    PreferencesUtils.addConfigInfo(SetupActivity.this, "push", false);
                } else {
                    PreferencesUtils.addConfigInfo(SetupActivity.this, "push", true);
                }
            }
        });
    }
}
