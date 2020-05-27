import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class p10930 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
        mdSHA256.update(line.getBytes("UTF-8"));
        byte[] sha256Hash = mdSHA256.digest();

        StringBuilder hexSHA256hash = new StringBuilder();
        for(byte b : sha256Hash) {
            String hexString = String.format("%02x", b);
            hexSHA256hash.append(hexString);
        }

        System.out.println(hexSHA256hash);
    }
}
