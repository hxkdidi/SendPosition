package com.kenos.positiondemo;

import android.content.Context;
import android.widget.Toast;

/**
 * User: hxk(huangxikang@520bangxin.cn)
 * Date: 2016-11-08
 * Time: 11:27
 * Description:
 */
public class ToastUtil {

    public static void show(Context context, String s) {
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }
}
