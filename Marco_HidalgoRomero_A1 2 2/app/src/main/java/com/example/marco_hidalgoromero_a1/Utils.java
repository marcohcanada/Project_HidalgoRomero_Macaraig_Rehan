package com.example.marco_hidalgoromero_a1;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-11
 */
public class Utils {
    public static boolean isValidEmail(String targetEmail) {
        return (!TextUtils.isEmpty(targetEmail) &&
                Patterns.EMAIL_ADDRESS.matcher(targetEmail).matches());
    }

    public static boolean isValidPhoneNumber(String targetPhoneNumber) {
        if (targetPhoneNumber.length() >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
