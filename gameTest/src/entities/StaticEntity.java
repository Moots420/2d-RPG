package entities;

import java.awt.Graphics;

import gameTest.Handler;
import gameTest.Player;
import gameTest.entity;

public abstract class StaticEntity extends entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height, boolean checkE, String name, int lvl,boolean vunerable, boolean building) {
	super(handler, x, y, width, height,checkE,  name, lvl,vunerable,building);
}

}



