import java.io.IOException;
import java.io.*;
import java.net.*;

class Server {
  public static void main(String[] args){
    //recieve what song is being played
    //send that info back

    while (true){
      try {
        DatagramSocket ds = new DatagramSocket(10001);
        DatagramSocket dssend = new DatagramSocket(10000);

              byte[] buffer = new byte[1024];
              byte[] data = new byte[1024];
                // prepare the buffer to hold the received data
                //byte[] buffer = new byte[1024];
                // create a new data packet based on the buffer
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 10001);
                // receive data packet
                ds.receive(dp);
                // analyze the received data
                data = dp.getData();


                System.out.println("data: "+ new String(data).trim());

                InetAddress address = dp.address();
                int port = dp.getPort();
                dp = new DatagramPacket(buffer, buffer.length, address, port);

                ds.send(dp);

                //DatagramPacket dptest = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 10000);
                //dssend.send(dptest);
                /*
                System.out.println("packet length: "+dp.getLength());
                System.out.println("sender port number: "+dp.getPort());
                System.out.println("sender address: "+dp.getAddress().toString());
                */
                System.out.println(buffer);

                DatagramPacket dptest = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 10000);
                System.out.println("test2");

                dssend.send(dptest);

                System.out.println("test");

        //ds.close();
      } catch (IOException ex){

      }
      //listenerSocket.receive(message);


      /*
      UDPSenderThread mythread3 = new UDPSenderThread();
      UDPRecieverThread2 mythread4 = new UDPRecieverThread2();

      Thread thread4 = new Thread(mythread3);
      Thread thread2 = new Thread(mythread4);

      thread4.start();
      thread2.start();
      */
    }
  }
}
