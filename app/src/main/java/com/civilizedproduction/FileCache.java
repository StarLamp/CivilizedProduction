package com.civilizedproduction;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class FileCache {
    private File cacheDir;

    public FileCache(Context context){
        if(android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_CHECKING))
            cacheDir = new File(android.os.Environment.getExternalStorageDirectory(),"LazyList");
        else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url){
        String filename = String.valueOf(url.hashCode());
        File f  =  new File(cacheDir,filename);
        return f;
    }

    public void clear(){

    }
}

