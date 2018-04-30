/*////////////////////////////////
Software Engineering Final Project
Grace Gowanlock, Monica Kavathekar,
and Abia Khan
Professor James
4/29/18
////////////////////////////////*/

//package a.m_musicplayer;

import javax.swing.*;
import java.awt.*;
import	jm.JMC;
import	jm.music.data.*;
import	jm.util.Play;

public class NewImage extends JPanel {
    String coverArtFile;
    public NewImage(String coverArtFile){
      this.coverArtFile = coverArtFile;
    }
    public NewImage(){
      
    }
    public void paintComponent(Graphics g){
        Image pic = new ImageIcon(coverArtFile, "cover").getImage();
        g.drawImage(pic, 0, 0, this);

    }

}
