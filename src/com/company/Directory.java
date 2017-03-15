package com.company;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Brej on 14.03.2017.
 */
public class Directory extends DiskElement {

    protected boolean isDirectory;
    Set<DiskElement> children;

    public Directory(String path){
        this(path, 0);
    }

    public Directory(String path, int depth) {
        super(path, depth);
        setDirectory(getFile().isDirectory());
        setTyp("Directory");
//        children = new TreeSet<DiskElement>();
//        children = new HashSet<DiskElement>();
        children = new TreeSet<>(DiskElement.DiskElementComperator);
        createChilds();
    }

    @Override
    protected void print(int depth) {
        String string = "";
        for(int i = 0; i < depth; i++){
            string += "-";
        }
        string += " " + getBasename();
        string = String.format("%-30s %-15d %s", string, 134, "yolo");
        System.out.println(string);
        for (DiskElement element : children) {
            element.print();
        }
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    protected void createChilds(){
        File[] files = getFile().listFiles();
        if (files != null) {
            factory Factory = new factory();
            for(File file : files){
                try {
                    children.add(Factory.factor(file, getDepth() + 1));
                }catch (Exception e){
                    continue;
                }
            }
        }
    }

    public Set<DiskElement> getChildren() {
        return children;
    }

    public void setChildren(Set<DiskElement> children) {
        this.children = children;
    }
}
