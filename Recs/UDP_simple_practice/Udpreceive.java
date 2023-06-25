package SocketPractice02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Udpreceive {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(8880);
            //receive barr
            byte[] barr = new byte[12];
            DatagramPacket dp = new DatagramPacket(barr, barr.length);

            ds.receive(dp);
            String s = new String(barr, 0, dp.getLength());

            System.out.println(s);

            ds.close();//这里懒得把try写外面了就这样close了，正常要在finally null判断
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
