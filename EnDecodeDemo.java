import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESEncryptionDecryptionTest {

    private static final String ALGORITHM       = "AES";
    private static final String myEncryptionKey = "w9o_hoox.TK@J_yj";
    private static final String UNICODE_FORMAT  = "UTF8";

    public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);//////////LINE 50
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        byte[] keyAsBytes;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        Key key = new SecretKeySpec(keyAsBytes, ALGORITHM);
        return key;
    }

    public static void main(String[] args) throws Exception {
        String value = "ttttt";
        String valueEnc = AESEncryptionDecryptionTest.encrypt(value).replaceAll("\r\n","");
        String valueDec = AESEncryptionDecryptionTest.decrypt(valueEnc);

        System.out.println("Plain Text : " + value);
        System.out.println("Encrypted : " + valueEnc);
        System.out.println("Decrypted : " + valueDec);
    }

}
