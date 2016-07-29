import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Amysue on 2016/7/29.
 */
public class Md5Compute {
    public static String getMd5(String msg) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.reset();
        md.update(msg.getBytes());
        byte[] bytes = md.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < bytes.length; i++)
        {
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & bytes[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return md5StrBuff.toString();
    }
    public static void main(String[] args) {
        String IMEI = "355902062329873";
        String uin = "1290068820";
        String md5 = getMd5(IMEI + uin);
        String md52 = new String(md5);
        System.out.println(md52.substring(8,24));
        System.out.println("md5 = " + md5);
        System.out.println(md5.substring(0,7));
    }
}
