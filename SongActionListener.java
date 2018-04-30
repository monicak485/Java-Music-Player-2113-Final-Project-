/*////////////////////////////////
Software Engineering Final Project
Grace Gowanlock, Monica Kavathekar,
and Abia Khan
Professor James
4/29/18
////////////////////////////////*/

import java.util.*;
import java.util.LinkedList.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//Action listener to play songs in order
public class SongActionListener implements ActionListener {
    //fields
    int listSize; //list size to be used when list is converted into an array
    int index; //index to hold place in the list
    LinkedList<Song> mixtape; //the linked list
    Song[] listArray; //array for the list to be converted to 

    //constructor
    public SongActionListener(int listSize, LinkedList<Song> mixtape, int index) {
        this.listSize = listSize;
        this.mixtape = mixtape;
        index = 0; //index is initialized to 0
        this.index = index;
    }

    public void actionPerformed(ActionEvent e) {
      if (index < listSize){ //checks that index is within the size of the list
        listArray = mixtape.toArray(new Song[listSize]); //converts list to array 
         //creates a now playing frame for the song at the point in the list (@index)
        NowPlayingFrame nowPlaying = new NowPlayingFrame(listArray[index], listArray[index].coverArtFile);
        nowPlaying.runThread(listArray[index]); //runs a thread for this info to be sent over the server
        index++; //increments index so the next time the button is pressed, it will play the next song in order
      }
      else //in case the end of list has been reached
        System.out.println("End of List Reached");
    }
  }
