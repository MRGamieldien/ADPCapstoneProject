/* Helper.java
Helper class
Author: Lyle Solomons (230123872)
Date: 26 March 2026
*/
package za.ac.cput.util;

public class Helper {
    //Checks whether a given string is null or empty.
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    //Checks any object, will use for other than string
    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
