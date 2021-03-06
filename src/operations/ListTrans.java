package operations;

import java.math.BigDecimal;
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
				/* conferir se esse produto j� foi vendido nesse m�s-ano */
				
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
		
		range = calendar_range.getSize() >= range ?
					calendar_range.getSize() - range :
					0;
		
		ReportWindow frame = new ReportWindow();
		frame.setVisible(true);
		
		for (int m = calendar_range.getSize() - 1; m >= range; m--) { /* by month */
			
			int mes = calendar_range.getMonth(m) + 1;
			int ano = calendar_range.getYear(m);
			
			String output_string = print_date_string(mes, ano);
			
			ArrayList<Transaction> toplist = new ArrayList<>();
			
			for(Transaction t: ListTrans.getTrans_list()) {
				if ((t.getMonth() == mes-1) && (t.getYear() == ano)) {
					toplist.add(t);
				}
			}
			
			Collections.sort(toplist);
			
			for(int i = 0; i < top_products; i++) {
				Transaction t = toplist.get(i);
				
				/* format output */
				float income = t.getIncome()/10000;
				String income_text = income < 1000 ? /* � menor que mil? */
						Float.toString(round(income, 2)) :
						income < 1000000 ? /* � menor que um milh�o? */
							Float.toString(round(income/1000, 1)).concat("k") :
							Float.toString(round(income/1000000, 1)).concat("M");
				
				output_string = output_string.concat(
											  "\r\n" + 
						                      t.getItemName() +
                                              " - " +
                                              income_text + 
                                              " gold");
			}
			frame.addToPanel(output_string);
		}
	}

	private static String print_date_string(int mes, int ano) {
		String s = "";
		
		switch (mes) {
		case 1:
			s = "January";
			break;
		case 2:
			s = "February";
			break;
		case 3:
			s = "March";
			break;
		case 4:
			s = "April";
			break;
		case 5:
			s = "May";
			break;
		case 6:
			s = "June";
			break;
		case 7:
			s = "July";
			break;
		case 8:
			s = "August";
			break;
		case 9:
			s = "September";
			break;
		case 10:
			s = "October";
			break;
		case 11:
			s = "November";
			break;
		case 12:
			s = "December";
			break;
		}
		
		s = s.concat(" of " + Integer.toString(ano) + ":");
		
		return s;		
	}
	
	public static float round(float d, int decimalPlace) {
	    return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
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
