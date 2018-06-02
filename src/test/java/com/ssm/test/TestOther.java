package com.ssm.test;

import org.junit.Test;

import java.io.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-21
 * @Time: 23:11
 */
public class TestOther {

    @Test
    public void test() {
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            File file = new File("e:/logs/log.log");
            File file2 = new File("e:/logs/log3.log");

//            读取字符流
            FileInputStream fis = new FileInputStream(file);
//            转换字节流
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
//            设置缓冲流
            br = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream(file2);
            OutputStreamWriter osr = new OutputStreamWriter(fos, "GBK");
            bw = new BufferedWriter(osr);

            String str;
            int len;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                bw.write(str + "\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
