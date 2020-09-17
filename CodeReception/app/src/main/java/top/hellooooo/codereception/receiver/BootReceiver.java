package top.hellooooo.codereception.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import top.hellooooo.codereception.service.PasswordExpireService;

/**
 * @Author Q
 * @Date 17/09/2020 15:12
 * @Description
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        可以在这里干相干的事
        Toast.makeText(context, "CodeReception", Toast.LENGTH_SHORT).show();
//        启动服务
        context.startService(new Intent(context, PasswordExpireService.class));
    }
}
