package com.ssm.test;

import org.junit.Test;

import java.io.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-21
 * @Time: 21:10
 */
public class FileInputOutputStream {

    @Test
    public void testFileOutputStream() {
        long start = System.currentTimeMillis();
        String src = "e:/logs/error.log";
        String dest = "e:/logs/logs.log";
        copyFile(src, dest);
        long end = System.currentTimeMillis();

        System.out.println("Time" + (end - start));

    }

    public void copyFile(String src, String desc) {
        File file1 = new File(src);
        File file2 = new File(desc);

        FileInputStream fis = null;
        FileOutputStream fos = null;


        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            int getByteArrayLen;
            byte[] getByteArray = new byte[1024];
            while ((getByteArrayLen = fis.read(getByteArray)) != -1) {

//                String str = new String(getByteArray, 0, getByteArrayLen);
//                fos.write(str.getBytes());
                fos.write(getByteArray, 0, getByteArrayLen);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileInputStream() {


        FileInputStream fis = null;

        try {
            File file = new File("e:/logs/log.log");

            fis = new FileInputStream(file);
            byte[] getByteArray = new byte[50];
            int len;
            while ((len = fis.read(getByteArray)) != -1) {

                String str = new String(getByteArray, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {

                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFile() {
        File file = new File("/script/abc.txt");
        System.out.println(file.getName());

    }
}
