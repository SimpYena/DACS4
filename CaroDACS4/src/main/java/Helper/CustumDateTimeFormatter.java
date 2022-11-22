/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

/**
 *
 * @author Admin
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class CustumDateTimeFormatter {

    // https://stackoverflow.com/a/6953926
    public static String getCurrentTimeFormatted() {
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static String secondsToMinutes(int seconds) {
        return addZero(seconds / 60) + ":" + addZero(seconds % 60);
    }

    public static String addZero(int n) {
        if (n < 10) {
            return "0" + n;
        }
        return "" + n;
    }
}
