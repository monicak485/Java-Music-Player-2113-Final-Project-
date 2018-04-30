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
import java.util.Random;

//Action listener that plays songs in a random order
public class RandomActionListener implements ActionListener {
    //fields
    int listSize; //Size so that the array can parse through 
    int randomIndex; //index number of the song that is being played
    LinkedList<Song> mixtape; //the linked list
    Song[] listArray; //the array that the list is converted to to play 

    //Constructor
    public RandomActionListener(int listSize, LinkedList<Song> mixtape) {
        this.listSize = listSize; 
        this.mixtape = mixtape;
        //System.out.println("Size: " + listSize);
    }

    public void actionPerformed(ActionEvent e) {
      listArray = mixtape.toArray(new Song[listSize]); //converts linked list to array of Song type
      randomIndex = new Random().nextInt(listSize); //generates a random number for the index
      listArray[randomIndex].toString(); //generates the details of the song that's playing
      //Creates a new instance of a NowPlaying frame that will display the info
      NowPlayingFrame nowPlaying = new NowPlayingFrame(listArray[randomIndex], listArray[randomIndex].coverArtFile);
      nowPlaying.runThread(listArray[randomIndex]); //Runs the thread so that this info will be sent over the server
      //listArray[randomIndex].Play();
    }
  }
