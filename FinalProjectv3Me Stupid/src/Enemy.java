import java.awt.Color;
import java.util.*;
import java.util.Random;

import javax.swing.JLabel;

public class Enemy extends JLabel{
	private String id;
	private int health, speed, wFrame, hFrame;
	private ArrayList<Color> colors = new ArrayList<Color>();
	
	//Constructor for enemy class
	public Enemy(String s, int hp, int spd, int width, int height){
		id = s;
		health = hp;
		speed = spd;
		wFrame = width; //Width of the frame, not the enemy itself
		hFrame = height; //Height of the frame, not the enemy itself
		
		this.setBackground(Color.CYAN);
		this.setSize(50,50);
		this.setOpaque(true);
		this.setVisible(false);
	}
	
	//Spawns the enemy at a random spawn location
	public void spawn(){
		Random rn = new Random();
		int x = Math.abs(rn.nextInt()) % (wFrame - this.getWidth() + 1);
		
		//Places the enemy right above the screen
		this.setLocation(x, -this.getHeight());
		this.setText(id + ", "+ x);
		this.setVisible(true);
		this.initColors();
		this.setColor(health);
	}
	
	//Spawns the enemy at a specified X coordinate
	public void spawn(int xPos){
		if(!inBounds(xPos))
		{
			this.spawn();
			return;
		}
		
		//Place enemy at specified location, right above the screen
		this.setLocation(xPos, -this.getHeight());
		this.setText(id + ", "+ xPos);
		this.setVisible(true);
		this.initColors();
		this.setColor(health);
	}
	
	//If the enemy is hit, lowers health and changes color
	public void hit(){
		health--;
		if(health <= 0){
			this.setVisible(false);
			return;
		}
		this.setColor(health);
	}
	
	//Move the enemy, according to it's move type
	public void move(){
		if(this.isVisible()){
			this.setLocation(this.getX(), this.getY() + speed);
		}
	}
	
	//Creates an arrayList of colors for the different health values
	// This one is ROY G BIV, with Red being the lowest health
	public void initColors()
	{
		colors.add(new Color(255, 51, 0)); //Deep Red
		colors.add(new Color(255, 153, 51)); //Deep Orange
		colors.add(new Color(255, 255, 102)); //Bright Yellow
		colors.add(new Color(204, 255, 102)); //Bright Green
		colors.add(new Color(102, 255, 204)); //Green-Blue
		colors.add(new Color(0, 255, 255)); //Cyan
		colors.add(new Color(51, 204, 255)); //Medium Blue
		colors.add(new Color(0, 51, 204)); //Dark Blue
	}
	
	//Sets color to the specified int value
	public void setColor(int num)
	{
		num--;
		if(num >= colors.size())
		{
			this.setBackground(colors.get(colors.size()-1));
			return;
		}
		if(num < 0)
		{
			this.setBackground(colors.get(0));
			return;
		}
		this.setBackground(colors.get(num));
		
	}
	
	//Returns if a number is in bounds of the frame
	public boolean inBounds(int xPos)
	{
		return (xPos >= 0 && xPos <= wFrame);
	}
	
	//Prints out enemy
	public String toString()
	{
		return "Enemy " + id + ": (" + health + ", " + speed + ")";
	}
}
