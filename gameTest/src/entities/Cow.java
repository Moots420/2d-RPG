package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameTest.Creature;
import gameTest.Handler;
import gameTest.display.Animation;
import gameTest.display.Assets;
import items.Item;

public class Cow extends Creature{
	
	private Animation cowLeft, cowRight,cowStill, cowHurt;
	private int facing;
	private int maxWanderDistance; 
	private int wanderDistance;
	private int wanderX;
	private int wanderY;
    private int currentTimer, timeToWait;
    private int hitTimer, cooldown;
    private boolean wandering,hurting;

 

	public Cow(Handler handler, float x, float y, int lvl) {
		super(handler, x, y,45, 38, true,"Cow",true,lvl,true,false);
		//isVulnerable = true;
		hitTimer = 0;
		cooldown = 30;
		headTile = Assets.cowHead;
		health = 10;
		maxHealth = 10;
		wandering = false;
		speed = 0.5f; 
	    timeToWait = handler.getRandomNumber(1, 5);
	
	    bounds.x = 6;
		bounds.y = height/2+2;
		bounds.width = width-12;
		bounds.height = height/2-6;
		facing = 0;
		maxWanderDistance = 64;
		cowLeft = new Animation(350,Assets.cow_left);
		cowRight = new Animation(350,Assets.cow_right);
		cowStill = new Animation(350,Assets.cow_still);
		cowHurt = new Animation(350,Assets.cow_hurt);
		facing = 1;
		
	}
    public void checkWander(){
  
		wanderDistance = handler.getRandomNumber(32, maxWanderDistance);
		int a = handler.getRandomNumber(0, 1);
			if(a == 1) {
			wanderX = (int) (this.x + wanderDistance);
		}else if(a == 0) {
			wanderX = (int) (this.x - wanderDistance);
			
		}
		wanderDistance = handler.getRandomNumber(32, maxWanderDistance);
		
		int b = handler.getRandomNumber(0, 1);
		if(b == 1) {
			wanderY = (int)this.y + wanderDistance;
		}else if(b == 0) {
			wanderY = (int) this.y - wanderDistance;
         }
		timeToWait = handler.getRandomNumber(6, 15);
		
		
		
		wandering = true;
		currentTimer = 0;
	
    }
    private void wander(int xDist,int yDist) {
    	//System.out.println("thisx"+x+"wanderx"+wanderX+"thisy"+y+ "wandery" + wanderY);
    	
    	//System.out.println(handler.getEngine().getWidth() + "   " + handler.getEngine().getHeight());
//    	if(wanderX>handler.getEngine().getWidth()) {
//			wanderX = handler.getEngine().getWidth()-width;
//		}else if(wanderX<0) {
//			wanderX = width;
//		}else if(wanderY>handler.getEngine().getHeight()) {
//			wanderY = handler.getEngine().getHeight()-height;
//		}else 	if(wanderY<0) {
//			wanderY = height;
//		}
    	
    	if(entityCollison == true || tileCollision == true && hurting == false ) {
    
          //System.out.println("Stuck");
        		 xMove = 0;
        	     yMove = 0;
        	 wandering = false;
        	 
    	}
    	
    	//System.out.println("xdist:" + xDist + "thisx" +this.x +"ydist:" + yDist + "thisy" +this.y);
    	if(xDist>this.x+10) {
    		xMove = speed;
    	}else if(xDist<this.x-10) {
    		xMove = -speed;	
    	}else {
    		xMove = 0;
    	}
    	if(yDist>this.y+10) {
    		yMove = speed;	
    	
    	}else if(yDist<this.y-10) {
    	
    		yMove = -speed; 		
    	}else {
    		yMove = 0;
    	}
    	//System.out.println(xMove);
    	//System.out.println(yMove);
    	//System.out.println(wandering);
    	
    	if(xMove == 0 && yMove == 0 ) {	
    		xMove = 0;
    		yMove = 0;
    		wandering = false;	
    		speed = 0.5f;
    	}
    
    	
    }
	public void tick() {
		cowLeft.tick();
		cowRight.tick();
		cowStill.tick();
		cowHurt.tick();
		
		if(!wandering) {
		currentTimer ++;
		}
	    //System.out.println("currentTime:"+currentTimer/60+ "  Time to Wait:" + timeToWait + wandering);
		if(hitTimer>cooldown) {
			hurting = false;
			hitTimer = 0;
		
		}else {
			hitTimer++;
		}
		if(currentTimer>timeToWait*60 && !wandering) {
			checkWander();
		}
		if(wandering) {
		wander(wanderX, wanderY);
		move();
		}
		if(hit) {
			hitTimer = 0;
		    checkHit();
			hit = false;
	
		}
	}
    public void checkHit() {
    	checkWander();
		speed = 2f;
		timeToWait = 2;
		hurting = true;
    }
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);
		
	}
	
	
	private BufferedImage getCurrentAnimationFrame() {
		if(hurting) {
	
			cowHurt.setCurrentFrame(facing);
		    handler.getSoundManager().play(Assets.moo);
			return cowHurt.getCurrentFrame();
			
		}else {
		if(xMove<0  && wandering) {
		
			facing = 0;
			return cowLeft.getCurrentFrame();
		}else if(xMove>0 && wandering) {
		
			facing = 1;
			return cowRight.getCurrentFrame();
		} else if(yMove<0 && facing == 1 && wandering) {
           return cowLeft.getCurrentFrame();
		}else if(yMove<0 && facing == 0 && wandering) {
	           return cowRight.getCurrentFrame();
			}else if(yMove>0 && facing == 1 && wandering) {
           return cowLeft.getCurrentFrame();
		} else if(yMove>0 && facing == 0 && wandering) {
	           return cowRight.getCurrentFrame();
			} else {
			cowStill.setCurrentFrame(facing);
			return cowStill.getCurrentFrame();
			
		}
		}
	}

	public void die() {
		handler.getWorld().getEntityManager().getPlayer().setCurrentExp(2);
		if(handler.getWorld().getEntityManager().getPlayer().lastEntity == this) {
			handler.getWorld().getEntityManager().getPlayer().lastEntity = null;
			
		}
		
		int r = handler.getRandomNumber(0, 1000);
		handler.getWorld().getItemManager().addItem(Item.arrowItm.createNew((int)x,(int) y,handler.getRandomNumber(1, 10)));
		
		if(r<200) {
			handler.getWorld().getItemManager().addItem(Item.Log.createNew((int)x,(int) y,1));
			
		}else if(r>200 && r<800) {
			handler.getWorld().getItemManager().addItem(Item.Beef.createNew((int)x,(int) y,1));
			
			
		}else if(r>800) {
			handler.getWorld().getItemManager().addItem(Item.smlCoins.createNew((int)x,(int) y,1));
			
			}
		
		
	}
	@Override
	public void interact() {
		if(!handler.getWorld().getEntityManager().getPlayer().isRiding()) {
	
			int e = handler.getWorld().getEntityManager().getPlayer().getFacing();
			if(e == 1) {
			handler.getWorld().getEntityManager().getPlayer().setFacing(0);
			}else if(e == 3) {
				handler.getWorld().getEntityManager().getPlayer().setFacing(1);
				}else {
					handler.getWorld().getEntityManager().getPlayer().setFacing(1);
				}
			handler.getWorld().getEntityManager().getPlayer().setHeight(24*2);
			handler.getWorld().getEntityManager().getPlayer().setWidth(20*2);
			handler.getWorld().getEntityManager().getPlayer().setRiding(true);
			this.active = false;
			
		}
		// TODO Auto-generated method stub
		
	}

}
