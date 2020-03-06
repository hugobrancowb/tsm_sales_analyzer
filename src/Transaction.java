public class Transaction {

    private String type = "";
    private int amount = 0;
    private String otherPlayer = "";
    private String player = "";
    private int time = 0;

    public Transaction() {
    }
    
	public Transaction(String type, int amount, String otherPlayer, String player, int time) {
		this.type = type;
		this.amount = amount;
		this.otherPlayer = otherPlayer;
		this.player = player;
		this.time = time;
	}

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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}