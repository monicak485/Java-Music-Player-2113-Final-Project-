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


    Container cPane = this.getContentPane();
    JLabel L = new JLabel ("Now Playing");
    L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 24));

    cPane.setBackground(new java.awt.Color(0,204,204));

    cPane.add (L, BorderLayout.NORTH);
    cPane.add (imageViewer, BorderLayout.CENTER);

    JTextArea songText = new JTextArea();
    songText.setText(songPlaying.toString());
    songText.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
    cPane.add(songText, BorderLayout.SOUTH);

    this.setVisible (true);
    songPlaying.Play();
  }
}
