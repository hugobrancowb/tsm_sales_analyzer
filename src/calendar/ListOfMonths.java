package calendar;

import java.util.ArrayList;
import java.util.Calendar;

public class ListOfMonths {
	
	private static ArrayList<Calendar> listcalendar = new ArrayList<>();

	public void setListcalendar(Calendar max, Calendar min) {
		max.set(Calendar.DAY_OF_MONTH, 1);
		min.set(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println("maxTime = " + max.getTime());
		System.out.println("minTime = " + min.getTime());
		
		Calendar index = (Calendar)min.clone();;
		
		while((index.get(Calendar.MONTH) != max.get(Calendar.MONTH)) || (index.get(Calendar.YEAR) != max.get(Calendar.YEAR))) {
			
			Calendar eachmonth = (Calendar)index.clone();			
			listcalendar.add(eachmonth);
			index.add(Calendar.MONTH, 1);
		}
		listcalendar.add(index); /* add the last month */
	}

	public static ArrayList<Calendar> getListcalendar() {
		return listcalendar;
	}
}
