package gameTest;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import Text;
import Enemies.Skeleton;
import entities.Building1;
import entities.Cow;
import entities.Crate1;
import entities.EntityManager;
import entities.Grave;
import entities.Haybale1;
import entities.Tree;
import entities.checkPoint;
import entities.streetLamp;
import entities.warpTile;
import gameTest.display.Assets;
import gameTest.display.DayNight;
import gameTest.display.Fader;
import inventory.Notifier;
import items.itemManager;

public class World {
private Handler handler;
	private int width, height; 
private int spawnX, spawnY;
private int[][] tiles;
private int[][] treeLocations;
private String path;
private Fader fader;
private EntityManager entityManager;
private Notifier notifier;
private DayNight dayNight;

//item
private itemManager ItemManager;


	public World(Handler handler,String path)  {
		loadTrees();
		
			this.handler = handler;
			
			this.path = path;
			dayNight = new DayNight(handler);
			fader = new Fader(handler);
			entityManager = new EntityManager(handler, new Player(handler,100,200,1));
			ItemManager = new itemManager(handler);
	    	notifier = new Notifier(handler, 213 , 286, 195, 34);
	    	loadWorld(path);
	    	
	    	entityManager.getPlayer().setX(spawnX);
	    	entityManager.getPlayer().setY(spawnY);
	    	
	    	//world warps WarpNo <50 Warps on buildings >50
		      
	    	
	    	//graveyard
	    	
	    	entityManager.addEntity(new Grave(handler,200,450));
	    	entityManager.addEntity(new Grave(handler,140,386));
	    	entityManager.addEntity(new Grave(handler,240,375));
	    	
	    	entityManager.addEntity(new Grave(handler,510,375));
	    	entityManager.addEntity(new Grave(handler,570,386));
	    	entityManager.addEntity(new Grave(handler,606,450));
	    	entityManager.addWarp(new warpTile(handler,350,515,833,1600,true,0));//graveyard spawn
		       
	    	
	    	 //Town1
	    	entityManager.addEntity(new checkPoint(handler,833,1632)); //graveyard checkpoint
	    	entityManager.addEntity(new Skeleton(handler,208,1500,2));
	    	entityManager.addEntity(new Skeleton(handler,100,1500,2));
	    	entityManager.addEntity(new Skeleton(handler,300,1500,2));
	    	entityManager.addEntity(new Grave(handler,710,1632));
	    	entityManager.addEntity(new Grave(handler,943,1636));
	    	entityManager.addEntity(new Grave(handler,880,1580));
	    	  
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));
	      	entityManager.addEntity(new Tree(handler,handler.getRandomNumber(10, 900),handler.getRandomNumber(1000,1250),0,0));

	    	entityManager.addEntity(new Building1(handler,208,1210,1090,288)); entityManager.addWarp(new warpTile(handler,1088,332,224,1340,true,1));
	    	 
	    	 
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new Cow(handler, handler.getRandomNumber(0, 600),  handler.getRandomNumber(1500, 2000),1));
	    	entityManager.addEntity(new streetLamp(handler,100,1500));
	    	entityManager.addEntity(new Haybale1(handler,400,1900));
	    	entityManager.addEntity(new Crate1(handler,1000,208));
	    	
	}

	public Notifier getNotifier() {
		return notifier;
	}

	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public void tick() {
		for(int i = 0; i<tile.tiles.length;i++) {
			if(tile.tiles[i] != null) {
			tile.tiles[i].tick();
			}
		}
		ItemManager.tick();
		entityManager.tick();
	    notifier.tick();
		fader.tick();
		dayNight.tick();
	}
	public void render(Graphics g) {
	
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / tile.TILEWIDTH ); //+1 for render effect
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+ handler.getWidth()) / tile.TILEWIDTH +1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset()+ handler.getHeight()) / tile.TILEWIDTH +1);
		
		
		for(int y = yStart; y<yEnd;y++) {
			for(int x = xStart; x <xEnd; x++) {
				getTile(x,y).render(g,(int) (x*tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y*tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//entitys
		
		ItemManager.render(g);
		entityManager.render(g);
		Text.drawString(g,"FPS:"+ Integer.toString(handler.getEngine().getFps()), 4, 300, false, Color.WHITE, Assets.font8);
		Text.drawString(g,"X: " + Integer.toString((int)handler.getMouseManager().getMouseX() + (int)handler.getGameCamera().getxOffset()) + " Y: " + Integer.toString((int)handler.getMouseManager().getMouseY() + (int)handler.getGameCamera().getyOffset()) , 4, 280, false, Color.WHITE, Assets.font8);
		dayNight.render(g);
		fader.render(g);
		
      
		
		
	}
	public Fader getFader() {
		return fader;
	}

	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public itemManager getItemManager() {
		return ItemManager;
	}
	public void setItemManager(itemManager itemManager) {
		ItemManager = itemManager;
	}
	public tile getTile(int x, int y) {
		if(x< 0 || y<0 || x >= width || y>= height )
		return tile.errorTile;
		tile t = tile.tiles[tiles[x][y]];
				if(t == null)
					return tile.errorTile;
		return t;
	}
	private void loadTrees() {
	
		treeLocations = new int[2][3];
		
	}
	@SuppressWarnings("deprecation")
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		//String[] tokens = file.split(",");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
	tiles = new int[width][height];
	
	for (int y = 0; y<height; y++) {
		for (int x = 0; x<width; x++) {
			tiles[x][y] = Utils.parseInt(tokens[(x+y *width +4)]);
			
		}
	}

	
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}


}