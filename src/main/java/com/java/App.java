package com.java;

import sun.security.mscapi.CPublicKey;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final Logger LOGGER=Logger.getLogger(App.class.getName());
    public static void main( String[] args ) throws MalformedURLException {
        //forNameClassLoader();
        urlClassLoader();

    }
    public static void urlClassLoader() throws MalformedURLException{
        String jar_path="file:///E:\\a-study\\code\\employee-app\\target\\employee-app-1.0-SNAPSHOT.jar";
        URLClassLoader loader=new URLClassLoader(new URL[]{new URL(jar_path)});
        try {

            System.out.println(App.class.getClassLoader());
            System.out.println(loader);
            System.out.println(loader.getParent());
            //Class.forName("com.java.Employee");
            Class claz=loader.loadClass("com.java.Employee");
            System.out.println(claz.getName());

            Object o = claz.newInstance();
            System.out.println(o);

             Class.forName(App.class.getName(),true,loader);
            System.out.println("class is loaded by foName");


        } catch (Exception e) {
            LOGGER.info("class not found");
        }
    }
    //class.forName used to load the class which is in your class path or in jar or u have to use uriClassLoader as a parameter in class.forName
    //to load the class
    public static void forNameClassLoader(){
        try {
           Class c1= Class.forName("java.lang.String");
            //ClassLoader loader=c1.getClassLoader();
            //Class c2=Class.forName("com.java.String",true,loader);
        } catch (ClassNotFoundException e) {
            LOGGER.info("class not found");
        }
    }
}
