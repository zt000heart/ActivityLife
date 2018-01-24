package com.sankuai.moviepro.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhangtao21 on 2017/12/15.
 */

public class SayHello implements ISay{
    @Override
    public void say(Context context) {
        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
    }
}
