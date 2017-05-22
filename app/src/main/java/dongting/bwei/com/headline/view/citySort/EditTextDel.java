package dongting.bwei.com.headline.view.citySort;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import dongting.bwei.com.headline.R;

/**
 * 作者:${董婷}
 * 日期:2017/5/18
 * 描述:
 */

public class EditTextDel extends EditText {
    private final static String TAG = "EditTextWithDel";
    private Drawable imgInable;
    private Drawable imgAble;
    private Context mContext;

    public EditTextDel(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public EditTextDel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    public EditTextDel(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        imgAble = mContext.getResources().getDrawable(
                R.drawable.icon_delete_gray);
        //监听 edittext 内容的变化
        addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();

            }
        });
        setDrawable();
    }

    // 设置删除图片 意思是设置Drawable显示在text的左、上、右、下位置。
    private void setDrawable() {
        if (length() < 1) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble, null);
        }
    }

    // 处理删除事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgAble != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);

            Rect rect = new Rect();
//            获取视图在屏幕坐标中的可视区域  http://www.cxyclub.cn/n/76738/
            getGlobalVisibleRect(rect);
            System.out.println("rect = " + rect);
            rect.left = rect.right - 50;
            System.out.println("rect 1 = " + rect);
            if (rect.contains(eventX, eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }

}
