package gameTest;

public class GameCamera {
	private float xOffset, yOffset;
 private Handler handler;
public GameCamera(Handler handler, float xOffset, float yOffset) {
	
	 this.handler = handler; 
	 this.xOffset = xOffset;
	 this.yOffset = yOffset;
 }
public void move(float xAmt, float yAmt) {
	xOffset += xAmt;
	yOffset += yAmt;
	checkBlankSpace();
}
public void checkBlankSpace() {
	if(xOffset < 0) {
		xOffset = 0;
	}else if (xOffset > handler.getWorld().getWidth() * tile.TILEWIDTH - handler.getWidth()) {
		xOffset = handler.getWorld().getWidth() * tile.TILEWIDTH - handler.getWidth();
	}
	if(yOffset<0) {
		yOffset =0;
	}else if(yOffset > handler.getWorld().getHeight() * tile.TILEHEIGHT - handler.getHeight()) {
		yOffset = handler.getWorld().getHeight() * tile.TILEHEIGHT - handler.getHeight(); 
	}
	
}
public void centerOnEntity(entity e) {
	xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
	yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
	checkBlankSpace();
}

//getters and setters
public float getxOffset() {
	return xOffset;
}

public void setxOffset(float xOffset) {
	this.xOffset = xOffset;
}

public float getyOffset() {
	return yOffset;
}

public void setyOffset(float yOffset) {
	this.yOffset = yOffset;
}
}
