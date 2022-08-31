package encrypt_decrypt;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

  private static SecretKeySpec secretKey;
  private static byte[] key;

  public void setKey(final String myKey) {
    MessageDigest sha = null;
    try {
      key = myKey.getBytes("UTF-8");
      sha = MessageDigest.getInstance("SHA-1");
      key = sha.digest(key);
      key = Arrays.copyOf(key, 16);
      secretKey = new SecretKeySpec(key, "AES");
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
  
  public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
  
  public static IvParameterSpec generateIv() {
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}

  public static SealedObject encryptObject(String algorithm, Serializable object,
		    SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException,
		    NoSuchAlgorithmException, InvalidAlgorithmParameterException, 
		    InvalidKeyException, IOException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    SealedObject sealedObject = new SealedObject(object, cipher);
		    return sealedObject;
		}

  public static Serializable decryptObject(String algorithm, SealedObject sealedObject,
		    SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException,
		    NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
		    ClassNotFoundException, BadPaddingException, IllegalBlockSizeException,
		    IOException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    Serializable unsealObject = (Serializable) sealedObject.getObject(cipher);
		    return unsealObject;
		}
}
