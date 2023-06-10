package com.portal.comercio.Utils;
import org.springframework.security.crypto.codec.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class utilClass {

    public static String encriptarAMD5(String input) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            return new String(Hex.encode(digest));
        }catch (Exception exp){
            try {
                throw new NoSuchAlgorithmException(exp);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
