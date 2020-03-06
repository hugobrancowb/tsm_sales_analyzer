import java.util.ArrayList;

public class ListTrans {
    
    static ArrayList<Transaction> trans_list = new ArrayList<>();
    
	public static void addNew(String type, int amount, String otherPlayer, String player, int time) {
		Transaction t = new Transaction(type, amount, otherPlayer, player, time);
		trans_list.add(t);
	}
	
	public static void clearList() {
		trans_list = new ArrayList<>();
	}

	public static ArrayList<Transaction> getTrans_list() {
		return trans_list;
	}

	public static void setTrans_list(ArrayList<Transaction> trans_list) {
		ListTrans.trans_list = trans_list;
	}
}
