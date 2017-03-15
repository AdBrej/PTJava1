package com.company;

/**
 * Created by Brej on 14.03.2017.
 */
public class myFile extends DiskElement {

    protected boolean isMyFile;

    public myFile(String path){
        this(path, 0);
    }

    public myFile(String path, int depth) {
        super(path, depth);
        setMyFile(getFile().isFile());
        setTyp("File");
    }

    @Override
    protected void print(int depth) {
        String string = "";
        for(int i = 0; i < depth; i++){
            string += "-";
        }
        string += " " + getBasename();
        System.out.println(string);
    }

    public boolean isMyFile() {
        return isMyFile;
    }

    public void setMyFile(boolean file) {
        isMyFile = file;
    }
}
