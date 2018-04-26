import java.util.LinkedList.*;

public class Song{
  String artistName;
  String songName;
  String albumName;
  String fileName;
  String coverArtFile;
  String listName;

  public Song (String artistName, String songName, String albumName, String fileName, String coverArtFile){
   this.artistName = artistName;
   this.songName = songName;
   this.albumName = albumName;
   this.fileName = fileName;
   this.coverArtFile = coverArtFile;
  }
  public String toString(){
    String output = "Artist : " + artistName + "Song: " + songName + "Album: " + albumName;
    return output; 
  }
}
