import java.util.ArrayList;

public class Wow {

	public static void main(String[] args) {
		ListTrans trans_list = new ListTrans();
		
		ArrayList<Transaction> lista = new ArrayList<>();
		
		trans_list.setTrans_list(files.import_file()); /* aparentemente isto � uma
		lista mas s� pode ser acessada quando fa�o o get */

        lista = trans_list.getTrans_list(); /* funciona */
	}

}