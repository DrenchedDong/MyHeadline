package dongting.bwei.com.headline.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 作者:${董婷}
 * 日期:2017/5/17
 * 描述:
 */

public class TuijianOpenHelper extends SQLiteOpenHelper {
    public TuijianOpenHelper(Context context) {
        super(context, "recommend.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table recommend (id integer primary key autoincrement,title varchar(100),comment integer,author varchar(20),hot integer,date integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
