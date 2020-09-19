package top.hellooooo.codereceptionserver.util;

/**
 * @Author Q
 * @Date 19/09/2020 14:50
 * @Description
 */
public class StringUtil {
    public static boolean isEmpty(String text) {
        return (text == null || text.equals(""));
    }

    public static boolean isNum(String inp) {
        if (inp.length() > 1) {
            throw new NumberFormatException(inp + " is not a char!");
        }
        char ch = inp.charAt(0);
        return (ch > '0' && ch < '9');
    }

    public static boolean isAlpha(String inp) {
        if (inp.length() > 1) {
            throw new NumberFormatException(inp + " is not a char!");
        }
        char ch = inp.charAt(0);
        return (ch > 'a' && ch < 'z') || (ch > 'A' && ch < 'Z');
    }
}
