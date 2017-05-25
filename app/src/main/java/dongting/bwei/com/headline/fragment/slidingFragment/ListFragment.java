package dongting.bwei.com.headline.fragment.slidingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.adapter.ListAdapter;
import dongting.bwei.com.headline.asyncTask.ListAsyncTask;
import dongting.bwei.com.headline.bean.TuijianBean;
import dongting.bwei.com.headline.utils.NetUtil;
import dongting.bwei.com.headline.utils.StringUtils;

/**
 * 作者:${董婷}
 * 日期:2017/5/9
 * 描述:
 */

public class ListFragment extends Fragment {

    private SpringView springView;
    private ListView listView;
    int page=3;

    private List<TuijianBean.DataBean> dataBeanList =new ArrayList<>();
    private ListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recommend,container,false);
        springView = (SpringView) view.findViewById(R.id.springview);
        listView = (ListView) view.findViewById(R.id.listview);

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
                Bundle bundle = getArguments();
                String url = bundle.getString("url");

                 s = new ListAsyncTask().execute(url).get();

            }else{
                Toast.makeText(getActivity(), "网络无连接，无法刷新", Toast.LENGTH_SHORT).show();
                    File file = new File(getActivity().getCacheDir(), "offline.txt");
                    InputStream is = new FileInputStream(file);

                s = StringUtils.inputStreamToString(is);

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