import java.util.ArrayList;

public class Wow {

	public static void main(String[] args) {
		
		ArrayList<Transaction> lista = new ArrayList<>();
		
		ListTrans.setTrans_list(Files.import_file()); /* aparentemente isto � uma
		lista mas s� pode ser acessada quando fa�o o get */

        lista = ListTrans.getTrans_list(); /* funciona */
	}

}