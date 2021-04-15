package com.other.io;

import java.io.*;

public class IODemo {
    public static void main(String[] args) throws IOException {
//        输入流
//        InputStream in = new FileInputStream("D:\\oes-system\\OES-ADMIN\\BE\\src\\main\\java\\com\\other\\io\\1.txt");
//        int len  = 0;
//        while ( true ) {
//            len = in.read();
//            if (len != -1 ){
//                System.out.println(len);
//            } else {
//                break;
//            }
//        }
//        in.close();

//        File file = new File("");
//        String FILE_PATH = file.getAbsolutePath() + "\\";
//        System.out.println(FILE_PATH);
////        输出流
//        OutputStream out = new FileOutputStream(FILE_PATH + "2.txt");
//        String outStr = "你好啊！";
//        byte[] arr = outStr.getBytes();
//        for (byte b : arr) {
//            out.write(b);
//        }
//        out.close();

//        文件拷贝 边输入边输出
        String FILE_PATH = new File("").getAbsolutePath() + "\\";
        System.out.println(FILE_PATH);
//        InputStream in = new FileInputStream(FILE_PATH + "1.txt");
//        OutputStream out = new FileOutputStream(FILE_PATH + "2.txt");
//        int len = 0;
//        while (true) {
//            len = in.read();
//            if (len == -1) break;
//            else out.write(len);
//        }
//        out.close();


//        输入
//        InputStream in = new FileInputStream(FILE_PATH + "1.txt");
//        byte[] arr = new byte[8];
//        int len = 0;
//        while((len = in.read(arr)) != -1 ) {
//            System.out.print(new String(arr, 0, len));
//        }
//        in.close();


//        字节流的缓冲区
//        InputStream in = new FileInputStream(FILE_PATH + "1.txt");
//        OutputStream out = new FileOutputStream(FILE_PATH + "2.txt");
//        byte[] arr = new byte[1024];
//        int len = 0;
//        while( (len = in.read(arr)) != -1){
//            out.write(arr, 0, len);
//        }
//        in.close();out.close();

        // 装饰器设计模式+字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FILE_PATH + "1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE_PATH+"2.txt"));
        int len = 0;
        while( (len=bis.read()) != -1){
            bos.write(len);
        }
        bis.close();bos.close();
    }
}
