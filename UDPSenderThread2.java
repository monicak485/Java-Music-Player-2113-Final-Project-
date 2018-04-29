import java.io.IOException;
import java.io.*;
import java.net.*;

class UDPSenderThread2 implements Runnable {
  public void run(){ //throws IOException
    while (true){
      try {
        DatagramSocket ds = new DatagramSocket();
        String message = "";
        //boolean keepgoing = true;

        InputStream input = System.in;
        byte[] buffer = new byte[1024];
        int len = 0;
        // read 1024 bytes into the buffer
        // the returned number is the length of the characters actually read in
        //while (keepgoing == true){
        len = input.read(buffer);
            // construct string from the byte array
        message = new String(buffer,0,len);
        message = message.trim();

          // prepare the message
          // since DatagramPacket can only pack up byte array,
          //we need to convert string to bytes
        byte[] data = message.getBytes();
          // create a new data packet, we must specify the IP address
          //and port number here
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 10001);
          // send the packet
        ds.send(dp);
      } catch (IOException ex){

      }
      try {
        Thread.sleep(1);
      } catch (InterruptedException ex){

      }
    }
  }
}
