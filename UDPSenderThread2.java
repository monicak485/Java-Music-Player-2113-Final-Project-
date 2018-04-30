/*////////////////////////////////
Software Engineering Final Project
Grace Gowanlock, Monica Kavathekar,
and Abia Khan
Professor James
4/29/18
////////////////////////////////*/
import java.io.IOException;
import java.io.*;
import java.net.*;

class UDPSenderThread2 implements Runnable {
  Song details;
  boolean stopThisLoop; 
  public UDPSenderThread2(Song details, boolean stopThisLoop){ //constructor
    this.stopThisLoop = stopThisLoop;
    this.details = details;
  }
  public void run(){
    while (true){
      try {
        if (stopThisLoop == true){ //this boolean variables only allows song data to be sent to the server once
          DatagramSocket ds = new DatagramSocket();

          String message = details.toString();
            // prepare the message which contains song data
          
            // since DatagramPacket can only pack up byte array,
            //we need to convert string to bytes
          byte[] data = message.getBytes();
            // create a new data packet, we must specify the IP address
            //and port number here
          DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 10001);
            // send the packet
          ds.send(dp);
          stopThisLoop = false; //prevents sending same song data multiple times
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
