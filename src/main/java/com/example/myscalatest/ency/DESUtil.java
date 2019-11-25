package com.example.myscalatest.ency;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class DESUtil {
    /*
     * 生成密钥
     */
    public static byte[] initKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }


    /*
     * DES 加密
     * data是数据
     * key是秘钥
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }


    /*
     * DES 解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(data);
        return plainBytes;
    }

    public static void main(String[] args) throws Exception {
        // byte[] desKey = DESUtil.initKey();
        // System.out.println("DES KEY : " + Hex.encodeHexString(desKey));

        String DATA = "13810522371";
        byte[] desKey = Hex.decodeHex("cd1c584fba940b9d".toCharArray());
        byte[] desResult = DESUtil.encrypt(DATA.getBytes(), desKey);
        System.out.println(DATA + "-》DES 加密结果：" + Hex.encodeHexString(desResult));

        byte[] desPlain = DESUtil.decrypt(desResult, desKey);
        System.out.println(DATA + "-》DES 解密结果：" + new String(desPlain));
    }
}
