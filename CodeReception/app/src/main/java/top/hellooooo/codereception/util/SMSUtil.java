package top.hellooooo.codereception.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author Q
 * @Date 17/09/2020 14:54
 * @Description
 */
public class SMSUtil {

    /**
     * content://sms/               所有短信
     * content://sms/inbox        收件箱
     * content://sms/sent          已发送
     * content://sms/draft         草稿
     * content://sms/outbox     发件箱
     * content://sms/failed       发送失败
     * content://sms/queued    待发送列表
     */
    final static String SMS_URI_ALL = "content://sms/";
    /**
     * 关于content://sms/inbox表，大致包含的域有：
     * _id | 短消息序号 如100
     * thread_id | 对话的序号 如100
     * address | 发件人地址，手机号.如+8613811810000
     * person　| 发件人，返回一个数字就是联系人列表里的序号，陌生人为null
     * date | 日期  long型。如1256539465022
     * protocol | 协议 0 SMS_RPOTO, 1 MMS_PROTO
     * read | 是否阅读 0未读， 1已读
     * status | 状态 -1接收，0 complete, 64 pending, 128 failed
     * type | 类型 1是接收到的，2是已发出
     * body | 短消息内容
     * service_center | 短信服务中心号码编号。如+8613800755500
     */
    final static String SMS_URI_INBOX = "content://sms/inbox";
    final static String SMS_URI_SEND = "content://sms/sent";
    final static String SMS_URI_DRAFT = "content://sms/draft";
    final static String SMS_URI_OUTBOX = "content://sms/outbox";
    final static String SMS_URI_FAILED = "content://sms/failed";
    final static String SMS_URI_QUEUED = "content://sms/queued";

    /**
     * 尝试获取手机号码
     * @param context
     * @return 返回获取到的手机号码，或者空字符串
     */
    public static String getPhoneNum(Context context) {
        Uri SMS_INBOX = Uri.parse(SMS_URI_INBOX);
        String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};
        Cursor cursor = context.getContentResolver().query(SMS_INBOX, projection, null, null, "date desc");
        StringBuilder smsBuilder = new StringBuilder();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                // get internal SMS
                int indexAddress = cursor.getColumnIndex("address");
                int indexPerson = cursor.getColumnIndex("person");
                int indexBody = cursor.getColumnIndex("body");
                int indexDate = cursor.getColumnIndex("date");
                int indexType = cursor.getColumnIndex("type");
                do {
                    String strAddress = cursor.getString(indexAddress);
                    if (strAddress == null || strAddress.equals("")) {
                        continue;
                    } else {
                        return strAddress;
                    }
//                    String strBody = cursor.getString(indexBody);
//                    long longDate = cursor.getLong(indexDate);
//                    int intType = cursor.getInt(indexType);
//                    // format time
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                    Date d = new Date(longDate);
//                    String strDate = dateFormat.format(d);
//
//                    // format the content
//                    String strType = "";
//                    if (intType == 1) {
//                        strType = "receive";
//                    } else if (intType == 2) {
//                        strType = "send";
//                    } else {
//                        strType = "null";
//                    }
//
//                    smsBuilder.append("[ ");
//                    smsBuilder.append(strAddress).append(", ");
//                    smsBuilder.append(intPerson).append(", ");
//                    smsBuilder.append(strBody).append(", ");
//                    smsBuilder.append(strDate).append(", ");
//                    smsBuilder.append(strType);
//                    smsBuilder.append(" ]\n\n");
                } while (cursor.moveToNext());
            }
        }
        return "";
    }

    public static void getMessageOfInbox(){

    }


    /**
     * 发送短信
     * @param receive
     * @param contentText
     */
    public static void sendMessage(String receive, String contentText) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(receive, null, contentText, null, null);
    }
}
