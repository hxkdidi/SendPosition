package com.kenos.positiondemo;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * User: hxk(huangxikang@520bangxin.cn)
 * Date: 2016-11-08
 * Time: 11:37
 * Description:
 */
public class KeyBoardUtils {


    public static void showKeyboard(EditText editText,InputMethodManager inputMethodManager) {
        editText.requestFocus();
        inputMethodManager.showSoftInput(editText, 0);
    }

    public static void hideKeyboard(EditText editText,InputMethodManager inputMethodManager) {
        editText.clearFocus();
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
