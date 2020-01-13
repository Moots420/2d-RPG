package gameTest;
import gameTest.entity;

public abstract class Creature extends entity{

	public static final float DEFAULT_SPEED = 3f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	protected float speed;
	protected float xMove, yMove;
	public boolean moving;
	private boolean solid;
	
	public Creature(Handler handler, float x, float y, int width, int height, boolean checkE,String name, Boolean Solid,int lvl,boolean vunerable, boolean building) {
		super(handler, x, y, width,height,checkE,name,lvl,vunerable,building);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0; 
		this.solid = Solid;
		
	}

	public void move() {
		if(!checkEntityCollisions(xMove, 0f) && solid) {
				moveX();
		}else if(!solid) {
			moveX();
		}
		if(!checkEntityCollisions(0f, yMove) && solid) {
	moveY();
		}else if(!solid) {
			moveY();
		}
		if(checkEntityCollisions(xMove, 0f)) {
			entityCollison = true;
			
		}else if(checkEntityCollisions(0f, yMove)) {
			entityCollison = true;
			
		}else {
			entityCollison = false;
			
	}
		
		
			
			
		if(checkEntityCollisions(xMove, 0f)&& xMove == 0) {
			x += handler.getRandomNumber(-2, 2);
			
		}
		if(checkEntityCollisions(0f, yMove)&& yMove == 0){
			y += handler.getRandomNumber(-2, 2);
			
		}
		
	}
	public void moveX() {
	if(xMove>0) { //moving right
		int tx = (int) (x + xMove + bounds.x + bounds.width) / tile.TILEWIDTH;
		if(!collisionWithTile(tx, (int) (y+ bounds.y) / tile.TILEHEIGHT ) &&
			!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / tile.TILEHEIGHT)) {
			x += xMove;
			tileCollision = false;
		}else if(solid) {
			x = tx * tile.TILEWIDTH - bounds.x - bounds.width-1;
			tileCollision = true;
			
		}else if(!solid) {
			x += xMove;
			tileCollision = false;
			
		}
		
	}else if(xMove <0) { //moving left
		int tx = (int) (x + xMove + bounds.x) / tile.TILEWIDTH;
		if(!collisionWithTile(tx, (int) (y+ bounds.y) / tile.TILEHEIGHT ) &&
			!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / tile.TILEHEIGHT)) {
			x += xMove;
			tileCollision = false;
		}else if(solid) {
			x = tx* tile.TILEWIDTH + tile.TILEWIDTH - bounds.x;
			tileCollision = true;
			
		}else if(!solid) {
			x += xMove;
			tileCollision = false;
		}
		
	}
	}
	public void moveY() {
		if(yMove <0) { //up
			int ty = (int) (y + yMove +bounds.y) / tile.TILEHEIGHT;
		
		if(!collisionWithTile((int) (x + bounds.x)/ tile.TILEHEIGHT, ty )&&
				!collisionWithTile((int) (x + bounds.x +bounds.width)/ tile.TILEHEIGHT, ty )) {
			y += yMove;
			tileCollision = false;
		}else if(solid) {
			tileCollision = true;
			y = ty * tile.TILEHEIGHT + tile.TILEHEIGHT - bounds.y;
	
		}else if (!solid) {
			y += yMove;
			tileCollision = false;
		}
	
		}else if(yMove> 0) { //down
			int ty = (int) (y + yMove +bounds.y + bounds.height) / tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/ tile.TILEHEIGHT, ty )&&
					!collisionWithTile((int) (x + bounds.x +bounds.width)/ tile.TILEHEIGHT, ty )) {
				y += yMove;
				tileCollision = false;
			}else if (solid){
				y =ty * tile.TILEHEIGHT - bounds.y - bounds.height -1;
				tileCollision = true;
		
			}else if (!solid) {
				y += yMove;
				tileCollision = false;
			}
		}
		
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	//getters and setters
	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health += health;
		if(health>maxHealth) {
			health = maxHealth;
		}
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
	


}
