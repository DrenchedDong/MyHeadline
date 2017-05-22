package dongting.bwei.com.headline.activity.leftactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.view.channel.draggridview.my.MyDragGridView;

/**
 * 作者:${董婷}
 * 日期:2017/5/19
 * 描述:
 */


public class ChannelActivity extends Activity {
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acti_main);

        MyDragGridView mDragGridView = (MyDragGridView) findViewById(R.id.dragGridView);
        for (int i = 0; i < 50; i++) {
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image",R.mipmap.ic_launcher);
            itemHashMap.put("item_text", "拖 " + Integer.toString(i));
            dataSourceList.add(itemHashMap);
        }


        final SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, dataSourceList,
                R.layout.grid_item, new String[] { "item_image", "item_text" },
                new int[] { R.id.item_image, R.id.item_text });

        mDragGridView.setAdapter(mSimpleAdapter);

        mDragGridView.setOnChangeListener(new MyDragGridView.OnChanageListener() {

            @Override
            public void onChange(int from, int to) {
//                HashMap<String, Object> temp = dataSourceList.get(from);
                // 直接交互item
//              dataSourceList.set(from, dataSourceList.get(to));
//              dataSourceList.set(to, temp);
//              dataSourceList.set(to, temp);


                //这里的处理需要注意下
                if(from < to){
                    for(int i=from; i<to; i++){
                        Collections.swap(dataSourceList, i, i+1);
                    }
                }else if(from > to){
                    for(int i=from; i>to; i--){
                        Collections.swap(dataSourceList, i, i-1);
                    }
                }

                mSimpleAdapter.notifyDataSetChanged();
            }
        });

        mDragGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println("click " + position + "____" + dataSourceList.get(position).get("item_text"));

            }
        });


    }

}
