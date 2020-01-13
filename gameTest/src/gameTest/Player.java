package gameTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Text;
import entities.Arrow;
import entities.Cow;
import gameTest.display.Animation;
import gameTest.display.Assets;
import gameTest.display.Hud;
import inventory.Inventory;
import items.Item;

public class Player extends Creature{
	
	private boolean Riding;
    public long lastAttackTimer , attackCooldown = 120, attackTimer = attackCooldown;
    private int spawnX, spawnY;
    private Color healthGreen = new Color(72,161,46);
    private Color purple = new Color(118 ,66,138);
	private Animation animDown, animUp, animRight, animLeft, animStill,ePrompt,atkDown, atkLeft, atkUp, atkRight, cowRight, cowLeft, cowStill,shootDown,shootLeft,shootUp,shootRight;
	private int Facing;
	private float sprintSpeed;
	private float walkSpeed;
	private boolean sprinting;
	private int animDefaultSpeed;
	private int animSprintSpeed;
	private float maxEnergy;
	private float energy;
	private float energyBuff;
	private int energyPercent;
	private int healthPercent;
	private boolean moving;
	private float hBarWidth,expBarWidth, sBarWidth;
	private float hBarMaxWidth,expBarMaxWidth, sBarMaxWidth;
	private int EhealthPercent;
	private float EBarWidth;
	private float EMaxWidth;
	private static boolean showE;
	public int meleeStr, arrowStr;
	private int wallet = 5;
	private Inventory inventory;
	private Hud hud;
	private float eHealth;
	private float eMaxHealth;
	private BufferedImage eHeadTile;
	private float rideSpeed;
	public Object lastEntity;
	private float currentExp,expUntilNextLevel ;
	private int expPercent, currentLevel;
	private int hitTimer, cooldown;
	private boolean hurting;
	private entity lastEnt;
	private int playerState; 
	private String currentWeapon;
	public Arrow arrow;
	public boolean hasArrows;
	public int arrowAmt;
	public int checkpointX = 1500, checkpointY= 1000;
	public int getCheckpointX() {
		return checkpointX;
	}

	public void setCheckpointX(int checkpointX) {
		this.checkpointX = checkpointX;
	}

	public int getCheckpointY() {
		return checkpointY;
	}

	public void setCheckpointY(int checkpointY) {
		this.checkpointY = checkpointY;
	}

	public Player(Handler handler, float x, float y,int lvl) {
		super(handler, x, y, 32, 32,false,"Player",true, lvl,true,false);
		
		spawnX = 356;
	    spawnY = 170;
	    arrowAmt = 0;
		currentWeapon = "FISTS";
		playerState = 0;
		currentExp = 0;
	    expUntilNextLevel = 50;
		cooldown = 15;
	
	    meleeStr = 1;
	    arrowStr = 1;
		currentLevel = 1;
		EMaxWidth = 96;
		EBarWidth = EMaxWidth;	
		EhealthPercent = 100;
		rideSpeed = 4f;
		showE = false;
		hud = new Hud(handler);
		attacking = false;
		sprinting = false;
		moving = false;
		maxEnergy = 15;
		energy = maxEnergy;
		energyPercent = 100;
		sBarMaxWidth = 96;
		sBarWidth = sBarMaxWidth;
		hBarMaxWidth = 96;
		hBarWidth = sBarMaxWidth;
		expBarWidth = 0;
		expBarMaxWidth = 96;
		healthPercent = 100;
		maxHealth = 20;
		health = maxHealth;
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;
		Facing = 0;
		walkSpeed = 1.3f;
	    sprintSpeed = 2.5f;
	    animDefaultSpeed = 350;
	    animSprintSpeed = 500/4;
		animStill = new Animation(800, Assets.player_still);
		animDown = new Animation(animDefaultSpeed, Assets.player_down);
		animUp = new Animation( animDefaultSpeed, Assets.player_up);
		animRight = new Animation( animDefaultSpeed, Assets.player_right);
		animLeft = new Animation( animDefaultSpeed, Assets.player_left);
		ePrompt = new Animation(animDefaultSpeed, Assets.ePrompt);
		atkDown = new Animation(animDefaultSpeed,Assets.player_down_att);
		atkLeft = new Animation(animDefaultSpeed,Assets.player_left_att);
		atkUp = new Animation(animDefaultSpeed,Assets.player_up_att);
		atkRight = new Animation(animDefaultSpeed,Assets.player_right_att);
		cowRight = new Animation(animDefaultSpeed,Assets.cow_ride_right);
		cowLeft = new Animation(animDefaultSpeed,Assets.cow_ride_left);
		cowStill = new Animation(animDefaultSpeed,Assets.cow_ride_still);
		shootUp = new Animation(animDefaultSpeed,Assets.plr_shoot_up);
		shootLeft = new Animation(animDefaultSpeed,Assets.plr_shoot_left);
		shootDown = new Animation(animDefaultSpeed,Assets.plr_shoot_down);
		shootRight = new Animation(animDefaultSpeed,Assets.plr_shoot_right);
		  
		inventory = new Inventory(handler);
		
	}
	
