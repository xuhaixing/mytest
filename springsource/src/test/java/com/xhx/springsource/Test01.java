package com.xhx.springsource;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Test01 {


    @Test
    public void test01() throws IOException {
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("META-INF/spring.factories");
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url);
        }
    }

    @Test
    public void test02() throws Exception{
//        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("");
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("/");
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url);
        }
    }
}
