package dongting.bwei.com.headline.asyncTask;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import dongting.bwei.com.headline.constants.Urls;
import dongting.bwei.com.headline.utils.StringUtils;

/**
 * 作者:${董婷}
 * 日期:2017/5/16
 * 描述:
 */

public class CatagoryAsyncTask extends AsyncTask<String,Object,String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url =new URL(Urls.NEWS_CATEGORY);
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
