import java.util.ArrayList;
import java.util.Calendar;
import calendar.ListOfMonths;


public class Wow {

	public static void main(String[] args) {
		
		/**/ArrayList<Transaction> lista = new ArrayList<>();
		/**/ArrayList<Calendar> lista2 = new ArrayList<>();
		
		ListTrans.setTrans_list(Files.import_file()); /* isto � uma
		lista mas s� pode ser acessada quando fa�o o get */

		ListOfMonths.setListcalendar(
		ListTrans.getMaxTime(),
		ListTrans.getMinTime()
		);
		
        /**/lista = ListTrans.getTrans_list(); /* funciona */
        /**/lista2 = ListOfMonths.getListcalendar(); /* funciona */
	}

}