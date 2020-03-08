import java.util.Calendar;

public class Transaction {

    private String itemName = "";
    private int stackSize = 0;
    private int quantity = 0;
    private float price = 0;
    private String otherPlayer = "";
    private String player = "";
    private Calendar time;
    private String source = "";

    public Transaction() {
    }
    
	public Transaction(String itemName, int stackSize, int quantity, float price, String otherPlayer,
				       String player, int time, String source) {
		Calendar t = Calendar.getInstance();
		t.setTimeInMillis((long)time*1000);
		
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.otherPlayer = otherPlayer;
		this.player = player;
		this.time = t;
		this.source = source;
	}
	
	/* getters and setters */

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getStackSize() {
		return stackSize;
	}

	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getOtherPlayer() {
		return otherPlayer;
	}

	public void setOtherPlayer(String otherPlayer) {
		this.otherPlayer = otherPlayer;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Calendar getTime() {
		return this.time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}