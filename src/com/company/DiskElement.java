package com.company;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Brej on 14.03.2017.
 */
public abstract class DiskElement implements java.lang.Comparable<DiskElement>{

    protected Date lastModified;
    protected String formattedDate;
    protected String basename;
    protected String path;
    protected File file;
    protected String typ;

    protected int depth;

    protected abstract void print(int depth);

    public void print() { print(getDepth()); }

    public DiskElement(String path, int depth) {
        setDepth(depth);
        setFile(new File(path));
        setBasename(file.getName());
        setPath(file.getPath());
        setLastModified(new Date(file.lastModified()));
        SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
        setFormattedDate(template.format(getLastModified()));
    }


    public DiskElement(String path){
        this(path, 0);
    }


    public static Comparator<DiskElement> DiskElementComperator = new Comparator<DiskElement>() {
        @Override
        public int compare(DiskElement o1, DiskElement o2) {
            if(o1.getFile().isDirectory()){
                return -1;
            }
            return o1.compareTo(o2);
        }
    };

    @Override
    public int compareTo(DiskElement other) {
        int result = getBasename().compareTo(other.getBasename());
        if(result == 0){
            return getLastModified().compareTo(other.getLastModified());
        }
        return result;
    }
    @Override
    public int hashCode() {
        int hash = 13;
        hash = getDepth() * hash + Objects.hashCode(getBasename());
        hash = getDepth() * hash + Objects.hashCode(getFile());
        hash = getDepth() * hash + Objects.hashCode(getTyp());
        hash = getDepth() * hash + Objects.hashCode(getLastModified());
        hash = getDepth() * hash + Objects.hashCode(getPath());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if (this.getClass() == obj.getClass()){
            DiskElement o = (DiskElement) obj;
            return getFile().equals(o.getFile());
        }
        return false;
    }


    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "DiskElement{" +
                "formattedDate='" + formattedDate + '\'' +
                ", basename='" + basename + '\'' +
                ", path='" + path + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }


}
