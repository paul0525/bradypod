package com.java.basic.tech.encrypt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *Note: Please read the code,and than copy.
 *
 *
 */
public class AESUtils {

    public static String encrypt(String content, String passwd, String iv)    {
        try {
            Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec key = new SecretKeySpec(passwd.getBytes(), "AES");
            
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
            
            aesCBC.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            byte[] result = aesCBC.doFinal(content.getBytes("GBK"));
            return new BASE64Encoder().encode( result );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e){
            e.printStackTrace();
        } catch ( UnsupportedEncodingException e ){
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String content, String passwd,String iv) {
         try {
             Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");// 创建密码器
             SecretKeySpec key = new SecretKeySpec(passwd.getBytes(), "AES");
             
             IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
             
             aesCBC.init(Cipher.DECRYPT_MODE, key, ivSpec);// 初始化
             
             byte[] result = new BASE64Decoder().decodeBuffer(content);
             return new String(aesCBC.doFinal(result),"GBK"); // 解密
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         } catch (NoSuchPaddingException e) {
             e.printStackTrace();
         } catch (InvalidKeyException e) {
             e.printStackTrace();
         } catch (IllegalBlockSizeException e) {
             e.printStackTrace();
         } catch (BadPaddingException e) {
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (InvalidAlgorithmParameterException e){
             e.printStackTrace();
         }
         return null;
     }
    
    
    public static String pwd = "abcr4234gG465356";
    public static String  myIv = "1234123412341234";
    
    public static void main(String args[]) throws UnsupportedEncodingException{
       String str = "我爱你！";
       String tempEncrypt = encrypt(str, pwd,myIv);
       System.out.println("加密后的字符串：" + encrypt(str, pwd,myIv).replace("\r\n", ""));
       
       String temp1 = decrypt( tempEncrypt, pwd, myIv);
       System.out.println("解密后的串为:"+ temp1);

     
    }
}