	public void setLastEnt(entity e) {
		lastEnt = e;
	}
	
	public void pay(int amt) {
		handler.getNotifier().pushNotif("+"+amt+"  Coins");
		wallet = wallet + amt;
		
	}
	public void deduct(int amt) {
		handler.getNotifier().pushNotif("-"+amt+"  Gold");
		wallet -= amt;
	}

	public void die() {
		
		handler.getNotifier().pushNotif("YOU DIED!");
		x = spawnX;
		y = spawnY;
		health = maxHealth;
		energy = maxEnergy;
	}
   

	


	public float getCurrentExp() {
		return currentExp;
	}
	public void setCurrentExp(float Amount) {
		this.currentExp += Amount;
		handler.getNotifier().pushNotif("+"+Amount+"  EXP");
		
	}
	public void tick() {

		checkExp();
		checkEnergy();
		checkHealth();
		//animations
		animStill.tick();
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		atkDown.tick();
		atkLeft.tick();
		atkUp.tick();
		atkRight.tick();
		cowRight.tick();
		cowLeft.tick();
		cowStill.tick();
		shootUp.tick();
		shootLeft.tick();
		shootRight.tick();
		shootDown.tick();
		checkHitting();
		
		if(arrowAmt>0) {
			hasArrows = true;
		}else if(arrowAmt <= 0) {
			hasArrows = false;
			
		}
		
		
		if(hitTimer>cooldown) {
			hurting = false;
			hitTimer = 0;
		
		}else {
			hitTimer++;
		}
		if(hit && !hurting) {
			hitTimer = 0;
		    hurting = true;
			hit = false;

		}
		if(playerState == 0) {
			attackCooldown = 120;
		}if(playerState == 1) {
			attackCooldown = 60*5;
			
		}
		 
	        
		//movement
   if(Riding) {
	   ride();
   }
	getInput();
	move();
	handler.getGameCamera().centerOnEntity(this);
    //attack
	if(!Riding) {
	checkAttack();
	}
	if(handler.getWorld().getEntityManager().paused == false) {
	inventory.tick();
	}
	}
	public void ride() {
		speed = rideSpeed;
	
	}
	public void stopRide() {
		 Riding = false;
		 
	    handler.getWorld().getEntityManager().addEntity(new Cow(handler, x, y+16,1));
		energy = 5;
	   
	    width = 32;
		height = 32;
		speed = walkSpeed;
	}
	public void setFacing(int facing) {
		Facing = facing;
	}
	public void checkAttack() {
		//System.out.println("timer:" + attackTimer + "cooldown:" + attackCooldown + "Last Timer:" + lastAttackTimer);
       
        
		
		//System.out.println(attacking);
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer<attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0,0,0,0);
		Rectangle ar = new Rectangle();
		ar.width = width;
		ar.height = height;
		
