package utils;

public class Sanitization {

    public static boolean StringIsDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
