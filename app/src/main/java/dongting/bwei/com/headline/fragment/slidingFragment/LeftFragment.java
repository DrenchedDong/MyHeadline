package dongting.bwei.com.headline.fragment.slidingFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kyleduo.switchbutton.SwitchButton;

import org.greenrobot.eventbus.EventBus;

import dongting.bwei.com.headline.MainActivityEvent;
import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.activity.leftactivity.LoginActivity;
import dongting.bwei.com.headline.activity.leftactivity.SetupActivity;
import dongting.bwei.com.headline.constants.Constants;
import dongting.bwei.com.headline.utils.PreferencesUtils;

/**
 * 作者:${董婷}
 * 日期:2017/5/9
 * 描述:
 */

public class LeftFragment extends Fragment implements View.OnClickListener{

    private View view;
    private TextView tv_more;
    private LinearLayout setup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.leftfragment,container,false);
        tv_more = (TextView) view.findViewById(R.id.more);
        setup = (LinearLayout) view.findViewById(R.id.setup);

        tv_more.setOnClickListener(this);
        setup.setOnClickListener(this);


        initView(view);

        return view;
    }

    private void initView(View view) {

        SwitchButton switchButton = (SwitchButton) view.findViewById(R.id.switch_btn);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean mode =  PreferencesUtils.getValueByKey(getContext(), Constants.isNightMode,isChecked);
                setMode(isChecked);
                //发送消息
                EventBus.getDefault().post(new MainActivityEvent(isChecked));

                setBackground(isChecked);

            }
        });

    }

    private void setBackground(boolean white){

        if(white){
            view.setBackgroundColor(Color.WHITE);
        } else {
            //夜间
            view.setBackgroundColor(Color.BLACK);
        }
    }


    // mode true 夜 false 日
    private void setMode(boolean mode){
        PreferencesUtils.addConfigInfo(getContext(), Constants.isNightMode,mode);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more:
                jump();
                break;
            case R.id.setup:
               startActivity(new Intent(getActivity(), SetupActivity.class));
                break;
        }
    }

    private void jump() {
startActivity(new Intent(getActivity(), LoginActivity.class));

    }
}
