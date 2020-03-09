import java.util.ArrayList;

import Operations.ListTrans;
import Operations.Transaction;


public class Wow {

	public static void main(String[] args) {
		ArrayList<Transaction> lista = new ArrayList<>();
		
		ListTrans.setTrans_list(Files.import_file());

        lista = ListTrans.getTrans_list();
        System.out.println("size of 2019 = " + ListTrans.getSize());
        System.out.println("size of 2019 = " + lista.size());
	}

}