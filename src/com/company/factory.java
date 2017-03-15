package com.company;

import java.io.File;

/**
 * Created by Brej on 14.03.2017.
 */
public class factory {
    public DiskElement factor(File file, int depth){
        if(file.isDirectory()){
            return new Directory(file.getAbsolutePath(), depth);
        }
        return new myFile(file.getAbsolutePath(), depth);
    }
}
