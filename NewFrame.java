/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package a.m_musicplayer;

/*
Group Members: Abia Khan, Monica Kavathekar, Grace Gowanlock
Sources: courtesy of Prof. Simha from Module 11 (CS 2113) and Module 6 (CS 1112)
 */

//package form1;

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



public class NewFrame extends JFrame {

    // Data.
    JPanel centerpanel;         // For the inputs
    JScrollPane sc;             // For placing the centerpanel.
    JTextField artistNameText = new JTextField(10);   // To get the artist name.
    String artistName;
    JTextField albumNameText = new JTextField(10);  // To get the album name.
    String albumName;
    JTextField songNameText = new JTextField(10);   // To get the song name.
    String songName;
    JTextField addressTextA = new JTextField(10);     // To get the filename song name.
    String address;
    JTextField addressTextB = new JTextField(10);     // Address (TextArea)
    String addressB;
    JMenuBar mb;                // The menubar.
    JButton jButton1;
    JButton jButton2;

    //////////////////////////////////////////////////////////////////////////////////

    JTextField text;
    JTextArea area;
    JButton button;
     Image img;

    JList q4List;
    double q4Score = 0;
    JPanel centerpanel1;
    CardLayout card;

    JTextField tf;
    boolean q2Option4;

    LinkedList<Song> Playlist = new LinkedList<Song>();
    DefaultListModel listModel = new DefaultListModel();

    // Constructor for the frame that will allow users to enter data
    public NewFrame (int width, int height)
    {
        this.setTitle ("Song Editor");
        this.setResizable (true);
        this.setSize (width, height);

        Container cPane = this.getContentPane();
        // cPane.setLayout (new BorderLayout());

        // First, a welcome message:
        JLabel L = new JLabel ("Add songs to MAG music player");
        L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 24));
        //L.setForeground (Color.pink);
        cPane.setBackground(new java.awt.Color(0,204,204));

        L.setHorizontalAlignment(SwingConstants.CENTER);
        cPane.add (L, BorderLayout.NORTH);

        // Now the center panel.
        centerpanel = new JPanel ();
        centerpanel.setLayout (new GridLayout (4,1));

        // Each widget is created in a separate method.
        centerpanel.add ( albumName() );
        centerpanel.add ( artistName() );
        centerpanel.add ( songName() );
        centerpanel.add ( address() );
        centerpanel.add ( addressB() );



        sc = new JScrollPane (centerpanel);
        cPane.add (sc, BorderLayout.CENTER);

        mb = new JMenuBar ();
        mb.add ( makeActionMenu() );

        this.setJMenuBar (mb);

        // Finally, show the frame.
        this.setVisible (true);
    }

