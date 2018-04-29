import java.util.*;
import java.util.LinkedList.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class RandomActionListener implements ActionListener {
    int listSize;
    int randomIndex;
    LinkedList<Song> mixtape;
    Song[] listArray;

    public RandomActionListener(int listSize, LinkedList<Song> mixtape) {
        this.listSize = listSize;
        this.mixtape = mixtape;
        //System.out.println("Size: " + listSize);
    }

    public void actionPerformed(ActionEvent e) {
      listArray = mixtape.toArray(new Song[listSize]);
      randomIndex = new Random().nextInt(listSize);
      listArray[randomIndex].toString();
      NowPlayingFrame nowPlaying = new NowPlayingFrame(listArray[randomIndex], listArray[randomIndex].coverArtFile);
      listArray[randomIndex].Play();
    }
  }
