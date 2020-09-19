package top.hellooooo.codereceptionserver.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Q
 * @Date 19/09/2020 14:47
 * @Description
 */
public class MessagePhaser {

    /**
     * 在给出的字符串中，获取第一个出现的账号以及密码
     * @param text
     * @param pattern
     * @return
     */
    public static Date parseDate(String text, String pattern) {
        if (StringUtil.isEmpty(text)) {
            throw new NullPointerException("Input text is empty!");
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
//            碰到数字直接截取之后几位
            if (StringUtil.isNum(text.substring(i, i + 1))) {
                if (i + pattern.length() > text.length()) {
                    return null;
                }
                stringBuffer.append(text, i, i + pattern.length());
                try {
                    Date date = parseStringToDate(stringBuffer.toString(), pattern);
                    return date;
                } catch (ParseException e) {
//                    不是日期，继续
                    stringBuffer.delete(0, stringBuffer.length());
                    continue;
                }
            }
        }
        System.out.println(stringBuffer.toString());
        return null;
    }

    private static Date parseStringToDate(String inp, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parse = simpleDateFormat.parse(inp);
        return parse;
    }

    /**
     * 从字符串中读取出密码
     * @param text
     * @param length
     * @return
     */
    public static String parsePassword(String text, int length) {
        if (StringUtil.isEmpty(text)) {
            throw new NullPointerException("Input text is empty!");
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
//            碰到数字直接截取之后几位
            if (StringUtil.isNum(text.substring(i, i + 1))) {
                if (i + length > text.length()) {
                    return null;
                }
                int isRight = 0;
                stringBuffer.append(text, i, i + length);
                for (int i1 = 0; i1 < length; i1++) {
                    if (StringUtil.isNum(stringBuffer.substring(i1, i1 + 1))) {
                        isRight ++;
                    }
                }
                if (isRight == length) {
                    return stringBuffer.toString();
                }
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
        return null;
    }

}
