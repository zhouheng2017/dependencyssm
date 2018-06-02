package com.how2java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-19
 * @Time: 13:14
 */
public class FileInputStreamTest {

    public static void main(String[] args) {

        int b = 0;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("e:/logs/log.log");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ((b = fis.read()) != -1) {
                System.out.print((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
