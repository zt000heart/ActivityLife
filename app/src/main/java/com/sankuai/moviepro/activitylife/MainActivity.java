package com.sankuai.moviepro.activitylife;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sankuai.moviepro.mylibrary.ISay;

import java.io.File;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("1"," "+MainActivity.class.getClassLoader());
        Log.e("parent1"," "+MainActivity.class.getClassLoader().getParent());
        Log.e("parent2"," "+MainActivity.class.getClassLoader().getParent().getParent());
        Log.e("path", ""+Environment.getExternalStorageDirectory().getPath());

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final File jarFile =
                        new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "mysdk_dex.jar");
                if(!jarFile.canRead()){
                    // 如果没有读权限,确定你在 AndroidManifest 中是否声明了读写权限
                    Log.d("tag", jarFile.canRead() + "");
                    return;
                }
                if (!jarFile.exists()) {
                    Log.e("tag", "mysdk_dex.jar not exists");
                    return;
                }

                DexClassLoader dexClassLoader = new DexClassLoader(jarFile.getAbsolutePath(), getExternalCacheDir().getAbsolutePath(), null, getClassLoader());
//                PathClassLoader dexClassLoader = new PathClassLoader(jarFile.getAbsolutePath(), null, getClassLoader());
                try {
                    Class clazz = dexClassLoader.loadClass("com.sankuai.moviepro.mylibrary.SayHello");
                    ISay say = (ISay) clazz.newInstance();

                    Log.e("classLoader say", ""+ say.getClass().getClassLoader());
                    say.say(MainActivity.this);
                    say.say1(MainActivity.this);
                }catch (Throwable e){
                    e.printStackTrace();
                }

            }
        });
        final String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        findViewById(R.id.per).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this, permissions,10);
            }
        });
    }
}
