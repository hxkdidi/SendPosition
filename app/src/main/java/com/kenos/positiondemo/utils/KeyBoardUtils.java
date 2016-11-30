package com.kenos.positiondemo.utils;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


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
