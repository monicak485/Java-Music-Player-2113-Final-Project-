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

    public SongActionListener(int listSize, LinkedList<Song> mixtape, int index) {
        this.listSize = listSize;
        this.mixtape = mixtape;
        index = 0;
        this.index = index;
        System.out.println("Size: " + listSize);
    }

    public void actionPerformed(ActionEvent e) {
      System.out.println("Size " + listSize);
      Object[] listArray = mixtape.toArray();
      System.out.println(listArray[index]);
      index++; 
      }
    }
