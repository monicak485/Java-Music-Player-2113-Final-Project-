import java.util.*;
import java.util.LinkedList.*;
import	jm.JMC;
import	jm.music.data.*;
import	jm.util.Play;
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
   //this.songData = Read.audio(fileName);
  }
  public Song(){

  }
  public String toString(){
    String output = "Artist : " + artistName + " Song: " + songName + " Album: " + albumName;
    return output;
  }
/*  public void play(LinkedList Playlist)
	{
		Object counter = new Song();
    counter = Playlist.getFirst(); //finds the head
		int playlistLength = 0;
		while (counter != null)
		{
			playlistLength += counter.songData.length;
			counter = counter.next;
		}

		float[] hugeArray = new float[playlistLength];

		counter = Playlist.getFirst();
		int count = 0;
		while (counter != null)
		{
			for (int i = 0; i < counter.songData.length; i++)
			{
				hugeArray[count] = counter.songData[i];
				count++;
			}
			counter = counter.next;
		}
		counter = Playlist.getFirst();
		while (counter != null)
		{
			Write.audio(hugeArray, "myMix.wav",2,44100,16);
			Play.au("myMix.wav");
			counter = counter.next;
		}
	}*/
}
