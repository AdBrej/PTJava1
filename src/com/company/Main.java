package com.company;


import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if(args.length == 0){
            System.out.printf("nie podałeś ściężki");
            return;
        }
        factory factory = new factory();
        DiskElement diskElement = factory.factor(new File(args[0]), 0);
        diskElement.print();
    }
}
