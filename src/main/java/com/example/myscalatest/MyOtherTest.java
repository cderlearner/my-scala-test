package com.example.myscalatest;

import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetAddress;
import java.util.Arrays;

public class MyOtherTest {

    public static void main(String[] args) throws Exception {
        //System.out.println(toCachePrefix(USER.LOGINIPAREA));
        //System.out.println(getCacheKey(Etc.ALERT_AREA_LOCK, 1));
        //System.out.println(InetAddress.getLocalHost().getHostName());
        //System.out.println(InetAddress.getByName("xueqiudeMacBook-Pro-81.local").getHostAddress());
        //System.out.println(InetAddress.getLoopbackAddress());
        //System.out.println(8018321172L%64);
        //new MyTestExceutor().out();
        //new MyTestExceutor().out2();
        //System.out.println("1");
        System.out.println(HmacUtils.hmacSha256Hex("2", "1"));
        System.out.println(sha256_HMAC("1", "2"));
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

    public static String sha256_HMAC(String message, String secret) {
        String hash = "";
        if (StringUtils.isBlank(message)) return hash;
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = bytesToHexString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for (int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }
}
