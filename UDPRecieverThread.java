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

class UDPRecieverThread implements Runnable {

  public void run(){ //throws IOException
    try {
      DatagramSocket ds = new DatagramSocket(10000); //prepares to recieve on this socket

      while (true){

            // prepare the buffer to hold the received data
            byte[] buffer = new byte[1024];

            // create a new data packet based on the buffer
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            // receive data packet
            ds.receive(dp);

            // analyze the received data
            byte[] data = dp.getData();

            ServerFrame newServerFrame = new ServerFrame(data); //creates a new window with the song info that was recieved


        try {
          Thread.sleep(1);
        } catch (InterruptedException ex){

        }
      }
    } catch (IOException ex){

    }
  }
}
