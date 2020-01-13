package gameTest;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import gameTest.display.UIManager;


public class MouseManager implements MouseListener, MouseMotionListener {
private boolean leftPressed, rightPressed;
private int mouseX, mouseY;
private UIManager uiManager;

	
	public MouseManager(){
	
	
}
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
//getters
	public boolean isLeftPressed() {
		
		return leftPressed;
	}
	public boolean isRightPressed() {
		
		return rightPressed;
	}
	public int getMouseX() {
		return mouseX;
		
	}
	public int getMouseY() {
		
		return mouseY;
	}
	
	
	//implimented methods
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub

	
}

@Override
public void mouseMoved(MouseEvent e) {
	PointerInfo a = MouseInfo.getPointerInfo();
	  
	 Point b = a.getLocation();
	  int x = (int)b.getX();
	  int y = (int)b.getY();
	  mouseX = x -223 ;
	  mouseY = y -105;
	  //System.out.println( mouseX + "    " + mouseY );
	 
	
			if(uiManager != null)
				uiManager.onMouseMove(e);
			
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getButton() == MouseEvent.BUTTON1)
		leftPressed = true;
	else if(e.getButton() == MouseEvent.BUTTON3)
		rightPressed = true;
}

@Override
public void mouseReleased(MouseEvent e) {
	if(e.getButton() == MouseEvent.BUTTON1)
		leftPressed = false;
	else if(e.getButton() == MouseEvent.BUTTON3)
		rightPressed = false;
	
	if(uiManager != null)
		uiManager.onMouseRelease(e);
	
}

public void setRightPressed(boolean rightPressed) {
	this.rightPressed = rightPressed;
}
public void setLeftPressed(boolean leftPressed) {
	this.leftPressed = leftPressed;
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
	
}
