package dongting.bwei.com.headline;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import dongting.bwei.com.headline.bean.TuijianBean;

/**
 * 作者:${董婷}
 * 日期:2017/5/14
 * 描述:
 */

public class MyXutils {

    static RequestParams params;
    static boolean error = false;
    static String Myresult = null;

    public void get(String url) {

        params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson =new Gson();
                TuijianBean tuijianBean = gson.fromJson(result, TuijianBean.class);


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
}