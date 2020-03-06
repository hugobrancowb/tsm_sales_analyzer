public class Transaction {

    String type = "";
    int amount = 0;
    String otherPlayer = "";
    String player = "";
    int time = 0;

    public Transaction (String type, int amount, String otherPlayer, String player, int time) {
        this.type = type;
        this.amount = amount;
        this.otherPlayer = otherPlayer;
        this.player = player;
        this.time = time;
    }

}