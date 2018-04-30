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

class Server {
  public static void main(String[] args){
    //recieve what song is being played
    //send that info back

    while (true){
      try {
        DatagramSocket ds = new DatagramSocket(10001); //this socket recieves info
        DatagramSocket dssend = new DatagramSocket(); //this socket sends info

        byte[] buffer = new byte[1024]; //this stores the song info
        byte[] data = new byte[1024]; //this also stores song info
        
        // prepare the buffer to hold the received data
        // create a new data packet based on the buffer
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 10001);
        // receive data packet
        ds.receive(dp);
        // analyze the received data
        data = dp.getData();


        System.out.println("data: "+ new String(data).trim()); //prints song data to console

        InetAddress address = dp.getAddress();

        dp = new DatagramPacket(buffer, buffer.length, address, 10000); //packet contains song data with new port

        dssend.send(dp); //sends packet back to playlist
        
      } catch (IOException ex){

      }
      
    }
  }
}
