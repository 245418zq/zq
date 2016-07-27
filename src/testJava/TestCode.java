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
        //��������ָ���㷨��������Կ�� KeyGenerator ����
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        //��ʼ������Կ��������ʹ�����ȷ������Կ��С
        //AES Ҫ����Կ����Ϊ 128
        kg.init(128);
        //����һ����Կ
        SecretKey  secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }
    private static Key toKey(byte[] key){
        //������Կ
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }
    public static byte[] encrypt(byte[] data,Key key) throws Exception{
        return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }
    public static byte[] encrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //ʵ����
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //ʹ����Կ��ʼ��������Ϊ����ģʽ
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //ִ�в���
        return cipher.doFinal(data);
    }
    public static byte[] decrypt(byte[] data,Key key) throws Exception{
        return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }
    public static byte[] decrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //ʵ����
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //ʹ����Կ��ʼ��������Ϊ����ģʽ
        cipher.init(Cipher.DECRYPT_MODE, key);
        //ִ�в���
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
//        System.out.println("key��"+showByteArray(key));
        Key k = toKey(key);
        String data ="SS563uf556kllaADWC";
//        System.out.println("����ǰ����: string:"+data);
//        System.out.println("����ǰ����: byte[]:"+showByteArray(data.getBytes()));
//        System.out.println();
        byte[] encryptData = encrypt(data.getBytes(), k);
//        System.out.println("���ܺ�����: byte[]:"+showByteArray(encryptData));
        System.out.println();
//        System.out.println("���ܺ�����: hexStr:"+Hex.encodeHexStr(encryptData));
        String s = URLEncoder.encode(showByteArray(encryptData),"utf-8");
        System.out.println(s);
//        byte[] decryptData = decrypt(encryptData, k);
//        System.out.println("���ܺ�����: byte[]:"+showByteArray(decryptData));
//        System.out.println("���ܺ�����: string:"+new String(decryptData));
        String s1 = ""+URLDecoder.decode(s, "utf-8");
//        System.out.println(s1);
        byte[] b = tobyte(s1);
        System.out.println(showByteArray(b));
        byte[] decryptData = decrypt(b, k);
        System.out.println("���ܺ�����: string:"+new String(decryptData));
//        System.out.println(URLDecoder.decode(new String(decryptData), "utf-8"));
        
    }
}