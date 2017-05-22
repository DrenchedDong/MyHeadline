package dongting.bwei.com.headline.activity.leftactivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import dongting.bwei.com.headline.MainActivity;
import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.bean.LoginBean;
import dongting.bwei.com.headline.fragment.slidingFragment.LeftFragment;

public class LoginActivity extends Activity {

    private Button register;
    private Button login;
    private EditText username;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        ImageView iv=(ImageView) findViewById(R.id.login_back);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                new LeftFragment().setMenuVisibility(true);
            }
        });

     login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          gotoLogin();
        }
    });


    register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gotoRegister();
        }
    });
    }



    private void gotoLogin() {
          String eusername =username.getText().toString();
         String epwd= pwd.getText().toString();
        //http://qhb.2dyt.com/Bwei/login?username=13934722940&password=123&postkey=1503d
        RequestParams requestParams=new RequestParams("http://qhb.2dyt.com/Bwei/login");
 requestParams.addQueryStringParameter("username",eusername);
 requestParams.addQueryStringParameter("password",epwd);
 requestParams.addQueryStringParameter("postkey","1503d");

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson =new Gson();
                LoginBean loginBean = gson.fromJson(result, LoginBean.class);
         loginBean.getRet_msg();
                Toast.makeText(LoginActivity.this, loginBean.getRet_msg(), Toast.LENGTH_SHORT).show();
      if(loginBean.getRet_msg().equals("登录成功")){
          startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
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


    private void gotoRegister() {
  startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

    }
}
