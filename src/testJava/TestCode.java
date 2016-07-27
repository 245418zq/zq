 package testJava;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
public class TestCode{
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static byte[] initSecretKey() {
        //返回生成指定算法的秘密密钥的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        //初始化此密钥生成器，使其具有确定的密钥大小
        //AES 要求密钥长度为 128
        kg.init(128);
        //生成一个密钥
        SecretKey  secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }
    private static Key toKey(byte[] key){
        //生成密钥
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }
    public static byte[] encrypt(byte[] data,Key key) throws Exception{
        return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }
    public static byte[] encrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }
    public static byte[] decrypt(byte[] data,Key key) throws Exception{
        return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }
    public static byte[] decrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }
    private static String  showByteArray(byte[] data){
        if(null == data){
            return null;
        }
        StringBuilder sb = new StringBuilder("{");
        for(byte b:data){
            sb.append(b).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
    private static byte[] tobyte(String str){
    	if(StringUtils.isBlank(str)){
    		return null;
    	}
    	str = str.substring(1,str.length()-1);
    	String[] strArr = str.split(",");
    	byte[] b = new byte[strArr.length];
    	for(int i=0;i<strArr.length;i++){
    		b[i]=Byte.parseByte(strArr[i]);
    	}
    	return b;
    }
    public static void main(String[] args) throws Exception {
//        byte[] key = initSecretKey();
    	String ss = "{58,122,80,77,-100,51,-35,-45,-90,89,-49,114,22,3,-109,-93}";
    	byte[] key = tobyte(ss);
//        System.out.println("key："+showByteArray(key));
        Key k = toKey(key);
        String data ="SS563uf556kllaADWC";
//        System.out.println("加密前数据: string:"+data);
//        System.out.println("加密前数据: byte[]:"+showByteArray(data.getBytes()));
//        System.out.println();
        byte[] encryptData = encrypt(data.getBytes(), k);
//        System.out.println("加密后数据: byte[]:"+showByteArray(encryptData));
        System.out.println();
//        System.out.println("加密后数据: hexStr:"+Hex.encodeHexStr(encryptData));
        String s = URLEncoder.encode(showByteArray(encryptData),"utf-8");
        System.out.println(s);
//        byte[] decryptData = decrypt(encryptData, k);
//        System.out.println("解密后数据: byte[]:"+showByteArray(decryptData));
//        System.out.println("解密后数据: string:"+new String(decryptData));
        String s1 = ""+URLDecoder.decode(s, "utf-8");
//        System.out.println(s1);
        byte[] b = tobyte(s1);
        System.out.println(showByteArray(b));
        byte[] decryptData = decrypt(b, k);
        System.out.println("解密后数据: string:"+new String(decryptData));
//        System.out.println(URLDecoder.decode(new String(decryptData), "utf-8"));
        
    }
}