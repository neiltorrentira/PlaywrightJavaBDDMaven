package webui.playwright.Utils;

import java.text.SimpleDateFormat;
import java.util.*;
import static webui.playwright.Utils.Constants.*;

public class Utils {
    public static String decode64(String encodedStr) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

    public static String DateTimestamp() {
        String timeStamp;
        timeStamp = new SimpleDateFormat("h:mm:ss.SSS").format(new Date());
        return timeStamp;
    }

    public static String generateRandomString(int length) {
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random random = new Random();
        while (i < length) {
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }

    public static String RandomString() {
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random random = new Random();
        while (i < 8) {
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }

    public static String RandomLastName() {
        int size = lastnameListOfStrings.size();
        String[] stringArray = new String[size];
        lastnameListOfStrings.toArray(stringArray);
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        System.out.println("Lastname: " + stringArray[randomIndex]);
        return stringArray[randomIndex];
    }

    public static String RandomFirstName() {
        int size = firstnameListOfStrings.size();
        String[] stringArray = new String[size];
        firstnameListOfStrings.toArray(stringArray);
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        System.out.println("Firstname: " + stringArray[randomIndex]);
        return stringArray[randomIndex];
    }

}
