package com.ssm.test;

import org.junit.Test;

import java.io.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-21
 * @Time: 22:44
 */
public class TestBufferedInputOutputStream {

    @Test
    public void testBufferedStream() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file1 = new File("e:/logs/log.log");

            File file2 = new File("e:/logs/log2.log");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len ;
            byte[] b = new byte[1024];

            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bos != null) {

                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {

                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
