package by.makei.array.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GeneratorId {
    private static final Logger logger = LogManager.getLogger();
    private static final GeneratorId instance = new GeneratorId ();
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private Set<String> iDset = new HashSet<>();

    private GeneratorId (){};

    public static GeneratorId getInstance() {
        return instance;
    }

    /**
     *
     * @return String as generated with UUID unique ID
     */
    public String getId() {

        while (true) {

            try {
                MessageDigest crypto = MessageDigest.getInstance("SHA-256");
                crypto.update(UUID.randomUUID().toString().getBytes("UTF-8"));
                String generatedId = bytesToHex(crypto.digest());
                if(!iDset.contains(generatedId)){
                    iDset.add(generatedId);
                    return generatedId;
                }
            }catch (UnsupportedEncodingException e) {
                logger.log(Level.WARN, "Exception can't be thrown");
            } catch (NoSuchAlgorithmException e) {
                logger.log(Level.WARN, "Exception can't be thrown");
            }
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

}
