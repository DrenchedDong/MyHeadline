package dongting.bwei.com.headline;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;
import com.google.gson.Gson;
import com.umeng.socialize.UMShareAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import dongting.bwei.com.headline.adapter.TabAdapter;
import dongting.bwei.com.headline.asyncTask.CatagoryAsyncTask;
import dongting.bwei.com.headline.bean.TypeBean;
import dongting.bwei.com.headline.fragment.slidingFragment.LeftFragment;
import dongting.bwei.com.headline.fragment.slidingFragment.RightFragment;
import dongting.bwei.com.headline.listener.OfflineListener;
import dongting.bwei.com.headline.utils.NetUtil;
import dongting.bwei.com.headline.utils.StringUtils;
import dongting.bwei.com.headline.view.channel.newsdrag.ChannelActivity;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener,OfflineListener{

    private ViewPager viewPager;
    private WindowManager windowmanager;
    private View view;
    private WindowManager.LayoutParams layoutParams;
    private TabLayout tabLayout;
    private ImageView iv_add;
    private SlidingMenu slidingMenu;
    private List<TypeBean.DataBeanX.DataBean> types;
    private String result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_left= (ImageView) findViewById(R.id.title_left);
        ImageView iv_right= (ImageView) findViewById(R.id.title_right);

        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);

        slidingMethod();

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        iv_add = (ImageView) findViewById(R.id.title_add);

        iv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(MainActivity.this, ChannelActivity.class));
            }
        });

        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        upwith();

        initBackgroud();
    }

    private String getTypeResult() {
        String result =null;
        try {
            boolean available = NetUtil.isNetworkAvailable(MainActivity.this);

            if(available){
                result = new CatagoryAsyncTask().execute().get();
                System.out.println(result);
                File file=new File(getCacheDir(),"typeResult.txt");

                file.delete();
                file.createNewFile();

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(file))));
                bw.write(result.toCharArray());

                bw.close();

            }else{
                File file = new File(getCacheDir(), "typeResult.txt");
                InputStream is = new FileInputStream(file);

                result = StringUtils.inputStreamToString(is);
            }

            Gson gson =new Gson();
            TypeBean typeBean = gson.fromJson(result, TypeBean.class);

            types = typeBean.getData().getData();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void initBackgroud() {
        windowmanager = (WindowManager) getSystemService(WINDOW_SERVICE);

        layoutParams = new WindowManager.LayoutParams
                (WindowManager.LayoutParams.TYPE_APPLICATION,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        PixelFormat.TRANSPARENT);
        view = new View(this);

        view.setBackgroundResource(R.color.window);
    }
//订阅
    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onMode(MainActivityEvent event){
if(event.isDay()){
    windowmanager.removeView(view);

    setTabVpBackgroundColor(event.isDay());

}else{
    windowmanager.addView(view,layoutParams);

    setTabVpBackgroundColor(event.isDay());

}
setTextColor((ViewGroup)getWindow().getDecorView(),event.isDay());
    }

    private void setTabVpBackgroundColor(boolean day) {
          if(day){
        tabLayout.setBackgroundColor(Color.WHITE);
              viewPager.setBackgroundColor(Color.WHITE);
        setWhiteMode();
    }else {
        tabLayout.setBackgroundColor(Color.BLACK);
              viewPager.setBackgroundColor(Color.BLACK);
        setNightMode();
    }
    }

    private void setWhiteMode(){
        tabLayout.setTabTextColors
                (getResources().getColor(R.color.title_color),getResources().getColor(R.color.colorAccent));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
    }
    private void setNightMode(){
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        tabLayout.setTabTextColors(getResources().getColor(R.color.textblack),getResources().getColor(R.color.title_color));
    }

    private void setTextColor(ViewGroup view,boolean day) {
for(int i=0;i<view.getChildCount();i++){
    if(view.getChildAt(i) instanceof ViewGroup){
        setTextColor((ViewGroup) view.getChildAt(i),day);
    }else if(view.getChildAt(i) instanceof TextView){
        if(day){
            ((TextView) view.getChildAt(i)).setTextColor(Color.BLACK);
        }else{
            ((TextView) view.getChildAt(i)).setTextColor(Color.WHITE);
        }
    }
}
    }

    @Override
    public String get() {

        return getTypeResult();
    }
    Gson gson =new Gson();

    private void upwith() {
        result = getTypeResult();
        TypeBean typeBean = gson.fromJson(result, TypeBean.class);
        types =    typeBean.getData().getData();
        TabAdapter tabAdapter =new TabAdapter(getSupportFragmentManager(),types);
        //tabAdapter.setOfflineListener(this);

        viewPager.setAdapter(tabAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors
                (getResources().getColor(R.color.title_color),getResources().getColor(R.color.colorAccent));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void slidingMethod() {

        slidingMenu = getSlidingMenu();

        //左边
        LeftFragment leftFragment =new LeftFragment();

       setBehindContentView(R.layout.frameleft);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameleft,leftFragment).commit();

        //左右滑动
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        //触摸边缘滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //设置阴影图片
        slidingMenu.setShadowDrawable(R.drawable.show);
        //设置阴影大小
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);

        slidingMenu.setBackgroundResource(R.drawable.login_background_introduce);

        //设置侧滑视图宽度
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置透明度
        slidingMenu.setFadeDegree(0.35f);

        RightFragment rightFragment =new RightFragment();

        slidingMenu.setSecondaryMenu(R.layout.frameright);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameright,rightFragment).commit();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_left:
                slidingMenu.showMenu();
                break;
            case R.id.title_right:
                slidingMenu.showSecondaryMenu();
                break;
        }
    }
}
