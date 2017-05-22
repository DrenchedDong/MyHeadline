package dongting.bwei.com.headline.view.channel.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import dongting.bwei.com.headline.R;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("EventActivity ev = dispatchTouchEvent " );
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("EventActivity ev = onTouchEvent " );
//        getParent().requestDisallowInterceptTouchEvent(false);
        return super.onTouchEvent(event);
//        return false ;
//        return true;
    }
}
