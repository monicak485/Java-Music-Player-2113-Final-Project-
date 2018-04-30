/*////////////////////////////////
Software Engineering Final Project
Grace Gowanlock, Monica Kavathekar,
and Abia Khan
Professor James
4/29/18
////////////////////////////////*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.LinkedList.*;
import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import java.util.ListIterator;


/*Now Playing Frame- this frame pops up whenever the user starts to play a song*/
public class NowPlayingFrame extends JFrame {

  //Constructor for the frame, it takes in the song(&its details)
  NowPlayingFrame(Song songPlaying, String coverArtFile){
    //Basic Details of the Frame
    this.setTitle ("Now Playing");
    this.setResizable (true);
    this.setSize (300, 300);

    //Creates an image viewer from the NewImage class
    NewImage imageViewer;
    imageViewer = new NewImage(songPlaying.coverArtFile);
    imageViewer.setSize(700, 700);

    //Container with basic labels, etc
    Container cPane = this.getContentPane();
    JLabel L = new JLabel ("Now Playing");
    L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 24));

    cPane.setBackground(new java.awt.Color(0,204,204));

    cPane.add (L, BorderLayout.NORTH);
    cPane.add (imageViewer, BorderLayout.CENTER);

    //Text area to display the currently playing song 
    JTextArea songText = new JTextArea();
    songText.setText(songPlaying.toString()); //calls the toString method of the Song object
    songText.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
    cPane.add(songText, BorderLayout.SOUTH);

    this.setVisible (true);
    songPlaying.Play(); //Plays the song
  }
  //Run thread method for server communication
  public void runThread(Song newSong){
    //Boolean to stop infinite looping
    Boolean stopThisLoop = true; 
    //creates thread classes & starts them
    UDPSenderThread2 mythread = new UDPSenderThread2(newSong, stopThisLoop);
    UDPRecieverThread mythread2 = new UDPRecieverThread();

    Thread thread = new Thread(mythread);
    Thread thread3 = new Thread(mythread2);

    thread.start();
    thread3.start();
    System.out.println("Thread created");
  }
}
