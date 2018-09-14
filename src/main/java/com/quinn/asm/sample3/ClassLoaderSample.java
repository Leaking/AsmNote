package com.quinn.asm.sample3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderSample {


    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        URL url = null;
        url = new URL("file:///Users/quinn/Documents/workspaces/asmnote/out/production/classes/");
        System.out.println("url " + url);
        URL[] urls = {url};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class.forName("com.quinn.asm.sample1.CopyClass$CopyInner", false, urlClassLoader);
    }
}
