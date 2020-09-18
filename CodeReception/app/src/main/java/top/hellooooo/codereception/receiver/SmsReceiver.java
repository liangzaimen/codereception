package top.hellooooo.codereception.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * @Author Q
 * @Date 18/09/2020 14:00
 * @Description
 */
public class SmsReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(SMS_RECEIVED_ACTION)) {
            Bundle bundle = intent.getExtras();
            //使用pdu秘钥来提取一个pdus数组
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }

            //获取发送方号码
            String address = messages[0].getOriginatingAddress();

            //获取短信内容
            String fullMessage = "";
            for (SmsMessage message : messages) {
                fullMessage += message.getMessageBody();
            }
            System.out.println("Send :" + address + " Content:" + fullMessage);
            Toast.makeText(context, fullMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
