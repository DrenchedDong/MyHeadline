package dongting.bwei.com.headline.activity.leftactivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Random;

import dongting.bwei.com.headline.R;
import dongting.bwei.com.headline.bean.LoginBean;
import dongting.bwei.com.headline.fragment.slidingFragment.LeftFragment;

public class RegisterActivity extends Activity implements View.OnClickListener{

    private EditText et_phone;
    private Button bt_next;
    private Button bt_get;
    private EditText et_code;
    private CheckBox agree;
    private EditText et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_phone = (EditText) findViewById(R.id.phone_input);
        et_code = (EditText) findViewById(R.id.code_input);
        et_pwd = (EditText) findViewById(R.id.pwd_input);

        bt_next = (Button) findViewById(R.id.register);
        bt_get = (Button) findViewById(R.id.code_get);
//同意协议
        agree = (CheckBox) findViewById(R.id.agree);
        ImageView iv=(ImageView) findViewById(R.id.register_back);

        bt_next.setOnClickListener(this);
        bt_get.setOnClickListener(this);
        iv.setOnClickListener(this);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                new LeftFragment().setMenuVisibility(true);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.code_get:
                StringBuffer sb=new StringBuffer();

                for(int i=0;i<4;i++){
                    Random random =new Random();
                    int a = random.nextInt(10);

                    sb.append(a);
                }

                et_code.setText(sb.toString());

                break;

            case R.id.register:
                String phone= et_phone.getText().toString().trim();
                String pwd=et_pwd.getText().toString().trim();

                RequestParams requestParams =new RequestParams("http://qhb.2dyt.com/Bwei/register");

                requestParams.addQueryStringParameter("phone",phone);
                requestParams.addQueryStringParameter("password",pwd);
                requestParams.addQueryStringParameter("postkey","1503d");

                x.http().get(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        //Toast.makeText(RegisterActivity.this, result , Toast.LENGTH_SHORT).show();
                        Gson gson =new Gson();
                        LoginBean loginBean = gson.fromJson(result, LoginBean.class);
                        String ret_msg = loginBean.getRet_msg();
                        Toast.makeText(RegisterActivity.this, ret_msg, Toast.LENGTH_LONG).show();

                        if(ret_msg.equals("注册成功")||ret_msg.equals("该手机号码已经注册，请直接登录")){

                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
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
                break;
        }
    }
}
