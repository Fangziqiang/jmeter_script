package AES;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import AES.Base64Decoder;

/**
 * http://blog.csdn.net/qq_33237207/article/details/53114122
 */
public class AEStest2 {
	public static String Encrypt(String sSrc, String sKey) throws Exception {  
		 String cKey="0102030405060708";
		if (sKey == null) {  
            System.out.print("Key为空null");  
            return null;  
        }  
        // 判断Key是否为16位  
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;  
        }  
        byte[] raw = sKey.getBytes("utf-8");  
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");  
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"  
        IvParameterSpec iv = new IvParameterSpec(cKey.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度  
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);  
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());  
//        return new Base64.encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return  Base64Encoder.encode(encrypted).replaceAll("\r|\n", "");
        
    }
	
	public static String Decrypt(String sSrc, String sKey) throws Exception {
		String cKey="0102030405060708";
        try {  
            // 判断Key是否正确
            if (sKey == null) {  
                System.out.print("Key为空null");  
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }  
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
            IvParameterSpec iv = new IvParameterSpec(cKey.getBytes());  
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//            byte[] encrypted1 = new Base64Decoder (sSrc);//先用base64解密 
            byte[] encrypted1 = Base64Decoder.decodeToBytes(sSrc);

            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);  
                return originalString; 
            } catch (Exception e) {  
                System.out.println(e.toString());
                return null;  
            }  
        } catch (Exception ex) {  
            System.out.println(ex.toString());  
            return null;  
        }  
    }
	public static void main(String[] args) throws Exception {  
        /* 
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定 
         * 此处使用AES-128-CBC加密模式，key需要为16位。 
         */  
 
        // 需要加密的字串 
        String cSrc = "{\"timestamp\":\"1605424485863\",\"student_id\":\"193430\",\"testpaper_id\":\"363331\",\"course_id\":0,\"do_type\":\"classPaper\"}";
//        String cSrc = "{"timestamp":"1605424485863","student_id":"193430","testpaper_id":"363331","course_id":0,"do_type":"classPaper"}";
        System.out.println(cSrc);
        // 加密  
        long lStart = System.currentTimeMillis();
        String enString = AEStest2.Encrypt(cSrc, "F697467B14B076F2");
        System.out.println("加密后的字串是：" + enString);
        System.out.println(enString);
        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        
        String parameter="ifUKt9UzLUZaHejCkUBFPnivsqsXObTCUaEVRFnAUzoUnUmegtyCh7cDQehTfoFvHtVtTh6DRhtj6uepwTUvRPeKi6116Q5S/qfGoNNTRxYdMAB18LQDlw4q43nanKCLfYMsH/RlaevgU5+mE1luRg==";
        String decodeString=AEStest2.Decrypt(parameter, "F697467B14B076F2");
        System.out.println("解密后："+decodeString);
        
        
//        // 解密  
//        lStart = System.currentTimeMillis();
//        String DeString = AES.Decrypt(enString, cKey);
//        System.out.println("解密后的字串是：" + DeString);  
//        lUseTime = System.currentTimeMillis() - lStart;  
//        System.out.println("解密耗时：" + lUseTime + "毫秒");  
    }
}