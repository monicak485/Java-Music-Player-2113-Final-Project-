import java.io.IOException;
import java.io.*;
import java.net.*;

class UDPRecieverThread implements Runnable {
  public void run(){ //throws IOException
    try {
      DatagramSocket ds = new DatagramSocket(10000);
      while (true){

            // prepare the buffer to hold the received data
            byte[] buffer = new byte[1024];
            // create a new data packet based on the buffer
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            // receive data packet
            ds.receive(dp);
            System.out.println("test3");
            // analyze the received data
            byte[] data = dp.getData();


            System.out.println("data: "+ new String(data).trim());

            /*
            System.out.println("packet length: "+dp.getLength());
            System.out.println("sender port number: "+dp.getPort());
            System.out.println("sender address: "+dp.getAddress().toString());
            */

        try {
          Thread.sleep(1);
        } catch (InterruptedException ex){

        }
      }
      //ds.close();
    } catch (IOException ex){

    }
  }
}
