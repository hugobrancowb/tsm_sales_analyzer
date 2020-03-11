package Operations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import calendar.ListOfMonths;

public class ListTrans {
	
	private static Calendar maxTime = null;
	private static Calendar minTime = null;

	static ArrayList<Transaction> trans_list = new ArrayList<>();
    
	public static void addNew(String itemName, int quantity, float price, long time, String source) {
		
		if (source.equalsIgnoreCase("Auction") && (itemName.length() > 1)) {
			Transaction t = new Transaction(itemName, quantity, price, time);

			setMaxMinTime(t);
			
			boolean exists = false;
			
			if (getSize() > 0) {
				/* conferir se esse produto já foi vendido nesse mês-ano */
				
				for(int i = 0; i < getSize(); i++) {
					
					Transaction t_og = trans_list.get(i);
					
					if(t_og.getItemName().equals(t.getItemName()) &&
					  (t_og.getMonth() == t.getMonth()) &&
					  (t_og.getYear() == t.getYear())
					  ) { 
						t_og.setIncome(t_og.getIncome() + t.getIncome());
						exists = true;
						break;
					}						
				}
			}	
			
			if((!exists) || (getSize() == 0)) {
				trans_list.add(t);
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
	
	public static void printReport(int range, int top_products) {
		ListOfMonths calendar_range = new ListOfMonths();
		calendar_range.setListcalendar(getMaxTime(), getMinTime());
		range = calendar_range.getSize() - range;
		
		for (int m = calendar_range.getSize() - 1; m >= range; m--) { /* by month */
			
			int mes = calendar_range.getMonth(m) + 1;
			int ano = calendar_range.getYear(m);
			
			System.out.println("Ano: " + ano + "; Mes: " + mes);
			
			ArrayList<Transaction> toplist = new ArrayList<>();
			
			for(Transaction t: ListTrans.getTrans_list()) {
				if ((t.getMonth() == mes-1) && (t.getYear() == ano)) {
					toplist.add(t);
				}
			}
			
			Collections.sort(toplist);
			
			for(int i = 0; i < top_products; i++) {
				Transaction t = toplist.get(i);
				System.out.println(t.getItemName() + " - " + t.getIncome()/10000);
			}
			System.out.println("");
		}
	}
	
	public static Float getIncome(int position) {
		return trans_list.get(position).getIncome();
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
