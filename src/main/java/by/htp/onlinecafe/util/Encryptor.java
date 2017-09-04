package by.htp.onlinecafe.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Util class that
 * encrypts to the MD5
 */
public class Encryptor {

    /**
     * Encodes the password with md5 algorithm
     * @param password a password to be encoded
     * @return encoded password
     */
    public static String encodePassword(byte[] password){
        return DigestUtils.md5Hex(password);
    }
}
