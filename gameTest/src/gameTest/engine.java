package gameTest;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import gameTest.display.Assets;
import gameTest.display.ImageLoader;
import gameTest.display.display;
import gameTest.display.spriteSheet;
import gameTest.MouseManager;

public class engine implements Runnable {
	
	
	private display disp;
	private int width, height;
	public String title;
    private Thread thread;
    
	private boolean running = false;
	private int Fps;
	private BufferStrategy bs;
	private Graphics g;

	//states
	public State gameState;
	public State menuState;
	
	public State getGameState() {
		return gameState;
	}
	//input
	private keyManager KeyManager;
	private MouseManager mouseManager;
	
	//camera
	private GameCamera gameCamera;
	
	//handler
	private Handler handler; 
	public engine(String title, int width, int height) {
		System.setProperty("sun.java2d.opengl", "true");
		Fps = 0;
		this.width = width;
		this.height = height;
		this.title = title;
		KeyManager = new keyManager();
		mouseManager = new MouseManager();
	}
	private void init() {
		disp = new display(title, width, height); 
		disp.getFrame().addKeyListener(KeyManager);
		
	
	disp.getFrame().addMouseListener(mouseManager);
	disp.getFrame().addMouseMotionListener(mouseManager);
	disp.getCanvas().addMouseListener(mouseManager);
	disp.getCanvas().addMouseMotionListener(mouseManager);
	
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		gameState = new gameState(handler);
		menuState = new menuState(handler);
		State.setState(gameState);
		Cursor curs = Toolkit.getDefaultToolkit().createCustomCursor(Assets.cursor, new Point(16,16), "curs");
		disp.getFrame().setCursor(curs);
	
	}
	
	private void tick() {
		KeyManager.tick();
		//cursor.render(g);
		
		
	
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	private void render() {
		
		bs = disp.getCanvas().getBufferStrategy();
		if(bs == null) {
			disp.getCanvas().createBufferStrategy(3);
		return;
		}
		g = bs.getDrawGraphics();
		
		//clear screen
		g.clearRect(0,0,width,height);
		//draw here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		

		//end draw
		
		bs.show();
		g.dispose();
	}
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/ fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta>=1) {
		tick();
		render();
		ticks++; 
		delta--;
			}
			if(timer>= 1000000000) {
				//System.out.println("ticks and frames:" + ticks);
				Fps = ticks;
				ticks = 0;
				timer = 0;
			}
			
		}
		stop();
		
		
	}
	public int getFps() {
		return Fps;
	}
	public keyManager getKeyManager() {
		
		return KeyManager;
	}
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	public GameCamera getGameCamera() {
		
		return gameCamera;
	}
	public int getWidth() {
		
		return width;
	}
	public int getHeight() {
		
		return height;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		
		thread.start();
	}
public synchronized void stop() {
	if(!running)
		return;
	running = false;
	try {
	
		thread.join();
		
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	
}
