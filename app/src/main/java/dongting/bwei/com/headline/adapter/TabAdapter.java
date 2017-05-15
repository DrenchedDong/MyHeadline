package dongting.bwei.com.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dongting.bwei.com.headline.fragment.slidingFragment.ListFragment;

/**
 * 作者:${董婷}
 * 日期:2017/5/10
 * 描述:
 */

public class TabAdapter extends FragmentPagerAdapter {

    String[] s= new String[]{"推荐","热点","视频","北京","社会","订阅","娱乐","图片","科技","汽车","体育","财经","军事","国际","段子","趣图","美女"};

    public TabAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        return new ListFragment();
    }

    @Override
    public int getCount() {
        return s.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return s[position];
    }
}
