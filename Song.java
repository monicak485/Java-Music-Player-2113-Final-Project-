/*////////////////////////////////
Software Engineering Final Project
Grace Gowanlock, Monica Kavathekar,
and Abia Khan
Professor James
4/29/18
////////////////////////////////*/

import java.util.*;
import java.util.LinkedList.*;
import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import jm.util.Read;
import jm.util.Write;
import javax.swing.*;
import java.awt.*;

/*This is our song class. It contains all the information that a Song object
needs as variables in the class,
and its methods allow it to be printed and played*/
public class Song extends JPanel{
  String username;
  String artistName;
  String songName;
  String albumName;
  String fileName;
  String coverArtFile;
  String listName;
  float[] songData;
  Song next;
	Song prev;

//Standard constructor
  public Song (String username, String artistName, String songName, String albumName, String fileName, String coverArtFile){
   this.username = username;
   this.artistName = artistName;
   this.songName = songName;
   this.albumName = albumName;
   this.fileName = "/Users/monicakavathekar/jMusic/2113FinalProject/Audio/";
   this.fileName += fileName;
   this.coverArtFile = coverArtFile;
   this.songData = Read.audio(fileName);
  }

//toString method
  public String toString(){
    String output = username + " is playing " + songName + " by " + artistName +" from album " + albumName + "\n";
    return output;
  }
  //Play method
  public void Play(){
    //System.out.println("Now Playing: " + songName + " by " + artistName +" from album " +albumName);
    Write.audio(songData,"myMix.wav",2,44100,16);
    Play.au("myMix.wav", false);
  }
}
