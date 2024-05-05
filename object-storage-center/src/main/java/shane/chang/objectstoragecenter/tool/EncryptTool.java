package shane.chang.objectstoragecenter.tool;

import org.springframework.util.DigestUtils;

public class EncryptTool {

    public static String encrypt2md5(String plainText) {
        return DigestUtils.md5DigestAsHex(plainText.getBytes());
    }

    public static String encrypt2base64(String plainText) {
        return null;
    }

}
