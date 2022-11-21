package dataLayer.Crypto;

import java.security.MessageDigest;

public class CryptoString {
	public static String crypto(String string) throws Exception {
		byte[] stringBytes = string.getBytes("UTF-8");
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256"); 
		byte[] digest = algorithm.digest(stringBytes);
		
		return digest.toString();
	}
}
