package dongting.bwei.com.headline.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import dongting.bwei.com.headline.activity.leftactivity.OffLineActivity;
import dongting.bwei.com.headline.asyncTask.CatagoryAsyncTask;
import dongting.bwei.com.headline.bean.TypeBean;
import dongting.bwei.com.headline.constants.Urls;
import dongting.bwei.com.headline.fragment.slidingFragment.ListFragment;
import dongting.bwei.com.headline.listener.OfflineListener;
import dongting.bwei.com.headline.utils.NetUtil;
import dongting.bwei.com.headline.utils.StringUtils;

/**
 * 作者:${董婷}
 * 日期:2017/5/10
 * 描述:
 */

public class TabAdapter extends FragmentPagerAdapter{

    //private OfflineListener offlineListener;
    String result;

/*
    public void setOfflineListener(OfflineListener offlineListener) {
        this.offlineListener = offlineListener;
    }*/

    private List<TypeBean.DataBeanX.DataBean> types;

    public TabAdapter(FragmentManager fragmentManager,  List<TypeBean.DataBeanX.DataBean> types){
        super(fragmentManager);
//        System.out.println(result);
        this.types=types;
     this.result=result;
    }

    @Override
    public Fragment getItem(final int position) {

        ListFragment listFragment = new ListFragment();

       // String s = offlineListener.get();
//        System.out.println(result);

        String category = types.get(position).getCategory();

        String url = Urls.getUrl(category);
        System.out.println("tab_url = " + url);

        Bundle bundle =new Bundle();
        bundle.putString("url",url);

        listFragment.setArguments(bundle);

        return listFragment;
    }

    @Override
    public int getCount() {

            return types!=null?types.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

            return types.get(position).getName();

    }
}
