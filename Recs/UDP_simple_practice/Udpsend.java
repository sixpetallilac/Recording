package SocketPractice02;

import java.io.IOException;
import java.net.*;

public class Udpsend {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            byte[]  bytes = "test hello".getBytes();
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8880);
            ds.send(dp);
            System.out.println("done");
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