	if(playerState == 0) {
	
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
			attacking = true;
			if(Facing == 0) {
				ar.x = (int) this.x;
				//ar.y = (int) this.y + (int) this.height;
				ar.y = (int) this.y;
				ar.height = height*2;
				ar.width = (int)this.width;
			}else if(Facing == 1 ) {
				ar.x = (int) this.x - this.width;
				ar.y = (int) this.y;
				ar.width = (int)this.width*2;
				ar.height = (int) this.height;
			}else if(Facing == 2) {
				ar.x = (int) this.x;
				ar.y = (int) this.y - (int)this.height;
				ar.height = (int) this.height*2;
				ar.width = (int)this.width;
			}else if(Facing == 3) {
				ar.x = (int) this.x;
				ar.y = (int) this.y;
				ar.width = (int)this.width*2;
				ar.height = (int) this.height;
			}else {
				
				return;
			}
		
		
			
			attackTimer = 0;
			for (entity e: handler.getWorld().getEntityManager().getEntities()) {
				if(e.equals (this))
					continue;
					if(e.getCollisionBounds(0,0,0,0).intersects(ar) && e.vunerable) {
					e.hurt(meleeStr);
					e.hit = true;
					lastHit(e);
					return;
				}else {
					eHeadTile = null;
					EhealthPercent = 0;
				
				}
					
			}
		}else {
			attacking = false;
		}
			//attacking = false;
		}else if(playerState == 1 && hasArrows) {
			
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
					attacking = true;
					arrowAmt -= 1;
			if(Facing == 0) {
		    arrow = new Arrow(handler,this.x,this.y+height,Facing);
		    handler.getWorld().getEntityManager().addEntity(arrow);
			}else if(Facing == 1) {
			arrow = new Arrow(handler,this.x-width,this.y,Facing);
			handler.getWorld().getEntityManager().addEntity(arrow);
			}else if(Facing == 2) {
		    arrow = new Arrow(handler,this.x,this.y-height,Facing);
		    handler.getWorld().getEntityManager().addEntity(arrow);
			}else if(Facing == 3) {
			arrow = new Arrow(handler,this.x+width,this.y,Facing);
			handler.getWorld().getEntityManager().addEntity(arrow);
			}
			
			//handler.getWorld().getEntityManager().addEntity(arrow);
			}
			
			if(arrowAmt<=0) {
				attacking = false;
			}
			
			if(arrow != null) {
		    arrow = null;
				return;	
		   }else {
			//attacking = false;
			
		}
			attacking = false;
		}

	}
	
	
	public int getFacing() {
		return Facing;
	}
	public void checkHitting() {
		
		
		 Rectangle cb = getCollisionBounds(x-width,y-height,width*2,height*2);
		//entitys
		for(entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(!e.isBuilding) {
			if(e.getCollisionBounds(e.getX()-e.getWidth(),e.getY()-e.getHeight(),e.getWidth()*2,e.getHeight()*2).intersects(cb)) {
				//System.out.println("hitting");
				if(e.checkE == true) {
					//System.out.println("prompting");
					promptE(true, e, null);
					break;
				} 
			}else {
				
				promptE(false, e, null);
			}
			}else {
				if(e.getCollisionBounds(e.getX(),e.getY()+e.getHeight(),e.getWidth(),e.getHeight()).intersects(cb)) {
					//System.out.println("hitting");
					if(e.checkE == true) {
						//System.out.println("prompting");
						promptE(true, e, null);
						break;
					} 
				}else {
					
					promptE(false, e, null);
				}
				
			}
		}
		
		//items
		for(Item i : handler.getWorld().getItemManager().getItems()) {
			if(i.getCollisionBounds((int) (i.getX()-i.ITEMWIDTH),(int) (i.getY()-i.ITEMHEIGHT),(int) (i.ITEMWIDTH*2) ,(int) (i.ITEMHEIGHT*2)).intersects(cb)) {
				//System.out.println("hitting");
				if(i.checkE == true) {
					//System.out.println("prompting");
					promptE(true,null,i);
					
					break;
				} 
			}else {
				
				promptE(false,null, i);
			}
		}
		
		
		
	}
	
	public void promptE(boolean inRange, entity e, Item i) {
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			if(e != null && inRange) {
			e.interact();
			}
			if(i != null && inRange) {
				i.pickUp();
			}
		}
		
		if(inRange && !Riding) {
		showE = true;
		}else {
		showE = false;
		}
		
	}
	
	public int getWallet() {
		return wallet;
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().shift && Riding) {
			stopRide();
			
		}
		if(handler.getKeyManager().shift && !Riding && !attacking) {
			if(energy>energyBuff) {
			sprinting = true;
			setAnimSpeed();
			checkSprint(sprintSpeed);
			}
			if(energy<=0) {
				sprinting = false;
				 setAnimSpeed();
				 checkSprint(walkSpeed);
				
			}
			
		}else {
			sprinting = false;
			 setAnimSpeed();
			 if(!Riding) {
			 checkSprint(walkSpeed);
			 }
		}
		if(attacking) {
			speed = speed/5;
			}
		
			
		if(handler.getKeyManager().up) {
			yMove = -speed;
			if(!Riding) {
			Facing = 2;
			}
		    
		}else if(handler.getKeyManager().down) {
			yMove = speed;
		Facing = 0;
		}else if(handler.getKeyManager().left) {
			xMove = -speed;
		Facing = 1;
		}else if(handler.getKeyManager().right) {
			xMove = speed;
			if(!Riding) {
			Facing = 3;
			}
	}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)) {
			if(playerState == 0) {
				if(hasArrows) {
				playerState = 1;
				currentWeapon = "ARROWS";
				}
			}else if(playerState == 1) {
				playerState = 0;
				currentWeapon = "FISTS";
			}
			System.out.println(playerState);
			
		}
