import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTextTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String myPassword = "1234567890";
        System.out.printf("Indigesting %s --> %s\n\n", myPassword, shaTest(myPassword, "SHA1"));
    }

    static String shaTest(String input, String encodingAlgorithm) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance(encodingAlgorithm);
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
