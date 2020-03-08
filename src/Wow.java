import java.util.ArrayList;
import java.util.Calendar;

import calendar.ListOfMonths;


public class Wow {

	public static void main(String[] args) {
		
		ArrayList<Transaction> lista = new ArrayList<>();
		ArrayList<Calendar> lista2 = new ArrayList<>();
		
		ListTrans.setTrans_list(Files.import_file()); /* aparentemente isto é uma
		lista mas só pode ser acessada quando faço o get */

		ListOfMonths.setListcalendar(ListTrans.getMaxTime(), ListTrans.getMinTime());

        lista = ListTrans.getTrans_list(); /* funciona */
        lista2 = ListOfMonths.getListcalendar();
        
        for (int i = 0; i < lista2.size(); i++) {
        	System.out.println(i + " // " + lista2.get(i).getTime());			
		}
	}

}