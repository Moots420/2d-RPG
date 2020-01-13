package Enemies;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import gameTest.Creature;
import gameTest.Handler;
import gameTest.display.Animation;
import gameTest.display.Assets;
import items.Item;

public class Slime extends Creature {
	private Rectangle FeildOfView;
	private Rectangle PlayerBounds;
	private float viewX, viewY;
	private int viewWidth, viewHeight;
	public Boolean inView;
	public Boolean attacking;
	public int attackCooldown, attackTimer;
	private int facing = 0 ;
	private int hitTimer, cooldown;
	private int viewTimer, vCooldown;
	private boolean hurting;
	private Animation slimeLeft,slimeRight,slimeStill,slimeAtt,slimeHurt;
	public int strength;
	public Slime(Handler handler, float x, float y,int lvl) {
		super(handler, x, y, 32, 32, false, "Slime",true,lvl,true,false);
		viewTimer = 0;
		vCooldown = 60*5;
		headTile = Assets.slimeHead;
		slimeLeft = new Animation(350,Assets.slime_left);
		slimeRight = new Animation(350,Assets.slime_right);
		slimeStill = new Animation(350,Assets.slime_still);
		slimeAtt = new Animation(175,Assets.slime_att);
		slimeHurt = new Animation(350,Assets.slime_hurt);
		viewWidth = 150;
		viewHeight = 150;
		attacking = false;
		inView = false;
		speed = .5f;
		attackCooldown = 30;
		attackTimer = 0;
		strength = 1;
		cooldown = 15;
		health = 15;
		//speed = (Level+speed);
		//health = (Level+health);
		strength = (Level+strength);
		maxHealth = health;
	}
	public void tick() {
		
		
		if(hurting == true) {
			inView = true;
		}
    slimeLeft.tick();
    slimeRight.tick();
    slimeStill.tick();
    slimeAtt.tick();
    checkinView();
	checkForPlayer();
	move();
	checkAttack();
	if(hitTimer>cooldown) {
		hurting = false;
		hitTimer = 0;
	
	}else {
		hitTimer++;
	}
	if(hit && hurting == false) {
		hitTimer = 0;
	    checkHit();
		hit = false;

	}
	}
	 public void checkHit() {
	    	
			hurting = true;
	    }
	public void checkAttack() {
		if(checkPlayerCollisions(this)) {
			attacking = true;
			
		}else {
			attacking = false;
		}
		if(attacking) {
			attackTimer ++ ;
			if(attackTimer>= attackCooldown && attacking) {
				handler.getWorld().getEntityManager().getPlayer().hit = true;
				handler.getWorld().getEntityManager().getPlayer().hurt(strength);
				attackTimer = 0;
				
			}
			
		}
	}
	
	public void checkinView() {
		if(xMove == 0 && yMove == 0) {
			moving = false;
		}else {
			moving = true;
		}
		
		viewX = this.x - viewWidth/2;
		viewY = this.y - viewHeight/2 ;
		FeildOfView = new Rectangle((int)viewX, (int)viewY,viewWidth, viewHeight);
		PlayerBounds = new Rectangle((int)handler.getWorld().getEntityManager().getPlayer().getX(),(int)handler.getWorld().getEntityManager().getPlayer().getY(),(int)handler.getWorld().getEntityManager().getPlayer().getWidth(),(int)handler.getWorld().getEntityManager().getPlayer().getHeight());
		if(FeildOfView.intersects(PlayerBounds)) {
		inView = true;

		}else if(!hurting) {
			xMove = 0;
					yMove =0;
						
		//inView = false;
		
	}
		
	}
	public void checkForPlayer() {
		if(inView && !attacking ) {
			viewTimer ++;
			if(viewTimer>vCooldown) {
				inView = false;
				viewTimer = 0;
			}
			if(handler.getWorld().getEntityManager().getPlayer().getX()>this.x+10) {
	    		xMove = speed;
	    	}else if(handler.getWorld().getEntityManager().getPlayer().getX()<this.x-10) {
	    		xMove = -speed;	
	    	}else {
	    		xMove = 0;
	    	}
			if(handler.getWorld().getEntityManager().getPlayer().getY()>this.y+10) {
	    		yMove = speed;	
	    	}else if(handler.getWorld().getEntityManager().getPlayer().getY()<this.y-10) {
	    		yMove = -speed; 		
	    	}else {
	    		yMove = 0;
	    	}
		}else {
			xMove =0;
			yMove = 0;
		}
		
	}
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);
		//g.drawRect((int)viewX,(int)viewY,viewWidth,viewHeight);
	}
	private BufferedImage getCurrentAnimationFrame() {
		if(attacking && !hurting) {
			return slimeAtt.getCurrentFrame();	
		} else if (hurting) {
			return slimeHurt.getCurrentFrame();
		}else {
	if(xMove < 0) {
		facing = 0;
		return slimeLeft.getCurrentFrame();
	}else if(xMove > 0 ) {
		facing = 1;
		return slimeRight.getCurrentFrame();
	}else if(yMove != 0 && moving) {
		if(facing == 0) {
			return slimeLeft.getCurrentFrame();
		}else {
			return slimeRight.getCurrentFrame();
		}
	}else if(!moving && !attacking) {
		if(facing == 0) {
			slimeStill.setCurrentFrame(0);
		}else {
			slimeStill.setCurrentFrame(1);
		}
		return slimeStill.getCurrentFrame();
	}else {
		return slimeStill.getCurrentFrame();
	}
		}
	}
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.HealthPotion.createNew((int)x,(int) y,1));
		handler.getWorld().getEntityManager().getPlayer().setCurrentExp(20);
		if(handler.getWorld().getEntityManager().getPlayer().lastEntity == this) {
			handler.getWorld().getEntityManager().getPlayer().lastEntity = null;
			
		}
		
		int r = handler.getRandomNumber(0, 1000);
		if(r<200) {
	
		}else if(r>200 && r<800) {
		
		}else if(r>800) {
			handler.getWorld().getItemManager().addItem(Item.smlCoins.createNew((int)x,(int) y,1));
			
			}
		
	}
	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

}
