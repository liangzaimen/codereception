package top.hellooooo.codereception;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import top.hellooooo.codereception.activity.BaseActivity;
import top.hellooooo.codereception.util.SMSUtil;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends BaseActivity {

    private TextView textView;

    private EditText editText;


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.tx_view);
        editText = findViewById(R.id.view_edit);
    }

    @Override
    protected void initData() {
        myRequetPermission();
        textView.setOnClickListener(view -> {
            String phoneNum = SMSUtil.getPhoneNum(mContext);
//            返回的手机号为空，要求输入
            if (phoneNum.equals("")) {

            }
            showToast(phoneNum);
        });
    }


    private static final int NOT_NOTICE = 2;//如果勾选了不再询问
    private AlertDialog alertDialog;
    private AlertDialog mDialog;

    private void myRequetPermission() {
        showToast("We need SMS Read/Write and STORAGE READ/Write permissions to make sure the application runs well");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 1);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {//选择了“始终允许”
                    Toast.makeText(this, "" + "Permission" + permissions[i] + "application successful", Toast.LENGTH_SHORT).show();
                } else {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])){//用户选择了禁止不再询问

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("permission")
                                .setMessage("We need SMS Read/Write and STORAGE READ/Write permissions to make sure the application runs well")
                                .setPositiveButton("Setting", (dialog, id) -> {
                                    if (mDialog != null && mDialog.isShowing()) {
                                        mDialog.dismiss();
                                    }
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", getPackageName(), null);//注意就是"package",不用改成自己的包名
                                    intent.setData(uri);
                                    startActivityForResult(intent, NOT_NOTICE);
                                });
                        mDialog = builder.create();
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.show();

                    }else {//选择禁止
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("permission")
                                .setMessage("We need SMS Read/Write and STORAGE READ/Write permissions to make sure the application runs well")
                                .setPositiveButton("Setting", (dialog, id) -> {
                                    if (alertDialog != null && alertDialog.isShowing()) {
                                        alertDialog.dismiss();
                                    }
                                    ActivityCompat.requestPermissions(MainActivity.this,
                                            new String[]{Manifest.permission.READ_SMS}, 1);
                                });
                        alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.show();
                    }

                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==NOT_NOTICE){
            myRequetPermission();//由于不知道是否选择了允许所以需要再次判断
        }
    }

}