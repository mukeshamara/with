package com.password;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decryption {
	 public static final String AES = "AES";

	    private static String byteArrayToHexString(byte[] b) {
	        StringBuffer sb = new StringBuffer(b.length * 2);
	        for (int i = 0; i < b.length; i++) {
	            int v = b[i] & 0xff;
	            if (v < 16) {
	                sb.append('0');
	            }
	            sb.append(Integer.toHexString(v));
	        }
	        return sb.toString().toUpperCase();
	    }

	    private static byte[] hexStringToByteArray(String s) {
	        byte[] b = new byte[s.length() / 2];
	        for (int i = 0; i < b.length; i++) {
	            int index = i * 2;
	            int v = Integer.parseInt(s.substring(index, index + 2), 16);
	            b[i] = (byte) v;
	        }
	        return b;
	    }

	    public String decry(String epass) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException, IOException {

	    	String ret="";
	        String tempkey = "";
	        String password = "";
	        Properties prop = new Properties();
	        InputStream input = null;
	   
	        // load a properties file
	   
	        tempkey = "DB99A2A8EB6904F492E9DF0595ED683C";
	        password = epass;

	        byte[] bytekey = hexStringToByteArray(tempkey);
	        SecretKeySpec sks = new SecretKeySpec(bytekey, Decryption.AES);
	        Cipher cipher = Cipher.getInstance(Decryption.AES);
	        cipher.init(Cipher.DECRYPT_MODE, sks);
	        byte[] decrypted = cipher.doFinal(hexStringToByteArray(password));
	        ret = new String(decrypted);
	        System.out.println("****************  Original Password  ****************");
	        System.out.println(ret);
	        System.out.println("****************  Original Password  ****************");
	   return ret;
	    }
}
