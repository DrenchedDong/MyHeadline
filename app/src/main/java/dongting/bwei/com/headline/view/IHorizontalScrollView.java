package dongting.bwei.com.headline.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class IHorizontalScrollView extends HorizontalScrollView {

    private  ViewPager viewPager ;
    private int selectorTabIndicatorColor ;
    private int normalTextColor;
    private int selectorTextColor;

    //默认每页显示5个
    private int defaultCount = 5 ;

    private List<String> titles ;

    //  上面 显示textview ， 下面显示View
    LinearLayout linearLayoutContainer ;

    //当前 选择的位置
    private int currentIndex ;
    //下划线View 的params
    private LinearLayout.LayoutParams buttomViewlayoutParams;
    // 下划线View
    private TextView buttomTextView;


    public IHorizontalScrollView(Context context) {
        super(context);
    }

    public IHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void setupWithViewPager(ViewPager viewPager) {
        this.viewPager =viewPager ;
    }

    public void setSelectedTabIndicatorColor(int color){
        this.selectorTabIndicatorColor = color ;
    }

    public void setTabTextColors(int normalColor,int selectorColor){
        this.normalTextColor = normalColor ;
        this.selectorTextColor = selectorColor ;
    }



    public void setTitles(List<String> list){
        this.titles = list ;
    }



    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            scrollView(msg.arg1,(float)msg.obj);
        }
    } ;

    private void scrollView(int position, float offset) {

        if (offset == 0){ // 停止滚动
            buttomViewlayoutParams.setMargins(buttomViewlayoutParams.width * position,0, 0, 0);
        }
        else{
            buttomViewlayoutParams.setMargins((int) (buttomViewlayoutParams.width * (position + offset)),0, 0, 0);
        }
        buttomTextView.setLayoutParams(buttomViewlayoutParams);
    }


    //最后调用该方法  用于显示

    /**
     *
     * @param context
     * @param defaultCount
     * @throws Exception
     */
    public void setView(Activity context, int defaultCount) throws Exception{

        if(viewPager == null){
            throw new Exception("ViewPager is not") ;
        }

        if(selectorTabIndicatorColor == 0){
            throw new Exception("TabIndicatorColor is not set") ;
        }

        if(normalTextColor == 0){
            throw new Exception("normalTextColor is not set") ;
        }

        if(selectorTextColor == 0){
            throw new Exception("selectorTextColor is not set") ;
        }

        if(titles == null || titles.size() == 0){
            throw new Exception("title size is not set") ;
        }
        int screenWidth = getWindowsWidth(context);
        int itemWidth = screenWidth / defaultCount ;

        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(titles.size() * itemWidth, LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(layoutParams);

        linearLayoutContainer = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParamsContainer = new LinearLayout.LayoutParams(titles.size() * itemWidth, LayoutParams.MATCH_PARENT,1.0f);
        linearLayoutContainer.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutContainer.setLayoutParams(layoutParamsContainer);

        linearLayout.addView(linearLayoutContainer);


        buttomTextView = new TextView(context);
        buttomViewlayoutParams = new LinearLayout.LayoutParams(itemWidth, 6);
        buttomTextView.setGravity(Gravity.CENTER);
        buttomTextView.setBackgroundColor(selectorTabIndicatorColor);
        buttomTextView.setLayoutParams(buttomViewlayoutParams);
        linearLayout.addView(buttomTextView);

        addView(linearLayout);






        for(int i=0;i<titles.size();i++){

            final int current = i ;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(itemWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
            TextView textView = new TextView(context);
            textView.setTextSize(16);
            textView.setGravity(Gravity.CENTER);
            textView.getPaint().setFakeBoldText(true);
            textView.setText(titles.get(i));
            textView.setTextColor(normalTextColor);

            textView.setTag(i);
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(current);
                }
            });

            if(currentIndex == i){
                textView.setTextColor(selectorTextColor);
            }
            linearLayoutContainer.addView(textView,i,params);
        }

        //
        buttomViewlayoutParams.width=itemWidth;
        buttomViewlayoutParams.setMargins(0,0,0,0);
        buttomTextView.setLayoutParams(buttomViewlayoutParams);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Message msg=Message.obtain();
                msg.arg1=position;
                msg.obj=positionOffset;
                handler.sendMessage(msg);
            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
                setButtomViewColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


    private void setButtomViewColor(int pos){
        TextView selectorTextView = null;
        for(int i=0;i<linearLayoutContainer.getChildCount();i++){
            TextView textView = (TextView) linearLayoutContainer.getChildAt(i);
            if(i == pos){
                selectorTextView = textView;
                textView.setTextColor(selectorTextColor);
            } else {
                textView.setTextColor(normalTextColor);
            }
        }
        int left = selectorTextView.getLeft();
        int right = selectorTextView.getRight();
        int sw = getResources().getDisplayMetrics().widthPixels;
        // 将控件滚动到屏幕的中间位置
        this.scrollTo(left - sw / 2 + (right - left) / 2, 0);
    }



    //获取屏幕宽度
    public  static int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**获取屏幕高度
     * @param activity
     * @return
     */
    public  static int getWindowsHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }



}
