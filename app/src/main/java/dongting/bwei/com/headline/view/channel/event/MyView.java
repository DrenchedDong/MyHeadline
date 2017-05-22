package dongting.bwei.com.headline.view.channel.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by muhanxi on 17/5/17.
 * http://blog.csdn.net/chaihuasong/article/details/17499799
 * http://waynehu16.iteye.com/blog/1926741
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("MyView ev = dispatchTouchEvent " );
        return super.dispatchTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("MyView ev = onTouchEvent " );
//        getParent().requestDisallowInterceptTouchEvent(false);
        return super.onTouchEvent(event);
//        return false ;
//        return true;
    }



}
