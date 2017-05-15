package dongting.bwei.com.headline.fragment.slidingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.headline.R;

/**
 * 作者:${董婷}
 * 日期:2017/5/9
 * 描述:
 */

public class ListFragment extends Fragment {

    private SpringView springView;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_layout,container,false);
        springView = (SpringView) view.findViewById(R.id.springview);
        listView = (ListView) view.findViewById(R.id.listview);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        springView.setHeader(new DefaultHeader(getActivity()));
        springView.setFooter(new DefaultFooter(getActivity()));

        springView.setType(SpringView.Type.FOLLOW);

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //System.out.println("\"onRefresh\" = " + "onRefresh");
                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                //System.out.println("\"onLoadmore\" = " + "onLoadmore");
                springView.onFinishFreshAndLoad();
            }
        });
    }
}
