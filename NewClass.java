/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package a.m_musicplayer;

import javax.swing.*;
import java.awt.*;
import	jm.JMC;
import	jm.music.data.*;
import	jm.util.Play;

public class NewClass extends JPanel {
    public void paintComponent(Graphics g){
        Image pic = new ImageIcon("/Users/monicakavathekar/Documents/Photos/FullSizeRender.jpg", "cover").getImage();
        g.drawImage(pic, 0, 0, this);

    }
}
