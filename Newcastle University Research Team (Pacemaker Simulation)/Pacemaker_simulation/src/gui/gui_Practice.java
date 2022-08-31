package gui;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import encrypt_decrypt.AES;
import heart.Heart;
import pacemaker.Pacemaker;

public class gui_Practice {

	public static void main(String[] args) throws InterruptedException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, IOException, ClassNotFoundException, BadPaddingException {
		// TODO Auto-generated constructor stub
		SecretKey key = AES.generateKey(128);
	    IvParameterSpec ivParameterSpec = AES.generateIv();
	    String algorithm = "AES/CBC/PKCS5Padding";
		
		
		 // Heart (object instantiation)
		 Heart heart1 = new Heart();
		 // Heart (Set values)
		 heart1.setArterial_Pulse_Width(450);
		 heart1.setVentricular_Pulse_Width(450);
		 heart1.setChamber_Contraction_Duration(3800);
		 
		 // Heart (object instantiation)
		 Pacemaker pacemaker1 = new Pacemaker(heart1);
		 
		 // Create new thread
		 new Thread(() -> {
			    try {
			    	// Start simulation
					heart1.start_sim();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		
		 // Infinite while loop... To test thread and ensure values are printed.
		 while (true) {
			String stringtoencrypt = heart1.toString();
			System.out.println(stringtoencrypt);
			
			SealedObject sealedObject = AES.encryptObject(
				      algorithm, pacemaker1, key, ivParameterSpec);
				    Pacemaker object = (Pacemaker) AES.decryptObject(
				      algorithm, sealedObject, key, ivParameterSpec);
				    System.out.println(object);
			
			Thread.sleep(100);
		}
		 
	}

}