//		if(!handler.getKeyManager().space && attacking) {
//			attacking = false;
//		}
		
	}
	private void setAnimSpeed() {
		if(sprinting) {
			animUp.setSpeed( animSprintSpeed);
			animDown.setSpeed( animSprintSpeed);
			animLeft.setSpeed( animSprintSpeed);
			animRight.setSpeed( animSprintSpeed);
			
		}else if (!sprinting) {
			animUp.setSpeed( animDefaultSpeed);
			animDown.setSpeed( animDefaultSpeed);
			animLeft.setSpeed( animDefaultSpeed);
			animRight.setSpeed( animDefaultSpeed);
			
		}
		
	}
	private void checkExp() {
          expPercent = (int)(currentExp/expUntilNextLevel*100);
          if(currentExp >= expUntilNextLevel) {
        	  handler.getWorld().getNotifier().pushNotif("LEVEL UP!");
        	  currentLevel += 1;  
        	  expUntilNextLevel += currentLevel * 15;
          }	
          
          if(expPercent <= 0) {
        	  expBarWidth = 3;
          }else {
        	  expBarWidth = expPercent*expBarMaxWidth/100;
          }
         
          }
	private void checkHealth() {
		if(health>maxHealth) {
			health = maxHealth;
		}
		healthPercent = (health*100)/maxHealth;
		hBarWidth = healthPercent*hBarMaxWidth/100;
		EBarWidth = EhealthPercent*EMaxWidth/100;
	}
    public void lastHit(entity e) {
    	eHealth = e.health;
        eMaxHealth = e.maxHealth;
        EhealthPercent = (int)(eHealth*100 )/(int) (eMaxHealth);
        eHeadTile = e.headTile;
    	
    }
	
	private void checkEnergy() {
		//System.out.println(sBarWidth); 
		energyBuff = maxEnergy/100*50;
		energyPercent = (int)(energy/maxEnergy*100);
		//System.out.println(energyPercent);
		sBarWidth = energyPercent*sBarMaxWidth/100;
		if(sprinting && moving) {
			energy -= .03;
			
		}else if(!sprinting) {
			energy += .01;
			
		}
		if(energy >= maxEnergy) {
			energy = maxEnergy;
		}
		if(energy <0) {
			energy = 0;
		}
	}
	private void checkSprint(float s) {
		setSpeed(s);
	}

	public void render(Graphics g) {
		if(energy > energyBuff) {
    		
			g.setColor(Color.ORANGE);
			}else {
				g.setColor(Color.BLUE);
			}
	    
	    	g.fillRect(18,33,(int)sBarWidth-3,7);
	    	
	    
	    	
	    	g.setColor(purple);
	    	g.fillRect(18,49,(int)expBarWidth,7);
	    	
	    	
	    	g.setColor(healthGreen);
	    	if(healthPercent < 25) {
	    		g.setColor(Color.RED);
	    	}
	    	g.fillRect(18,17,(int)hBarWidth-3,7);
	    	
	    	
	    	g.setColor(healthGreen);
	    	if(EhealthPercent < 25) {
	    		g.setColor(Color.RED);
	    	}
	    	g.fillRect(688,16,(int)EBarWidth,10);
		
		if(showE) {
			g.drawImage(ePrompt.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset())+7,(int)(y - handler.getGameCamera().getyOffset()) - 24 ,18,18,null );
		if(!handler.getKeyManager().eKey) {
			ePrompt.setCurrentFrame(0);
		}else if(handler.getKeyManager().eKey) {
			ePrompt.setCurrentFrame(1);
		}
		}
		
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);
      	
	//g.setColor(Color.GREEN);
	//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()) , bounds.width, bounds.height);
	
	
	}
    public void postRender(Graphics g) {
 
    	
        hud.show = true;
    	hud.render(g);
    	inventory.render(g);
    	
    	Text.drawString(g,currentWeapon,14,80,false,Color.WHITE,Assets.font12);
        Text.drawString(g, Integer.toString(currentLevel), 126, 52, true, Color.WHITE, Assets.font8);
       if(playerState == 1) {
        Text.drawString(g, Integer.toString(arrowAmt), 105, 65, true, Color.WHITE, Assets.font8);
       }else if(playerState == 0) {
    	   Text.drawString(g, "inf", 103, 65, true, Color.WHITE, Assets.font8);   
       }
        
    	if(eHeadTile != null) {
    	g.drawImage(eHeadTile,652,18,32,32,null);
    		}
    	if(lastEnt != null) {
    	Text.drawString(g, lastEnt.entName, 735,45, true, Color.WHITE, Assets.font12);
    	Text.drawString(g, "LVL:" +Integer.toString( lastEnt.Level), 736,74, true, Color.WHITE, Assets.font8);
    	}
    	handler.getWorld().getNotifier().render(g);
    	
    }
	
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	private BufferedImage getCurrentAnimationFrame() {
		if(Riding) {
			if(xMove<0) {
				moving = true;
				Facing = 0;
				return cowLeft.getCurrentFrame();
			}else if(xMove>0) {
				moving = true;
				Facing = 1;
				return cowRight.getCurrentFrame();
			}else if(yMove<0 && Facing == 0) {
				return cowLeft.getCurrentFrame();
			}else if(yMove>0 && Facing == 0) {
				return cowLeft.getCurrentFrame();
			}else if(yMove<0 && Facing == 1) {
				return cowRight.getCurrentFrame();
			}else if(yMove>0 && Facing == 1) {
				return cowRight.getCurrentFrame();
			}else {
				moving = false;
				cowStill.setCurrentFrame(Facing);
				return cowStill.getCurrentFrame();
			}
		}
		if(!Riding && hurting) {
			if(Facing == 0) {
				return Assets.playerHurt0;
			}else if(Facing == 1) {
				return Assets.playerHurt1;
			}else if(Facing == 2) {
				return Assets.playerHurt2;
			}if(Facing == 3) {
				return Assets.playerHurt3;
			}
		}
		if(attacking && !Riding && playerState == 0 ) {
			if(Facing == 0) {
				return atkDown.getCurrentFrame();
			}else if(Facing == 1) {
			return atkLeft.getCurrentFrame();
		}else if(Facing == 2) {
			return atkUp.getCurrentFrame();
			
		}else if(Facing == 3) {
			return atkRight.getCurrentFrame();
		}
			
		}else if(attacking && !Riding && playerState == 1 ) {
			if(Facing == 0) {
				return shootDown.getCurrentFrame();
			}else if(Facing == 1) {
			return shootLeft.getCurrentFrame();
		}else if(Facing == 2) {
			return shootUp.getCurrentFrame();
			
		}else if(Facing == 3) {
			return shootRight.getCurrentFrame();
		}
			
		}
		if(xMove<0) {
			moving = true;
			Facing = 1;
			return animLeft.getCurrentFrame();
		}else if(xMove>0) {
			moving = true;
			Facing = 3;
			return animRight.getCurrentFrame();
		}else if(yMove<0) {
			moving = true;
			Facing = 2;
			return animUp.getCurrentFrame();
		}else if(yMove>0) {
			moving = true;
			Facing =0;
			return animDown.getCurrentFrame();
			
		}else {
			moving = false;
			animStill.setCurrentFrame(Facing);
			return animStill.getCurrentFrame();
			
		}
		
		
	}


    public void teleport(float destx, float desty) {
    this.x = destx;
    this.energy = desty;
    	
    }
	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}
	public boolean isRiding() {
		return Riding;
	}
	public void setRiding(boolean riding) {
		Riding = riding;
	}
	
	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	
}
