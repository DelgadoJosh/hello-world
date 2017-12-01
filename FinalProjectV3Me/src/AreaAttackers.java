import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

import java.util.*;
import java.io.*;

public class AreaAttackers {

	//Initialize the frame, player, and keyboard input
	private JFrame frame;
	private JLabel player1;
	private JTextField txtInput;
	
	//constants
	private static int SHIP_SPEED_CNST = 4;
	private static int MAX_LIVES = 3;
	private static int ENEMY_DELAY = 100;
	
	private int lives = MAX_LIVES;
	private int speed = 0;
	private int delay = 0;
	private int wave = 0;
	private int enemyCnt = 0;
	private boolean arrowR,arrowL,arrowU = false;
	private boolean allEnemiesDeadInWave, waveDone;
	
	//timer creation
	public int milisecs = 10;
	public Timer stepitup = new Timer(milisecs,new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			update();
		}
	});
	
	//labels
	private JLabel shot1;
	
	//hitbox for shot collision
	private int hitbox1[] = new int[2];
	
	//test array for enemies
	private int size = 15;
	private Enemy[] goons = new Enemy[size];
	
	//EnemyReader for reading in enemy Wave types
	private enemyReader enemyList;
	
	//ArrayLists for storing enemySpawn information
	public static ArrayList<String[]> waveEnemyType;
	public static ArrayList<int[]> waveDelay;
	public static ArrayList<int[]> waveLocation;
	public static ArrayList<Enemy[]> waveEnemies;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaAttackers window = new AreaAttackers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AreaAttackers() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 760, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//PLAYER ONE SHIP
		player1 = new JLabel("");
		player1.setBackground(Color.RED);
		player1.setBounds(400, 371, 64, 64);
		player1.setOpaque(true);
		player1.setText(""+frame.getX());
		frame.getContentPane().add(player1);
		
		//INPUT TEXT FIELD
		//This reads in keyboard input, and thus controls the player
		txtInput = new JTextField();
		txtInput.addKeyListener(new KeyAdapter() {
			@Override
			//Reads in if the Left, Right, and Up Arrow Keys are pressed, and changes the booleans respectively.
			public void keyPressed(KeyEvent nav){
				int keyCode = nav.getKeyCode();
				
				switch( keyCode ) { 
				    case KeyEvent.VK_LEFT:
				    	arrowL = true;
				    	break;
				    case KeyEvent.VK_RIGHT:
				    	arrowR = true;
				    	break;
					case KeyEvent.VK_UP:
						arrowU = true;
						break;
					}
			}
			//Reads if the left, right, and up arrow keys are released, and changes the booleans to false
			public void keyReleased(KeyEvent nav){
				int keyCode = nav.getKeyCode();
				
				switch( keyCode ) { 
				    case KeyEvent.VK_LEFT:
				    	arrowL = false;
				    	break;
				    case KeyEvent.VK_RIGHT:
				    	arrowR = false;
				    	break;
				    case KeyEvent.VK_UP:
				    	arrowU = false;
				    	break;
			    }
			}
		});
		txtInput.setBounds(614, 240, -7, 20);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		//PLAYER ONE BULLET
		shot1 = new JLabel("");
		shot1.setBackground(Color.MAGENTA);
		shot1.setBounds(424, 330, 8, 30);
		shot1.setOpaque(true);
		shot1.setVisible(false);
		frame.getContentPane().add(shot1);
		
		//test array for enemies
		for(int i = 0; i < size; i++){
			goons[i] = new Enemy(i+"",1,1,1,frame.getWidth(), frame.getHeight());
			frame.getContentPane().add(goons[i]);
		}
		
		///Reading in Enemy Types
		enemyList.wFrame = frame.getWidth();
		enemyList.hFrame = frame.getHeight();
		enemyList.initialize();
		waveEnemyType = enemyList.waveEnemyType;
		waveDelay = enemyList.waveDelay;
		waveLocation = enemyList.waveLocation;
		waveEnemies = enemyList.waveEnemies;
		
		//Initializes enemies
		for(int wave = 0; wave < waveEnemies.size(); wave++)
		{
			for(int i = 0; i < waveEnemies.get(wave).length; i++)
			{
				frame.getContentPane().add( waveEnemies.get(wave)[i]);
			}
		}
		
		
		//Begins timer
		stepitup.start();
	}
	
	//Runs every timer tick
	public void update(){

		//If up arrow is pushed, shoot the bullet from the player
		if(arrowU || (arrowL && arrowR && arrowU )){
			shoot1();
		}
		
		//Spawn Enemies
		if(delay == waveDelay.get(wave)[enemyCnt] || waveDelay.get(wave)[enemyCnt] == 0)
		{
			//Spawns in the enemy. In the enemy class, it will check to see if it is within bounds
			//If out of bounds, it will spawn in a random spot.
			waveEnemies.get(wave)[enemyCnt].spawn( waveLocation.get(wave)[enemyCnt]);
			
			enemyCnt++;
			
			//Begins new wave once reached the number of enemies in current wave
			if(enemyCnt >= waveEnemies.get(wave).length)
			{
				wave++;
				enemyCnt = 0;
				//If reaches the end of all the waves
				if(wave >= waveEnemies.size())
				{
					waveDone = true;
					wave--;
				}
			}			
			
			//Immediately spawns in other enemies if their delay is 0
			while(waveDelay.get(wave)[enemyCnt] == 0)
			{
				waveEnemies.get(wave)[enemyCnt].spawn( waveLocation.get(wave)[enemyCnt]);
				enemyCnt++;
				if(enemyCnt >= waveEnemies.get(wave).length)
				{
					wave++;
					enemyCnt = 0;
				}
				//If reaches the end of all the waves
				if(wave >= waveEnemies.size())
				{
					waveDone = true;
					wave--;
					break;
				}
			}
			
			//If reaches the end of all the waves
			if(wave >= waveEnemies.size())
			{
				waveDone = true;
				wave--;
			}
			
			/*
			//Begins new wave once reached the number of enemies in current wave
			if(allEnemiesDeadInWave && waveDone)
			{
				wave++;
				enemyCnt = 0;
				waveDone = false;
			}
			*/
			delay = 0;
		}
		if(!waveDone)
		{
			delay++;
		}
		
		/*
		if(delay == ENEMY_DELAY){
			enemyCnt++;
			if(enemyCnt == size){
				enemyCnt = 0;
			}
			goons[enemyCnt].spawn();
			delay = 0;
		}
		delay++;
		*/
		
		
		
		//Checks for collisions of the bullet is on screen
		if(shot1.isVisible()){
			collisioncheck();
		}
		
		//Moves the enemies in all waves.
		allEnemiesDeadInWave = true;
		for(int wave = 0; wave < waveEnemies.size(); wave++)
		{
			for(int i = 0; i < waveEnemies.get(wave).length; i++)
			{
				if(waveEnemies.get(wave)[i].isVisible()) 
				{
					waveEnemies.get(wave)[i].move();
					allEnemiesDeadInWave = false;
				}
			}
		}
		
		/*
		for(int i = 0; i < size; i++){
			if(goons[i].isVisible()){
				goons[i].move();
			}
		}*/
		
		//Moves the player
		player1mvmt();
		
		//Moves the bullet
		bulletmvmt();
	}
	
	
	private void player1mvmt(){
		//Determine movement direction
		if(arrowL ^ arrowR){
			if(arrowL){
				speed = -SHIP_SPEED_CNST;
			}
			else if(arrowR){
				speed = SHIP_SPEED_CNST;
			}
		}
		else{
			speed = 0;
		}
		
		//If the player will be within bounds, move it
		if((player1.getX() + speed >= 0) && ((player1.getX() + player1.getWidth() + speed) <= (frame.getWidth() - 4))){
			player1.setLocation(player1.getX() + speed, player1.getY());
		}
		
		//test output on player 1 sprite
		player1.setText(player1.getX()+","+(player1.getX() + player1.getWidth()));
	}
	
	private void bulletmvmt(){
		if(shot1.isVisible()){
			shot1.setLocation(shot1.getX(), shot1.getY() - 4);
			if(shot1.getY() < 0){
				shot1.setVisible(false);
			}
		}
	}
	
	private void shoot1(){
		if(!shot1.isVisible()){
			shot1.setVisible(true);
			shot1.setLocation(player1.getX() + ((player1.getWidth() - shot1.getWidth()))/2, player1.getY());
			
		}
	}
	
	//Checks if the bullet hits any enemies
	private void collisioncheck(){
		
		//Gets coordinates of the bullet hitbox, the left and right side respectively
		hitbox1[0] = shot1.getX() - 3;
		hitbox1[1] = shot1.getX() + (shot1.getWidth());
		
		//Checks the bullet hitBox. If its top corners touch the 
		for(int i = 0; i < 2;i++){
			Component c = frame.findComponentAt(hitbox1[i], shot1.getY() + (shot1.getHeight()));
			if(c instanceof Enemy){
				((Enemy) c).hit();
				///*
				shot1.setVisible(true);
				//stepitup.stop();
				//JOptionPane.showMessageDialog(frame, "hitbox: " + i + "\nbullet X: " + shot1.getX()+ "\nenemy X: " + c.getX());
				//stepitup.start();
				//*/
				shot1.setVisible(false);
				break;
			}
			//else if(c instanceof JLabel && !c.equals(player1)&& !c.equals(shot1)){
			//	c.setVisible(false);
			//	shot1.setVisible(false);
			//}
		}
	}
	
	
	
}