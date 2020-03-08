import java.util.ArrayList;
import java.util.Calendar;

public class ListTrans {
	
	private static int size = 0;
	private static Calendar maxTime = null;
	private static Calendar minTime = null;
    
    static ArrayList<Transaction> trans_list = new ArrayList<>();
    
	public static void addNew(String itemName, int stackSize, int quantity, float price, String otherPlayer,
				              String player, int time, String source) {
		
		if (source.equals("Auction") && (itemName.length() > 1)) {
			Transaction t = new Transaction(itemName, stackSize, quantity, price, otherPlayer, player,
					time, source);
			
			setSize(getSize() + 1);
			
			if ((maxTime == null) || (minTime == null)) {
				setMaxTime(t.getTime());
				setMinTime(t.getTime());
			} else {
				setMaxTime(t.getTime().compareTo(maxTime) > 0 ? t.getTime() : maxTime);
				setMinTime(minTime.compareTo(t.getTime()) > 0 ? t.getTime() : minTime);
			}
			
			trans_list.add(t);
		}
	}
	
	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		ListTrans.size = size;
	}

	public static Calendar getMaxTime() {
		return maxTime;
	}

	public static void setMaxTime(Calendar maxTime) {
		ListTrans.maxTime = maxTime;
	}

	public static Calendar getMinTime() {
		return minTime;
	}

	public static void setMinTime(Calendar minTime) {
		ListTrans.minTime = minTime;
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
