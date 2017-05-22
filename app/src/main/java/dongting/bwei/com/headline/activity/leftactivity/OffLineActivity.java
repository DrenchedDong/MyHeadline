package dongting.bwei.com.headline.activity.leftactivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.asyncTask.CatagoryAsyncTask;
import dongting.bwei.com.headline.bean.TypeBean;
import dongting.bwei.com.headline.constants.Urls;
import dongting.bwei.com.headline.fragment.slidingFragment.LeftFragment;

public class OffLineActivity extends Activity {

    private ListView listView;
    private List<String> list;
    private List<TypeBean.DataBeanX.DataBean> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_layout);

        ImageView iv=(ImageView) findViewById(R.id.offline_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                new LeftFragment().setMenuVisibility(true);
            }
        });
        listView = (ListView) findViewById(R.id.offline_listview);
        list = new ArrayList<>();

        list.add("热点");
        list.add("北京");
        list.add("汽车");
        list.add("推荐");
        list.add("科技");
        list.add("财经");
        list.add("社会");
        list.add("订阅");
        list.add("娱乐");
        list.add("国际");
        list.add("段子");
        list.add("趣图");
        list.add("搞笑");
        list.add("美女");
        list.add("健康");

        listView.setAdapter(new MyAdpager());

        try {
            String result = new CatagoryAsyncTask().execute().get();

            Gson gson =new Gson();
            TypeBean typeBean = gson.fromJson(result, TypeBean.class);
            types = typeBean.getData().getData();

        } catch (Exception e) {
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = types.get(position).getCategory();
                if(position==0){
      download(Urls.getUrl(category));
       }
            }

            private void download(String url) {
                RequestParams requestParams = new RequestParams(url);

                x.http().get(requestParams, new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String result) {

                        File file=new File(Environment.getExternalStorageDirectory(),"offline.txt");

                       // Log.e("DownloadCacheDirectory", Environment.getDownloadCacheDirectory().getAbsolutePath());
                        try {
                            file.delete();
                            file.createNewFile();

                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(file))));
                            bw.write(result.toCharArray());
                            bw.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        });
    }

    class MyAdpager extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

              convertView= View.inflate(OffLineActivity.this,R.layout.item_off_line,null);
            CheckBox checkBox= (CheckBox) convertView.findViewById(R.id.item_off_checkbox);
            TextView textView= (TextView) convertView.findViewById(R.id.off_line_textview);
          textView.setText(list.get(position));

            return convertView;
        }
    }
}
