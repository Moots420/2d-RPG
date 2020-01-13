package gameTest;
import java.awt.Graphics;

import gameTest.display.Assets;
import gameTest.display.ClickListener;
import gameTest.display.UIManager;
import gameTest.display.UiImageButton;

public class menuState extends State {
 private UIManager uiManager;
	
public menuState(Handler handler) {
	super(handler);
	uiManager = new UIManager(handler);
	handler.getMouseManager().setUIManager(uiManager);
	uiManager.addObject(new UiImageButton(200,200,128,64,Assets.startBtn, new ClickListener() {

		@Override
		public void onClick() {
			handler.getMouseManager().setUIManager(null);
			State.setState(handler.getEngine().gameState);
			
		}}));
}
	public void tick() {
	//System.out.println(handler.getMouseManager().getMouseX() + "   "+ handler.getMouseManager().getMouseY());
uiManager.tick();
	}

	public void render(Graphics g) {
		uiManager.render(g);
		
	}

}
