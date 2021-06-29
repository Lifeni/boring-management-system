package app.lifeni.bms.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {
    public static String SHA256(String content) {
        MessageDigest messageDigest;
        var result = new StringBuffer();
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(content.getBytes(StandardCharsets.UTF_8));
            var hash = messageDigest.digest();
            for (byte b : hash) {
                if ((0xff & b) < 0x10) {
                    result.append("0").append(Integer.toHexString((0xFF & b)));
                } else {
                    result.append(Integer.toHexString(0xFF & b));
                }
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
