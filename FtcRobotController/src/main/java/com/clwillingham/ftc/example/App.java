package com.clwillingham.ftc.example;

import android.app.Application;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chris on 10/9/15.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AssetManager assets = getAssets();
        try {
            InputStream in = assets.open("configuration.xml");
            FileOutputStream out = new FileOutputStream(Environment.getExternalStorageDirectory() + "/FIRST/configuration.xml");
            copyFile(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
