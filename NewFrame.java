//package a.m_musicplayer;
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
    String addressCoverArt;
    JTextField usernameText = new JTextField(10);     // Address (TextArea)
    String username;
    JMenuBar mb;                // The menubar.
    JButton jButton1;
    JButton jButton2;

    //////////////////////////////////////////////////////////////////////////////////

    JTextField text;
    JTextArea area;
    JButton button;
    Image img;


    LinkedList mixtape = new LinkedList(); //mixtape linked list
    int listSize, index;
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

        cPane.setBackground(new java.awt.Color(0,204,204));

	//align the text to the center
        L.setHorizontalAlignment(SwingConstants.CENTER);
        cPane.add (L, BorderLayout.NORTH);

        // Now the center panel.
        centerpanel = new JPanel ();
        centerpanel.setLayout (new GridLayout (4,1));

        // Each widget is created in a separate method.
        centerpanel.add ( username() );
        centerpanel.add ( albumName() );
        centerpanel.add ( artistName() );
        centerpanel.add ( songName() );
        centerpanel.add ( address() );
        centerpanel.add ( addressCoverArt() );


	
        sc = new JScrollPane (centerpanel);
        cPane.add (sc, BorderLayout.CENTER);

        mb = new JMenuBar ();
        mb.add ( makeActionMenu() );

        this.setJMenuBar (mb);

        // Finally, show the frame.
        this.setVisible (true);
    }

  //This is the LinkedList. will actually display the images, etc.
    public NewFrame (int listSize, LinkedList mixtape){

      this.setTitle ("Playlist");
      this.setResizable (true);
      this.setSize (300, 800);

      Container cPane = this.getContentPane();

      // First, a welcome message:
      JLabel L = new JLabel ("Playlist");
      L.setFont (new Font ("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

      JPanel upPanel = new JPanel ();
    	upPanel.setLayout (new GridLayout (2,1));

	    //align title text to the center
      L.setHorizontalAlignment(SwingConstants.CENTER);
      upPanel.add (L);
	    cPane.add (upPanel, BorderLayout.CENTER);
      upPanel.setBackground(new java.awt.Color(0,204,204));

	//area that displays the list of songs
      area = new JTextArea();
      cPane.add(BorderLayout.SOUTH, area);

//add button and implement action listener for play next song
      System.out.println("Size: " + listSize);
      JButton playnext = new JButton ("Play next song ");
      playnext.setFont (new Font ("Serif", Font.PLAIN | Font.BOLD, 15));
        playnext.addActionListener (
        new SongActionListener (listSize, mixtape, index) );

//add button and implement action listener for play random song
      JButton playrandom = new JButton ("Play random song ");
	    playrandom.setFont (new Font ("Serif", Font.PLAIN | Font.BOLD, 15));
	    playrandom.addActionListener (
	     new RandomActionListener (listSize, mixtape) {
	     }
	    );

      {
	//add buttons to the panel
      	JPanel subpanel = new JPanel ();
      	subpanel.setLayout (new GridLayout (4,1));
        subpanel.add(area);
        subpanel.add(playnext);
  	    subpanel.add(playrandom);


	      //add subpanel to the content pane
	      cPane.add (subpanel, BorderLayout.SOUTH);
        subpanel.setBackground(new java.awt.Color(0,204,204));
	      
	      //add buttonPanel to the content pane

        JPanel buttonPanel = new JPanel ();
	      buttonPanel.setLayout (new GridLayout (6,2));
        cPane.add (buttonPanel, BorderLayout.NORTH);
      }
	    // Finally, show the frame.
	    this.setVisible (true);
    }
    //End Constructor

    ////////////////////////////////

    JPanel username ()
    {
	    //create new subpanel
      	JPanel subpanel = new JPanel ();

      	// a user label before the textfield.
      	JLabel L = new JLabel ("Username:");
      	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
      	subpanel.add (L);

	 //gets the text the user entered for the username 
      	albumNameText.setForeground (Color.blue);
      	subpanel.add (usernameText);
        String username = usernameText.getText();
      	return subpanel;
    }

    JPanel albumName ()
    {
      	JPanel subpanel = new JPanel ();

      	// a album name label before the textfield.
      	JLabel L = new JLabel ("Album Name:");
      	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
      	subpanel.add (L);

	 //gets the text the user entered for the album name
      	albumNameText.setForeground (Color.blue);
      	subpanel.add (albumNameText);
        String albumName = albumNameText.getText();
      	return subpanel;
    }

    JPanel artistName ()
    {
	     JPanel subpanel = new JPanel ();

      	// a artist name label before the textfield.
    	JLabel L = new JLabel ("Artist Name:");
    	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
    	subpanel.add (L);
	    
	 //gets the text the user entered for the artist name
    	artistNameText.setForeground (Color.blue);
    	subpanel.add (artistNameText);

    	return subpanel;
    }

    JPanel songName ()
    {
    	JPanel subpanel = new JPanel ();
	    
      	// a song title label before the songtitle.
    	JLabel L = new JLabel ("Song Title:");
    	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
    	subpanel.add (L);
	    
	 //gets the text the user entered for the songtitle
    	songNameText.setForeground (Color.blue);
    	subpanel.add (songNameText);

    	return subpanel;
    }


    JPanel address ()
    {
    	JPanel subpanel = new JPanel ();
      	// a song title label before the filename for song.
    	JLabel L = new JLabel ("Filename for Song:");
    	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
    	subpanel.add (L);
	    
	 //gets the text the user entered for the filename for song.
    	addressTextA.setForeground (Color.blue);
    	subpanel.add (addressTextA);

    	return subpanel;
    }

    JPanel addressCoverArt ()
    {
      	JPanel subpanel = new JPanel ();
      	// a song title label before the filename for album cover art
      	JLabel L = new JLabel ("Filename for album cover art:");
      	L.setFont (new Font ("SansSerif", Font.ITALIC, 15));
      	subpanel.add (L);
	    
	 //gets the text the user entered for the filename for album cover art
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
              username = usernameText.getText();
              albumName = albumNameText.getText();
              artistName = artistNameText.getText();
              songName = songNameText.getText();
              address = addressTextA.getText();
              addressCoverArt = addressTextB.getText();

              Song newSong = new Song (username, artistName, songName, albumName, address, addressCoverArt);
              mixtape.add(newSong);
              System.out.println("Successfully added: " + newSong.toString());
              //System.out.println(mixtape.toString());
              listSize = mixtape.size();
              //System.out.println("Size: " + listSize);
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
                  addressCoverArt = "";  addressTextB.setText (addressCoverArt);

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
              System.out.println(mixtape.toString());
              System.out.println(addressCoverArt);
              NewFrame display = new NewFrame(mixtape.size(), mixtape);
              display.area.setText(mixtape.toString());
            }
              }
                );
    actionMenu.add (displayMenuItem);
    return actionMenu;
  }
}
