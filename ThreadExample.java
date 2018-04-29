import java.io.IOException;
import java.io.*;
import java.net.*;

public class ThreadExample {

    public static void main(String[] args){

      /*
      int port;
      InetAddress address;
      DatagramSocket socket = null;
      DatagramPacket packet;
      byte[] sendBuf = new byte[256];

      address = InetAddress.getLocalHost();
      packet = new DatagramPacket(sendBuf, sendBuf.length, address, 4445);

      socket.send(packet);
      */

    UDPSenderThread2 mythread = new UDPSenderThread2();
    UDPRecieverThread mythread2 = new UDPRecieverThread();

    Thread thread = new Thread(mythread);
    Thread thread3 = new Thread(mythread2);

    thread.start();
    thread3.start();

    /*
    while (true){
      System.out.println("main running");

      try {
        Thread.sleep(1);
      } catch (InterruptedException ex){

      }
    }
    */
  }
}
