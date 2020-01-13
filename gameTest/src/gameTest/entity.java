package gameTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class entity {

	protected static Handler handler;
	protected float x, y;
	protected int width, height;
	protected int health;
	protected int maxHealth;
	protected int Level;
	public static final int DEFAULT_HEALTH = 3;
	public static final int DEFAULT_MAXHEALTH = DEFAULT_HEALTH;
	public boolean active = true;
	public boolean hit = false;
	public boolean attacking = false;
	public boolean entityCollison; 
	public boolean tileCollision; 
	public boolean isBuilding;
	public String entName;
	public boolean vunerable;
	protected BufferedImage headTile;
	private Rectangle pb,eb;

	protected int getHealth() {
		return health;
	}



	public void setHealth(int health) {
		this.health = health;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}
	protected Rectangle bounds;
	//protected static Rectangle playerBounds;
	//protected static Rectangle eBounds;
	protected boolean checkE;
	private static boolean hitting;

	
	public entity(Handler handler, float x, float y, int width, int height, boolean checkE,String name, int lvl,boolean vunerable, boolean building) {
		this.vunerable = vunerable;
		this.Level = lvl;
		entName = name;
		health = DEFAULT_HEALTH;
		maxHealth = DEFAULT_HEALTH;
			isBuilding = building;
		this.handler = handler;
		this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
				this.checkE = checkE;
				hitting = false;
				if(building) {
					
					bounds = new Rectangle(0,height/2+25,width*2,height);
					
				}else {
					bounds = new Rectangle(width/2,height/2,width/2,(int)height);
					
				}
					}
	


	public float getX() {
		return x;
	}



	public void setX(float x) {
		this.x = x;
	}



	public float getY() {
		return y;
	}



	public void setY(float y) {
		this.y = y;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}

public  boolean checkEntityCollisions(float xOffset, float yOffset) {
	for(entity e : handler.getWorld().getEntityManager().getEntities()) {
		if(e.equals(this) || e.entName == "Arrow"|| e.entName == "Player")
			continue;
		if(e.getCollisionBounds(0f,0f,0f,0f).intersects(getCollisionBounds(xOffset, yOffset,0f,0f)))
	
			return true;
	}

		return false;		
		
	}

public boolean checkArrowCollision(entity Arrow) {

	for(entity e : handler.getWorld().getEntityManager().getEntities()) {
		if(e.equals(Arrow))
			continue;
		if(e.getCollisionBounds(0f,0f,0f,0f).intersects(Arrow.bounds))
	
			return true;
	}

		return false;		
		
	}



public  boolean checkPlayerCollisions(entity e) {

pb = new Rectangle((int)handler.getWorld().getEntityManager().getPlayer().getX(),(int)handler.getWorld().getEntityManager().getPlayer().getY(),(int)handler.getWorld().getEntityManager().getPlayer().getWidth(),(int)handler.getWorld().getEntityManager().getPlayer().getHeight());
eb = new Rectangle((int)e.getX(), (int)e.getY(), e.getWidth(), e.getHeight());
if(pb.intersects(eb)) {
	return true;
}else {
	return false;
}
	

}

	
	



		
public  Rectangle getCollisionBounds(float xOffset, float yOffset,float wOffset, float hOffset) {
	return new Rectangle((int) (x + bounds.x + xOffset), (int) (y+ bounds.y + yOffset),(int) (bounds.width+wOffset),(int) (bounds.height+hOffset));
	
}		
		

	public abstract void tick();
	public abstract void render(Graphics g);
    public abstract void die();
    public abstract void interact();
public void hurt(int amt) {
	health -= amt;
if(this != handler.getWorld().getEntityManager().getPlayer()) {
	handler.getWorld().getEntityManager().getPlayer().setLastEnt(this);
}
			if(health <= 0) {
				if(this != handler.getWorld().getEntityManager().getPlayer()) {
				active = false;
				}
				die();
			}
}

	
	
}
