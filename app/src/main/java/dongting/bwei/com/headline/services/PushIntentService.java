package dongting.bwei.com.headline.services;

import android.content.Context;
import android.util.Log;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/**
 * 继承 GTIntentService 接收来 个推的消息, 所有消息在线程中回调, 如果注册 该服务, 则务必要在 AndroidManifest中声明, 否则 法接
 受消息<br>
 * onReceiveMessageData 处 透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br> * onReceiveCommandResult 各种事件处 回执 <br> */
public class PushIntentService extends GTIntentService{
    @Override
    public void onReceiveServicePid(Context context, int i) {
        Log.e(TAG, "onReceiveServicePid -> " + "clientid = " + i);

    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        Log.e(TAG, "onReceiveMessageData -> " + "clientid = context " + context );

        Log.e(TAG, "onReceiveMessageData -> " + "clientid = " + msg.getMessageId() + "  " + msg.getPayloadId());

        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();

        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        Log.d(TAG, "call sendFeedbackMessage = " + (result ? "success" : "failed"));

        Log.d(TAG, "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null");
        } else {
            String data = new String(payload);
            Log.d(TAG, "receiver payload = " + data);

            // 测试消息为了观察数据变化
            if (data.equals("收到一条透传测试消息")) {
                data = data + "-" ;
            }
            Log.e(TAG, "onReceiveMessageData -> " + "clientid = data " + data );

        }
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean b) {
        Log.e(TAG, "onReceiveOnlineState -> " + "clientid = " + b);

    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage gtCmdMessage) {
        Log.e(TAG, "onReceiveOnlineState -> " + "clientid = " + gtCmdMessage.getAppid());

    }
}
