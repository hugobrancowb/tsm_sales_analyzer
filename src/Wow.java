import java.util.ArrayList;
import java.util.Calendar;

import Operations.ListTrans;
import Operations.Transaction;


public class Wow {

	public static void main(String[] args) {
		
		ListTrans.setTrans_list(Files.import_file());
		
		//ArrayList<Transaction> lista = new ArrayList<>();
		//lista = ListTrans.getTrans_list();

        System.out.println("size of 2019 = " + ListTrans.getSize());
	}

}