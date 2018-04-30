import java.io.IOException;
import java.io.*;
import java.net.*;

class UDPSenderThread2 implements Runnable {
  Song details;
  boolean stopThisLoop; 
  public UDPSenderThread2(Song details, boolean stopThisLoop){
    this.stopThisLoop = stopThisLoop;
    this.details = details;
  }
  public void run(){
    //boolean stopThisLoop = true;
    while (true){
      try {
        if (stopThisLoop == true){
          DatagramSocket ds = new DatagramSocket();

          //System.out.println("test");

          String message = details.toString();
            // prepare the message
            // since DatagramPacket can only pack up byte array,
            //we need to convert string to bytes
          byte[] data = message.getBytes();
            // create a new data packet, we must specify the IP address
            //and port number here
          DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 10001);
            // send the packet
          ds.send(dp);
          stopThisLoop = false;
        }
      } catch (IOException ex){

      }
      try {
        Thread.sleep(1);
      } catch (InterruptedException ex){

      }
    }
  }
}
