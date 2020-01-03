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

    public static boolean StringIsImageURL(String input) {
        //return input.matches("(http:\\/\\/[0-9a-zA-Z\\.\\/_-]+.png|http:\\/\\/[0-9a-zA-Z\\.\\/_-]+.jpg)");
        return true;
    }
}
