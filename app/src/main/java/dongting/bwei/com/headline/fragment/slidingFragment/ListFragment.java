package dongting.bwei.com.headline.fragment.slidingFragment;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.adapter.ListAdapter;
import dongting.bwei.com.headline.asyncTask.ListAsyncTask;
import dongting.bwei.com.headline.bean.TuijianBean;
import dongting.bwei.com.headline.dao.RecommendDao;
import dongting.bwei.com.headline.utils.NetUtil;

/**
 * 作者:${董婷}
 * 日期:2017/5/9
 * 描述:
 */

public class ListFragment extends Fragment {

    private SpringView springView;
    private ListView listView;
    private String url;
    int page=3;

    private List<TuijianBean.DataBean> dataBeanList =new ArrayList<>();
    private ListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recommend,container,false);
        springView = (SpringView) view.findViewById(R.id.springview);
        listView = (ListView) view.findViewById(R.id.listview);

        Bundle bundle = getArguments();
        url = bundle.getString("url");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData(true,0,page);

        springView.setHeader(new DefaultHeader(getActivity()));
        springView.setFooter(new DefaultFooter(getActivity()));

        springView.setType(SpringView.Type.FOLLOW);

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {

                dataBeanList.clear();

               initData(true,0,page);

                listAdapter.notifyDataSetChanged();

                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {

                page++;
                initData(false,page,page+3);

                springView.onFinishFreshAndLoad();
            }
        });
    }

    private void initData(boolean refresh,int start,int end) {

        try {
            boolean available = NetUtil.isNetworkAvailable(getActivity());

            String s=null;

            if(available){
                 s = new ListAsyncTask().execute(url).get();
            }else{
                    File file = new File(Environment.getExternalStorageDirectory(), "offline.txt");
                    InputStream is = new FileInputStream(file);

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    s= br.readLine();
            }

            Gson gson =new Gson();
            TuijianBean tuijianBean = gson.fromJson(s, TuijianBean.class);
            List<TuijianBean.DataBean> dataBean = tuijianBean.getData();
            dataBeanList.addAll(dataBean);

            if(refresh){
                listAdapter = new ListAdapter(dataBeanList,getActivity());
                listView.setAdapter(listAdapter);
            }else{
                listAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}