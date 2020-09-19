package top.hellooooo.codereception.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import top.hellooooo.codereception.service.PasswordExpireService;

/**
 * @Author Q
 * @Date 19/09/2020 16:19
 * @Description
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, PasswordExpireService.class);
        context.startService(i);
    }
}
