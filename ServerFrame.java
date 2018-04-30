/*////////////////////////////////
Software Engineering Final Project
Grace Gowanlock, Monica Kavathekar,
and Abia Khan
Professor James
4/29/18
////////////////////////////////*/

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


/*Now Playing Frame- this frame pops up whenever the user starts to play a song*/
public class ServerFrame extends JFrame {
  ServerFrame(byte[] array){
    this.setTitle ("Your Friend is listening to....");
    this.setResizable (true);
    this.setSize (300, 300);

    Container cPane = this.getContentPane();
    JLabel L = new JLabel ("Your Friend is Playing: ");
    L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 24));

    cPane.setBackground(new java.awt.Color(0,204,204));

    cPane.add (L, BorderLayout.NORTH);

    JTextArea songText = new JTextArea();
    songText.setText(new String(array).trim());
    songText.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
    cPane.add(songText, BorderLayout.CENTER);

    this.setVisible (true);
}
}
