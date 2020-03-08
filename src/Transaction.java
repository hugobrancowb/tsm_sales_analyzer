import java.util.Calendar;

public class Transaction {

    private String type = "";
    private int amount = 0;
    private String otherPlayer = "";
    private String player = "";
    private Calendar time;

    public Transaction() {
    }
    
	public Transaction(String type, int amount, String otherPlayer, String
	player, int time) {
		Calendar t = Calendar.getInstance();
		t.setTimeInMillis((long)time*1000);
		
		this.type = type;
		this.amount = amount;
		this.otherPlayer = otherPlayer;
		this.player = player;
		this.time = t;
	}
	
	/* getters and setters */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}
}