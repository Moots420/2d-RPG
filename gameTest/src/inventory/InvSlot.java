package inventory;


import items.Item;



public class InvSlot{
   protected int SlotX;
   protected int SlotY;
   protected Item item;
	public InvSlot( int SlotX, int SlotY,Item item) {
	    this.item = item;
		this.SlotX = SlotX;
	    this.SlotY = SlotY;
		// TODO Auto-generated constructor stub
	}

	
	

}
