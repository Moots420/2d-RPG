package gameTest.display;

import java.awt.Color;
import java.awt.Graphics;

import Text;
import gameTest.Handler;

public class Hud {
	public boolean show;
	private Handler handler;
	public Hud(Handler handler) {
		this.handler = handler;
		show = true;
		
	}
	public void render(Graphics g) {
		if(show) {
		g.drawImage(Assets.hud,0,0,800,600, null);
		Text.drawString(g, "WALLET: $" +Integer.toString(handler.getWorld().getEntityManager().getPlayer().getWallet()),21,104, false,Color.WHITE, Assets.font8);
	}
	}
	public void tick() {
		
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}

}
