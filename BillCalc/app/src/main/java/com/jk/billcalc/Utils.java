package com.jk.billcalc;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-19
 */
public class Utils {
    public static boolean isValidAccountNumber(String targetAccountNumber) {
        if (targetAccountNumber.length() == 16) {
            return true;
        } else {
            return false;
        }
    }
}
