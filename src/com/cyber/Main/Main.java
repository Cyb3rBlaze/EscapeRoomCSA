package com.cyber.Main;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Main {
	//Initializing global window attributes
	public static int WIDTH = 1000;
	public static int HEIGHT = 800;
	
	/***************************************************************************/
	
	static Clip clip;
	
	//Main Method
	public static void main(String[] args) {
		//Creating window object
		JFrame window = new JFrame();
		Panel panel = new Panel();
		
		/***********************************************************************/
		
		//Initializing window attributes
		window.setSize(1000, 800);
		window.setLocationRelativeTo(null);
		window.setTitle("AP CSP Exam Create Task");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
			//Adding a panel object to the window
		window.add(panel);
		window.setVisible(true);
		
		//Audio stuff
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res/audio.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
