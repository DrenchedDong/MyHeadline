package dongting.bwei.com.headline.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.headline.bean.TuijianBean;

/**
 * 作者:${董婷}
 * 日期:2017/5/17
 * 描述:
 */

public class RecommendDao {

    private SQLiteDatabase db;
    private Cursor cursor;

    public  RecommendDao(Context context){
        TuijianOpenHelper h=new TuijianOpenHelper(context);
        db = h.getReadableDatabase();

    }

    public void add(String title,int comment,String author,int hot,int date){
        db.execSQL("insert into recommend (title,comment,author,hot,date) values (?,?,?,?,?)",new Object[]{title,comment,author,hot,date});

    }

    public List<TuijianBean.DataBean> query (){
        List<TuijianBean.DataBean> list =new ArrayList<>();
        cursor = db.query("recommend", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex("title"));
            int comment = cursor.getInt(cursor.getColumnIndex("comment"));
            String author= cursor.getString(cursor.getColumnIndex("author"));
            int hot = cursor.getInt(cursor.getColumnIndex("hot"));
            int date = cursor.getInt(cursor.getColumnIndex("date"));
            TuijianBean.DataBean data=new TuijianBean.DataBean();
            data.setTitle(title);
            data.setComment_count(comment);
            data.setMedia_name(author);
            data.setHot(hot);
            data.setPublish_time(date);
            list.add(data);
        }
        return list;
    }
    public void destory(){
        if (db!=null){
            db.close();
        }
        if (cursor!=null){
            cursor.close();
        }
    }
}
