package basicPackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

public class TwoPlayerGame {

	private JFrame frame;
	private JLabel player1;
	private JTextField txtInput;
	
	private int Dspeed = 4;
	private int speed = 0;
	private boolean arrowR,arrowL,arrowU = false;
	
	public int milisecs = 10;
	public Timer stepitup = new Timer(milisecs,new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			update();
		}
	});
	private JLabel shot1;
	private JLabel testEnemy;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	
	private int hitbox1[] = new int[2];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoPlayerGame window = new TwoPlayerGame();
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
	public TwoPlayerGame() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		txtInput = new JTextField();
		txtInput.addKeyListener(new KeyAdapter() {
			@Override
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
		
		//Test enemy for hitbox detection
		testEnemy = new JLabel("test");
		testEnemy.setBackground(Color.CYAN);
		testEnemy.setBounds(379, 78, 50, 50);
		testEnemy.setOpaque(true);
		frame.getContentPane().add(testEnemy);
		
		label = new JLabel("test");
		label.setOpaque(true);
		label.setBackground(Color.CYAN);
		label.setBounds(128, 60, 50, 50);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("test");
		label_1.setOpaque(true);
		label_1.setBackground(Color.CYAN);
		label_1.setBounds(529, 78, 50, 50);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("test");
		label_2.setOpaque(true);
		label_2.setBackground(Color.CYAN);
		label_2.setBounds(258, 94, 50, 50);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("test");
		label_3.setOpaque(true);
		label_3.setBackground(Color.CYAN);
		label_3.setBounds(25, 60, 50, 50);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("test");
		label_4.setOpaque(true);
		label_4.setBackground(Color.CYAN);
		label_4.setBounds(649, 42, 50, 50);
		frame.getContentPane().add(label_4);
		
		//PLAYER ONE BULLET
		shot1 = new JLabel("");
		shot1.setBackground(Color.MAGENTA);
		shot1.setBounds(424, 330, 8, 30);
		shot1.setOpaque(true);
		shot1.setVisible(false);
		frame.getContentPane().add(shot1);
		
		stepitup.start();
	}
	
	//Runs every timer tick
	public void update(){

		if(arrowU || (arrowL && arrowR && arrowU )){
			shoot1();
		}
		
		
		
		player1mvmt();
		
		if(shot1.isVisible()){
			collisioncheck();
		}
		
		bulletmvmt();
	}
	
	
	private void player1mvmt(){
		//Determine movement direction
		if(arrowL ^ arrowR){
			if(arrowL){
				speed = -Dspeed;
			}
			else if(arrowR){
				speed = Dspeed;
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
			shot1.setLocation(shot1.getX(), shot1.getY() - 5);
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
	
	private void collisioncheck(){
		
		hitbox1[0] = shot1.getX();
		hitbox1[1] = shot1.getX() + shot1.getWidth();
		
		for(int i = 0; i < 2;i++){
			Component c = frame.findComponentAt(hitbox1[i], shot1.getY() + (shot1.getHeight())); //+30?
			if(c instanceof JLabel && !c.equals(player1)&& !c.equals(shot1)){
				c.setVisible(false);
				shot1.setVisible(false);
			}
		}
	}
}
