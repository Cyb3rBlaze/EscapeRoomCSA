package com.cyber.GameUtils;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.cyber.Main.Main;

public class SettingContainer {
	//GameObject Declarations
		//Setting object
	private Setting setting;
		//Player object
	private Player controller;
	
	//Movement colliders
	private Rectangle2D left;
	private Rectangle2D right;
	
	//Field properties
	private int fieldWidth;
	private int fieldHeight;
	
	/***************************************************************************/
	
	public SettingContainer(int fieldWidth, int fieldHeight) {
		//Initializing player object
		try {
			this.fieldWidth = fieldWidth;
			this.fieldHeight = fieldHeight;
			
			controller = new Player(500, 200, 200, 200, ImageIO.read(new File("res/playerSpriteSheet.png")), true);
			
			//Initializing setting
			int[] field = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
					2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
					2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
					2, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 2, 0, 0, 0, 1, 1, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
					2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
					2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
					2, 1, 1, 2, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 2,
					2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 0, 0, 2, 2, 0, 2, 2, 2, 2, 0, 0, 2, 2, 2, 0, 2, 2, 0, 0, 2, 2, 2, 0, 0, 2, 2, 2, 2};
			
			setting = new Setting(field, ImageIO.read(new File("res/setting.png")), fieldWidth, fieldHeight, 40, 8, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Initializing Movement Colliders
		left = new Rectangle2D.Double(200, 0, 100, 800);
		right = new Rectangle2D.Double(600, 0, 100, 800);
	}
	
	/***************************************************************************/
	
	//Updates Setting properties every frame
	public void render() {
		//Rendering setting properties
		setting.render();
		
		//Rendering the user
		controller.render();
	}
	
	//Updates Setting graphics every frame
	public void paintComponent(Graphics2D g2) {
		//Painting background image
		try {
			g2.drawImage(ImageIO.read(new File("res/background.png")), 0, 0, Main.WIDTH, Main.HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		controller.paintComponent(g2);
		//Painting setting to window
		setting.paintComponent(g2);

		
		if(controller.borders[3].intersects(left)) {
			if(setting.getParentX() < 0) {
				controller.setX(controller.getX()+2);
				setting.setParentX(setting.getParentX()+2);
			}
		}
		else if(controller.borders[1].intersects(right)) {
			if(setting.getParentX() > -fieldWidth+1000) {
				controller.setX(controller.getX()-2);
				setting.setParentX(setting.getParentX()-2);
			}
		}
		
		for(int i = 0; i < setting.getFieldColliders().length; i++) {
			if(controller.borders()[0].intersects(setting.getFieldColliders()[i])) {
				controller.setVelY(4);
				controller.setStopped(false);
			}
			if(controller.borders()[1].intersects(setting.getFieldColliders()[i])) {
				controller.setX(controller.getX()-2);
			}
			if(controller.borders()[2].intersects(setting.getFieldColliders()[i])) {
				controller.setVelY(0);
				controller.setJumped(false);
				if(controller.getStopped()) {
					controller.setCurrMove(1);
				}
			}
			if(controller.borders()[3].intersects(setting.getFieldColliders()[i])) {
				controller.setX(controller.getX()+2);
			}
		}
	}
	
	/***************************************************************************/
	
	//KeyListener methods
	public void keyPressed(KeyEvent e) {
		controller.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		controller.keyReleased(e);
	}
}
