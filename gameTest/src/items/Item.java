package items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import Sound.soundManager;
import gameTest.Handler;
import gameTest.display.Animation;
import gameTest.display.Assets;

public class Item {
	//handler
	public static Animation coin = new Animation(100,Assets.coin);
	public static Item[] items = new Item[256];
	public static Item smlCoins = new Item(Assets.coins_sml, "smlCoins", 0, 5,false,1);
	  public static Item Coin = new Item(coin.getCurrentFrame(),"Coin",0,1,false,1);
	public static Item Log = new Item(Assets.log1, "Log",2,1,false,1);
	public static Item Beef = new Item(Assets.meat, "Beef",3,5,false,1);
	public static Item HealthPotion = new Item(Assets.healthpotion,"HP Potion",4,10,true,1);
	public static Item arrowItm = new Item(Assets.arrowitem,"Arrow",6,10,true,1);
  
	//class
public final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
 
 public int getItemwidth() {
	return ITEMWIDTH;
}

public int getItemheight() {
	return ITEMHEIGHT;
}
protected Handler handler;
 protected BufferedImage texture;
 protected String name;
 protected boolean useable;
 protected final int id;
 public boolean checkE = true;
 protected int x,y,count, value;
 protected boolean pickedUp = false;

 
	public Item(BufferedImage texture, String name, int id, int value,boolean useable,int amt) {
		
		this.useable = useable;
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.value = value;
		count = amt;
		items[id] = this;
		
		
	}
	
	public boolean isPickedUp() {
		return pickedUp;
	}

	public void pickUp() {
		
		handler.getSoundManager().play(Assets.pop);
		if(this.id == 0) {
			this.value = handler.getRandomNumber(1, 5);
			handler.getWorld().getEntityManager().getPlayer().pay(value);
		  
		}
		if(this.name == "Arrow") {
	 handler.getWorld().getEntityManager().getPlayer().arrowAmt += count;
			}
		
		if(this.id != 0 && this.name != "Arrow") {
		handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		 handler.getNotifier().pushNotif("+ "+this.name);
		}
		pickedUp = true;
	}
 public void tick() {
	if(this.name == "Coin") {
		this.texture = coin.getCurrentFrame();
		coin.tick();
	}
	 }
	 
	
 public void render(Graphics g) {
	 if(handler == null)
	  return;
	 render(g,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()));

 }
 
 
 public void render(Graphics g, int x , int y) {
	 
	 g.drawImage(texture,x,y,ITEMWIDTH,ITEMHEIGHT, null);
	 
 }
 public Item createNew(int x, int y,int amt) {
	 Item i = new Item(texture, name, id, value, useable,amt);
	 i.setPosition(x, y);
	 return i;
 }
 public void useItem(Item i) {
	 System.out.println("use");
	 if(i.id == 4) {
		 
		 handler.getWorld().getEntityManager().getPlayer().setHealth(5);
		 
	 }
	 
 }
 public boolean isUseable() {
	return useable;
}

public void setUseable(boolean useable) {
	this.useable = useable;
}

public void setPosition(int x , int y) {
	 this.x = x;
	 this.y = y;
			 
 }
 public  Rectangle getCollisionBounds(float xOffset, float yOffset,float wOffset, float hOffset) {
		return new Rectangle((int) (x + xOffset), (int) (y  + yOffset),(int) (ITEMWIDTH +wOffset),(int) (ITEMHEIGHT+hOffset));
		
	}	
 //getters setters
 public Handler getHandler() {
	return handler;
}
public void setHandler(Handler handler) {
	this.handler = handler;
}
public BufferedImage getTexture() {
	return texture;
}
public void setTexture(BufferedImage texture) {
	this.texture = texture;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public void deductCount(int count) {
	this.count -= count;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public int getId() {
	return id;
}

}