//This is the playlist. will actually display the images, etc.
    public NewFrame (NewFrame userInput){

    /// ADD IMAGE


      NewClass imageViewer;
      imageViewer = new NewClass();
      imageViewer.setSize(149, 337);

      this.setTitle ("Playlist");
      this.setResizable (true);
      this.setSize (300, 800);

      Container cPane = this.getContentPane();

      // First, a welcome message:
      JLabel L = new JLabel ("Playlist");
      L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 25));


      L.setHorizontalAlignment(SwingConstants.CENTER);
	    cPane.add (L, BorderLayout.NORTH);
      this.setVisible (true);

      cPane.add(BorderLayout.CENTER, imageViewer);

      JButton playnext = new JButton ("Play next song ");
      playnext.setFont (new Font ("Serif", Font.PLAIN | Font.BOLD, 15));
      playnext.addActionListener (
        new ActionListener () {
        		public void actionPerformed (ActionEvent a)
        		{
        		}
	       }
	     );

      JButton playrandom = new JButton ("Play random song ");
	    playrandom.setFont (new Font ("Serif", Font.PLAIN | Font.BOLD, 15));
	    playrandom.addActionListener (
	     new ActionListener () {
		       public void actionPerformed (ActionEvent a)
		       {
		       }
	     }
	    );

      {
      	JPanel subpanel = new JPanel ();
      	subpanel.setLayout (new GridLayout (4,1));

        subpanel.add (playnext);
  	    subpanel.add (playrandom);
        //subpanel.add(userInput.playlistDisplay());

      	// Create a JList with options.
      	String[] songs1 = new String[10];
        /*int i = 0;
        ListIterator<Song> listIt = Playlist.listIterator();
          // Iterating the list
          while(listIt.hasNext()){
             //System.out.println(listIt.next());
             Song nextSong = listIt.next();
             songs1[i] = nextSong.toString();
             System.out.println(songs1[i]);
             i++;
          }*/


      	q4List = new JList(listModel);
      	q4Score = 1;
      	q4List.addListSelectionListener (
          new ListSelectionListener () {
        		public void valueChanged (ListSelectionEvent e)
        		{
        		    q4Score = 1 + q4List.getSelectedIndex();
        		}
        	}
        );
        subpanel.add (q4List);
	      cPane.add (subpanel, BorderLayout.SOUTH);
        subpanel.setBackground(new java.awt.Color(0,204,204));

        JPanel buttonPanel = new JPanel ();
	      buttonPanel.setLayout (new GridLayout (6,2));
        cPane.add (buttonPanel, BorderLayout.NORTH);
      }
	    // Finally, show the frame.
	    this.setVisible (true);
    }
    //End Constructor

    ////////////////////////////////


    JPanel albumName ()
    {
      	JPanel subpanel = new JPanel ();

      	// a label before the textfield.
      	JLabel L = new JLabel ("Artist Name:");
      	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
      	subpanel.add (L);

      	albumNameText.setForeground (Color.blue);
      	subpanel.add (albumNameText);
        String albumName = albumNameText.getText();
      	return subpanel;
    }

    JPanel artistName ()
    {
	     JPanel subpanel = new JPanel ();

    	// The "Album name" label.
    	JLabel L = new JLabel ("Album Name:");
    	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
    	subpanel.add (L);

    	artistNameText.setForeground (Color.blue);
    	subpanel.add (artistNameText);

    	return subpanel;
    }

    JPanel songName ()
    {
    	JPanel subpanel = new JPanel ();

    	JLabel L = new JLabel ("Song Title:");
    	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
    	subpanel.add (L);

    	songNameText.setForeground (Color.blue);
    	subpanel.add (songNameText);

    	return subpanel;
    }


    JPanel address ()
    {
    	JPanel subpanel = new JPanel ();

    	JLabel L = new JLabel ("Filename for Song:");
    	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
    	subpanel.add (L);

    	addressTextA.setForeground (Color.blue);
    	subpanel.add (addressTextA);

    	return subpanel;
    }

    JPanel addressB ()
    {
      	JPanel subpanel = new JPanel ();

      	JLabel L = new JLabel ("Filename for album cover art:");
      	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
      	subpanel.add (L);

      	addressTextB.setForeground (Color.blue);
      	subpanel.add (addressTextB);

      	return subpanel;
    }


    JMenu makeActionMenu ()
    {
    	// Add an "Action" menu with two items.
    	JMenu actionMenu = new JMenu ("Action");

    	// "Load playlist" menu item
    	JMenuItem submitMenuItem = new JMenuItem ("Load in Playlist");
    	submitMenuItem.addActionListener (
    	    new ActionListener () {
            public void actionPerformed (ActionEvent a)
        		{
              albumName = albumNameText.getText();
              artistName = artistNameText.getText();
              songName = songNameText.getText();
              address = addressTextA.getText();
              addressB = addressTextB.getText();

              Song newSong = new Song (artistName, songName, albumName, address, addressB);
              Playlist.add(newSong);
              System.out.println(Playlist.toString());
		         }
	         }
        );

    	actionMenu.add (submitMenuItem);

    	// "Clear" menu item
    	JMenuItem clearMenuItem = new JMenuItem ("Clear Form");
    	clearMenuItem.addActionListener (
    	    new ActionListener () {
          		public void actionPerformed (ActionEvent a)
          		{
          		    // Clear all the fields.
          		    artistName = "";  artistNameText.setText (artistName);
          		    albumName = "";  albumNameText.setText (albumName);
          		    songName = "";  songNameText.setText (songName);
          		    address = "";  addressTextA.setText (address);
                              addressB = "";  addressTextB.setText (addressB);

          		}
          }
      );

      actionMenu.add (clearMenuItem);
      JMenuItem quitMenuItem = new JMenuItem ("Quit");
      quitMenuItem.addActionListener (
        new ActionListener () {
          		public void actionPerformed (ActionEvent a)
          		{
          		    System.exit (0);
          		}
          	    }
                  );
      actionMenu.add (quitMenuItem);


    JMenuItem displayMenuItem = new JMenuItem ("Display Playlist");
    displayMenuItem.addActionListener (
      new ActionListener () {
            public void actionPerformed (ActionEvent a)
            {
              System.out.println(Playlist.toString());
              NewFrame display = new NewFrame(Playlist);
            }
              }
                );
    actionMenu.add (displayMenuItem);
    return actionMenu;
  }
  public NewFrame (LinkedList Playlist){
    System.out.println(Playlist.toString());
    this.setTitle ("Playlist");
    this.setResizable (true);
    this.setSize (300, 300);

    Container cPane = this.getContentPane();
    JLabel L = new JLabel ("Playlist: ");
    L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 24));
    cPane.add(L, BorderLayout.NORTH);

    JLabel PlaylistText = new JLabel(Playlist.toString());
    System.out.println(Playlist.toString());

    cPane.add(PlaylistText, BorderLayout.CENTER);
    this.setVisible (true);
  }
}
