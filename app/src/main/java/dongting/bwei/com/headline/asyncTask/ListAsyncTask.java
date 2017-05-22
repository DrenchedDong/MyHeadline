package dongting.bwei.com.headline.asyncTask;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import dongting.bwei.com.headline.bean.TuijianBean;
import dongting.bwei.com.headline.constants.Urls;
import dongting.bwei.com.headline.utils.StringUtils;

/**
 * 作者:${董婷}
 * 日期:2017/5/17
 * 描述:
 */

public class ListAsyncTask extends AsyncTask<String,Object,String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String p=params[0];
        try {
            URL url =new URL(p);
            HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();

            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.setReadTimeout(5000);
            httpUrlConnection.setConnectTimeout(5000);

            InputStream inputStream = httpUrlConnection.getInputStream();
            String s = StringUtils.inputStreamToString(inputStream);

            return  s;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
