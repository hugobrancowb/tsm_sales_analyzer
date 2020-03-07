import java.util.ArrayList;

public class Wow {

	public static void main(String[] args) {
		
		ArrayList<Transaction> lista = new ArrayList<>();
		
		ListTrans.setTrans_list(Files.import_file()); /* aparentemente isto é uma
		lista mas só pode ser acessada quando faço o get */

        lista = ListTrans.getTrans_list(); /* funciona */
	}

}