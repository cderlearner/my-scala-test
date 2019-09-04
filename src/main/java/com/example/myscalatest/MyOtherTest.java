package com.example.myscalatest;

import java.net.InetAddress;
import java.util.Arrays;

public class MyOtherTest {

    public static void main(String[] args) throws Exception{
        //System.out.println(toCachePrefix(USER.LOGINIPAREA));
        //System.out.println(getCacheKey(Etc.ALERT_AREA_LOCK, 1));
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(InetAddress.getByName("xueqiudeMacBook-Pro-81.local").getHostAddress());
        System.out.println(InetAddress.getLoopbackAddress());
    }

    public enum USER {
        LASTLOGINDAYLOCK, LATESTNEWID, TELEPHONE, FULLTELEPHONE, ENCRYPTEDPHONE, ENCRYPTEDFULLPHONE, LOGINIP,
        LOGINIPAREA
    }

    public enum Etc {
        RECORD_ABNORMAL_LOCK,
        ALERT_DEVICE_LOCK,
        ALERT_AREA_LOCK
    }

    public static final String toCachePrefix(Enum<?> item) {
        return String.format("%s:%s:", item.getDeclaringClass().getSimpleName(), item.toString()).toLowerCase();
    }

    private static String toCachePrefixColon(Enum<?> item) {
        return String.format("%s:%s:", item.getDeclaringClass().getSimpleName(), item.toString())
                .replaceAll("_", ":").toLowerCase();
    }

    public static String getCacheKey(Enum<?> item, Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append(toCachePrefixColon(item));
        Arrays.stream(args).forEach(arg -> sb.append(arg.toString()).append(":"));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
