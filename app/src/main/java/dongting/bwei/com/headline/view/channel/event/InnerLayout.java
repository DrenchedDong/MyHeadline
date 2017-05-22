package dongting.bwei.com.headline.view.channel.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by muhanxi on 17/5/17.
 */

public class InnerLayout extends LinearLayout {
    public InnerLayout(Context context) {
        super(context);
    }

    public InnerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InnerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("InnerLayout ev = dispatchTouchEvent " );
        return super.dispatchTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("InnerLayout ev = onInterceptTouchEvent " );
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("InnerLayout ev = onTouchEvent " );
        return super.onTouchEvent(event);
    }
}
