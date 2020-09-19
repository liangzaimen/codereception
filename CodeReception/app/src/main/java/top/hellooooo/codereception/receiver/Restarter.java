package top.hellooooo.codereception.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import top.hellooooo.codereception.service.PasswordExpireService;

public class Restarter extends BroadcastReceiver {

    private static final String TAG = "Restarter";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Broadcast Listened", "Service tried to stop");
        Toast.makeText(context, "Service restarted", Toast.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, PasswordExpireService.class));
        } else {
            context.startService(new Intent(context, PasswordExpireService.class));
        }

    }

}