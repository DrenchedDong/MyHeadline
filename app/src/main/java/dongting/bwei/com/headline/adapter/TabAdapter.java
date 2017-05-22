package dongting.bwei.com.headline.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.gson.Gson;

import java.util.List;

import dongting.bwei.com.headline.asyncTask.CatagoryAsyncTask;
import dongting.bwei.com.headline.bean.TypeBean;
import dongting.bwei.com.headline.constants.Urls;
import dongting.bwei.com.headline.fragment.slidingFragment.ListFragment;

/**
 * 作者:${董婷}
 * 日期:2017/5/10
 * 描述:
 */

public class TabAdapter extends FragmentPagerAdapter{
    private List<TypeBean.DataBeanX.DataBean> types;

    public TabAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        try {

            String result = new CatagoryAsyncTask().execute().get();

            Gson gson =new Gson();
            TypeBean typeBean = gson.fromJson(result, TypeBean.class);
            types = typeBean.getData().getData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Fragment getItem(final int position) {

        ListFragment listFragment = new ListFragment();

        String category = types.get(position).getCategory();

        String url = Urls.getUrl(category);

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
