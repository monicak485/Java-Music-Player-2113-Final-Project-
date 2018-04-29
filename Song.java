import java.util.*;
import java.util.LinkedList.*;
import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import jm.util.Read;
import jm.util.Write;


public class Song extends Object{
  String artistName;
  String songName;
  String albumName;
  String fileName;
  String coverArtFile;
  String listName;
  float[] songData;
  Song next;
	Song prev;

  public Song (String artistName, String songName, String albumName, String fileName, String coverArtFile){
   this.artistName = artistName;
   this.songName = songName;
   this.albumName = albumName;
   this.fileName = fileName;
   this.coverArtFile = coverArtFile;
   this.songData = Read.audio(fileName);
  }
  public Song(){

  }
  public String toString(){
    String output = "Now Playing: " + songName + " by " + artistName +" from album " + albumName + "\n";
    return output;
  }
  public void Play(){
    System.out.println("Now Playing: " + songName + " by " + artistName +" from album " +albumName);
    Write.audio(songData, "myMix.wav",2,44100,16);
    Play.au("myMix.wav");
  }
}
