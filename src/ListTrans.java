import java.util.ArrayList;
import java.util.Date;

public class ListTrans {
	
	private static int size = 0;
	private static Date maxTime = null;
	private static Date minTime = null;
    
    static ArrayList<Transaction> trans_list = new ArrayList<>();
    
	public static void addNew(String type, int amount, String otherPlayer, String player, int time) {
		Transaction t = new Transaction(type, amount, otherPlayer, player, time);
		size += 1;
		
		if ((maxTime == null) || (minTime == null)) {
			maxTime = t.getTime();
			minTime = t.getTime();
		} else {
			maxTime = t.getTime().compareTo(maxTime) > 0 ? t.getTime() : maxTime;
			minTime = minTime.compareTo(t.getTime()) > 0 ? t.getTime() : minTime;
		}
		
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
