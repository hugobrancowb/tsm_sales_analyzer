package Operations;
import java.util.ArrayList;
import java.util.Calendar;

public class ListTrans {
	
	private static Calendar maxTime = null;
	private static Calendar minTime = null;

	static ArrayList<Transaction> trans_list = new ArrayList<>();
    
	public static void addNew(String itemName, int quantity, float price, float time, String source) {
		
		if (source.equalsIgnoreCase("Auction") && (itemName.length() > 1)) {
			Transaction t = new Transaction(itemName, quantity, price, time);
			
			if(t.getTime().get(Calendar.YEAR) == 2019) {

				setMaxMinTime(t);
				
				if (getSize() == 0) {
					trans_list.add(t);	
				} else {
					/* conferir se esse produto já foi vendido nesse mês/ano */
					boolean exists = false;
					
					for(int i = 0; i < getSize(); i++) {
						
						Transaction t_og = trans_list.get(i);
						
						if(t_og.getItemName().equals(t.getItemName()) &&
						  (t_og.getTime().get(Calendar.MONTH) == t.getTime().get(Calendar.MONTH))
						  ) {
							
							t_og.setIncome(t_og.getIncome() + t.getIncome());
							exists = true;
							break;
							
						}						
					}
					
					if(!exists) {
						trans_list.add(t);
					}
				}				
			}
		}
	}
	
	private static void setMaxMinTime(Transaction t) {
		if ((maxTime == null) || (minTime == null)) {
			setMaxTime(t.getTime());
			setMinTime(t.getTime());
		} else {
			setMaxTime(t.getTime().compareTo(maxTime) > 0 ? t.getTime() : maxTime);
			setMinTime(minTime.compareTo(t.getTime()) > 0 ? t.getTime() : minTime);
		}
	}

	public static int getSize() {
		return trans_list.size();
	}

	public static Calendar getMaxTime() {
		return maxTime;
	}

	private static void setMaxTime(Calendar maxTime) {
		ListTrans.maxTime = maxTime;
	}

	public static Calendar getMinTime() {
		return minTime;
	}

	private static void setMinTime(Calendar minTime) {
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
