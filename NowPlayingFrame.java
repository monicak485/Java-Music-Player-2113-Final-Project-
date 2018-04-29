import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.LinkedList.*;
import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import java.util.ListIterator;



public class NowPlayingFrame extends JFrame {

  NowPlayingFrame(Song songPlaying, String coverArtFile){
    this.setTitle ("Now Playing");
    this.setResizable (true);
    this.setSize (300, 300);

    NewImage imageViewer;
    imageViewer = new NewImage(coverArtFile);
    imageViewer.setSize(700, 700);


    Container cPane = this.getContentPane();
    JLabel L = new JLabel ("Now Playing");
    L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 24));

    cPane.setBackground(new java.awt.Color(0,204,204));

    cPane.add (L, BorderLayout.NORTH);
    cPane.add (imageViewer, BorderLayout.CENTER);

    JTextArea songText = new JTextArea();
    songText.setText(songPlaying.toString());
    cPane.add(songText, BorderLayout.SOUTH);

    this.setVisible (true);
  }
}
