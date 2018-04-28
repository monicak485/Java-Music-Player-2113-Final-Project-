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

    public RandomActionListener(int listSize, LinkedList<Song> mixtape) {
        this.listSize = listSize;
        this.mixtape = mixtape;
        //System.out.println("Size: " + listSize);
    }

    public void actionPerformed(ActionEvent e) {
      Object[] listArray = mixtape.toArray();
      randomIndex = new Random().nextInt(listSize);
      System.out.println(listArray[randomIndex]);
    }
  }
