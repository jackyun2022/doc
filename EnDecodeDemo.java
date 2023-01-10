package com.notes.java.endecode;

import java.util.Base64;

/**
 * 文件描述 加密解密方式
 **/
public class EnDecodeDemo {

    public static void main(String[] args) {
        //DES对称加密/解密
        //要求key至少长度为8个字符
        String key = "a4r!44MEVLgAKer_j!8WFqJDxvWqweEjFRXKREcc48G!MGWpx4@vQkhzhQfqfagTWw-T8f*jf!xaecrVPKsTsjUef3o!Q26*YrRc";
        //加密
        byte[] encode_bytes = EnDecoderUtil.DESEncrypt(key, "");
        System.out.println(Base64.getEncoder().encodeToString(encode_bytes));
        //解密
        byte[] decode_bytes = EnDecoderUtil.DESDecrypt(key, encode_bytes);
        System.out.println(new String(decode_bytes));

    }
}
