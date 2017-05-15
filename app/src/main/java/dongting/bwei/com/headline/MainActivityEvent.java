package dongting.bwei.com.headline;

/**
 * 作者:${董婷}
 * 日期:2017/5/10
 * 描述:
 */

public class MainActivityEvent {
    boolean day;

    public MainActivityEvent(boolean day) {
        this.day = day;
    }

    public void setDay(boolean day) {
        this.day = day;
    }

    public boolean isDay() {
        return day;
    }
}
