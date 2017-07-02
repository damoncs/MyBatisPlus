package org.aries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
    public static String trim(String s) {
        return s == null ? "" : s.trim();
    }

    public static String lineReplace(String source, String replacement) {
        source = trim(source).replaceAll("[\r\n]", replacement);
        return source;
    }

    public static String replaceToLine(String source, String regex) {
        source = trim(source).replaceAll(regex, "\n");
        return source;
    }

    public static String[] splitToArray(String src, String splitRegex) {
        return StringUtil.trim(src).split(splitRegex);
    }

    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c > Byte.MAX_VALUE) {
                unicode.append("\\u" + Integer.toHexString(c));
            } else {
                unicode.append(c);
            }
        }
        return unicode.toString();
    }

    public static String unicode2String(String unicode) {
        Pattern pattern = Pattern.compile("\\\\[uU](\\p{XDigit}{4})");
        StringBuffer str = new StringBuffer();
        Matcher matcher = pattern.matcher(unicode);
        int index = 0;
        while (matcher.find()) {
            int start = matcher.start();
            if (index < start) {
                str.append(unicode.substring(index, start));
            }
            str.append((char) Integer.parseInt(matcher.group(1), 16));
            index = matcher.end();
        }
        if (index < unicode.length()) {
            str.append(unicode.substring(index));
        }
        return str.toString();
    }

    public static String left(String value, int lenght) {
        value = StringUtil.trim(value);
        value = value.substring(0, Math.min(value.length(), lenght));
        return value;
    }
}