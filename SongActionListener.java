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

public class SongActionListener implements ActionListener {
    int listSize;
    int index;
    LinkedList<Song> mixtape;
    Song[] listArray;

    public SongActionListener(int listSize, LinkedList<Song> mixtape, int index) {
        this.listSize = listSize;
        this.mixtape = mixtape;
        index = 0;
        this.index = index;
        //System.out.println("Size: " + listSize);
    }

    public void actionPerformed(ActionEvent e) {
      if (index < listSize){
        //System.out.println("Size " + listSize);
        listArray = mixtape.toArray(new Song[listSize]);
        //System.out.println(listArray[index]);
        NowPlayingFrame nowPlaying = new NowPlayingFrame(listArray[index], listArray[index].coverArtFile);
        //listArray[index].Play();
        index++;
      }
      else
        System.out.println("End of List Reached");
    }
  }
