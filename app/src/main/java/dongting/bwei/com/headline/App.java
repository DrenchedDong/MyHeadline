package dongting.bwei.com.headline;

import android.app.Application;

import com.igexin.sdk.PushManager;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.DbManager;
import org.xutils.x;

import dongting.bwei.com.headline.services.PushIntentService;
import dongting.bwei.com.headline.services.PushService;

/**
 * 作者:${董婷}
 * 日期:2017/5/9
 * 描述:
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UMShareAPI.get(this);
        Config.DEBUG=true;

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        initDB();

        PushManager.getInstance().initialize(this, PushService.class);

        PushManager.getInstance().registerPushIntentService(this, PushIntentService.class);


    }

    public void initDB() {

        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName("abc.db")    //设置数据库名称
                .setDbVersion(1)//数据库版本
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
// TODO: ...
                        //  数据库版本号发生了变化  走这个回调
                    }
                });
        //return daoConfig;
    }

}